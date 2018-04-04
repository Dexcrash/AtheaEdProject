package com.athenaed.athena.mundo;

import java.util.ArrayList;

public class ProfesorTemp {

    public String institucion;
    public String nombre;
    public ArrayList<ClaseTemp> clases;


    public ProfesorTemp(String pinstitucion, String pnombre)
    {
        institucion = pinstitucion;
        nombre = pnombre;
        clases.add(new ClaseTemp(40));
    }
}
