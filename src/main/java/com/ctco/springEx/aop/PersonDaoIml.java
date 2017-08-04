package com.ctco.springEx.aop;

import com.ctco.utils.Log;

/**
 * Created by asus-cp on 2017-08-04.
 */
public class PersonDaoIml implements PersonDao {

    public void save() {
        Log.log("PersonDaoIml............save()");
    }

    public void delete() {
        Log.log("PersonDaoIml............delete()");
    }

    public void update() {
        Log.log("PersonDaoIml............update()");
    }

    public void getAllPerson() {
        Log.log("PersonDaoIml............getAllPerson()");
    }
}
