package com.agroia.api.controller;

import com.agroia.api.model.User;
import com.agroia.api.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        User user = userService.findByUsername(username);
        String token = generateJwtToken(user);
        
        return ResponseEntity.ok(token);
    }

    @GetMapping("/refresh")
    public ResponseEntity<String> refreshToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        String username = Jwts.parserBuilder()
            .setSigningKey(jwtSecret.getBytes())
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
        
        User user = userService.findByUsername(username);
        String newToken = generateJwtToken(user);
        
        return ResponseEntity.ok(newToken);
    }

    private String generateJwtToken(User user) {
        return Jwts.builder()
            .setSubject(user.getUsername())
            .claim("roles", user.getRoles().stream()
                .map(role -> role.getName())
                .collect(Collectors.toList()))
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + jwtExpiration))
            .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes())
            .compact();
    }
}
