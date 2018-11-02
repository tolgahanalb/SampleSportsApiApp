package com.example.tolgahanalbayram.learnfragment.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tolgahanalbayram.learnfragment.R;
import com.example.tolgahanalbayram.learnfragment.service.model.TopscorersResult;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopscorerAdapter extends RecyclerView.Adapter<TopscorerAdapter.MyViewHolder> {

    private ArrayList<TopscorersResult> topscorersResultArrayList;
    private Context context;
    private TopScorerInterface topScorerInterface;

    public TopscorerAdapter(ArrayList<TopscorersResult> topscorersResultArrayList, Context context,TopScorerInterface topScorerInterface) {
        this.topscorersResultArrayList = topscorersResultArrayList;
        this.context = context;
        this.topScorerInterface=topScorerInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_fragment_top_scorer, viewGroup, false);

        return new TopscorerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int position) {
        myViewHolder.tvPnameRowFragmentTopScorer.setBackgroundColor(ContextCompat.getColor(context,R.color.colorWhite));
        myViewHolder.tvPnameRowFragmentTopScorer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               topScorerInterface.onItemClick(((TextView) v),position);
            }
        });
        myViewHolder.tvPpRowFragmentTopScorer.setText(topscorersResultArrayList.get(position).getPlayer_place());
        myViewHolder.tvPnameRowFragmentTopScorer.setText(topscorersResultArrayList.get(position).getPlayer_name());
        myViewHolder.tvTnameRowFragmentTopScorer.setText(topscorersResultArrayList.get(position).getTeam_name());
        myViewHolder.tvGoalsRowFragmentTopScorer.setText(topscorersResultArrayList.get(position).getGoals());
    }

    @Override
    public int getItemCount() {
        return topscorersResultArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_pp_row_fragment_top_scorer)
        TextView tvPpRowFragmentTopScorer;
        @BindView(R.id.tv_pname_row_fragment_top_scorer)
        TextView tvPnameRowFragmentTopScorer;
        @BindView(R.id.tv_tname_row_fragment_top_scorer)
        TextView tvTnameRowFragmentTopScorer;
        @BindView(R.id.tv_goals_row_fragment_top_scorer)
        TextView tvGoalsRowFragmentTopScorer;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface TopScorerInterface {
        void onItemClick (TextView textView,int position);
    }

}
