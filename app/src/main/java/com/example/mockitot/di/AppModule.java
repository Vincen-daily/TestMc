package com.example.mockitot.di;

import android.content.Context;
import android.support.v4.widget.CircularProgressDrawable;

import com.example.mockitot.model.User;
import com.example.mockitot.presenter.Presenter;
import com.example.mockitot.view.LoginView;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.annotations.Nullable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by xiecy on 2018/01/09.
 */

@Module
public class AppModule {


    private LoginView loginView;

    public AppModule(LoginView loginView){
        this.loginView=loginView;
    }


    @Provides
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient okhttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
        return okhttpClient;
    }

    @Provides
    public Retrofit provideRetrofit(OkHttpClient okhttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okhttpClient)
                .baseUrl("https://free-api.heweather.com/s6/weather/")
                .build();
        return retrofit;
    }


    @Provides
    public LoginView provideLoginView(){
        return loginView;
    }

}
