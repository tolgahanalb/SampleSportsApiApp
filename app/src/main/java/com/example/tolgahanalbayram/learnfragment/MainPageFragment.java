package com.example.tolgahanalbayram.learnfragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tolgahanalbayram.learnfragment.helper.SharedPrefHelper;

import butterknife.BindView;


public class MainPageFragment extends BaseFragment {
    @BindView(R.id.tv_country_name_fragment_main_page)
    TextView tvCountryName;
    @BindView(R.id.tv_league_name_fragment_main_page)
    TextView tvLeagueName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return fragmentContent;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpMainPage();
    }


    @Override
    public int getLayoutID() {
        return R.layout.fragment_main_page;
    }

    @Override
    public int getPageTitle() {
        return R.string.title_mainpage_fragment;
    }

    public void setUpMainPage() {
        ((MainActivity) getActivity()).isBackPress = false;

        if (SharedPrefHelper.getStringFromShared(getContext(), "country_name") == null || SharedPrefHelper.getStringFromShared(getContext(), "league_name") == null) {
            final String countryName = getArguments().getString("countryName");
            final String leagueName = getArguments().getString("leagueName");
            final String countryKey = getArguments().getString("countryKey");
            final String leagueKey = getArguments().getString("leagueKey");

            SharedPrefHelper.putStringToShared(getContext(), "country_name", countryName);
            SharedPrefHelper.putStringToShared(getContext(), "league_name", leagueName);
            SharedPrefHelper.putStringToShared(getContext(), "country_key", countryKey);
            SharedPrefHelper.putStringToShared(getContext(), "league_key", leagueKey);

        }

        tvCountryName.setText(SharedPrefHelper.getStringFromShared(getContext(), "country_name"));
        tvLeagueName.setText(SharedPrefHelper.getStringFromShared(getContext(), "league_name"));

    }

}
