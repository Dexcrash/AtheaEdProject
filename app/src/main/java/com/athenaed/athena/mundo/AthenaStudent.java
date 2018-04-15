package com.athenaed.athena.mundo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class AthenaStudent implements Parcelable {

    String name;
    int kinesthetic;
    int visual;
    int auditory;

    public AthenaStudent(String name) {
        this.name = name;
        this.kinesthetic = 0;
        this.visual = 0;
        this.auditory = 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.kinesthetic);
        dest.writeInt(this.visual);
        dest.writeInt(this.auditory);
    }

    protected AthenaStudent(Parcel in) {
        this.name = in.readString();
        this.kinesthetic = in.readInt();
        this.visual = in.readInt();
        this.auditory = in.readInt();
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
