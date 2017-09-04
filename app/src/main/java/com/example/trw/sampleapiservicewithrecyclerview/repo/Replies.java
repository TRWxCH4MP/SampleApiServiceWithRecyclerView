package com.example.trw.sampleapiservicewithrecyclerview.repo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by TRW on 30/8/2560.
 */

public class Replies implements Parcelable {

    @SerializedName("totalItems")
    @Expose
    private String totalItems;
    @SerializedName("selfLink")
    @Expose
    private String selfLink;

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.totalItems);
        dest.writeString(this.selfLink);
    }

    public Replies() {
    }

    protected Replies(Parcel in) {
        this.totalItems = in.readString();
        this.selfLink = in.readString();
    }

    public static final Parcelable.Creator<Replies> CREATOR = new Parcelable.Creator<Replies>() {
        @Override
        public Replies createFromParcel(Parcel source) {
            return new Replies(source);
        }

        @Override
        public Replies[] newArray(int size) {
            return new Replies[size];
        }
    };
}
