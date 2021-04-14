package com.xvalue.myapplication.api;

import com.xvalue.myapplication.model.AllVideoResponse;
import com.xvalue.myapplication.model.HomePageResponse;
import com.xvalue.myapplication.model.ImageList;
import com.xvalue.myapplication.model.LoginResponse;
import com.xvalue.myapplication.model.RegisterResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("getdata.php")
    Call<List<ImageList>> geImgData();

    @FormUrlEncoded
    @POST("api/register")
    Call<RegisterResponse> getRegisterResponse(@FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST("api/register")
    Call<RegisterResponse> getRegisterResponseNew( @Field("email") String email,
                                                   @Field("password") String password,
                                                   @Field("c_password") String c_password,
                                                   @Field("firstName") String firstName,
                                                   @Field("lastName") String lastName,
                                                   @Field("mobileNo") String mobileNo,
                                                   @Field("phoneNo") String phoneNo,
                                                   @Field("userTypeId") int userTypeId,
                                                   @Field("isDeleted") boolean isDeleted,
                                                   @Field("addressId") String addressId,
                                                   @Field("isEmailVerification") String isEmailVerification,
                                                   @Field("user_detailscol") String user_detailscol);



    @FormUrlEncoded
    @POST("api/getAllVideos")
    Call<AllVideoResponse> getAllVideos(@Header("Authorization") String BearerToken,@Field("user_id") String user_id,
                                        @Field("language") String language);


    @FormUrlEncoded
    @POST("api/homepageService")
    Call<HomePageResponse> getHomeAllService(@Header("Authorization") String BearerToken, @Field("user_id") String user_id,
                                             @Field("language") String language, @Field("SearchText") String searchtext);


    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> getLoginData(@FieldMap Map<String,String> map);



}
