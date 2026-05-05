# Sistema Gestor de Usuarios - Spring Boot MVC

Este proyecto es una aplicación web robusta diseñada para la gestión y mantenimiento de usuarios (CRUD). Implementa una interfaz de usuario moderna y responsiva utilizando **Bootstrap** y sigue los estándares de la arquitectura **Model-View-Controller (MVC)** para garantizar un código organizado, escalable y fácil de mantener.

## Funcionalidad Principal
La aplicación funciona como un **Mantenedor de Usuarios**, permitiendo realizar las siguientes operaciones:
* **Creación:** Registro de nuevos usuarios en la base de datos.
* **Lectura:** Visualización de la lista completa de usuarios registrados.
* **Actualización:** Modificación de datos existentes.
* **Eliminación:** Borrado de registros de forma segura.

## Arquitectura y Estructura del Proyecto
El proyecto utiliza el patrón de diseño **MVC**, separando la lógica de negocio, los datos y la interfaz de usuario.

### Organización de Carpetas y Archivos:

* `src/main/java/com/app/usuarios/`
    * `controllers/`: Contiene los controladores que gestionan las peticiones HTTP y conectan el modelo con la vista. (`UserController.java`)
    * `entities/`: Define las entidades de datos (POJOs) que se mapean a las tablas de la base de datos. (`User.java`)
    * `services/`: Contiene la lógica de negocio e interfaces de servicio para desacoplar el controlador del repositorio. (`UserService.java`, `UserServiceImpl.java`)
    * `repositories/`: Interfaces que extienden de `JpaRepository` para interactuar con MySQL mediante JDBC. (Ej: `UserRepository.java`)
* `src/main/resources/`
    * `templates/`: Contiene las vistas en HTML procesadas por el motor de plantillas **Thymeleaf**.
    * `static/`: Archivos estáticos como estilos CSS personalizados o imágenes.
    * `application.properties`: Archivo central de configuración (conexión a base de datos, puerto, etc.).

## Tecnologías y Dependencias
El proyecto utiliza **Spring Boot 3.5.14** y Java 17 como base, integrando las siguientes dependencias:

* **Spring Data JPA:** Para la gestión de la persistencia de datos y mapeo objeto-relacional.
* **MySQL Driver:** Conector necesario para la comunicación con la base de datos **MySQL**.
* **Thymeleaf:** Motor de plantillas para generar contenido HTML dinámico en el servidor.
* **Spring Web:** Framework para construir la aplicación web bajo el patrón MVC.
* **Bootstrap:** Implementado para el diseño visual, asegurando que la interfaz sea limpia y adaptable a dispositivos móviles.

## ⚙️ Configuración de Base de Datos
Para que el sistema se conecte correctamente a tu instancia local de MySQL, debes ajustar las siguientes líneas en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/control_usuarios
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update