package com.example.tolgahanalbayram.learnfragment.service.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Livescore {
    @SerializedName("success")
    private Integer success;
    @SerializedName("result")
    private ArrayList<LivescoreResult> livescoreResults ;

    public Livescore(Integer success, ArrayList<LivescoreResult> livescoreResults) {
        this.success = success;
        this.livescoreResults = livescoreResults;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public ArrayList<LivescoreResult> getLivescoreResults() {
        return livescoreResults;
    }

    public void setLivescoreResults(ArrayList<LivescoreResult> livescoreResults) {
        this.livescoreResults = livescoreResults;
    }
}
