package com.ctco.springEx.mvc.annotation;

import com.ctco.utils.Log;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by asus-cp on 2017-08-03.
 */
@Repository("personDao")
public class PersonDaoIml implements PersonDao {

    public void save() {
        Log.log("save动作执行");
    }
}
