package com.example.tolgahanalbayram.learnfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tolgahanalbayram.learnfragment.adapters.LeaguesAdapter;
import com.example.tolgahanalbayram.learnfragment.service.ApiManager;
import com.example.tolgahanalbayram.learnfragment.service.model.Leagues;
import com.example.tolgahanalbayram.learnfragment.service.model.LeaguesResult;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SelectLeagueFragment extends BaseFragment implements LeaguesAdapter.LeaguesAdapterListener {

    @BindView(R.id.rv_fragment2)
    public RecyclerView recyclerView1;
    private MainPageFragment mainPageFragmentLF = new MainPageFragment();
    private ArrayList<LeaguesResult> leaguesListData = new ArrayList<>();

    @Override
    public int getLayoutID() {
        return (R.layout.fragment_select_league);
    }

    @Override
    public int getPageTitle() {

        return R.string.title_select_league_fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return fragmentContent;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        connect();
    }

    public void connect() {
        final String countryId = getArguments().getString("countryKey");

        Call<Leagues> callLeague = ApiManager.getInstance().callLeagues(countryId);
        callLeague.enqueue(new Callback<Leagues>() {
            @Override
            public void onResponse(@NonNull Call<Leagues> call, @NonNull Response<Leagues> response) {
                leaguesListData = response.body().getResult();
                Log.i("LeagueKey", leaguesListData.get(0).getLeague_key());
                Log.i("Countrykey", leaguesListData.get(0).getCountry_key());
                setAdapter();
            }

            @Override
            public void onFailure(@NonNull Call<Leagues> call, @NonNull Throwable t) {
                Log.i("Basarisiz", countryId);
            }
        });

    }


    private void setAdapter() {
        recyclerView1.setHasFixedSize(true);
        LeaguesAdapter leaguesAdapter1 = new LeaguesAdapter(leaguesListData, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.setAdapter(leaguesAdapter1);
        leaguesAdapter1.setLeaguesAdapterListener(this);


    }

    @Override
    public void onItemClick(String country_name, String league_name, String country_key, String league_key) {
        Bundle bundle = new Bundle();
        bundle.putString("countryName", country_name);
        bundle.putString("leagueName", league_name);
        bundle.putString("countryKey", country_key);
        bundle.putString("leagueKey", league_key);
        mainPageFragmentLF.setArguments(bundle);

        ((MainActivity) (getActivity())).replace(mainPageFragmentLF);

    }
}
