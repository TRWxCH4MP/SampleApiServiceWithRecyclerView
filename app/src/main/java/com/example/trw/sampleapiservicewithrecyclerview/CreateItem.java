package com.example.trw.sampleapiservicewithrecyclerview;

import com.example.trw.sampleapiservicewithrecyclerview.item.BaseItem;
import com.example.trw.sampleapiservicewithrecyclerview.item.Item;
import com.example.trw.sampleapiservicewithrecyclerview.repo.Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TRW on 3/9/2560.
 */

public class CreateItem {

    public static List<BaseItem> createItem(Collection collection) {
        List<BaseItem> itemList = new ArrayList<>();

        for (int index = 0; index < collection.getItems().size(); index++) {

            itemList.add(new Item()
                    .setTitle(collection.getItems().get(index).getTitle())
                    .setImage(collection.getItems().get(index).getImages().get(0).getUrl())
            );
        }
        return itemList;
    }

}
