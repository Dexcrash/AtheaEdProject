package com.athenaed.athena.mundo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class AthenaClass implements Parcelable {

    public ArrayList<AthenaStudent> students = new ArrayList<>();
    public String type;
    public String name;
    public String description;
    public int img_principal;
    public int average;
    public int kinesthetic;
    public int visual;
    public int auditory;

    public AthenaClass(ArrayList<AthenaStudent> students, String type, String name, String description, int img_principal, int average, int kinesthetic, int visual, int auditory) {
        this.students = students;
        this.type = type;
        this.name = name;
        this.description = description;
        this.img_principal = img_principal;
        this.average = average;
        this.kinesthetic = kinesthetic;
        this.visual = visual;
        this.auditory = auditory;
    }

    public void agregarEstudiante(AthenaStudent student)
    {
        this.students.add(student);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.students);
        dest.writeString(this.type);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.img_principal);
        dest.writeInt(this.average);
        dest.writeInt(this.kinesthetic);
        dest.writeInt(this.visual);
        dest.writeInt(this.auditory);
    }

    protected AthenaClass(Parcel in) {
        this.students = in.createTypedArrayList(AthenaStudent.CREATOR);
        this.type = in.readString();
        this.name = in.readString();
        this.description = in.readString();
        this.img_principal = in.readInt();
        this.average = in.readInt();
        this.kinesthetic = in.readInt();
        this.visual = in.readInt();
        this.auditory = in.readInt();
    }

    public static final Creator<AthenaClass> CREATOR = new Creator<AthenaClass>() {
        @Override
        public AthenaClass createFromParcel(Parcel source) {
            return new AthenaClass(source);
        }

        @Override
        public AthenaClass[] newArray(int size) {
            return new AthenaClass[size];
        }
    };
}