package com.xvalue.myapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.xvalue.myapplication.R;
import com.xvalue.myapplication.activity.SplashScreen;
import com.xvalue.myapplication.utils.Constants;

public class FavFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    SharedPreferences sharedpreferences;

    TextView name,email;
    RelativeLayout logoutlayout;

    public FavFragment() {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_fav, container, false);

        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        logoutlayout = view.findViewById(R.id.logoutlayout);

        sharedpreferences = getActivity().getSharedPreferences(Constants.MYPREFERENCE,
                Context.MODE_PRIVATE);

        String name_str = sharedpreferences.getString(Constants.MYUSERNAME, null);
        String email_str = sharedpreferences.getString(Constants.EMAIL, null);

        name.setText(name_str);
        email.setText(email_str);

        logoutlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Constants.MYUSERNAME,null);
                editor.putString(Constants.EMAIL, null);
                editor.commit();

                Toast.makeText(getActivity(), "LogOut Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), SplashScreen.class);
                startActivity(intent);

            }
        });


        return view;
    }
}