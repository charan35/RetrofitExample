package com.journaldev.retrofitintro.Api;

import com.journaldev.retrofitintro.CartFetch.Cartfetch;
import com.journaldev.retrofitintro.pojo.Check_otp;
import com.journaldev.retrofitintro.pojo.otp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {

//        @FormUrlEncoded
//        @POST("user")
//        Call<login> send_otp(@Field("username") String username);

//        @POST("user")
//        @Headers("Content-Type:application/json")
//        Call<login> send_otp(@Body RequestBody params);

        @FormUrlEncoded
        @POST("hitotp.php")
        Call<otp> send_otp(@Field("mobile") String Mobile);

        @FormUrlEncoded
        @POST("cust_signup.php")
        Call<Check_otp> check_otp(@Field("loginid") String Mobile,
                                  @Field("otp") String Otp,
                                  @Field("type") String Type,
                                  @Field("password") String Password,
                                  @Field("device_id") String Device_id);

       /* @POST("cart_fetch2.php")
        @Headers("Content-Type:application/json")
        Call<List<Cartfetch>> getCartList(@Body RequestBody params);*/

//        @FormUrlEncoded
//        @POST("cart_fetch2.php")
//        Call<Cartfetch> getCartList(@Field("cust_id") String Cust_id);

//        @GET("cart_fetch2.php")
//        Call<Cartfetch> getCartList(@Query("cust_id") String Cust_id);

        @FormUrlEncoded
        @POST("cart_fetch2.php")
        @Headers("Content-Type:application/json")
        Call<Cartfetch> getCartList(@Field("cust_id") String Cust_id);

}
