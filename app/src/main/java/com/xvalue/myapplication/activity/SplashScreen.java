package com.xvalue.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.xvalue.myapplication.BottomTab;
import com.xvalue.myapplication.R;
import com.xvalue.myapplication.utils.Constants;

public class SplashScreen extends AppCompatActivity {

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        sharedpreferences = getSharedPreferences(Constants.MYPREFERENCE,
                Context.MODE_PRIVATE);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                String name_str = sharedpreferences.getString(Constants.MYUSERNAME, null);
                String email_str = sharedpreferences.getString(Constants.EMAIL, null);

                if(name_str != null && email_str != null){
                    Intent intent = new Intent(SplashScreen.this, BottomTab.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        }, 5000);


    }
}
