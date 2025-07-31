package com.actividadSena.servicio_web_autenticacion;

import org.springframework.http.HttpStatus; // Importa los códigos de estado HTTP (ej. 200, 400, 401)
import org.springframework.http.ResponseEntity; // Permite devolver respuestas HTTP completas (datos + estado)
import org.springframework.web.bind.annotation.PostMapping; // Anotación para mapear solicitudes POST
import org.springframework.web.bind.annotation.RequestBody; // Anotación para obtener el cuerpo de la solicitud
import org.springframework.web.bind.annotation.RequestMapping; // Anotación para mapear la URL base
import org.springframework.web.bind.annotation.RestController; // Anotación para indicar que esta clase es un controlador REST

import java.util.HashMap; // simula la base de datos de usuarios
import java.util.Map;     // Interfaz general para mapas

@RestController // Le dice a Spring que esta clase es un "controlador REST", es decir, que maneja las peticiones web.
@RequestMapping("/api") // Define una ruta base para todas las peticiones de este controlador.

public class AutenticacionController {

    // Simulación de una base de datos de usuarios.
    private final Map<String, String> usuariosRegistrados = new HashMap<>();

    // Constructor del controlador.
    // Aquí podemos inicializar algunos usuarios de prueba para que no esté vacío al iniciar.
    public AutenticacionController() {
        usuariosRegistrados.put("admin", "password123");
        usuariosRegistrados.put("usuario1", "claveabc");
    }

    // --- Ruta para el registro de usuarios ---

    @PostMapping("/registro")
    public ResponseEntity<Map<String, String>> registro(@RequestBody Usuario usuario) {
        // @RequestBody le dice a Spring que tome el cuerpo de la petición (JSON)
        // y lo convierta automáticamente en un objeto 'Usuario'.


        // 1. Validar que el usuario y la contraseña no estén vacíos
        if (usuario.getUsuario() == null || usuario.getUsuario().trim().isEmpty() ||
                usuario.getPassword() == null || usuario.getPassword().trim().isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Datos incompletos. Se requiere 'usuario' y 'password'.");

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // Código 400
        }

        // 2. Verificar si el usuario ya existe
        if (usuariosRegistrados.containsKey(usuario.getUsuario())) {
            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "El usuario '" + usuario.getUsuario() + "' ya existe. Por favor, elija otro.");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT); // Código 409 (Conflicto)
        }

        // 3. Registrar al nuevo usuario
        usuariosRegistrados.put(usuario.getUsuario(), usuario.getPassword());

        // 4. Devolver mensaje de éxito
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Usuario '" + usuario.getUsuario() + "' registrado exitosamente.");
        return new ResponseEntity<>(response, HttpStatus.CREATED); // Código 201 (Creado)
    }

    // --- Ruta para el inicio de sesión ---

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Usuario usuario) {


        // 1. Validar que el usuario y la contraseña no estén vacíos
        if (usuario.getUsuario() == null || usuario.getUsuario().trim().isEmpty() ||
                usuario.getPassword() == null || usuario.getPassword().trim().isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Datos incompletos. Se requiere 'usuario' y 'password'.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // Código 400
        }

        // 2. Verificar si el usuario existe y la contraseña es correcta
        String storedPassword = usuariosRegistrados.get(usuario.getUsuario());

        if (storedPassword != null && storedPassword.equals(usuario.getPassword())) {

            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Autenticación satisfactoria.");
            return new ResponseEntity<>(response, HttpStatus.OK); // Código 200 (OK)
        } else {

            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Error en la autenticación. Usuario o contraseña incorrectos.");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED); // Código 401 (No autorizado)
        }
    }
}