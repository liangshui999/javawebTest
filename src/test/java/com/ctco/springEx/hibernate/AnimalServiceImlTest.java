package com.ctco.springEx.hibernate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by asus-cp on 2017-08-07.
 */
public class AnimalServiceImlTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/ctco/springEx/hibernate/applicationContext.xml");
        AnimalService animalService = (AnimalService) context.getBean("animalService");
        Animal animal = new Animal("dog大黄", 20);
        animalService.save(animal);
    }

}