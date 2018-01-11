package com.example.mockitot;

import android.app.Application;

import com.example.mockitot.di.AppComponent;
import com.example.mockitot.di.AppModule;
import com.example.mockitot.di.ComponentHolder;
import com.example.mockitot.di.DaggerAppComponent;
import com.example.mockitot.view.LoginView;

/**
 * Created by xiecy on 2018/01/09.
 */

public class MyApplication extends Application {

    LoginView loginView;

    @Override
    public void onCreate() {
        super.onCreate();

//        AppComponent appComponent = DaggerAppComponent.builder()
//                .appModule(new AppModule(this))
//                .build();
//        ComponentHolder.setAppComponent(appComponent);
    }
}
