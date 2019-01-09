package com.example.mateusz.lamimozgi.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mateusz.lamimozgi.R;
import com.example.mateusz.lamimozgi.items.Statistic;
import com.example.mateusz.lamimozgi.views.StatisticItem;

import java.util.ArrayList;

public class StatisticAdapter extends BaseAdapter {


    private final Context context;
    private final ArrayList<Statistic> statistics;

    public StatisticAdapter(Context context, ArrayList<Statistic> statistics) {
        super();
        this.statistics = statistics;
        this.context = context;
    }

    @Override
    public int getCount() {
        return statistics.size();
    }

    @Override
    public Statistic getItem(int position) {
        return (null == statistics) ? null : statistics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StatisticItem si;
        if (null == convertView) {
            si = (StatisticItem) View.inflate(context, R.layout.statistic_item, null);
        } else {
            si = (StatisticItem) convertView;
        }
        si.setStatistic(statistics.get(position));
        return si;
    }
}
