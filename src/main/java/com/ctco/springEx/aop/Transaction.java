package com.ctco.springEx.aop;

import com.ctco.utils.Log;

/**
 * Created by asus-cp on 2017-08-04.
 */
public class Transaction {

    public void beginTransaction(){
        Log.log("Transaction................beginTransaction()");
    }

    public void commit(){
        Log.log("Transaction....................commit()");
    }

}
