package com.example.mateusz.lamimozgi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GameChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_choice);
    }

    public void choice_level(View view) {
        startActivity(new Intent(getApplicationContext(), LevelActivity.class));
    }
}
