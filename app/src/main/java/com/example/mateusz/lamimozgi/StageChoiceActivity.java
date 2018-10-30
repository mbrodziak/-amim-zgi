package com.example.mateusz.lamimozgi;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.mateusz.lamimozgi.adapters.StageListAdapter;
import com.example.mateusz.lamimozgi.items.Stage;

public class StageChoiceActivity extends ListActivity{
    private int selectedPosition;
    private GameApplication app;
    private Stage selectedStage;
    private StageListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_choice);
        app = (GameApplication) getApplication();
        loadStages();
    }

    private void loadStages() {
        app.loadStages();
        adapter = new StageListAdapter(this, app.getCurrentStages());
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        selectedPosition = position;
        selectedStage = adapter.getItem(position);
        app.selectedStage = selectedStage;
        app.gameStart();
    }
}
