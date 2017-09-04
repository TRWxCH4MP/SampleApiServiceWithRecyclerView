package com.example.trw.sampleapiservicewithrecyclerview.holder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.trw.sampleapiservicewithrecyclerview.R;
import com.example.trw.sampleapiservicewithrecyclerview.contextor.Contextor;

/**
 * Created by TRW on 30/8/2560.
 */

public class ItemViewHolder extends BaseViewHolder {

    private TextView textViewTitle;
    private ImageView imageView;

    public ItemViewHolder(View itemView) {
        super(itemView);

        textViewTitle = (TextView) itemView.findViewById(R.id.tv_title);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
    }

    public void setTitle(String title) {
        textViewTitle.setText(title);
    }

    public void setImage(String image) {
        Glide.with(itemView.getContext())
                .load(image)
                .into(imageView);
    }
}
