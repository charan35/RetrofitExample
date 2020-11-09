
package com.journaldev.retrofitintro.CartFetch;

import java.util.List;
import com.google.gson.annotations.Expose;


public class Cartfetch {

    @Expose
    private List<Re> res;

    public List<Re> getRes() {
        return res;
    }

    public void setRes(List<Re> res) {
        this.res = res;
    }

}
