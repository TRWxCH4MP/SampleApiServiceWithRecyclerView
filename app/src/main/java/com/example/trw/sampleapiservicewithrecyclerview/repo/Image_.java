package com.example.trw.sampleapiservicewithrecyclerview.repo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by TRW on 1/9/2560.
 */

public class Image_ implements Parcelable {

    @SerializedName("url")
    @Expose
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
    }

    public Image_() {
    }

    protected Image_(Parcel in) {
        this.url = in.readString();
    }

    public static final Parcelable.Creator<Image_> CREATOR = new Parcelable.Creator<Image_>() {
        @Override
        public Image_ createFromParcel(Parcel source) {
            return new Image_(source);
        }

        @Override
        public Image_[] newArray(int size) {
            return new Image_[size];
        }
    };
}
