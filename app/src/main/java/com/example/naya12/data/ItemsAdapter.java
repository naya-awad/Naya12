package com.example.naya12.data;
import java.util.ArrayList;

public class ItemsAdapter {

    private ArrayList<MyItem> arrItem;

    public ItemsAdapter(ArrayList<MyItem> arrItem) {
        this.arrItem = arrItem;
    }

    public ArrayList<MyItem> getArrItem() {
        return arrItem;
    }

    public void setArrItem(ArrayList<MyItem> arrItem) {
        this.arrItem = arrItem;
    }

    @Override
    public String toString() {
        return "ItemsAdapter{" +
                "arrItem=" + arrItem +
                '}';
    }
}
