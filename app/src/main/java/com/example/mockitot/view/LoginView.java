package com.example.mockitot.view;

/**
 * Created by xiecy on 2018/01/09.
 */

public interface LoginView {

       void showLoginSuccess(String message);

       void showLoginFailure(String message);

       void clearText();
}
