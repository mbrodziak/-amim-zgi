package com.example.mateusz.lamimozgi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        Button playButton = findViewById(R.id.play);
        Button optionsButton = findViewById(R.id.options);
        Button statisticsButton = findViewById(R.id.statistics);
        Button aboutButton = findViewById(R.id.about);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GameChoiceActivity.class));
            }
        });
    }
}
