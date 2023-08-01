package com.ltp.globalsuperstore.storeReopository;

import java.util.ArrayList;
import java.util.List;

import com.ltp.globalsuperstore.Item;

public class Respository {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public void updateItem(int index, Item item){
        items.set(index, item);
    }

    public Item getItemByIndex(int index){
        return items.get(index);
    }

    public List<Item> getAllItems(){
        return items;
    }
}
