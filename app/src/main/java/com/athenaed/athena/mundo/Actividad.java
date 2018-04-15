package com.athenaed.athena.mundo;

import java.util.ArrayList;

public class Actividad {

    public String nombre;
    public String descripcion;
    public int kinestesica;
    public int visual;
    public int auditiva;
    public ArrayList<Clase> clases = new ArrayList<>();


    public Actividad()
    {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getKinestesica() {
        return kinestesica;
    }

    public void setKinestesica(int kinestesica) {
        this.kinestesica = kinestesica;
    }

    public int getVisual() {
        return visual;
    }

    public void setVisual(int visual) {
        this.visual = visual;
    }

    public int getAuditiva() {
        return auditiva;
    }

    public void setAuditiva(int auditiva) {
        this.auditiva = auditiva;
    }

    public ArrayList<Clase> getClases() {
        return clases;
    }

    public void setClases(ArrayList<Clase> clases) {
        this.clases = clases;
    }
}
