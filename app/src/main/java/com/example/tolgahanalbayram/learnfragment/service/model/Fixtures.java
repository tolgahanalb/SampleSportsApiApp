package com.example.tolgahanalbayram.learnfragment.service.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Fixtures {
    @SerializedName("success")
    private Integer success;
    @SerializedName("result")
    private ArrayList<FixtureResults> fixtureResults = null;

    public Fixtures(Integer success, ArrayList<FixtureResults> fixtureResults) {

        this.success = success;
        this.fixtureResults = fixtureResults;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public ArrayList<FixtureResults> getFixtureResults() {
        return fixtureResults;
    }

    public void setFixtureResults(ArrayList<FixtureResults> fixtureResults) {
        this.fixtureResults = fixtureResults;
    }


}
