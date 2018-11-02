package com.example.tolgahanalbayram.learnfragment.service.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Countries {
    public Countries(Integer success, List<Result> result) {
        this.success = success;
        this.result = result;
    }

    @SerializedName("success")
    private Integer success;
    @SerializedName("result")
    private List<Result> result = null;


    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public List<Result> getResults() {
        return result;
    }

    public void setResults(List<Result> result) {
        this.result = result;
    }


}
