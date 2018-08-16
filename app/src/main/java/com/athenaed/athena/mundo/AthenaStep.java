package com.athenaed.athena.mundo;

import android.os.Parcel;
import android.os.Parcelable;

public class AthenaStep implements Parcelable {

    public String description;
    public int img;

    public AthenaStep(String description, int img) {
        this.img = img;
        this.description = description;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.description);
        dest.writeInt(this.img);
    }

    protected AthenaStep(Parcel in) {
        this.description = in.readString();
        this.img = in.readInt();
    }

    public static final Parcelable.Creator<AthenaStep> CREATOR = new Parcelable.Creator<AthenaStep>() {
        @Override
        public AthenaStep createFromParcel(Parcel source) {
            return new AthenaStep(source);
        }

        @Override
        public AthenaStep[] newArray(int size) {
            return new AthenaStep[size];
        }
    };
}
