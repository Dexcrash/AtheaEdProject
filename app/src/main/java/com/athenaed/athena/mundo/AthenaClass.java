package com.athenaed.athena.mundo;

import java.util.ArrayList;

public class AthenaClass {

    public ArrayList<AthenaStudent> students = new ArrayList<>();
    public String type;
    public int average;

    public AthenaClass(ArrayList<AthenaStudent> students, String type, int average) {
        this.students = students;
        this.type = type;
        this.average = average;
    }

    public void agregarEstudiante(AthenaStudent student)
    {
        this.students.add(student);
    }
}