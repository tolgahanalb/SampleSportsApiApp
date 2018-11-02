package com.example.tolgahanalbayram.learnfragment.service;

import com.example.tolgahanalbayram.learnfragment.service.model.Countries;
import com.example.tolgahanalbayram.learnfragment.service.model.Fixtures;
import com.example.tolgahanalbayram.learnfragment.service.model.Leagues;
import com.example.tolgahanalbayram.learnfragment.service.model.Topscorers;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiManager {

    private static ApiManager instance;
    private static ApiInterface apiInterface;

    private static final String APIURL = "https://allsportsapi.com";
    private static final String APIkey = "c188a2f376bab3e91b83aa42975af12905361a9879b767e08dd93635049979ce";
    private static final String methodName = "Countries";
    private static final String action = "Leagues";
    private static final String actionFixture = "Fixtures";
    private static final String actionTopscorers = "Topscorers";
    private static final String fromFixture = "2018-10-01";
    private static final String toFixture = "2019-07-01";


    public static ApiManager getInstance() {
        if (instance == null) {
            instance = new ApiManager();
        }
        if (apiInterface == null) {
            createApiInterface();
        }
        return instance;
    }


    private static void createApiInterface() {
        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(APIURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = retrofit.create(ApiInterface.class);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Call<Countries> callCountries() {
        return apiInterface.countries(methodName, APIkey);
    }

    public Call<Leagues> callLeagues(String countryId) {
        return apiInterface.leagues(action, APIkey, countryId);
    }

    public Call<Fixtures> callFixture(String countryId) {
        return apiInterface.fixture(actionFixture, APIkey, countryId, fromFixture, toFixture);
    }

    public Call<Topscorers> callTopscorers(String leagueId) {
        return apiInterface.topscorers(actionTopscorers, leagueId, APIkey);
    }

}
