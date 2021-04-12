package com.xvalue.myapplication.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;
import com.xvalue.myapplication.BottomTab;
import com.xvalue.myapplication.R;
import com.xvalue.myapplication.api.ApiInterface;
import com.xvalue.myapplication.api.RetrofitInstance;
import com.xvalue.myapplication.model.RegisterResponse;
import com.xvalue.myapplication.utils.Constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    TextView signUpTextView,fullname,email,mobilenumber,password,confirmpassword,mobilenumberlabel;

    private ApiInterface apiInterface;

    private static final int RC_SIGN_IN = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        apiInterface= RetrofitInstance.getRegister().create(ApiInterface.class);

        mobilenumberlabel = (TextView)findViewById(R.id.mobilenumberlabel);
        signUpTextView = (TextView)findViewById(R.id.signUpTextView);
        fullname = (TextView)findViewById(R.id.fullname);
        email = (TextView)findViewById(R.id.email);
        mobilenumber = (TextView)findViewById(R.id.mobilenumber);
        password = (TextView)findViewById(R.id.password);
        confirmpassword = (TextView)findViewById(R.id.confirmpassword);

        mobilenumberlabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifymobileno();
            }
        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullname_str = fullname.getText().toString();
                String email_str = email.getText().toString();
                String mobilenumber_str = mobilenumber.getText().toString();
                String password_str = password.getText().toString();
                String confirmpassword_str = confirmpassword.getText().toString();

                if(!fullname_str.equals("") && fullname_str != null && !email_str.equals("") &&
                        email_str != null && !password_str.equals("") && password_str != null ) {

//                    if(password_str.equals(confirmpassword_str)) {

//                        if (new Networkutils(SignUpActivity.this).isConnectingToInternet()) {

                    String lastName = "";
                    String mobileNo  = "";
                    String phoneNo = "";
                    int userTypeId = 1;
                    boolean isDeleted = false;
                    String addressId = "";
                    String isEmailVerification = "";
                    String user_detailscol = "";

                    signUpMethod(fullname_str, email_str, password_str, confirmpassword_str,
                            lastName,mobileNo,phoneNo,userTypeId,isDeleted,addressId,
                            isEmailVerification,user_detailscol);

//                        }else{
//                            Toast.makeText(SignUpActivity.this, "Please check internet connection...", Toast.LENGTH_SHORT).show();
//                        }

//                        Toast.makeText(SignUpActivity.this, "Please give confirm password as same  ", Toast.LENGTH_SHORT).show();
//                    }
                }else{
                    Toast.makeText(SignUpActivity.this, "Fill all field", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null && user.getPhoneNumber() != null) {
                    mobilenumber.setText(user.getPhoneNumber());

                } else {
                    Toast.makeText(this, "Not get the phoneno", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    private void verifymobileno() {

        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.PhoneBuilder().build());
        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setTheme(R.style.OTPTheme)
                        .build(),
                RC_SIGN_IN);

    }

    private void signUpMethod(String fullname_str, String email_str, String password_str,
                              String confirmpassword_str, String lastName, String mobileNo, String phoneNo, int userTypeId,
                              boolean isDeleted, String addressId, String isEmailVerification, String user_detailscol) {


        HashMap map = new HashMap<>();
        map.put(Constants.FIRSTNAME,fullname_str);
        map.put(Constants.EMAIL,email_str);
        map.put(Constants.PASSWORD,password_str);
        map.put(Constants.CONFIRMPASSWORD,confirmpassword_str);
        map.put(Constants.LASTNAME,"");
        map.put(Constants.MOBILENO,"");
        map.put(Constants.PHONENO,"");
        map.put(Constants.USERTYPEID, userTypeId);
        map.put(Constants.ISDELETED, isDeleted);
        map.put(Constants.ADDRESSID,"");
        map.put(Constants.ISEMAILVERIFICATION,isEmailVerification);
        map.put(Constants.USERDETAILSCOL,user_detailscol);

        Log.d("register_params:","register_params:"+new Gson().toJson(map));
        Call<RegisterResponse> call = apiInterface.getRegisterResponseNew(email_str,password_str,
                confirmpassword_str,fullname_str,"","","",
                userTypeId,isDeleted,"",isEmailVerification,user_detailscol);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                Log.d("register_response:","register_response:"+response.errorBody());
                Log.d("register_response1:","register_response1:"+response.code());
                Log.d("register_response11:","register_response11:"+response.message());
                Log.d("register_response111:","register_response111:"+response.headers());
                if (response.code() == 200) {
                    Log.d("register_response1111:","register_response1111:"+new Gson().toJson(response.body()));
                    Toast.makeText(SignUpActivity.this, "Successfully Register: ", Toast.LENGTH_SHORT).show();
                    RegisterResponse registerResponse = response.body();
                    if(registerResponse.getStatus().equals("success")) {
                        Intent intent = new Intent(SignUpActivity.this, BottomTab.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(SignUpActivity.this, "Register Status: False", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(SignUpActivity.this, "Unable to reach server....", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Log.d("registe1r:","register:1");
                t.printStackTrace();
            }
        });

    }
}