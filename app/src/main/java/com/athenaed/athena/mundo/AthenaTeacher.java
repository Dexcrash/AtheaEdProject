package com.athenaed.athena.mundo;

import java.util.ArrayList;

public class AthenaTeacher {

    String institution;
    String name;
    int kinesthetic;
    int visual;
    int auditory;
    ArrayList<AthenaClass> classes = new ArrayList<>();

    public AthenaTeacher(String institution, String name) {
        this.institution = institution;
        this.name = name;
        this.kinesthetic = 5;
        this.visual = 5;
        this.auditory = 5;
    }

    public void addAthenaClass(AthenaClass athenaClass){
        this.classes.add(athenaClass);
    }
}