package com.athenaed.athena.mundo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class AthenaTeacher implements Parcelable {

    public String institution;
    public String name;
    public int kinesthetic;
    public int visual;
    public int auditory;
    public ArrayList<AthenaClass> classes = new ArrayList<>();

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.institution);
        dest.writeString(this.name);
        dest.writeInt(this.kinesthetic);
        dest.writeInt(this.visual);
        dest.writeInt(this.auditory);
        dest.writeList(this.classes);
    }

    protected AthenaTeacher(Parcel in) {
        this.institution = in.readString();
        this.name = in.readString();
        this.kinesthetic = in.readInt();
        this.visual = in.readInt();
        this.auditory = in.readInt();
        this.classes = new ArrayList<AthenaClass>();
        in.readList(this.classes, AthenaClass.class.getClassLoader());
    }

    public static final Parcelable.Creator<AthenaTeacher> CREATOR = new Parcelable.Creator<AthenaTeacher>() {
        @Override
        public AthenaTeacher createFromParcel(Parcel source) {
            return new AthenaTeacher(source);
        }

        @Override
        public AthenaTeacher[] newArray(int size) {
            return new AthenaTeacher[size];
        }
    };
}