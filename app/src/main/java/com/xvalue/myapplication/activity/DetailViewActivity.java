package com.xvalue.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.xvalue.myapplication.R;

public class DetailViewActivity extends AppCompatActivity {

    String title_str = "",timer_str = "";

    TextView title_TextView,timer_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        title_TextView = (TextView)findViewById(R.id.title);
        timer_TextView = (TextView)findViewById(R.id.timer_);

        getIntentData();

        title_TextView.setText(title_str);
        timer_TextView.setText(timer_str);
        
    }

    private void getIntentData() {

        title_str = getIntent().getStringExtra("title");
        timer_str = getIntent().getStringExtra("time");

    }
}