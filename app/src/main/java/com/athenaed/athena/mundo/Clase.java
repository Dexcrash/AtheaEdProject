package com.athenaed.athena.mundo;

import java.util.ArrayList;

public class Clase {

    public ArrayList<Estudiante> estudiantes = new ArrayList<>();
    public ArrayList<Actividad> actividades = new ArrayList<>();
    public String tipo;
    public int kinestesico;
    public int visual;
    public int auditivo;
    public int promedio;

    public Clase()
    {

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    public int getKinestesico() {
        return kinestesico;
    }

    public void setKinestesico(int kinestesico) {
        this.kinestesico = kinestesico;
    }

    public int getVisual() {
        return visual;
    }

    public void setVisual(int visual) {
        this.visual = visual;
    }

    public int getAuditivo() {
        return auditivo;
    }

    public void setAuditivo(int auditivo) {
        this.auditivo = auditivo;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }
}