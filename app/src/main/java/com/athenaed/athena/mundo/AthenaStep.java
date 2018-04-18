package com.athenaed.athena.mundo;

public class AthenaStep {

    public String title;
    public String description;
    public int number;

    public AthenaStep(String title, String description, int number) {
        this.number = number;
        this.title = title;
        this.description = description;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
