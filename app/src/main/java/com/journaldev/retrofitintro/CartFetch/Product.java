
package com.journaldev.retrofitintro.CartFetch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @Expose
    private Long amount;
    @Expose
    private String img;
    @Expose
    private String name;
    @SerializedName("partnr_id")
    private String partnrId;
    @Expose
    private String price;
    @Expose
    private String qty;
    @Expose
    private String shipchr;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartnrId() {
        return partnrId;
    }

    public void setPartnrId(String partnrId) {
        this.partnrId = partnrId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getShipchr() {
        return shipchr;
    }

    public void setShipchr(String shipchr) {
        this.shipchr = shipchr;
    }

}
