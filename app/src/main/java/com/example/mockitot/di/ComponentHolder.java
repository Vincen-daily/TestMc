package com.example.mockitot.di;

/**
 * Created by xiecy on 2018/01/10.
 */

public class ComponentHolder {

    private static AppComponent sAppComponent;

    public static void setAppComponent(AppComponent appComponent) {
        sAppComponent = appComponent;
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }
}
