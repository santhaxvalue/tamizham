package com.xvalue.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.xvalue.myapplication.BottomTab;
import com.xvalue.myapplication.R;
import com.xvalue.myapplication.api.ApiInterface;
import com.xvalue.myapplication.api.RetrofitInstance;
import com.xvalue.myapplication.model.LoginResponse;
import com.xvalue.myapplication.utils.Constants;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextView loginbutton,email,password,create_account;

    private ApiInterface apiInterface;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        apiInterface= RetrofitInstance.getLogin().create(ApiInterface.class);

        sharedpreferences = getSharedPreferences(Constants.MYPREFERENCE,
                Context.MODE_PRIVATE);

        loginbutton = (TextView)findViewById(R.id.loginbutton);
        email = (TextView)findViewById(R.id.email);
        password = (TextView)findViewById(R.id.password);
        create_account = (TextView)findViewById(R.id.create_account);

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_str = email.getText().toString();
                String password_str = password.getText().toString();

                loginMethod(email_str,password_str);

            }
        });

    }

    private void loginMethod(String email_str, String password_str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("email",email_str);
        map.put("password",password_str);
        Log.d("login_params:","login_params:"+new Gson().toJson(map));
        Call<LoginResponse> call = apiInterface.getLoginData(map);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.code() == 200) {
                    Log.d("login_response:","login_response:"+new Gson().toJson(response.body()));
                    Toast.makeText(LoginActivity.this, "Login  Successfull: ", Toast.LENGTH_SHORT).show();
                    LoginResponse loginResponse = response.body();
                    if(loginResponse.getStatus().equals("success")) {

                        String username = loginResponse.getData().getUserDetails().getFirstName();
                        String email = loginResponse.getData().getUserDetails().getEmail();
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(Constants.MYUSERNAME, username);
                        editor.putString(Constants.EMAIL, email);
                        editor.commit();

                        Intent intent = new Intent(LoginActivity.this, BottomTab.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginActivity.this, "Login Status: False", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(LoginActivity.this, "Unable to reach server....", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("register1:","register:1");
                t.printStackTrace();

            }
        });


    }
}