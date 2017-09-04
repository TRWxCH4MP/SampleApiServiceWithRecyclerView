package com.example.trw.sampleapiservicewithrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.trw.sampleapiservicewithrecyclerview.R;
import com.example.trw.sampleapiservicewithrecyclerview.ViewType;
import com.example.trw.sampleapiservicewithrecyclerview.contextor.Contextor;
import com.example.trw.sampleapiservicewithrecyclerview.holder.BaseViewHolder;
import com.example.trw.sampleapiservicewithrecyclerview.holder.ItemViewHolder;
import com.example.trw.sampleapiservicewithrecyclerview.item.BaseItem;
import com.example.trw.sampleapiservicewithrecyclerview.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TRW on 30/8/2560.
 */

public class MainAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<BaseItem> itemList = new ArrayList<>();

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;

        if (viewType == ViewType.TYPE_ITEM_VIEW) {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item, parent, false);
            return new ItemViewHolder(v);
        }

        throw new RuntimeException("type is not match");
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        BaseItem i = itemList.get(position);
        if (holder instanceof ItemViewHolder) {
            Item items = (Item) i;
            ((ItemViewHolder) holder).setTitle(items.getTitle());
            ((ItemViewHolder) holder).setImage(items.getImage());
        }
    }

    public void setItemList(List<BaseItem> itemList) {
        this.itemList = itemList;

        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return itemList.get(position).getType();
    }

    @Override
    public int getItemCount() {

        if (!itemList.isEmpty() || itemList != null) {
            return itemList.size();
        }
        return 0;
    }
}
