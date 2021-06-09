package com.example.naya12.data;

public class MyOwner {

    private String phone, firstn, lastn,emailOw;

    public MyOwner(String phone, String firstn, String lastn, String emailOw) {
        this.phone = phone;
        this.firstn = firstn;
        this.lastn = lastn;
        this.emailOw= emailOw;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstn() {
        return firstn;
    }

    public void setFirstn(String firtn) {
        this.firstn = firtn;
    }

    public String getLastn() {
        return lastn;
    }

    public void setLastn(String lastn) {
        this.lastn = lastn;
    }

    public String getEmailOw() {
        return emailOw;
    }

    public void setEmailOw(String emailOw) {
        this.emailOw = emailOw;
    }

    @Override
    public String toString() {
        return "MyOwner{" +
                "phone='" + phone + '\'' +
                ", firtn='" + firstn + '\'' +
                ", lastn='" + lastn + '\'' +
                '}';
    }
}
