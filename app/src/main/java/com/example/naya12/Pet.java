package com.example.naya12;

public class Pet
{
    private String namePet;
    private String codeGPSPet;
    public Pet(String name, String codeGPS)
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
        Pet person=new Pet(name1,codeGPS1);
    }
}
