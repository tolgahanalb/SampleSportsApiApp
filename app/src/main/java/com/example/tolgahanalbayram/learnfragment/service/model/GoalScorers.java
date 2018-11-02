package com.example.tolgahanalbayram.learnfragment.service.model;

import com.google.gson.annotations.SerializedName;

public class GoalScorers {

    @SerializedName("time")
    private String time;
    @SerializedName("home_scorer")
    private String home_scorer;
    @SerializedName("score")
    private String score;
    @SerializedName("away_scorer")
    private String away_scorer;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public GoalScorers(String time, String home_scorer, String score, String away_scorer) {
        this.time = time;
        this.home_scorer = home_scorer;
        this.score = score;
        this.away_scorer = away_scorer;
    }

    public String getHome_scorer() {
        return home_scorer;
    }

    public void setHome_scorer(String home_scorer) {
        this.home_scorer = home_scorer;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAway_scorer() {
        return away_scorer;
    }

    public void setAway_scorer(String away_scorer) {
        this.away_scorer = away_scorer;
    }


}
