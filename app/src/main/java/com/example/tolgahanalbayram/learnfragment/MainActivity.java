package com.example.tolgahanalbayram.learnfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.tolgahanalbayram.learnfragment.helper.SharedPrefHelper;

import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private FragmentManager manager = getSupportFragmentManager();
    public boolean isBackPress;
    private SelectCountryFragment fragment = new SelectCountryFragment();
    MainPageFragment mainPageFragment = new MainPageFragment();
    DrawerLayout dl;
    private ActionBarDrawerToggle t;
    FixtureFragment fixtureFragment = new FixtureFragment();
    TopScorerFragment topScorerFragment = new TopScorerFragment();
    LiveScoreFragment liveScoreFragment = new LiveScoreFragment();
    NavigationView nv;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        isLogin();
        setUpNavigationDrawer();

    }

    @Override
    public void onBackPressed() {

        if (!isBackPress) {
            this.finish();
        } else {
            super.onBackPressed();
        }
    }

    public void replace(Fragment newFragment) {


        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_frame, newFragment, newFragment.getClass().getName());
        transaction.addToBackStack(null);

        transaction.commit();
    }


    public void isLogin() {
        if (SharedPrefHelper.getStringFromShared(getApplicationContext(), "country_name") == null || (SharedPrefHelper.getStringFromShared(getApplicationContext(), "league_name") == null)) {
            replace(fragment);
        } else {
            replace(mainPageFragment);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dl.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        if (t.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void setUpNavigationDrawer() {
        dl = findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        t.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(t);
        t.syncState();
        nv = findViewById(R.id.nv);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.menu_item_fixture:
                        replace(fixtureFragment);
                        break;
                    case R.id.menu_item_top_scorer:
                        replace(topScorerFragment);
                        break;
                    case R.id.menu_item_live_score:
                        replace(liveScoreFragment);

                    default:

                }
                dl.closeDrawer(GravityCompat.START);

                return true;

            }
        });

    }

//    public void setBgResource(int resourceId) {
//        imageView.setBackgroundResource(resourceId);
//    }
}
