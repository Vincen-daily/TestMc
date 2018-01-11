package com.example.mockitot.presenter;

import com.example.mockitot.di.AppComponent;
import com.example.mockitot.di.AppModule;

import com.example.mockitot.model.User;
import com.example.mockitot.view.LoginActivity;
import com.example.mockitot.view.LoginView;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by xiecy on 2018/01/09.
 */

public class Presenter implements IPresenter {


    LoginView mLoginView;


    @Inject
    public Presenter(LoginView loginView) {
        this.mLoginView=loginView;
    }

//    public void setLoginView(LoginView loginView){
//        this.loginView=loginView;
//    }

    @Override
    public void clear() {
        mLoginView.clearText();
    }

    @Override
    public void login(String name ,String password,String message) {
        if (name.equals("x")&&password.equals("x")){
            message="login success";
            mLoginView.showLoginSuccess(message);
        }else {
            message="login failure";
            mLoginView.showLoginFailure(message);
            mLoginView.clearText();
        }
    }

    @Override
    public void register(String name, String password) {

    }


     public String add(String a, String b) {
        return a+b;
    }


    public boolean testSpy(String message) {
        return "xx".equals(message);
    }


    public String getMessage(String message) {
        return message;
    }


}
