package com.ctco.springEx.hibernate;


import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * Created by asus-cp on 2017-08-07.
 *
 * 需要继承HibernateDaoSupport
 */
public class AnimalDaoIml extends HibernateDaoSupport implements AnimalDao{

    public void save(Animal animal) {
        getHibernateTemplate().save(animal);
    }
}
