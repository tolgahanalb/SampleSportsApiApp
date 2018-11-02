package com.example.tolgahanalbayram.learnfragment.service.model;

import com.google.gson.annotations.SerializedName;

public class Result {
    public Result(String country_key, String country_name) {
        this.country_key = country_key;
        this.country_name = country_name;
    }

    @SerializedName("country_key")
    private String country_key;
    @SerializedName("country_name")
    private String country_name;


    public String getCountry_key() {
        return country_key;
    }

    public void setCountry_key(String country_key) {
        this.country_key = country_key;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }


}
