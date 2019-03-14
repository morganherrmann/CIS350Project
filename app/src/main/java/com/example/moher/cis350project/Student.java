package com.example.moher.cis350project;

/**
 * Created by Morgan Herrmann on 3/14/2019.
 */

public class Student {


    private String id;
    private String firstName;
    private String lastName;

    private String userName;
    private String password;

    private String parentID;


    public Student(String firstName, String lastName, String userName, String password){

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;

    }


    public void setParent(String parentID){
        this.parentID = parentID;
    }

    public void setName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }






}


