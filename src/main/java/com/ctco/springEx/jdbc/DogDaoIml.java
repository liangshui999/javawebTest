package com.ctco.springEx.jdbc;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by asus-cp on 2017-08-07.
 */
public class DogDaoIml extends JdbcDaoSupport implements DogDao {

    public void save(Dog dog) {
        getJdbcTemplate().execute("insert into dog values(" + dog.getId() + "," + "'" + dog.getName() + "')");
    }
}
