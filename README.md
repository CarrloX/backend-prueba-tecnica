# Backend Prueba Técnica

API REST desarrollada con Spring Boot para gestión de usuarios y categorías.

## 🛠️ Tecnologías

- **Java 21**
- **Spring Boot 3.5.9**
- **Spring Data JPA**
- **MySQL**
- **MapStruct** - Mapeo de objetos
- **Lombok** - Reducción de código boilerplate
- **Swagger/OpenAPI** - Documentación de API
- **Docker**

## 📋 Requisitos Previos

- Java 21 o superior
- Maven 3.9+
- MySQL 8.0+
- Docker (opcional)

## 🚀 Instalación y Ejecución

### Ejecución Local

1. Clonar el repositorio:
```bash
git clone https://github.com/CarrloX/backend-prueba-tecnica.git
cd backend-prueba-tecnica
```

2. Configurar la base de datos en `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
```

3. Ejecutar la aplicación:
```bash
./mvnw spring-boot:run
```

### Ejecución con Docker

```bash
docker build -t backend-prueba-tecnica .
docker run -p 8080:8080 backend-prueba-tecnica
```

## 📡 API Endpoints

**Base URL:** `http://localhost:8080/api/v1`

### Usuarios
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/users` | Obtener todos los usuarios |
| GET | `/users/{id}` | Obtener usuario por ID |
| POST | `/users` | Crear usuario |
| PUT | `/users/{id}` | Actualizar usuario |
| DELETE | `/users/{id}` | Eliminar usuario |
| POST | `/users/login` | Iniciar sesión |
| POST | `/users/register` | Registrar usuario |

### Categorías
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/categories` | Obtener todas las categorías |
| GET | `/categories/{id}` | Obtener categoría por ID |
| POST | `/categories` | Crear categoría |
| PUT | `/categories/{id}` | Actualizar categoría |
| DELETE | `/categories/{id}` | Eliminar categoría |

## 📖 Documentación API

La documentación Swagger está disponible en:
```
http://localhost:8080/api/v1/swagger-ui.html
```

## 📁 Estructura del Proyecto

```
src/main/java/com/ejemplo/demo/
├── api/
│   ├── controllers/         # Controladores REST
│   ├── dto/
│   │   ├── request/         # DTOs de entrada
│   │   ├── response/        # DTOs de salida
│   │   └── errors/          # DTOs de errores
│   └── error_handler/       # Manejo de excepciones
├── config/                  # Configuraciones (OpenAPI, Web)
├── domain/
│   └── entities/            # Entidades JPA
│       └── repositories/    # Repositorios JPA
├── infrastructure/
│   ├── abstract_services/   # Interfaces de servicios
│   └── helpers/
│       ├── mappers/         # MapStruct mappers
│       └── services/        # Implementaciones de servicios
└── utils/
    ├── enums/               # Enumeraciones
    ├── exceptions/          # Excepciones personalizadas
    └── messages/            # Mensajes de error
```

## ⚙️ Configuración

| Variable | Descripción | Valor por defecto |
|----------|-------------|-------------------|
| `PORT` | Puerto del servidor | `8080` |
| `spring.datasource.url` | URL de conexión MySQL | - |
| `spring.datasource.username` | Usuario de BD | - |
| `spring.datasource.password` | Contraseña de BD | - |

## 👤 Autor

- GitHub: [@CarrloX](https://github.com/CarrloX)

## 📝 Licencia

Este proyecto está bajo la Licencia MIT.
