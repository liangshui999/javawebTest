package com.ctco.springEx.mvc.annotation;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by asus-cp on 2017-08-03.
 *
 * Service("personService")注解相当于在配置文件中添加了id为personService的bean
 * 就像下面这样
 * <bean id="personService" class="com.ctco.springEx.mvc.annotation.PersonServiceIml"/>
 *
 */
@Service("personService")
public class PersonServiceIml implements PersonService {

    @Resource(name = "personDao")
    private PersonDao personDao;

    public void save() {
        personDao.save();
    }
}
