package com.example.naya12.data;

public class MyClient {
    private String nameClient;
    private String phoneClient;//String because it can start with 0



    public MyClient(String nameClient, String phoneClient) {
        this.nameClient = nameClient;
        this.phoneClient = phoneClient;
    }
    public MyClient() {

    }

    public String getNameClient(String name) {
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

    @Override
    public String toString() {
        return "MyClient{" +
                "nameClient='" + nameClient + '\'' +
                ", phoneClient='" + phoneClient + '\'' +
                '}';
    }
}


