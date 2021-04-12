package com.xvalue.myapplication.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xvalue.myapplication.R;
import com.xvalue.myapplication.adapter.ImageAdapter;
import com.xvalue.myapplication.api.ApiInterface;
import com.xvalue.myapplication.api.RetrofitInstance;
import com.xvalue.myapplication.model.ImageList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendingFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters

    private RecyclerView rv;
    private List<ImageList> imageLists;
    private ApiInterface apiInterface;
    private ImageAdapter adapter;
    private String mParam1;
    private String mParam2;
    private View trendingTabView;
    public TrendingFragment() {

    }

    public static TrendingFragment newInstance(String param1, String param2) {
        TrendingFragment fragment = new TrendingFragment();
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
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        trendingTabView = inflater.inflate(R.layout.fragment_trending, container, false);
        rv=(RecyclerView)trendingTabView.findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));


        apiInterface= RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
//        apicall();
        return trendingTabView;
    }

    public void apicall(){

        Call<List<ImageList>> call=apiInterface.geImgData();
        call.enqueue(new Callback<List<ImageList>>() {
            @Override
            public void onResponse(Call<List<ImageList>> call, Response<List<ImageList>> response) {
                imageLists=response.body();
                adapter=new ImageAdapter(imageLists,getActivity());
                rv.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<ImageList>> call, Throwable t) {

            }
        });

    }
}