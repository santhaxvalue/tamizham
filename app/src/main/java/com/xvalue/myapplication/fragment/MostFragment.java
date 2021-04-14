package com.xvalue.myapplication.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.xvalue.myapplication.R;
import com.xvalue.myapplication.adapter.AllVideoListAdapter;
import com.xvalue.myapplication.adapter.TrendingVideoListAdapter;
import com.xvalue.myapplication.adapter.VideoListAdapter;
import com.xvalue.myapplication.api.ApiInterface;
import com.xvalue.myapplication.api.RetrofitInstance;
import com.xvalue.myapplication.model.HomePageResponse;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ApiInterface apiInterface;
    private AllVideoListAdapter allVideoListAdapter;

    private TrendingVideoListAdapter trendingVideoListAdapter;

    LinearLayout pop_layout, trending_layout, recent_layout;
    private TextView mTextMessage, pop_txt, trending_txt, recent_txt, networkPlaceholderTxt, exp_text, empty_view;

    RecyclerView nv_recycler_view, pop_recycler_view, search_recycler_view;

    private View view;


    private List<HomePageResponse.Data.AllVideo> homePageSingleResponseAll;
    private List<HomePageResponse.Data.FavouriteVideo> homePageSingleResponseFavourite;
    private List<HomePageResponse.Data.Trending> homePageSingleResponseTrend;

    public MostFragment() {

    }

    public static MostFragment newInstance(String param1, String param2) {
        MostFragment fragment = new MostFragment();
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

        view =  inflater.inflate(R.layout.fragment_most, container, false);

        initLayout();

        apiInterface= RetrofitInstance.getHomePageService().create(ApiInterface.class);

        homePageService();



        pop_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popularVideo();

                trending_layout.setBackgroundResource(android.R.color.transparent);
                trending_txt.setTextColor(Color.parseColor("#7C7C7C"));

                pop_layout.setBackgroundResource(R.drawable.new_border_left_side);
                pop_txt.setTextColor(Color.parseColor("#000000"));


            }
        });

        trending_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trendingVideos();

                pop_layout.setBackgroundResource(android.R.color.transparent);
                pop_txt.setTextColor(Color.parseColor("#7C7C7C"));

                trending_layout.setBackgroundResource(R.drawable.new_border_left_side);
                trending_txt.setTextColor(Color.parseColor("#000000"));

            }
        });

        return view;

    }


    private void trendingVideos() {

        trendingVideoListAdapter = new TrendingVideoListAdapter(getActivity(),homePageSingleResponseTrend);
        LinearLayoutManager VerticalLayout = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        pop_recycler_view.setLayoutManager(VerticalLayout);
        pop_recycler_view.setAdapter(trendingVideoListAdapter);

    }

    private void popularVideo() {


        allVideoListAdapter = new AllVideoListAdapter(getActivity(),homePageSingleResponseAll);
        LinearLayoutManager VerticalLayout = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        pop_recycler_view.setLayoutManager(VerticalLayout);
        pop_recycler_view.setAdapter(allVideoListAdapter);


    }

    private void initLayout() {

        pop_layout = view.findViewById(R.id.pop_layout);
        trending_layout = view.findViewById(R.id.trending_layout);
        recent_layout = view.findViewById(R.id.recent_layout);

        pop_txt = view.findViewById(R.id.pop_txt);
        trending_txt = view.findViewById(R.id.trending_txt);
        recent_txt = view.findViewById(R.id.recent_txt);

        pop_recycler_view = view.findViewById(R.id.pop_recycler_view);
        pop_recycler_view.setNestedScrollingEnabled(false);

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
                    Toast.makeText(getActivity(), "getHomeAllService  Successfull: ", Toast.LENGTH_SHORT).show();


                    homePageSingleResponseAll = response.body().getData().getAllVideos();
                    homePageSingleResponseTrend = response.body().getData().getTrending();


                    allVideoListAdapter = new AllVideoListAdapter(getActivity(),homePageSingleResponseAll);
                    LinearLayoutManager VerticalLayout = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                    pop_recycler_view.setLayoutManager(VerticalLayout);
                    pop_recycler_view.setAdapter(allVideoListAdapter);



//                    HomePageResponse loginResponse = response.body();
//                    if(loginResponse.getStatus().equals("success")) {
//                        Intent intent = new Intent(getActivity(), BottomTab.class);
//                        startActivity(intent);
//                    }else {
//                        Toast.makeText(getActivity(), "Login Status: False", Toast.LENGTH_SHORT).show();
//                    }
                }else {
                    Toast.makeText(getActivity(), "Unable to reach server....", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<HomePageResponse> call, Throwable t) {
                Log.d("register1:","register:1");
                t.printStackTrace();

            }
        });


    }
}