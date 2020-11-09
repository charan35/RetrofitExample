package com.journaldev.retrofitintro.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class login {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("status_code")
    @Expose
    public String status_code;

    @SerializedName("data")
    @Expose
    public List<Datum> data = null;

    public class Datum {

        @SerializedName("userId")
        @Expose
        public String userId;
        @SerializedName("username")
        @Expose
        public String username;
        @SerializedName("phone_number")
        @Expose
        public String phone_number;
        @SerializedName("otp")
        @Expose
        public String otp;
        @SerializedName("gender")
        @Expose
        public String gender;
        @SerializedName("email")
        @Expose
        public String email;
        @SerializedName("profile_name")
        @Expose
        public String profile_name;
        @SerializedName("date_of_birth")
        @Expose
        public String date_of_birth;
        @SerializedName("location")
        @Expose
        public String location;

    }
}

