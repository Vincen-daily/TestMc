package com.example.mockitot.di;

import com.example.mockitot.model.User;
import com.example.mockitot.presenter.Presenter;
import com.example.mockitot.view.LoginActivity;

import dagger.Component;

/**
 * Created by xiecy on 2018/01/09.
 */

@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(LoginActivity loginActivity);


}
