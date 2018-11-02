package com.example.tolgahanalbayram.learnfragment.service.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Leagues {


    @SerializedName("success")
    private Integer success;
    @SerializedName("result")
    private ArrayList<LeaguesResult> leaguesResult = null;


    public Leagues(Integer success, List<Result> result) {
        this.success = success;
        this.leaguesResult = leaguesResult;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public ArrayList<LeaguesResult> getResult() {
        return leaguesResult;
    }

    public void setResult(List<Result> result) {
        this.leaguesResult = leaguesResult;
    }


}
