package com.example.naya12;

public class Child<name>
{
    private String name;
    private int codeGPS;

    public Child(String name, int codeGPS)
    {
        this.name=name;
        this.codeGPS=codeGPS;
    }
    public String getName()
    {
        return this.name;
    }
    public int getCodeGPS()
    {
        return this.codeGPS;
    }
    public void setName(String nameset)
    {
        this.name=nameset;
    }
    public void setCodeGPS(int codeGPSset)
    {
        this.codeGPS=codeGPSset;
    }
    public void add(String name1, int codeGPS1)
    {
        Child ch=new Child(name1,codeGPS1);
    }

}
