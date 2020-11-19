package com.example.naya12;

import com.example.naya12.data.MyPerson;

import java.util.Queue;

public class PersonData
{
    private Queue<MyPerson> qPerson;


    public PersonData(Queue<MyPerson> qPerson)
    {
        this.qPerson=qPerson;

    }
    public Queue<MyPerson> getqPerson() {
        return this.qPerson;
    }
}
