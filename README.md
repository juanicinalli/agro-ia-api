# Agro-IA API

API RESTful para gestión agrícola con integración IA (Gemini) y seguridad JWT (Firebase).

## Tecnologías
- Java 17
- Spring Boot 3.x
- PostgreSQL
- Spring Security + JWT
- WebClient (Gemini)
- Lombok

## Estructura de paquetes
- `com.agroia.api.config`
- `com.agroia.api.model`
- `com.agroia.api.dto`
- `com.agroia.api.repository`
- `com.agroia.api.service`
- `com.agroia.api.controller`
- `com.agroia.api.exception`

## Configuración
1. Crea una base de datos Postgres llamada `agroia_db`.
2. Coloca tu clave de Gemini en la variable de entorno `GEMINI_API_KEY`.
3. Configura el issuer de Firebase en `application.yml` si usas JWT de Firebase.

## Ejecución
```bash
mvn spring-boot:run
```

## Endpoints
Revisa los controladores para los endpoints de lotes, inventario y balance.
