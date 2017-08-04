package com.ctco.springEx.mvc.annotation;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by asus-cp on 2017-08-03.
 *
 * Controller("personAction")相当于在配置文件中加了
 * <bean id="personAction" class="com.ctco.springEx.mvc.annotation.PersonAction"/>
 */
@Controller("personAction")
public class PersonAction {

    /**
     * 相当于在配置文件中注入了id为personService的bean，就像下面那样
     * 务必确保配置文件中有id为personService的bean，否则会报错的
     *
     * <bean id="personAction" class="com.ctco.springEx.mvc.annotation.PersonAction">
            <property name="personService" ref="personService"/>
     </bean>
     <bean id="personService" class="com.ctco.springEx.mvc.annotation.PersonServiceIml"/>
     *
     */
    @Resource(name="personService")
    private PersonService personService;

    public void save(){
        personService.save();
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
