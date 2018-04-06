package com.athenaed.athena.mundo;

import java.util.ArrayList;

public class Estudiante {

    public String nombre;
    public String tipo;
    public ArrayList<Clase> clases = new ArrayList<>();

    public Estudiante(String pnombre, String ptipo)
    {
        nombre = pnombre;
        tipo = ptipo;
    }
}
