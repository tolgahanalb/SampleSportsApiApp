package com.example.tolgahanalbayram.learnfragment.service.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LivescoreResult {
    @SerializedName("event_key")
    private String event_key;
    @SerializedName("event_date")
    private String event_date;
    @SerializedName("event_time")
    private String event_time;
    @SerializedName("event_home_team")
    private String event_home_team;
    @SerializedName("home_team_key")
    private String home_team_key;
    @SerializedName("event_away_team")
    private String event_away_team;
    @SerializedName("away_team_key")
    private String away_team_key;
    @SerializedName("event_halftime_result")
    private String event_halftime_result;
    @SerializedName("event_final_result")
    private String event_final_result;
    @SerializedName("event_status")
    private String event_status;
    @SerializedName("country_name")
    private String country_name;
    @SerializedName("league_name")
    private String league_name;
    @SerializedName("league_key")
    private String league_key;
    @SerializedName("league_round")
    private String league_round;
    @SerializedName("league_season")
    private String league_season;
    @SerializedName("event_live")
    private String event_live;
    @SerializedName("goalscorers")
    private ArrayList<GoalScorers> lsgoalScorers;

    public LivescoreResult(String event_key, String event_date, String event_time, String event_home_team, String home_team_key, String event_away_team, String away_team_key, String event_halftime_result, String event_final_result, String event_status, String country_name, String league_name, String league_key, String league_round, String league_season, String event_live, ArrayList<GoalScorers> lsgoalScorers) {
        this.event_key = event_key;
        this.event_date = event_date;
        this.event_time = event_time;
        this.event_home_team = event_home_team;
        this.home_team_key = home_team_key;
        this.event_away_team = event_away_team;
        this.away_team_key = away_team_key;
        this.event_halftime_result = event_halftime_result;
        this.event_final_result = event_final_result;
        this.event_status = event_status;
        this.country_name = country_name;
        this.league_name = league_name;
        this.league_key = league_key;
        this.league_round = league_round;
        this.league_season = league_season;
        this.event_live = event_live;
        this.lsgoalScorers = lsgoalScorers;
    }

    public String getEvent_key() {
        return event_key;
    }

    public void setEvent_key(String event_key) {
        this.event_key = event_key;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public String getEvent_home_team() {
        return event_home_team;
    }

    public void setEvent_home_team(String event_home_team) {
        this.event_home_team = event_home_team;
    }

    public String getHome_team_key() {
        return home_team_key;
    }

    public void setHome_team_key(String home_team_key) {
        this.home_team_key = home_team_key;
    }

    public String getEvent_away_team() {
        return event_away_team;
    }

    public void setEvent_away_team(String event_away_team) {
        this.event_away_team = event_away_team;
    }

    public String getAway_team_key() {
        return away_team_key;
    }

    public void setAway_team_key(String away_team_key) {
        this.away_team_key = away_team_key;
    }

    public String getEvent_halftime_result() {
        return event_halftime_result;
    }

    public void setEvent_halftime_result(String event_halftime_result) {
        this.event_halftime_result = event_halftime_result;
    }

    public String getEvent_final_result() {
        return event_final_result;
    }

    public void setEvent_final_result(String event_final_result) {
        this.event_final_result = event_final_result;
    }

    public String getEvent_status() {
        return event_status;
    }

    public void setEvent_status(String event_status) {
        this.event_status = event_status;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public String getLeague_key() {
        return league_key;
    }

    public void setLeague_key(String league_key) {
        this.league_key = league_key;
    }

    public String getLeague_round() {
        return league_round;
    }

    public void setLeague_round(String league_round) {
        this.league_round = league_round;
    }

    public String getLeague_season() {
        return league_season;
    }

    public void setLeague_season(String league_season) {
        this.league_season = league_season;
    }

    public String getEvent_live() {
        return event_live;
    }

    public void setEvent_live(String event_live) {
        this.event_live = event_live;
    }

    public ArrayList<GoalScorers> getLsgoalScorers() {
        return lsgoalScorers;
    }

    public void setLsgoalScorers(ArrayList<GoalScorers> lsgoalScorers) {
        this.lsgoalScorers = lsgoalScorers;
    }
}
