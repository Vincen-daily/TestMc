package com.example.mockitot.model;

import org.litepal.crud.DataSupport;

import javax.inject.Inject;

/**
 * Created by xiecy on 2018/01/09.
 */

public class User extends DataSupport {


    String name;

    String password;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
