Proyecto Spring Boot con Thymeleaf - Lista de Usuarios

Descripción del Proyecto
Este proyecto consiste en una aplicación web utilizando Spring Boot y Thymeleaf para mostrar una lista de usuarios con sus respectivos datos: nombre, apellido y correo electrónico. Si el correo de un usuario es null, se mostrará "--------".

Características:
Modelo User: Define los datos de los usuarios (nombre, apellido, correo).


Servicio: Simula una lista de usuarios.


Controlador: Maneja las solicitudes HTTP y pasa los datos a la vista.


Vista: Utiliza Thymeleaf para mostrar la información en una tabla HTML.


Estructura del Proyecto
demo/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/demo/
│       │       ├── DemoApplication.java
│       │       ├── model/
│       │       │   └── User.java
│       │       ├── service/
│       │       │   └── UserService.java
│       │       └── controller/
│       │           └── UserController.java
│       └── resources/
│           ├── templates/
│           │   └── usuarios.html
│           └── application.properties
├── pom.xml

Instrucciones de Instalación
Clona este repositorio o descarga el archivo ZIP y descomprímelo.

Accede a la carpeta del proyecto desde la terminal o el explorador de archivos:
cd demo

Verifica que tienes Maven instalado (para verificar que Maven funciona correctamente, ejecuta mvn -v).

Compila y ejecuta el proyecto utilizando el siguiente comando:
mvn spring-boot:run

Abre tu navegador y accede a la siguiente URL:
http://localhost:8080/usuarios

Ahí verás la lista de usuarios.

Descripción del Código
A continuación se describe la estructura y función de los principales archivos en el proyecto.

1. User.java (Modelo)
Este archivo define el modelo de usuario. Contiene los atributos nombre, apellido y correo, junto con los métodos para obtener y establecer esos valores.
public class User {
    private String nombre;
    private String apellido;
    private String correo;

    // Getters y setters
}

2. UserService.java (Servicio)
El servicio simula una lista de usuarios. Aquí, la lista de usuarios está definida de manera estática para simplificar el ejemplo.
import java.util.Arrays;
import java.util.List;

public class UserService {
    public List<User> getUsers() {
        User user1 = new User("Juan", "Pérez", "juan@example.com");
        User user2 = new User("María", "González", null);
        return Arrays.asList(user1, user2);
    }
}

3. UserController.java (Controlador)
El controlador maneja la solicitud HTTP para la ruta /usuarios y pasa la lista de usuarios a la vista de Thymeleaf.
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/usuarios")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "usuarios";
    }
}

4. usuarios.html (Vista Thymeleaf)
Este es el archivo de plantilla de Thymeleaf que muestra la lista de usuarios en una tabla. Si el correo de un usuario es null, se muestra "--------".
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Usuarios</title>
</head>
<body>
    <h1>Lista de Usuarios</h1>
    <table>
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Correo</th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="user : ${users}">
                <td th:text="${user.nombre}">Nombre</td>
                <td th:text="${user.apellido}">Apellido</td>
                <td th:text="${user.correo != null ? user.correo : '--------'}">Correo</td>
            </tr>
        </tbody>
    </table>
</body>
</html>

