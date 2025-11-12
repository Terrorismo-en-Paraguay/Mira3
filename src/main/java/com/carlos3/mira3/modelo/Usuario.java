package com.carlos3.mira3.modelo;

import java.util.ArrayList;

public class Usuario {
    private String login;
    private String password;
    private String nombre;
    private String apellidos;
    private String role;
    private String imagen;
    private ArrayList<Modulo> ListaNotas = new ArrayList<>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Modulo> getListaNotas() {
        return ListaNotas;
    }

    public void setListaNotas(ArrayList<Modulo> listaNotas) {
        ListaNotas = listaNotas;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "login='" + login + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", imagen='" + imagen + '\'' +
                ", role= '" + role + '\'' +
                ", ListaModulos=" + ListaNotas +
                '}';
    }
}
