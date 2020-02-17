package com.demo.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Person{

    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;

    @SerializedName("age")
    int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
