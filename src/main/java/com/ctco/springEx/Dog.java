package com.ctco.springEx;

import com.ctco.utils.Log;

/**
 * Created by asus-cp on 2017-08-03.
 */
public class Dog {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void fei(){
        Log.log("Dog.....fei");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
