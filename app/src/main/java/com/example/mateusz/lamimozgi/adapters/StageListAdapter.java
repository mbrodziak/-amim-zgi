package com.example.mateusz.lamimozgi.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mateusz.lamimozgi.R;
import com.example.mateusz.lamimozgi.items.Stage;
import com.example.mateusz.lamimozgi.views.StageListItem;

import java.util.ArrayList;

public class StageListAdapter extends BaseAdapter {
    private final ArrayList<Stage> stage;
    private final Context context;

    public StageListAdapter(Context context, ArrayList<Stage> stage) {
        super();
        this.stage = stage;
        this.context = context;
    }

    @Override
    public int getCount() {
        return stage.size();
    }

    public Stage getItem(int position) {
        return (null == stage) ? null : stage.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StageListItem sli;
        if (null == convertView) {
            sli = (StageListItem) View.inflate(context, R.layout.stage_list_item, null);
        } else {
            sli = (StageListItem) convertView;
        }
        sli.setStage(stage.get(position));
        return sli;
    }
}
