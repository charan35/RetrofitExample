
package com.journaldev.retrofitintro.cate;

import com.google.gson.annotations.Expose;

public class Datum {

    @Expose
    private String category;
    @Expose
    private String icon;
    @Expose
    private Long id;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
