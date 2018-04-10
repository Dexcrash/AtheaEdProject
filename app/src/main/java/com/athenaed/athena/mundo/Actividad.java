package com.athenaed.athena.mundo;

public class Actividad {

    public String nombre;
    public String descripcion;
    public int kinestesica;
    public int visual;
    public int auditiva;

    public Actividad(String nombre, String descripcion, int kinestesica, int visual, int auditiva) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.kinestesica = kinestesica;
        this.visual = visual;
        this.auditiva = auditiva;
    }
}
