package com.example.tolgahanalbayram.learnfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tolgahanalbayram.learnfragment.adapters.TopscorerAdapter;
import com.example.tolgahanalbayram.learnfragment.helper.SharedPrefHelper;
import com.example.tolgahanalbayram.learnfragment.service.ApiManager;
import com.example.tolgahanalbayram.learnfragment.service.model.Topscorers;
import com.example.tolgahanalbayram.learnfragment.service.model.TopscorersResult;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TopScorerFragment extends BaseFragment implements TopscorerAdapter.TopScorerInterface {
    ArrayList<TopscorersResult> topscorersResultsArrayList;
    @BindView(R.id.rv_fragment_top_scorer)
    RecyclerView rvTopscorerFragment;
    @BindView(R.id.progress_bar_topscore_fragment)
    ProgressBar progressBarTopscorerFragment;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_top_scorer;
    }

    @Override
    public int getPageTitle() {
        return R.string.title_topscorer_fragment;
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
        final String leagueKey = SharedPrefHelper.getStringFromShared(getContext(), "league_key");

        Call<Topscorers> callTopscorers = ApiManager.getInstance().callTopscorers(leagueKey);
        progressBarTopscorerFragment.setVisibility(View.VISIBLE);

        callTopscorers.enqueue(new Callback<Topscorers>() {
            @Override
            public void onResponse(@NonNull Call<Topscorers> call, @NonNull Response<Topscorers> response) {
                progressBarTopscorerFragment.setVisibility(View.GONE);
                topscorersResultsArrayList = response.body().getTopscorersResult();
                Log.i("Basarili", call.request().url().toString());
                setAdapter();

            }

            @Override
            public void onFailure(@NonNull Call<Topscorers> call, @NonNull Throwable t) {
                Log.i("Key", call.request().url().toString());
                Log.i("Key", "gelmedi");

            }

        });
    }

    public void setAdapter() {
        rvTopscorerFragment.setHasFixedSize(true);
        TopscorerAdapter topscorerAdapter = new TopscorerAdapter(topscorersResultsArrayList, getContext(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvTopscorerFragment.setLayoutManager(linearLayoutManager);
        rvTopscorerFragment.setAdapter(topscorerAdapter);


    }


    @Override
    public void onItemClick(TextView textView, int position) {
        int tvColor = R.color.colorAccent;
        if (position % 2 == 0) {
            tvColor = R.color.colorPrimary;
        }
        textView.setBackgroundColor(ContextCompat.getColor(getContext(),tvColor));

        Toast.makeText(getContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
    }
}
