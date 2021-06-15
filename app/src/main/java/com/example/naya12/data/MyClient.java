package com.example.naya12.data;

public class MyClient {
    private String nameClient;
    private String phoneClient;//String because it can start with 0
    private String phoneOwner;
    private String emailCl;

    private String typeClient;
    private String keyCl;
    private String ownerCl;


    public MyClient(String nameClient, String phoneClient, String phoneOwner, String typeClient) {
        this.nameClient = nameClient;
        this.phoneClient = phoneClient;
        this.phoneOwner = phoneOwner;
        this.typeClient = typeClient;
    }

    public MyClient() {

    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getPhoneClient() {
        return phoneClient;
    }

    public void setPhoneClient(String phoneClient) {
        this.phoneClient = phoneClient;
    }

    public String getPhoneOwner() {
        return phoneOwner;
    }

    public void setPhoneOwner(String phoneOwner) {
        this.phoneOwner = phoneOwner;
    }


    public String getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }

    public String getKeyCl() {
        return keyCl;
    }

    public void setKeyCl(String keyCl) {
        this.keyCl = keyCl;
    }

    public String getOwnerCl() {
        return ownerCl;
    }

    public void setOwnerCl(String ownerCl) {
        this.ownerCl = ownerCl;
    }

    @Override
    public String toString() {
        return "MyClient{" +
                "nameClient='" + nameClient + '\'' +
                ", phoneClient='" + phoneClient + '\'' +
                '}';
    }
}


