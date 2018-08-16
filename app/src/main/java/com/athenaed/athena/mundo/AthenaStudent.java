package com.athenaed.athena.mundo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class AthenaStudent implements Parcelable {

    public String name;
    public int img_profile;
    public double musical;
    public double corporal;
    public double interpersonal;
    public double linguistico;
    public double logico;
    public double naturalista;
    public double intrapersonal;
    public double visual;
    public String comentarios;

    public AthenaStudent(String name, int img_profile, double musical, double corporal, double interpersonal, double linguistico, double logico, double naturalista, double intrapersonal, double visual, String comentarios) {
        this.name = name;
        this.img_profile = img_profile;
        this.musical = musical;
        this.corporal = corporal;
        this.interpersonal = interpersonal;
        this.linguistico = linguistico;
        this.logico = logico;
        this.naturalista = naturalista;
        this.intrapersonal = intrapersonal;
        this.visual = visual;
        this.comentarios = comentarios;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.img_profile);
        dest.writeDouble(this.musical);
        dest.writeDouble(this.corporal);
        dest.writeDouble(this.interpersonal);
        dest.writeDouble(this.linguistico);
        dest.writeDouble(this.logico);
        dest.writeDouble(this.naturalista);
        dest.writeDouble(this.intrapersonal);
        dest.writeDouble(this.visual);
        dest.writeString(this.comentarios);
    }

    protected AthenaStudent(Parcel in) {
        this.name = in.readString();
        this.img_profile = in.readInt();
        this.musical = in.readDouble();
        this.corporal = in.readDouble();
        this.interpersonal = in.readDouble();
        this.linguistico = in.readDouble();
        this.logico = in.readDouble();
        this.naturalista = in.readDouble();
        this.intrapersonal = in.readDouble();
        this.visual = in.readDouble();
        this.comentarios = in.readString();
    }

    public static final Parcelable.Creator<AthenaStudent> CREATOR = new Parcelable.Creator<AthenaStudent>() {
        @Override
        public AthenaStudent createFromParcel(Parcel source) {
            return new AthenaStudent(source);
        }

        @Override
        public AthenaStudent[] newArray(int size) {
            return new AthenaStudent[size];
        }
    };
}
