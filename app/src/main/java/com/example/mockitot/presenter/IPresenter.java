package com.example.mockitot.presenter;

/**
 * Created by xiecy on 2018/01/09.
 */

public interface IPresenter {

    void clear();

    void login(String name,String password,String message);

    void register(String name ,String password);


}
