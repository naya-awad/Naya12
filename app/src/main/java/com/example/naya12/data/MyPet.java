package com.example.naya12.data;

public class MyPet extends MyClient
{
    private String namePet;
    private String codeGPSPet;



    public MyPet()
    {

    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public String getCodeGPSPet() {
        return codeGPSPet;
    }

    public void setCodeGPSPet(String codeGPSPet) {
        this.codeGPSPet = codeGPSPet;
    }

    @Override
    public String toString() {
        return "MyPet{" +
                "namePet='" + namePet + '\'' +
                ", codeGPSPet='" + codeGPSPet + '\'' +
                '}';
    }
}
