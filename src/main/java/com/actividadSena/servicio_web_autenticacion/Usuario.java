package com.actividadSena.servicio_web_autenticacion;

// Esta clase representa la información que tendrá un usuario en nuestro sistema.

public class Usuario {
    private String usuario;   // Guardará el nombre de usuario
    private String password;  // Guardará la contraseña del usuario

    // Constructor vacío:
    // Spring Boot lo necesita para poder crear un objeto Usuario automáticamente
    // cuando recibe datos desde una petición web (JSON).
    public Usuario() {
    }

    // Constructor con parámetros:
    // Este nos permite crear un objeto Usuario y darle valores iniciales al mismo tiempo.

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    // Métodos "Getter":
    // Permiten a otras partes del código OBTENER (leer) el valor de las variables 'usuario' y 'password'.

    public String getUsuario() {
        return usuario;
    }

    // Métodos "Setter":
    // Permiten a otras partes del código ESTABLECER (cambiar) el valor de las variables 'usuario' y 'password'.
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}