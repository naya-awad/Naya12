package com.example.naya12.data;

public class MyPerson<name> extends MyPet
{
    private String namePerson;
    private String codeGPSPerson;

    public MyPerson() {
    }

    public MyPerson(String namePerson, String  codeGPSPerson)
    {
        super();
        this.namePerson=namePerson;
        this.codeGPSPerson=codeGPSPerson;
    }
    public String getNamePerson()
    {
        return this.namePerson;
    }
    public String getCodeGPSPerson()
    {
        return this.codeGPSPerson;
    }
    public void setNamePerson(String nameset)
    {
        this.namePerson=nameset;
    }
    public void setCodeGPSPerson(String codeGPSset)
    {
        this.codeGPSPerson=codeGPSset;
    }
    public void addPerson(String name1, String codeGPS1)
    {

    }

}
