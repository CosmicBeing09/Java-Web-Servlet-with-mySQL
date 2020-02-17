package com.demo.Converter;

import com.demo.model.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class JSONconverter<T> {

    private final Gson gson;

    public JSONconverter(){
     gson = new GsonBuilder().create();
    }

    public String objectToJSON(T t){
        return gson.toJson(t);
    }

    public T JSONtoObject(String json, Type t){
        return (T) gson.fromJson(json,t.getClass());
    }
}
