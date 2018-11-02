package com.example.tolgahanalbayram.learnfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tolgahanalbayram.learnfragment.adapters.CountryAdapter;
import com.example.tolgahanalbayram.learnfragment.service.ApiManager;
import com.example.tolgahanalbayram.learnfragment.service.model.Countries;
import com.example.tolgahanalbayram.learnfragment.service.model.Result;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SelectCountryFragment extends BaseFragment implements CountryAdapter.CountryAdapterListener {

    @BindView(R.id.rv_country_fragment)
    public RecyclerView recyclerView;
    public ArrayList<Result> results;
    private SelectLeagueFragment selectLeagueFragment;

    @Override
    public int getLayoutID() {
        return (R.layout.fragment_select_country);
    }

    @Override
    public int getPageTitle() {
        return R.string.title_select_country_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        connectAndAdd();
        return fragmentContent;
    }

    public void connectAndAdd() {
        recyclerView.setVisibility(View.GONE);
        Call<Countries> callCountries = ApiManager.getInstance().callCountries();
        callCountries.enqueue(new Callback<Countries>() {
            @Override
            public void onResponse(@NonNull Call<Countries> call, @NonNull Response<Countries> response) {
                recyclerView.setVisibility(View.VISIBLE);
                results = (ArrayList<Result>) response.body().getResults();
                setAdapter();

            }

            @Override
            public void onFailure(@NonNull Call<Countries> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "Bağlantı Hatası", Toast.LENGTH_LONG);
                Log.i("Basarisiz", t.getMessage());
            }
        });
    }

    private void setAdapter() {
        recyclerView.setHasFixedSize(true);
        CountryAdapter countryAdapter1 = new CountryAdapter(results, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(countryAdapter1);

    }


    @Override
    public void onItemClick(String countryKey, String countryName) {
        Bundle bundle = new Bundle();
        bundle.putString("countryKey", countryKey);
        bundle.putString("countryName", countryName);
        selectLeagueFragment = new SelectLeagueFragment();
        selectLeagueFragment.setArguments(bundle);
        ((MainActivity) (getActivity())).replace(selectLeagueFragment);

    }

}


