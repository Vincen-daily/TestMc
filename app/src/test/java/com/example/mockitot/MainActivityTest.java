package com.example.mockitot;

import android.content.Intent;
import android.widget.Button;

import com.example.mockitot.view.LoginActivity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;

import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertEquals;


/**
 * Created by xiecy on 2018/01/10.
 *
 *
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    @Test
    public void testMainActivity()throws Exception{
        MainActivity mainActivity= Robolectric.setupActivity(MainActivity.class);
         mainActivity.findViewById(R.id.button).performClick();

        Intent intent1=new Intent(mainActivity, LoginActivity.class);
        ShadowActivity shadowActivity= Shadows.shadowOf(mainActivity);
        Intent intent2=shadowActivity.getNextStartedActivity();
        Assert.assertEquals(intent1,intent2);
    }

    @Test
    public void testJump() throws Exception {

        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        activity.findViewById(R.id.button).performClick();


        ShadowActivity shadowActivity = Shadows.shadowOf(activity);

        Intent nextIntent = shadowActivity.getNextStartedActivity();

        assertEquals(nextIntent.getComponent().getClassName(), LoginActivity.class.getName());
    }

}