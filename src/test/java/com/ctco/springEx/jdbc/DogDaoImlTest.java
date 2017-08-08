package com.ctco.springEx.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by asus-cp on 2017-08-07.
 */
public class DogDaoImlTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/ctco/springEx/jdbc/applicationContext.xml");
        DogService dogService = (DogService) context.getBean("dogService");
        dogService.save();
    }

}