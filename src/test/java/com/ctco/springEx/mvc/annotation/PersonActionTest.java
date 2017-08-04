package com.ctco.springEx.mvc.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by asus-cp on 2017-08-03.
 */
public class PersonActionTest {

    @Test
    public void testM(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/ctco/springEx/mvc/annotation/applicationContext.xml");
        PersonAction personAction = (PersonAction) context.getBean("personAction");
        personAction.save();
    }

}