package com.athenaed.athena.mundo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class AthenaActivity implements Parcelable {

    public String name;
    public String description;
    public int img_principal;
    public int kinesthetic;
    public int visual;
    public int auditory;
    public ArrayList<AthenaStep> steps;


    public AthenaActivity(){    }

    public AthenaActivity(String name, String description, int img_principal, int kinesthetic, int visual, int auditory, ArrayList<AthenaStep> steps) {
        this.name = name;
        this.description = description;
        this.img_principal = img_principal;
        this.kinesthetic = kinesthetic;
        this.visual = visual;
        this.auditory = auditory;
        this.steps = steps;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.img_principal);
        dest.writeInt(this.kinesthetic);
        dest.writeInt(this.visual);
        dest.writeInt(this.auditory);
        dest.writeTypedList(this.steps);
    }

    protected AthenaActivity(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.img_principal = in.readInt();
        this.kinesthetic = in.readInt();
        this.visual = in.readInt();
        this.auditory = in.readInt();
        this.steps = in.createTypedArrayList(AthenaStep.CREATOR);
    }

    public static final Creator<AthenaActivity> CREATOR = new Creator<AthenaActivity>() {
        @Override
        public AthenaActivity createFromParcel(Parcel source) {
            return new AthenaActivity(source);
        }

        @Override
        public AthenaActivity[] newArray(int size) {
            return new AthenaActivity[size];
        }
    };
}