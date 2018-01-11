package com.example.mockitot.presenter;

import android.speech.SpeechRecognizer;
import android.support.v4.widget.TextViewCompat;

import com.example.mockitot.BuildConfig;
import com.example.mockitot.di.AppComponent;
import com.example.mockitot.di.AppModule;
import com.example.mockitot.di.DaggerAppComponent;
import com.example.mockitot.model.User;
import com.example.mockitot.view.LoginView;

import org.apache.maven.settings.RuntimeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
 * @BeforeClass的作用是，在跑一个测试类的所有测试方法之前，会执行一次被@BeforeClass修饰的方法，
 * 执行完所有测试方法之后，会执行一遍被@AfterClass修饰的方法。
 * 这两个方法可以用来setup和release一些公共的资源，需要注意的是，被这两个annotation修饰的方法必须是静态的。
 *
 * Mockito.mock()并不是mock一整个类，而是根据传进去的一个类，mock出属于这个类的一个对象，
 * 并且返回这个mock对象；而传进去的这个类本身并没有改变，用这个类new出来的对象也没有受到任何改变！
 */

public class PresenterTest {

    LoginView loginView;

    Presenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new Presenter(loginView);
    }


    @Test
    public void login() throws Exception {

        Presenter mockPresenter = mock(Presenter.class);


        doThrow(new RuntimeException()).when(mockPresenter).login("x", "x", null);



        mockPresenter.login("xx", "x", null);

    }

    @Test
    public void test1() {

        Presenter mockPresenter = mock(Presenter.class);

        when(mockPresenter.getMessage("nihao")).thenReturn("success");

        System.out.println(mockPresenter.getMessage("nihao"));

        System.out.println(verify(mockPresenter).getMessage("nihao"));

    }

    @Test
    public void register() throws Exception {
    }

    @Test
    public void test2() throws Exception {
        String result = presenter.add("hello", "world");
        assertEquals("helloworld", result);
    }

    @Test
    public void testSpy() {
        Presenter spyPresenter = Mockito.spy(new Presenter(loginView));
        spyPresenter.add("11","22");

       // when(spyPresenter.add("aa","bb")).thenCallRealMethod();
       // Mockito.verify(spyPresenter).testSpy("xx");
       // Mockito.when(spyPresenter.add("a","aaa")).thenReturn("x");

        doReturn("1").when(spyPresenter).add("11","22");


    }

    @Test
    public void test3(){
        Presenter mockPresenter = mock(Presenter.class);

        mockPresenter.add("aa","bb");
        mockPresenter.add("aa","bb");
        mockPresenter.add("aa","bb");

        verify(mockPresenter, times(3)).add("aa","bb");

       // Mockito.doCallRealMethod();

        //verify(mockPresenter).add("aa","bb");

      //  when(mockPresenter.add("a","b")).thenReturn("first");
      //  when(mockPresenter.add("aa","b")).thenThrow(new RuntimeException());

      //  System.out.println(mockPresenter.add("a","b"));


       System.out.println(mockPresenter.add("aa","b"));
    }

}