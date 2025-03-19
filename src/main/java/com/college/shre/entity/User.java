package com.college.shre.entity;


public class User {

    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String toString()
    {
    return "User details : id ="+id+ ", name : "+name +" , email: "+email;
    
    }

}
