package com.example.tolgahanalbayram.learnfragment.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tolgahanalbayram.learnfragment.service.model.LeaguesResult;
import com.example.tolgahanalbayram.learnfragment.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaguesAdapter extends RecyclerView.Adapter<LeaguesAdapter.MyViewHolder> {
    private ArrayList<LeaguesResult> leaguesListData;
    private Context context;
    private LeaguesAdapterListener leaguesAdapterListener;

    public LeaguesAdapter(ArrayList<LeaguesResult> leaguesListData, Context context) {
        this.leaguesListData = leaguesListData;
        this.context = context;
    }

    @NonNull
    @Override
    public LeaguesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row_fragment_select_league, viewGroup, false);
        return new LeaguesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaguesAdapter.MyViewHolder myViewHolder, final int position) {
        myViewHolder.textView.setText(leaguesListData.get(position).getLeague_name());
        myViewHolder.cvItemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leaguesAdapterListener != null) {
                    leaguesAdapterListener.onItemClick(leaguesListData.get(position).getCountry_name(), leaguesListData.get(position).getLeague_name(),leaguesListData.get(position).getCountry_key(),leaguesListData.get(position).getLeague_key());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return leaguesListData.size();
    }

    public void setLeaguesAdapterListener(LeaguesAdapterListener leaguesAdapterListener) {
        this.leaguesAdapterListener = leaguesAdapterListener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cv_card_row_item_container_fragment2)
        CardView cvItemContainer;
        @BindView(R.id.tv_card_row)
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface LeaguesAdapterListener {
        void onItemClick(String country_name, String league_name, String country_key, String league_key);
    }

}
