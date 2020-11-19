package com.example.naya12.data;

import java.util.Queue;

public class MyPerson<name>
{
    private String namePerson;
    private String codeGPSPerson;

    public MyPerson(String name, String  codeGPS)
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
    public boolean addPerson(String name1, String codeGPS1)
    {
        MyPerson person=new MyPerson(name1,codeGPS1);
        Queue<MyPerson> q=new Queue<MyPerson>();
        while ()

    }

}
