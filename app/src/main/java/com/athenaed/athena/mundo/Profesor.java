package com.athenaed.athena.mundo;

import java.util.ArrayList;

public class Profesor {

    public String institucion;
    public String nombre;
    public int cantidadVisual = 0;
    public int cantidadKinestesico = 0;
    public int cantidadAuditivo = 0;
    public int promedioVisual = 0;
    public int promedioKinestesico = 0;
    public int promedioAuditivo = 0;
    public ArrayList<Clase> clases = new ArrayList<>();


    public Profesor(String pinstitucion, String pnombre)
    {
        institucion = pinstitucion;
        nombre = pnombre;
    }

    public void agregarClase(Clase pclase)
    {
        clases.add(pclase);
        if(pclase.tipo.equals("kinestesico"))
        {
            promedioKinestesico = promedioKinestesico*cantidadKinestesico;
            promedioKinestesico += pclase.promedio;
            cantidadKinestesico++;
            promedioKinestesico = promedioKinestesico/cantidadKinestesico;
        }
        else if(pclase.tipo.equals("auditivo"))
        {
            promedioAuditivo = promedioAuditivo*cantidadAuditivo;
            promedioAuditivo += pclase.promedio;
            cantidadAuditivo++;
            promedioAuditivo = promedioAuditivo/cantidadAuditivo;
        }
        else if(pclase.tipo.equals("visual"))
        {
            promedioVisual = promedioVisual*cantidadVisual;
            promedioVisual += pclase.promedio;
            cantidadVisual++;
            promedioVisual = promedioVisual/cantidadVisual;
        }
    }
}