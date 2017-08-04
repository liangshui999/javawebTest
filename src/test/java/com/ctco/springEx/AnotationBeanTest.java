package com.ctco.springEx;

import com.ctco.utils.Log;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by asus-cp on 2017-08-03.
 */
public class AnotationBeanTest {


    @Test
    public void testM(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/ctco/springEx/applicationContext.xml");
        AnotationBean bean = (AnotationBean) context.getBean("anotationBean");

        Log.log("bean = " + bean);
        bean.getDog().fei();
    }

}