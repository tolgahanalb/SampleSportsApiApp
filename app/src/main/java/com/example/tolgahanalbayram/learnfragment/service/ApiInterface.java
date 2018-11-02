package com.example.tolgahanalbayram.learnfragment.service;
import com.example.tolgahanalbayram.learnfragment.service.model.Countries;
import com.example.tolgahanalbayram.learnfragment.service.model.Fixtures;
import com.example.tolgahanalbayram.learnfragment.service.model.Leagues;
import com.example.tolgahanalbayram.learnfragment.service.model.Topscorers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/football")
    Call<Countries> countries(@Query("met") String met,
                              @Query("APIkey") String APIkey);

    @GET("api/football")
    Call<Leagues> leagues(@Query("met") String action,
                          @Query("APIkey") String APIkey,
                          @Query("countryId") String countryId);

    @GET("api/football")
    Call<Fixtures> fixture(@Query("met") String actionFixture,
                           @Query("APIkey") String APIkey,
                           @Query("countryId") String countryId,
                           @Query("from") String fromFixture,
                           @Query("to") String toFixture);

    @GET("api/football")
    Call<Topscorers> topscorers(@Query("met") String actionTopscorers,
                                @Query("leagueId") String leagueId,
                                @Query("APIkey") String APIkey);
}
