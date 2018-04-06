package com.athenaed.athena.mundo;

import java.util.ArrayList;

public class Clase {

    public ArrayList<Estudiante> estudiantes = new ArrayList<>();
    public String tipo;
    public int promedio;

    public Clase(int ppromedio, String ptipo)
    {
        promedio = ppromedio;
        tipo = ptipo;
    }

    public void agregarEstudiante(Estudiante pestudiante)
    {
        estudiantes.add(pestudiante);
    }
}