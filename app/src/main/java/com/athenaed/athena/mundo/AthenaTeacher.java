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
    public ArrayList<AthenaActivity> activities = new ArrayList<>();

    public AthenaTeacher(String institution, String name, int kinesthetic, int visual, int auditory, ArrayList<AthenaClass> classes, ArrayList<AthenaActivity> activities) {
        this.institution = institution;
        this.name = name;
        this.kinesthetic = kinesthetic;
        this.visual = visual;
        this.auditory = auditory;
        this.classes = classes;
        this.activities = activities;
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
        dest.writeTypedList(this.classes);
        dest.writeTypedList(this.activities);
    }

    protected AthenaTeacher(Parcel in) {
        this.institution = in.readString();
        this.name = in.readString();
        this.kinesthetic = in.readInt();
        this.visual = in.readInt();
        this.auditory = in.readInt();
        this.classes = in.createTypedArrayList(AthenaClass.CREATOR);
        this.activities = in.createTypedArrayList(AthenaActivity.CREATOR);
    }

    public static final Creator<AthenaTeacher> CREATOR = new Creator<AthenaTeacher>() {
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