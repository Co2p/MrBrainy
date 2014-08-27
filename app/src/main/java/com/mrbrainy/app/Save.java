package com.mrbrainy.app;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gordoncooper on 27/08/14.
 */

public class Save implements Parcelable{

    private Parcel save;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel save, int score) {
        save.writeInt(score);
    }
}
