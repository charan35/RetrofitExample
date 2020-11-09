package com.journaldev.retrofitintro.pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Check_otp {

    @SerializedName("customer_id")
    @Expose
    public String customer_id;

    @SerializedName("message")
    @Expose
    public String message;

    public Check_otp() {
    }

    public Check_otp(String customer_id, String message) {
        this.customer_id = customer_id;
        this.message = message;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
