package com.agroia.api.service;

import com.agroia.api.model.User;
import com.agroia.api.repository.RoleRepository;
import com.agroia.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Asignar rol por defecto
        Role defaultRole = roleRepository.findByName("USER")
            .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.getRoles().add(defaultRole);
        
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User existingUser = findByUsername(user.getUsername());
        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    public void deleteUser(String username) {
        User user = findByUsername(username);
        userRepository.delete(user);
    }
}
