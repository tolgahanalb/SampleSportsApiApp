package com.example.tolgahanalbayram.learnfragment.service.model;

public class LeaguesResult {

    private String league_key;
    private String league_name;
    private String country_key;
    private String country_name;


    public LeaguesResult(String league_key, String league_name, String country_key, String country_name) {

        this.league_key = league_key;
        this.league_name = league_name;
        this.country_key = country_key;
        this.country_name = country_name;
    }

    public String getLeague_key() {
        return league_key;
    }

    public void setLeague_key(String league_key) {
        this.league_key = league_key;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

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
