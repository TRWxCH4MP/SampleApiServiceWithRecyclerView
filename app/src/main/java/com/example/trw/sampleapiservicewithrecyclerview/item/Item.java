package com.example.trw.sampleapiservicewithrecyclerview.item;

import android.app.Activity;

import com.bumptech.glide.Glide;
import com.example.trw.sampleapiservicewithrecyclerview.ViewType;
import com.example.trw.sampleapiservicewithrecyclerview.repo.Image;

import java.util.List;


/**
 * Created by TRW on 30/8/2560.
 */

public class Item extends BaseItem {

    private String title;
    private String image;

    public Item() {
        super(ViewType.TYPE_ITEM_VIEW);
    }

    public String getTitle() {
        return title;
    }

    public Item setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Item setImage(String image) {
        this.image = image;
        return this;
    }
}
