package com.ctco.springEx;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by asus-cp on 2017-08-03.
 */
public class HelloSpringTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void myTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/ctco/springEx/applicationContext.xml");
        HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
        helloSpring.sayHello();
    }

}