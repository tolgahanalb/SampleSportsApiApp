package com.example.tolgahanalbayram.learnfragment.service.model;

import com.google.gson.annotations.SerializedName;

public class TopscorersResult {
    @SerializedName("player_place")
    private String player_place;
    @SerializedName("player_name")
    private String player_name;
    @SerializedName("player_key")
    private String player_key;
    @SerializedName("team_name")
    private String team_name;
    @SerializedName("team_key")
    private String team_key;
    @SerializedName("goals")
    private String goals;

    public TopscorersResult(String player_place, String player_name, String player_key, String team_name, String team_key, String goals) {
        this.player_place = player_place;
        this.player_name = player_name;
        this.player_key = player_key;
        this.team_name = team_name;
        this.team_key = team_key;
        this.goals = goals;
    }

    public String getPlayer_place() {
        return player_place;
    }

    public void setPlayer_place(String player_place) {
        this.player_place = player_place;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_key() {
        return player_key;
    }

    public void setPlayer_key(String player_key) {
        this.player_key = player_key;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_key() {
        return team_key;
    }

    public void setTeam_key(String team_key) {
        this.team_key = team_key;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }
}
