package com.example.mateusz.lamimozgi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class LevelActivity extends AppCompatActivity {

    private GameApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        setUpViews();
    }

    private void activityFinish(){
        finish();
    }

    private void setUpViews() {
        ImageView Easy = findViewById(R.id.Easy);
        ImageView Medium = findViewById(R.id.Medium);
        ImageView Hard = findViewById(R.id.Hard);
        app = (GameApplication) getApplication();
        Easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.gameLevel = 0;
                app.gameStart();
                activityFinish();
            }
        });

        Medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.gameLevel = 1;
                app.gameStart();
                activityFinish();
            }
        });

        Hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.gameLevel = 2;
                app.gameStart();
                activityFinish();
            }
        });

    }
}
