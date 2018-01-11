package com.example.mockitot.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mockitot.R;
import com.example.mockitot.di.AppComponent;
import com.example.mockitot.di.AppModule;


import com.example.mockitot.di.ComponentHolder;
import com.example.mockitot.di.DaggerAppComponent;
import com.example.mockitot.presenter.IPresenter;
import com.example.mockitot.presenter.Presenter;

import java.util.InvalidPropertiesFormatException;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,LoginView{

    private EditText userAccount;

    private EditText userPassword;

    private Button login;

    private Button register;

    String message;

   // IPresenter iPresenter=new Presenter(this);

   @Inject
    Presenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build(); //<=
        appComponent.inject(this);

//        ComponentHolder.getAppComponent().inject(this);
    }

    public void initView() {
        userAccount=findViewById(R.id.login_account);
        userPassword=findViewById(R.id.login_password);
        login=findViewById(R.id.login);
        register=findViewById(R.id.register);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                presenter.login(userAccount.getText().toString(),userPassword.getText().toString(),message);
                break;
            case R.id.register:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        }
    }


    @Override
    public void showLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this,WeatherActivity.class));

    }

    @Override
    public void showLoginFailure(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearText() {
            userAccount.setText("");
            userPassword.setText("");
    }
}
