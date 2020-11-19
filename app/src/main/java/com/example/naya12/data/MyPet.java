package com.example.naya12.data;

public class MyPet
{
    private String namePet;
    private String codeGPSPet;
    public MyPet(String name, String codeGPS)
    {
        this.namePet=namePet;
        this.codeGPSPet=codeGPSPet;
    }
    public String getNamePet()
    {
        return this.namePet;
    }
    public String getCodeGPSPet()
    {
        return this.codeGPSPet;
    }
    public void setNamePet(String nameset)
    {
        this.namePet=nameset;
    }
    public void setCodeGPSPet(String codeGPSset)
    {
        this.codeGPSPet=codeGPSset;
    }
    public void addPet(String name1, String codeGPS1)
    {
        MyPet person=new MyPet(name1,codeGPS1);
    }
}
