package com.xvalue.myapplication;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.xvalue.myapplication.api.ApiInterface;
import com.xvalue.myapplication.api.RetrofitInstance;
import com.xvalue.myapplication.fragment.AllFragment;
import com.xvalue.myapplication.fragment.AllVideoFragment;
import com.xvalue.myapplication.fragment.DownloadFragment;
import com.xvalue.myapplication.fragment.FavFragment;
import com.xvalue.myapplication.fragment.MostFragment;
import com.xvalue.myapplication.fragment.SettingFragment;
import com.xvalue.myapplication.fragment.TrendingFragment;
import com.xvalue.myapplication.model.HomePageResponse;

import java.io.Serializable;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BottomTab extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    private ApiInterface apiInterface;

    public  HomePageResponse homePageResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_tab);

//        apiInterface= RetrofitInstance.getHomePageService().create(ApiInterface.class);

        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Fragment fragment = new TrendingFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                .commit();

//        homePageService();

    }

    private void homePageService() {

        HashMap<String, String> map = new HashMap<>();
        map.put("user_id","49");
        map.put("language","1");
        map.put("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiOTJmZTkwNWEwN2Q2NzZlZWVhMTRjOGUxODI4YzdmODNmOWNiMmU2NTg3NTM3NzQ1NmZjOWUyN2ZhM2VkOTk3MjQ5ZWEwNGM5ZTc0YzIwYWEiLCJpYXQiOjE2MTgxMjE3NDMsIm5iZiI6MTYxODEyMTc0MywiZXhwIjoxNjQ5NjU3NzQzLCJzdWIiOiI0OSIsInNjb3BlcyI6W119.W3--rcEF4heRIsXquCdXnVxRLs5c4MMnmy1j12jWT4zEXguQmDSeOI8vSN8u_kCg1xE05ZCIP3tIOTul45wDn8d3_ICCXk0ad8h-92LmxvH5PyTbc0CFNJC-DJmR_YgEQo-nJ1Vm_TaxklEo10BvP9FgcnKZ0ci_UEtZbMP5fH4u38fEp4zwlUOozBj7UtvRq04n6v2VOvMIltPW92SB40ABv8KGJFA1WT995Uo6HOwYikvgRpGtj3Npjl-IThTIeCPlIeRdl0f2nN9g8ymu3XpA_8vTCQp7MGM6HTyH-c7uuSj9wZD4Yfg2vfvtpaItIhv95Vt541ueVdq2uqt_c9jhLQTiKSGAPlL5CqKYf1I2tEG-AXxv7PTDRprQHeVk8a4p8HQYwkXMrARIYssfvEskTIkcmrIqEGyclFFTPFhe91VE96En8WOCHeuOMBhkjTyoYm8gbVESyHBE_8ZV6DSkTh5MbyaS7N9r_u9M-GY46Mpvz7Jst_0bNBoyAfKaiXzFBR2oQgmianIVMMpkmwKREUZWpOlAK03qnRBxD_hMaM6Cbcx55wveFiraomUvRVpKFcsdjPeqB2TIYogeod8j1HFQZ4HYrqaqkqUxUJyBaVJGXOIqzUdBa970lK-DI6rTx1D_pW0wxPrHN-oRCzZzMy1QQSnoLQDYDdfhgBA");
        map.put("Content-Type","application/json");
        Log.d("getHomeAllSer_params:","getHomeAllSer_params:"+new Gson().toJson(map));
        Call<HomePageResponse> call = apiInterface.getHomeAllService("Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiOTJmZTkwNWEwN2Q2NzZlZWVhMTRjOGUxODI4YzdmODNmOWNiMmU2NTg3NTM3NzQ1NmZjOWUyN2ZhM2VkOTk3MjQ5ZWEwNGM5ZTc0YzIwYWEiLCJpYXQiOjE2MTgxMjE3NDMsIm5iZiI6MTYxODEyMTc0MywiZXhwIjoxNjQ5NjU3NzQzLCJzdWIiOiI0OSIsInNjb3BlcyI6W119.W3--rcEF4heRIsXquCdXnVxRLs5c4MMnmy1j12jWT4zEXguQmDSeOI8vSN8u_kCg1xE05ZCIP3tIOTul45wDn8d3_ICCXk0ad8h-92LmxvH5PyTbc0CFNJC-DJmR_YgEQo-nJ1Vm_TaxklEo10BvP9FgcnKZ0ci_UEtZbMP5fH4u38fEp4zwlUOozBj7UtvRq04n6v2VOvMIltPW92SB40ABv8KGJFA1WT995Uo6HOwYikvgRpGtj3Npjl-IThTIeCPlIeRdl0f2nN9g8ymu3XpA_8vTCQp7MGM6HTyH-c7uuSj9wZD4Yfg2vfvtpaItIhv95Vt541ueVdq2uqt_c9jhLQTiKSGAPlL5CqKYf1I2tEG-AXxv7PTDRprQHeVk8a4p8HQYwkXMrARIYssfvEskTIkcmrIqEGyclFFTPFhe91VE96En8WOCHeuOMBhkjTyoYm8gbVESyHBE_8ZV6DSkTh5MbyaS7N9r_u9M-GY46Mpvz7Jst_0bNBoyAfKaiXzFBR2oQgmianIVMMpkmwKREUZWpOlAK03qnRBxD_hMaM6Cbcx55wveFiraomUvRVpKFcsdjPeqB2TIYogeod8j1HFQZ4HYrqaqkqUxUJyBaVJGXOIqzUdBa970lK-DI6rTx1D_pW0wxPrHN-oRCzZzMy1QQSnoLQDYDdfhgBA","49","1","");
        call.enqueue(new Callback<HomePageResponse>() {
            @Override
            public void onResponse(Call<HomePageResponse> call, Response<HomePageResponse> response) {
                if (response.code() == 200) {
                    Log.d("getHomeAllSer_response:","getHomeAllSer_response:"+new Gson().toJson(response.body()));
                    Toast.makeText(BottomTab.this, "getHomeAllService  Successfull: ", Toast.LENGTH_SHORT).show();
                    homePageResponse = response.body();
                    if(homePageResponse.getStatus().equals("success")) {
                        Intent intent = new Intent(BottomTab.this, BottomTab.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(BottomTab.this, "Login Status: False", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(BottomTab.this, "Unable to reach server....", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<HomePageResponse> call, Throwable t) {
                Log.d("register1:","register:1");
                t.printStackTrace();

            }
        });


    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_action, menu) ;

        return true ;
    }*/

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_trending:
                    Log.e("Fragment", "TESTING");

                    Fragment fragment = new TrendingFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    //openFragment(TrendingFragment.newInstance("", ""));

//                    Fragment fragment = new HomeFragment();
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
//                            .commit();
//
//                    openFragment(HomeFragment.newInstance("",""));

//                    Fragment fragment = new TrendingFragment();
//                    Bundle bundle = new Bundle();
//                    HomePageResponse obj = homePageResponse;
//                    bundle.putSerializable("homepageresponse", (Serializable) obj);
//                    fragment.setArguments(bundle);



                    return true;
                case R.id.navigation_most:

                    Fragment fragment1 = new MostFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment1, fragment1.getClass().getSimpleName())
                            .commit();
                    //openFragment(MostFragment.newInstance("", ""));


//                    Fragment fragment1 = new AllVideoFragment();
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.container, fragment1, fragment1.getClass().getSimpleName())
//                            .commit();
//                    openFragment(AllVideoFragment.newInstance("", ""));

                    return true;
                case R.id.navigation_all:
                    Fragment fragment2 = new AllFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment2, fragment2.getClass().getSimpleName())
                            .commit();
                   // openFragment(AllFragment.newInstance("", ""));

//                    Fragment fragment2 = new DownloadFragment();
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.container, fragment2, fragment2.getClass().getSimpleName())
//                            .commit();
//                     openFragment(AllFragment.newInstance("", ""));

                    return true;
                case R.id.navigation_fav:
                    Fragment fragment3 = new FavFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment3, fragment3.getClass().getSimpleName())
                            .commit();
                    //openFragment(FavFragment.newInstance("", ""));

//                    Fragment fragment3 = new SettingFragment();
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.container, fragment3, fragment3.getClass().getSimpleName())
//                            .commit();
//                    openFragment(SettingFragment.newInstance("", ""));

                    return true;

            }
            return false;
        }
    };


}
