package com.example.tolgahanalbayram.learnfragment.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tolgahanalbayram.learnfragment.R;
import com.example.tolgahanalbayram.learnfragment.service.model.Result;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    private ArrayList<Result> results;

    private CountryAdapterListener countryAdapterListener;

    public CountryAdapter(List<Result> results,CountryAdapterListener countryAdapterListener) {
        this.countryAdapterListener = countryAdapterListener;
        this.results = (ArrayList<Result>) results;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row_fragment_select_country, viewGroup, false);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        myViewHolder.textView.setText(results.get(position).getCountry_name());
        myViewHolder.cvItemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countryAdapterListener != null) {
                    countryAdapterListener.onItemClick(results.get(position).getCountry_key(),results.get(position).getCountry_name());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv2)
        TextView textView;

        @BindView(R.id.cv_card_row_item_container)
        CardView cvItemContainer;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface CountryAdapterListener {
        void onItemClick(String countryKey, String country_name);
    }


}
