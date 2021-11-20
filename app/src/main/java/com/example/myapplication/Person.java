package com.example.myapplication;


import java.util.ArrayList;

public class Person {
    int _id;
    String _name;
    String _email;

    // Empty constructor
    public Person(){

    }
    // constructor
    public Person(int id, String name, String _email){
        this._id = id;
        this._name = name;
        this._email = _email;
    }

    // constructor
    public Person(String name, String _email){
        this._name = name;
        this._email = _email;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getEmail(){
        return this._email;
    }

    // setting phone number
    public void setEmail(String email){
        this._email = email;
    }
}

