package com.athenaed.athena.mundo;

import java.util.ArrayList;

public class Estudiante {

    public String nombre;
    public int visual;
    public int kinestesico;
    public int auditivo;

    public ArrayList<Clase> clases = new ArrayList<>();

    public Estudiante()
    {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVisual() {
        return visual;
    }

    public void setVisual(int visual) {
        this.visual = visual;
    }

    public int getKinestesico() {
        return kinestesico;
    }

    public void setKinestesico(int kinestesico) {
        this.kinestesico = kinestesico;
    }

    public int getAuditivo() {
        return auditivo;
    }

    public void setAuditivo(int auditivo) {
        this.auditivo = auditivo;
    }

    public ArrayList<Clase> getClases() {
        return clases;
    }

    public void setClases(ArrayList<Clase> clases) {
        this.clases = clases;
    }
}
