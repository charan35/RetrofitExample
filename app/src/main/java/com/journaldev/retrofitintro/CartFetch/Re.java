
package com.journaldev.retrofitintro.CartFetch;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Re {

    @SerializedName("cust_id")
    private String custId;
    @Expose
    private String date;
    @SerializedName("partner_id")
    private String partnerId;
    @Expose
    private List<Product> products;
    @SerializedName("total_part")
    private Long totalPart;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getTotalPart() {
        return totalPart;
    }

    public void setTotalPart(Long totalPart) {
        this.totalPart = totalPart;
    }

}
