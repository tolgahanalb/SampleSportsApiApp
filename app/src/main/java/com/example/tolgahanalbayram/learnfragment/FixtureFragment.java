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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tolgahanalbayram.learnfragment.adapters.FixturesAdapter;
import com.example.tolgahanalbayram.learnfragment.helper.SharedPrefHelper;
import com.example.tolgahanalbayram.learnfragment.service.ApiManager;
import com.example.tolgahanalbayram.learnfragment.service.model.FixtureResults;
import com.example.tolgahanalbayram.learnfragment.service.model.Fixtures;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FixtureFragment extends BaseFragment implements FixturesAdapter.FixturesAdapterListener {

    private ArrayList<FixtureResults> fixtureResultsArrayList = new ArrayList<>();

    @BindView(R.id.rv_fragment_fixture)
    RecyclerView rvFixtureFragment;
    @BindView(R.id.progress_bar_fixture_fragment)
    ProgressBar progressBar;

    public FixtureFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        connect();

    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_fixture;
    }

    @Override
    public int getPageTitle() {
        return R.string.title_fixture_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return fragmentContent;
    }

    public void connect() {
        final String countryKey = SharedPrefHelper.getStringFromShared(getContext(), "country_key");

        Call<Fixtures> callFixture = ApiManager.getInstance().callFixture(countryKey);
        progressBar.setVisibility(View.VISIBLE);


        callFixture.enqueue(new Callback<Fixtures>() {
            @Override
            public void onResponse(@NonNull Call<Fixtures> call, @NonNull Response<Fixtures> response) {

                progressBar.setVisibility(View.GONE);
                fixtureResultsArrayList = response.body().getFixtureResults();
                Log.i("Key", call.request().url().toString());
                setAdapter();

            }

            @Override
            public void onFailure(@NonNull Call<Fixtures> call, @NonNull Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Bağlantı Hatası", Toast.LENGTH_LONG);
                Log.i("Key", call.request().url().toString());
                Log.i("Key", "gelmedi");

            }

        });
    }

    private void setAdapter() {
        rvFixtureFragment.setHasFixedSize(true);
        FixturesAdapter fixturesAdapter = new FixturesAdapter(fixtureResultsArrayList, getContext(),this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvFixtureFragment.setLayoutManager(linearLayoutManager);
        rvFixtureFragment.setAdapter(fixturesAdapter);




    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
    }
}
