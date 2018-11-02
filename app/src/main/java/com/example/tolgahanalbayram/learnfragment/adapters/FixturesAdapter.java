package com.example.tolgahanalbayram.learnfragment.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tolgahanalbayram.learnfragment.R;
import com.example.tolgahanalbayram.learnfragment.service.model.FixtureResults;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FixturesAdapter extends RecyclerView.Adapter<FixturesAdapter.MyViewHolder> {
    private ArrayList<FixtureResults> fixtureResults;
    private Context context;
    private FixturesAdapterListener fixturesAdapterListener;

    public FixturesAdapter(ArrayList<FixtureResults> fixtureResults, Context context, FixturesAdapterListener fixturesAdapterListener) {
        this.fixtureResults = fixtureResults;
        this.context = context;
        this.fixturesAdapterListener = fixturesAdapterListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row_fragment_fixtures, viewGroup, false);

        return new FixturesAdapter.MyViewHolder(view);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv1_card_row_fragment_fixtures)
        TextView textView;
        @BindView(R.id.cv_card_row_fragment_fixtures_item_container)
        CardView cardView;
        @BindView(R.id.tv2_lname_card_row_fragment_fixtures)
        TextView tvLeagueName;
        @BindView(R.id.tv3_card_row_fragment_fixtures)
        TextView tvDate;
        @BindView(R.id.tv4_card_row_fragment_fixtures)
        TextView tvHomeTeam;
        @BindView(R.id.tv5_card_row_fragment_fixtures)
        TextView tvAwayTeam;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fixturesAdapterListener.onItemClick(position);
            }
        });
        int color = R.color.colorPrimary;
        if (position % 2 == 0) {
            color = R.color.colorAccent;
        }
        myViewHolder.itemView.setBackgroundColor(ContextCompat.getColor(context, color));
        myViewHolder.textView.setText(fixtureResults.get(position).getCountry_name());
        myViewHolder.tvLeagueName.setText(fixtureResults.get(position).getLeague_name());
        myViewHolder.tvDate.setText(context.getResources().getString(R.string.tv_fixture_fragment_text, fixtureResults.get(position).getEvent_date()));
        myViewHolder.tvHomeTeam.setText(fixtureResults.get(position).getEvent_home_team());
        myViewHolder.tvAwayTeam.setText(fixtureResults.get(position).getEvent_away_team());
    }

    @Override
    public int getItemCount() {
        return fixtureResults.size();
    }

    public Object getItem(int position) {
        return (fixtureResults == null) ? null : fixtureResults.get(position);
    }


    public interface FixturesAdapterListener {
        void onItemClick(int position);
    }

}
