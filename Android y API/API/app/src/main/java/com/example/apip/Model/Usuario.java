package com.example.apip.Model;

public class Usuario {
    private String IdUsuario;
    private String NombreUsuario;
    private String ApellidoUsuario;
    private int EdadUsuario;
    private String NombreUsuarioUsuario;
    private String CorreoUsuario;
    private String PasswordUsuario;
    private String TipoUsuario;

    public Usuario() {
    }

    public Usuario(String idUsuario, String nombreUsuario, String apellidoUsuario, int edadUsuario, String nombreUsuarioUsuario, String correoUsuario, String contraseñaUsuario, String tipoUsuario) {
        IdUsuario = idUsuario;
        NombreUsuario = nombreUsuario;
        ApellidoUsuario = apellidoUsuario;
        EdadUsuario = edadUsuario;
        NombreUsuarioUsuario = nombreUsuarioUsuario;
        CorreoUsuario = correoUsuario;
        PasswordUsuario= contraseñaUsuario;
        TipoUsuario = tipoUsuario;

    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return ApellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        ApellidoUsuario = apellidoUsuario;
    }

    public int getEdadUsuario() {
        return EdadUsuario;
    }

    public void setEdadUsuario(int edadUsuario) {
        EdadUsuario = edadUsuario;
    }

    public String getNombreUsuarioUsuario() {
        return NombreUsuarioUsuario;
    }

    public void setNombreUsuarioUsuario(String nombreUsuarioUsuario) {
        NombreUsuarioUsuario = nombreUsuarioUsuario;
    }

    public String getCorreoUsuario() {
        return CorreoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        CorreoUsuario = correoUsuario;
    }

    public String getPasswordUsuario() {
        return PasswordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        PasswordUsuario = passwordUsuario;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        TipoUsuario = tipoUsuario;
    }
}
