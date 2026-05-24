# Task Manager Backend - GitFlow Practice

## 📋 Descripción del Proyecto

Aplicación backend desarrollada con **Spring Boot** para gestionar tareas (CRUD completo). Este proyecto forma parte de la práctica de **GitFlow** y **Conventional Commits** del laboratorio académico.

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.2.1**
- **Spring Data JPA**
- **SQL Server 2022**
- **Maven**
- **Lombok**

## 📦 Dependencias Principales

```xml
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- mssql-jdbc
- lombok
```

## 🚀 Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

1. **Java JDK 17** o superior
2. **Maven 3.6+**
3. **SQL Server 2022** (o Docker con SQL Server)
4. **Git**

## 🗄️ Configuración de Base de Datos

### Opción 1: Docker (Recomendado)

```bash
docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=Password123@" -p 1433:1433 --name sqlserver -d mcr.microsoft.com/mssql/server:2022-latest
```

### Opción 2: SQL Server Local

1. Instalar SQL Server 2022
2. Crear la base de datos `task_manager`
3. Configurar usuario `sa` con contraseña `Password123@`

### Configuración en `application.properties`

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=task_manager;encrypt=true;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=Password123@
```

## 📂 Estructura del Proyecto

```
gitFlow251s3_t06_be/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── vallegrande/edu/pe/gitFlow242s3_t06_be/
│   │   │       ├── controller/
│   │   │       │   └── TaskController.java
│   │   │       ├── model/
│   │   │       │   └── Task.java
│   │   │       ├── repository/
│   │   │       │   └── TaskRepository.java
│   │   │       ├── service/
│   │   │       │   └── TaskService.java
│   │   │       └── GitFlow242s3T06BeApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## ⚙️ Instalación y Ejecución

### 1. Clonar el repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
cd gitFlow251s3_t06_be
```

### 2. Compilar el proyecto

```bash
mvn clean install
```

### 3. Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## 🔌 Endpoints de la API

### Base URL: `http://localhost:8080/api/tasks`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/tasks` | Crear una nueva tarea |
| `GET` | `/api/tasks` | Obtener todas las tareas |
| `GET` | `/api/tasks/{id}` | Obtener una tarea por ID |
| `PUT` | `/api/tasks/{id}` | Actualizar una tarea |
| `DELETE` | `/api/tasks/{id}` | Eliminar una tarea |

### Ejemplos de Uso

#### Crear Tarea (POST)

```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Tarea de ejemplo",
    "description": "Descripción de la tarea",
    "status": "pendiente"
  }'
```

#### Obtener Todas las Tareas (GET)

```bash
curl http://localhost:8080/api/tasks
```

#### Actualizar Tarea (PUT)

```bash
curl -X PUT http://localhost:8080/api/tasks/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Tarea actualizada",
    "description": "Nueva descripción",
    "status": "completada"
  }'
```

#### Eliminar Tarea (DELETE)

```bash
curl -X DELETE http://localhost:8080/api/tasks/1
```

## 📊 Modelo de Datos

### Entidad Task

```java
{
  "id": Long,
  "title": String,
  "description": String,
  "status": String,
  "createdAt": LocalDateTime
}
```

## 🌿 GitFlow - Ramas

Este proyecto sigue el flujo de trabajo **GitFlow**:

- `main`: Rama de producción
- `develop`: Rama de desarrollo
- `feature/*`: Ramas de características
  - `feature/sp8-us1_createTasks`
  - `feature/sp8-us2_listTasks`
  - `feature/sp8-us5_updateTasks`
  - `feature/sp8-us6_eliminateTasks`

## 📝 Conventional Commits

Los commits siguen el estándar **Conventional Commits**:

```
<tipo>(<área>): <descripción breve>

Tipos: feat, fix, style, refactor, chore
```

### Ejemplos:

```bash
feat(backend): add endpoint to create tasks
feat(backend): add endpoint to list tasks
fix(backend): correct validation in task update
```

## 🔧 Configuración CORS

El backend está configurado para aceptar peticiones desde el frontend Angular:

```java
@CrossOrigin(origins = "http://localhost:4200")
```

## 🧪 Testing

Ejecutar las pruebas:

```bash
mvn test
```

## 📦 Compilar para Producción

```bash
mvn clean package
```

El archivo JAR se generará en: `target/gitFlow242s3_t06_be-0.0.1-SNAPSHOT.jar`

## 🚀 Ejecutar JAR

```bash
java -jar target/gitFlow242s3_t06_be-0.0.1-SNAPSHOT.jar
```

## 🐛 Solución de Problemas

### Error de conexión a SQL Server

- Verificar que SQL Server esté ejecutándose
- Verificar credenciales en `application.properties`
- Verificar que el puerto 1433 esté disponible

### Error de compilación Maven

```bash
mvn clean install -U
```

### Puerto 8080 en uso

Cambiar el puerto en `application.properties`:

```properties
server.port=8081
```

## 👥 Autores

- **dev1**: Endpoints de crear y listar tareas
- **dev2**: Endpoints de actualizar y eliminar tareas

## 📄 Licencia

Este proyecto es parte de un laboratorio académico de Valle Grande.

## 📞 Contacto

Para consultas sobre el proyecto, contactar al equipo de desarrollo.

---

**Versión**: 1.0.0  
**Fecha**: Enero 2025  
**Institución**: Valle Grande