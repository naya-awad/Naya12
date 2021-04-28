package com.example.naya12.data;

public class MyOwner {

    private String phone, firtn, lastn;

    public MyOwner(String phone, String firtn, String lastn) {
        this.phone = phone;
        this.firtn = firtn;
        this.lastn = lastn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirtn() {
        return firtn;
    }

    public void setFirtn(String firtn) {
        this.firtn = firtn;
    }

    public String getLastn() {
        return lastn;
    }

    public void setLastn(String lastn) {
        this.lastn = lastn;
    }

    @Override
    public String toString() {
        return "MyOwner{" +
                "phone='" + phone + '\'' +
                ", firtn='" + firtn + '\'' +
                ", lastn='" + lastn + '\'' +
                '}';
    }
}
