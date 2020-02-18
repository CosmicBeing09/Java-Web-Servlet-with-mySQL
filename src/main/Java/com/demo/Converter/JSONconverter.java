package com.demo.Converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONconverter<T> {

    private  Gson gson;



    public JSONconverter(){
     gson = new GsonBuilder().create();
    }

    public String objectToJSON(T t){
        return gson.toJson(t);
    }

    public T JSONtoObject(String json,Class<T> t){
        return  gson.fromJson(json,t);
    }
}
