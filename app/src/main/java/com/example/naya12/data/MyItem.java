package com.example.naya12.data;

public class MyItem
{
    /*
    Item's name
     */
    private String nameItem;
    /*
    Item's phone
     */
    private String phoneItem;
    /*
    Item's type (pet, person, Item)
     */
    private String typeItem;



    /*
    constructors
     */

    public MyItem() {

    }

    public MyItem(String nameItem, String phoneItem, String typeItem) {
        this.nameItem = nameItem;
        this.phoneItem = phoneItem;
        this.typeItem = typeItem;
    }

    /*
    getters & setters
     */

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getPhoneItem() {
        return phoneItem;
    }

    public void setPhoneItem(String phoneItem) {
        this.phoneItem = phoneItem;
    }

    public String getTypeItem() {
        return typeItem;
    }

    public void setTypeItem(String typeItem) {
        this.typeItem = typeItem;
    }


    @Override
    public String toString() {
        return "MyItem{" +
                "nameItem='" + nameItem + '\'' +
                ", phoneItem='" + phoneItem + '\'' +
                ", typeItem='" + typeItem + '\'' +
                '}';
    }
}
