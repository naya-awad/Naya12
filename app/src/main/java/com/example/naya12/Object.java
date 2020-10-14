package com.example.naya12;

public class Object {

    private String nameObject;
    private String codeGPSObject;//String because it can start with 0

    public Object(String name, String codeGPS)
    {
        this.nameObject=nameObject;
        this.codeGPSObject=codeGPSObject;
    }
    public String getNameObject()
    {
        return this.nameObject;
    }
    public String getCodeGPSObject()
    {
        return this.codeGPSObject;
    }
    public void setNamePerson(String nameset)
    {
        this.nameObject=nameset;
    }
    public void setCodeGPSPerson(String codeGPSset)
    {
        this.codeGPSObject=codeGPSset;
    }
    public void addPerson(String name1, String codeGPS1)
    {
        Person person=new Person(name1,codeGPS1);
    }
}
