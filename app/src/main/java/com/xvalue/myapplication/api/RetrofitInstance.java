package com.xvalue.myapplication.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    //old code
    private static Retrofit retrofit=null;
    private static final String BASE_URL = "https://uniqueandrocode.000webhostapp.com/hiren/retrofit/";
    public static Retrofit getRetrofitInstance(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }

    //new code

    public static Retrofit getRetrofitInstanceNewOne(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://3.6.233.52/tamizham/public/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }


    public static Retrofit getLogin(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://3.6.233.52/tamizham/public/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }

    public static Retrofit getAllVideos(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://3.6.233.52/tamizham/public/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }

    public static Retrofit getRegister(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://3.6.233.52/tamizham/public/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }



}
