package com.example.mateusz.lamimozgi.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mateusz.lamimozgi.R;
import com.example.mateusz.lamimozgi.items.Statistic;
import com.example.mateusz.lamimozgi.views.StatisticItem;

import java.util.ArrayList;

public class StatisticAdapter extends RecyclerView.Adapter<StatisticAdapter.StatisticViewHolder> {


    private final ArrayList<Statistic> statistics;

    public StatisticAdapter(ArrayList<Statistic> statistics) {
        super();
        this.statistics = statistics;
    }


    @NonNull
    @Override
    public StatisticViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        StatisticItem si = (StatisticItem) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.statistic_item, viewGroup, false);
        return new StatisticViewHolder(si);
    }

    @Override
    public void onBindViewHolder(@NonNull StatisticViewHolder statisticViewHolder, int i) {
        statisticViewHolder.statisticsItem.setStatistic(statistics.get(i));

    }

    @Override
    public int getItemCount() {
        return statistics.size();
    }

    class StatisticViewHolder extends RecyclerView.ViewHolder{

        private final StatisticItem statisticsItem;

        StatisticViewHolder(@NonNull StatisticItem itemView) {
            super(itemView);
            statisticsItem = itemView;
        }
    }
}
