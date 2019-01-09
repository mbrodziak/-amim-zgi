package com.example.mateusz.lamimozgi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private GameApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
        app = (GameApplication) getApplication();
        super.onCreate(savedInstanceState);
        setUpViews();
    }

    private void setUpViews() {
        setContentView(R.layout.activity_main);
        Button statisticsButton = findViewById(R.id.statistics);
        Button aboutButton = findViewById(R.id.about);

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.clickSound();
                startActivity(new Intent(getApplicationContext(), GameChoiceActivity.class));

            }
        });

        findViewById(R.id.options).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.clickSound();
                startActivity(new Intent(getApplicationContext(), OptionsActivity.class));
            }
        });
    }

}






