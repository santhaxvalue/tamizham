package com.xvalue.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.xvalue.myapplication.BottomTab;
import com.xvalue.myapplication.R;
import com.xvalue.myapplication.activity.LoginActivity;
import com.xvalue.myapplication.api.ApiInterface;
import com.xvalue.myapplication.api.RetrofitInstance;
import com.xvalue.myapplication.model.AllVideoResponse;
import com.xvalue.myapplication.model.LoginResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllFragment extends Fragment {

    private ApiInterface apiInterface;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private View view;
    private RecyclerView recyclerViewOffline;

    public AllFragment() {

    }

    public static AllFragment newInstance(String param1, String param2) {
        AllFragment fragment = new AllFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_all, container, false);


        initLayout();

//        apiInterface= RetrofitInstance.getAllVideos().create(ApiInterface.class);

//        getAllVideos();



        return view;

    }

    private void initLayout() {
        recyclerViewOffline = view.findViewById(R.id.offline_video_list);
    }

    private void getAllVideos() {

        HashMap<String, String> map = new HashMap<>();
        map.put("user_id","49");
        map.put("language","1");
        map.put("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiOTJmZTkwNWEwN2Q2NzZlZWVhMTRjOGUxODI4YzdmODNmOWNiMmU2NTg3NTM3NzQ1NmZjOWUyN2ZhM2VkOTk3MjQ5ZWEwNGM5ZTc0YzIwYWEiLCJpYXQiOjE2MTgxMjE3NDMsIm5iZiI6MTYxODEyMTc0MywiZXhwIjoxNjQ5NjU3NzQzLCJzdWIiOiI0OSIsInNjb3BlcyI6W119.W3--rcEF4heRIsXquCdXnVxRLs5c4MMnmy1j12jWT4zEXguQmDSeOI8vSN8u_kCg1xE05ZCIP3tIOTul45wDn8d3_ICCXk0ad8h-92LmxvH5PyTbc0CFNJC-DJmR_YgEQo-nJ1Vm_TaxklEo10BvP9FgcnKZ0ci_UEtZbMP5fH4u38fEp4zwlUOozBj7UtvRq04n6v2VOvMIltPW92SB40ABv8KGJFA1WT995Uo6HOwYikvgRpGtj3Npjl-IThTIeCPlIeRdl0f2nN9g8ymu3XpA_8vTCQp7MGM6HTyH-c7uuSj9wZD4Yfg2vfvtpaItIhv95Vt541ueVdq2uqt_c9jhLQTiKSGAPlL5CqKYf1I2tEG-AXxv7PTDRprQHeVk8a4p8HQYwkXMrARIYssfvEskTIkcmrIqEGyclFFTPFhe91VE96En8WOCHeuOMBhkjTyoYm8gbVESyHBE_8ZV6DSkTh5MbyaS7N9r_u9M-GY46Mpvz7Jst_0bNBoyAfKaiXzFBR2oQgmianIVMMpkmwKREUZWpOlAK03qnRBxD_hMaM6Cbcx55wveFiraomUvRVpKFcsdjPeqB2TIYogeod8j1HFQZ4HYrqaqkqUxUJyBaVJGXOIqzUdBa970lK-DI6rTx1D_pW0wxPrHN-oRCzZzMy1QQSnoLQDYDdfhgBA");
        map.put("Content-Type","application/json");
        Log.d("getAllVideos_params:","getAllVideos_params:"+new Gson().toJson(map));
        Call<AllVideoResponse> call = apiInterface.getAllVideos("Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiOTJmZTkwNWEwN2Q2NzZlZWVhMTRjOGUxODI4YzdmODNmOWNiMmU2NTg3NTM3NzQ1NmZjOWUyN2ZhM2VkOTk3MjQ5ZWEwNGM5ZTc0YzIwYWEiLCJpYXQiOjE2MTgxMjE3NDMsIm5iZiI6MTYxODEyMTc0MywiZXhwIjoxNjQ5NjU3NzQzLCJzdWIiOiI0OSIsInNjb3BlcyI6W119.W3--rcEF4heRIsXquCdXnVxRLs5c4MMnmy1j12jWT4zEXguQmDSeOI8vSN8u_kCg1xE05ZCIP3tIOTul45wDn8d3_ICCXk0ad8h-92LmxvH5PyTbc0CFNJC-DJmR_YgEQo-nJ1Vm_TaxklEo10BvP9FgcnKZ0ci_UEtZbMP5fH4u38fEp4zwlUOozBj7UtvRq04n6v2VOvMIltPW92SB40ABv8KGJFA1WT995Uo6HOwYikvgRpGtj3Npjl-IThTIeCPlIeRdl0f2nN9g8ymu3XpA_8vTCQp7MGM6HTyH-c7uuSj9wZD4Yfg2vfvtpaItIhv95Vt541ueVdq2uqt_c9jhLQTiKSGAPlL5CqKYf1I2tEG-AXxv7PTDRprQHeVk8a4p8HQYwkXMrARIYssfvEskTIkcmrIqEGyclFFTPFhe91VE96En8WOCHeuOMBhkjTyoYm8gbVESyHBE_8ZV6DSkTh5MbyaS7N9r_u9M-GY46Mpvz7Jst_0bNBoyAfKaiXzFBR2oQgmianIVMMpkmwKREUZWpOlAK03qnRBxD_hMaM6Cbcx55wveFiraomUvRVpKFcsdjPeqB2TIYogeod8j1HFQZ4HYrqaqkqUxUJyBaVJGXOIqzUdBa970lK-DI6rTx1D_pW0wxPrHN-oRCzZzMy1QQSnoLQDYDdfhgBA","49","1");
        call.enqueue(new Callback<AllVideoResponse>() {
            @Override
            public void onResponse(Call<AllVideoResponse> call, Response<AllVideoResponse> response) {
                if (response.code() == 200) {
                    Log.d("getAllVideos_response:","getAllVideos_response:"+new Gson().toJson(response.body()));
//                    Toast.makeText(getActivity(), "getAllVideos  Successfull: ", Toast.LENGTH_SHORT).show();
                    AllVideoResponse loginResponse = response.body();
                    if(loginResponse.getStatus().equals("success")) {
                        Intent intent = new Intent(getActivity(), BottomTab.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getActivity(), "Login Status: False", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getActivity(), "Unable to reach server....", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<AllVideoResponse> call, Throwable t) {
                Log.d("register1:","register:1");
                t.printStackTrace();

            }
        });



    }
}

