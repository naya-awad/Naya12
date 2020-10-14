package com.example.naya12;

public class Person<name>
{
    private String namePerson;
    private String codeGPSPerson;

    public Person(String name, String  codeGPS)
    {
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
        Person person=new Person(name1,codeGPS1);
    }

}
