package com.example.tolgahanalbayram.learnfragment.service.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Topscorers {
    @SerializedName("success")
    private Integer success;
    @SerializedName("result")
    private ArrayList<TopscorersResult> topscorersResult ;

    public Topscorers(Integer success, ArrayList<TopscorersResult> topscorersResult) {
        this.success = success;
        this.topscorersResult = topscorersResult;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public ArrayList<TopscorersResult> getTopscorersResult() {
        return topscorersResult;
    }

    public void setTopscorersResult(ArrayList<TopscorersResult> topscorersResult) {
        this.topscorersResult = topscorersResult;
    }
}
