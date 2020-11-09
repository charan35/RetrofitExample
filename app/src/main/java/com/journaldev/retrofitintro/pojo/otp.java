package com.journaldev.retrofitintro.pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class otp {

    @SerializedName("OTP IS")
    @Expose
    public String OTP_IS;

    public otp() {
    }

    public otp(String OTP_IS) {
        this.OTP_IS = OTP_IS;
    }

    public String getOTP_IS() {
        return OTP_IS;
    }

    public void setOTP_IS(String OTP_IS) {
        this.OTP_IS = OTP_IS;
    }
}
