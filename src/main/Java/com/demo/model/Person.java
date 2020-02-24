package com.demo.model;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "person")
@XmlType(propOrder = {"id","name","age"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Person{

    @XmlElement
    @SerializedName("id")
    private int id;

    @XmlElement
    @SerializedName("name")
    private String name;

    @XmlElement
    @SerializedName("age")
    private int age;

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
