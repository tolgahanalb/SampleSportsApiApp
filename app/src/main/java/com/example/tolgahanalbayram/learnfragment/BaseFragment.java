package com.example.tolgahanalbayram.learnfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    protected View fragmentContent;

    public abstract int getLayoutID();

    public abstract int getPageTitle();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentContent = inflater.inflate(getLayoutID(), container, false);
        ButterKnife.bind(this, fragmentContent);
        Toolbar toolbar = setUpToolbar();
        setUpToolbar();
        setToolbarTitle(toolbar);
        return fragmentContent;
    }


    public Toolbar setUpToolbar() {
        Toolbar toolbar = fragmentContent.findViewById(R.id.my_toolbar);
        final MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.isBackPress = false;

        if (getLayoutID() == R.layout.fragment_main_page) {
            activity.dl.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            activity.isBackPress = false;
            activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_menu_black_18dp);
        }
        if (getLayoutID() != R.layout.fragment_main_page) {
            activity.dl.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getLayoutID() != R.layout.fragment_select_country) {
                        activity.isBackPress = true;
                    }


                    getActivity().onBackPressed();
                }
            });

        }

        return toolbar;
    }

    public void setToolbarTitle(Toolbar toolbar) {
        if (toolbar == null) {
            return;
        }

        toolbar.setTitle(getPageTitle());
        toolbar.setSubtitle(null);

    }

}
