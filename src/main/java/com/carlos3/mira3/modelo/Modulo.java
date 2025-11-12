package com.carlos3.mira3.modelo;

public class Modulo {
    private String id;
    private String nombre;
    private double  nota;
    private int curso;
    private String ciclo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", curso=" + curso +
                ", ciclo='" + ciclo + '\'' +
                '}';
    }
}
