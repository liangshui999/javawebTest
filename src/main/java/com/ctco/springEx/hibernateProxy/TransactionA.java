package com.ctco.springEx.hibernateProxy;

import com.ctco.utils.Log;

/**
 * Created by asus-cp on 2017-08-04.
 */
public class TransactionA {

    public void beginTransaction(){
        Log.log("TransactionA.........beginTransaction");
    }

    public void commitTransaction(){
        Log.log("TransactionA.........commitTransaction");
    }

}
