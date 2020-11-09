package com.journaldev.retrofitintro.pojo;

import com.google.gson.annotations.SerializedName;

public class Sub_Sub_Category {

    @SerializedName("cat_id") private String cat_id;
    @SerializedName("subcat_id") private String subcat_id;
    @SerializedName("subsubcat_id") private String subsubcat_id;
    @SerializedName("subsubcat_name") private String subsubcat_name;
    @SerializedName("subsubcat_img") private String subsubcat_img;

    public Sub_Sub_Category() {
    }

    public Sub_Sub_Category(String cat_id, String subcat_id, String subsubcat_id, String subsubcat_name, String subsubcat_img) {
        this.cat_id = cat_id;
        this.subcat_id = subcat_id;
        this.subsubcat_id = subsubcat_id;
        this.subsubcat_name = subsubcat_name;
        this.subsubcat_img = subsubcat_img;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getSubcat_id() {
        return subcat_id;
    }

    public void setSubcat_id(String subcat_id) {
        this.subcat_id = subcat_id;
    }

    public String getSubsubcat_id() {
        return subsubcat_id;
    }

    public void setSubsubcat_id(String subsubcat_id) {
        this.subsubcat_id = subsubcat_id;
    }

    public String getSubsubcat_name() {
        return subsubcat_name;
    }

    public void setSubsubcat_name(String subsubcat_name) {
        this.subsubcat_name = subsubcat_name;
    }

    public String getSubsubcat_img() {
        return subsubcat_img;
    }

    public void setSubsubcat_img(String subsubcat_img) {
        this.subsubcat_img = subsubcat_img;
    }
}
