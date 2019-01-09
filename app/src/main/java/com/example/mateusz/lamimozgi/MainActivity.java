package com.example.mateusz.lamimozgi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.mateusz.lamimozgi.items.Stage;
import com.example.mateusz.lamimozgi.items.Statistic;

import java.util.ArrayList;

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

        findViewById(R.id.statistics).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                setUpViewsSudokuStatistics();
            }
        });

        findViewById(R.id.about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                setUpViewsAbout();
            }
        });
    }

    private void setUpViewsSudokuStatistics() {
        setContentView(R.layout.activity_statistics_sudoku);
        RecyclerView NSV = findViewById(R.id.normalSudokuView);
        ArrayList<Statistic> als = new ArrayList<>();
        app.gameType = "normalSudoku";
        app.gameLevel = 0;
        app.loadStages();
        ArrayList<Stage> al = app.getCurrentStages();
        int amountGames = 0;
        int amountWin = 0;
        for (Stage stage:al){
            amountGames += 1;
            if(stage.isComplete()){
                amountWin += 1;
            }
        }
        als.add(new Statistic(0,amountGames,amountWin));
        

    }

    private void setUpViewsAbout() {
        setContentView(R.layout.activity_about_application);

        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                setUpViews();
            }
        });
    }

}






