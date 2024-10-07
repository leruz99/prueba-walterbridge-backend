# Prueba-Walterbridge
# **Documentación de Prueba Técnica para walterbridge**
## Introducción
Esta documentación detalla el desarrollo de un servicio API RESTful para el puesto de Desarrollador Back End en Walterbridge. El objetivo es construir una aplicación web sencilla que gestione una lista de tareas (TO-DO list). La aplicación deberá tener una API RESTful, consumir otra API REST externa para obtener información adicional (por ejemplo, citas motivacionales), y una interfaz de usuario para interactuar con las tareas.

## Descripción del Proyecto
### Arquitectura y Estructura del Proyecto
El proyecto está organizado utilizando una estructura de paquetes por componentes, lo que facilita la modularidad y el mantenimiento del código. Esta organización permite separar claramente la lógica de negocio, la persistencia de datos, y la interfaz de usuario, mejorando la escalabilidad y la gestión del código.

### Tecnologías y Herramientas Utilizadas
* **[Spring Boot:](https://start.spring.io/)** Utilizado para simplificar la configuración inicial del proyecto y la gestión de dependencias.
* **Spring Data JPA**: Facilita la integración con la base de datos PostgreSQL y simplifica las operaciones CRUD mediante el uso de interfaces de repositorio.
* **Spring Web**: Permite la creación de endpoints REST y maneja las solicitudes HTTP.
* **[PostgreSQL Database:](https://www.postgresql.org/)** Base de datos PostgreSQL utilizada para el desarrollo y pruebas, proporcionando persistencia confiable y escalable con una configuración sencilla.
* **[Swagger:](https://springdoc.org/#google_vignette)** Genera la documentación interactiva de la API, facilitando la prueba y visualización de los endpoints disponibles.


## Patrones de Diseño Implementados
* **Dependency Injection**: Ampliamente utilizado a través de Spring Framework, este patrón facilita la gestión de dependencias y la configuración del proyecto, promoviendo un código más limpio y mantenible.
* **Repository**: Implementado mediante Spring Data JPA para abstraer la lógica de acceso a datos. Esto simplifica las operaciones con la base de datos y mejora la mantenibilidad del código al separar la lógica de negocio de la de persistencia
* **Factory**: Empleado para la creación de objetos complejos. Este patrón permite una mayor flexibilidad y desacoplamiento en la creación de instancias, facilitando la extensión y el mantenimiento del código..


## Principios SOLID
* **Principio de Responsabilidad Única (SRP)**: Cada clase se ha diseñado para tener una sola razón para cambiar, lo cual se logra segregando las funcionalidades en distintos servicios y repositorios, minimizando así las dependencias cruzadas.
* **Principio de Invesión de Dependencias (DIP)**: Se ha aplicado este principio para reducir la dependencia de implementaciones concretas y fomentar la dependencia de abstracciones. Esto se observa en cómo las capas superiores de la aplicación interactúan con interfaces en lugar de con implementaciones concretas, lo que facilita la sustitución de componentes y la realización de pruebas.

## Instrucciones para correr el proyecto en local
### Requisitos previos
Antes de empezar, asegúrate de tener instalados los siguientes requisitos en tu máquina:
1. **Java 17 (JDK 17)**
* El proyecto está desarrollado con Java 17. Asegúrate de tener el JDK 17 instalado en tu sistema
* Puedes verificar la versión de Java instalada ejecutando el siguiente comando en tu terminal:
```bash
java -version
```
Si no tienes instalado Java 17, puedes descargarlo e instalarlo desde el siguiente enlace:
https://www.oracle.com/java/technologies/javase-jdk17-downloads.html
2. **PostgreSQL**
* La base de datos utilizada por el proyecto es PostgreSQL. Debes instalar PostgreSQL localmente. 
* Una vez instalado PostgreSQL, crea una base de datos llamada prueba con las siguientes configuraciones:
   * Host: localhost
   * Puerto: 5432 (puerto por defecto de PostgreSQL)
   * Usuario: el usuario que usas en tu instalación de PostgreSQL
   * Contraseña: la contraseña de tu usuario de PostgreSQL.
  
Puedes crear la base de datos test ejecutando el siguiente comando desde el terminal o consola de PostgreSQL:
```bash
CREATE DATABASE prueba;
```
**Nota:** Asegúrate de que los detalles de conexión coincidan con los valores en el archivo `src/main/resources/application.properties` del proyecto.

Ejemplo de configuración en `application.properties`:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/test
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```
3. **Node.js y Angular CLI (para el frontend)**
* Para el frontend del proyecto, necesitas tener instalado Node.js y Angular CLI.
* Verifica si tienes Node.js instalado ejecutando:

```bash
node -v
```
* Si no tienes Node.js instalado, puedes descargarlo desde aquí https://nodejs.org/.

Una vez instalado Node.js, instala Angular CLI globalmente ejecutando:
```bash
npm install -g @angular/cli
```
## Instrucciones para correr el backend (Java Spring Boot)
1. Clona el repositorio del proyecto en tu máquina local:
```bash
git clone https://github.com/leruz99/prueba-walterbridge-backend
```
2. Accede al directorio del proyecto:
```bash
cd prueba-tecnica
```
3. Compila y ejecuta el proyecto con Gradle o tu IDE de preferencia.

```bash
gradle build
gradle run
```
El backend estará corriendo en http://localhost:8080/swagger-ui/index.html#/ ya que tiene las configuraciones respectivas del Swagger.
## Instrucciones para correr el frontend (Angular)
1. Clona el repositorio del proyecto en tu máquina local:
```bash
git clone https://github.com/leruz99/prueba-walterbridge-frontend
```
2. Accede al directorio del proyecto:
```bash
cd prueba-tecnica-front
```
3. Instala las dependencias necesarias usando npm:
```bash
npm install
```
4. Ejecuta la aplicación de Angular:
```bash
ng serve
```
El frontend estará corriendo en http://localhost:4200/basic.



## Endpoints

### Agregar Task
- **Descripción**: Agregar una Task.
- **Method**: `POST`
- **Path** : `api/tasks`
- **Códigos de Respuesta**:
- - `200`: Task guardada exitosamente.

**Ejemplo de Uso:**

```bash
curl --request POST \
  --url http://localhost:8080/api/task
  --header 'Content-Type: application/json' \
  --data '{
  "title": "Task 1",
  "description": "Task 1 Descripcion"
}'
```

### Mostrar las Task
- **Descripción** : Mostrar todas las task registradas.
- **Método HTTP** : `GET`
- **Path** : `/api/tasks`
- **Códigos de Respuesta**:
- - `200`: Task mostradas exitosamente.

**Ejemplo de Uso**
```bash
curl --request GET \
  --url http://localhost:8080/api/task
  --header 'Content-Type: application/json' \
```

### Actualizar Task
- **Descripción** : Actualiza una Task.
- **Método HTTP** : `PUT`
- **Path** : `/api/users/{id}`
- **Códigos de Respuesta** :
- - `200`: Task moodificada correctamente
-
**Ejemplo de Uso**:
```bash
curl --request PUT \
  --url http://localhost:8080/api/task/2
  --header 'Content-Type: application/json' \
  --data:{
  "title": "Task modificada",
  "description": "Descripcion modificada",
  "completed": true,
  "quote": "Frase modificada"
}
```


### Eliminar Task
- **Descripción** : Permite eliminar unas task.
- **Método HTTP** : `DELETE`
- **Path** : `/api/users/{id}`
- **Códigos de Respuesta** :
- - `200`: Task eliminada correctamente.

    **Ejemplo de Uso**
```bash
curl --request POST \
  --url ttp://localhost:8080/api/task/2
  --header 'Content-Type: application/json' \
  
```
