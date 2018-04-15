package com.athenaed.athena.mundo;

import java.util.ArrayList;

public class AthenaStudent{

    public String name;
    int kinesthetic;
    int visual;
    int auditory;
    public ArrayList<AthenaClass> classes = new ArrayList<>();

    public AthenaStudent(String name) {
        this.name = name;
        this.kinesthetic = 0;
        this.visual = 0;
        this.auditory = 0;
    }

}
