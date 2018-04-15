package com.athenaed.athena.mundo;

public class AthenaActivity {

    public String name;
    public String description;
    public int img_principal;
    public int img_extra_1;
    public int img_extra_2;
    public int img_extra_3;
    public int kinesthetic;
    public int visual;
    public int auditory;

    public AthenaActivity(String name, String description, int kinesthetic, int visual, int auditory, int img_principal) {
        this.name = name;
        this.description = description;
        this.kinesthetic = kinesthetic;
        this.visual = visual;
        this.auditory = auditory;
    }
}
