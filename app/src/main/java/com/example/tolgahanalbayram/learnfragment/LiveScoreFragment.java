package com.example.tolgahanalbayram.learnfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class LiveScoreFragment extends BaseFragment {


    @Override
    public int getLayoutID() {
        return R.layout.fragment_live_score;
    }

    @Override
    public int getPageTitle() {
            return R.string.title_livescore_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return fragmentContent;
    }

}
