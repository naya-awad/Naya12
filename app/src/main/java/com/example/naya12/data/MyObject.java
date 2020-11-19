package com.example.naya12.data;

public class MyObject {

    private String nameObject;
    private String codeGPSObject;//String because it can start with 0

    public MyObject(String name, String codeGPS)
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
        MyPerson person=new MyPerson(name1,codeGPS1);
    }
}
