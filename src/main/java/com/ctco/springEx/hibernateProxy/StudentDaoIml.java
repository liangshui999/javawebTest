package com.ctco.springEx.hibernateProxy;

import com.ctco.utils.Log;

/**
 * Created by asus-cp on 2017-08-04.
 */
public class StudentDaoIml implements StudentDao {

    public void addStudent() {
        Log.log("StudentDaoIml...........addStudent()");
    }

    public void deleteStudent() {
        Log.log("StudentDaoIml...........deleteStudent()");
    }

    public void updateStudent() {
        Log.log("StudentDaoIml...........updateStudent()");
    }

    public void getAllStudent() {
        Log.log("StudentDaoIml...........getAllStudent()");
    }
}
