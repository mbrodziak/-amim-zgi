package com.example.mateusz.lamimozgi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mateusz.lamimozgi.adapters.StatisticAdapter;
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
        RecyclerView USV = findViewById(R.id.unNormalSudokuView);
        ArrayList<Statistic> als = new ArrayList<>();
        int[] amount = amountGames("normalSudoku", 0);
        als.add(new Statistic(0,amount[0],amount[1]));
        amount = amountGames("normalSudoku", 1);
        als.add(new Statistic(1,amount[0],amount[1]));
        amount = amountGames("normalSudoku", 2);
        als.add(new Statistic(2,amount[0],amount[1]));
        NSV.setHasFixedSize(true);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        NSV.setLayoutManager(lm);
        NSV.setAdapter(new StatisticAdapter(als));
        als = new ArrayList<>();
        amount = amountGames("unNormalSudoku", 0);
        als.add(new Statistic(0,amount[0],amount[1]));
        amount = amountGames("unNormalSudoku", 1);
        als.add(new Statistic(1,amount[0],amount[1]));
        amount = amountGames("unNormalSudoku", 2);
        als.add(new Statistic(2,amount[0],amount[1]));
        USV.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        USV.setLayoutManager(lm);
        USV.setAdapter(new StatisticAdapter(als));
        
        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                setUpViews();
            }
        });

        findViewById(R.id.next_arrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                setUpViewsCrossSearchStatistics();
            }
        });
    }

    private void setUpViewsCrossSearchStatistics() {
        setContentView(R.layout.activity_statistics_cross_search);
        RecyclerView CWV = findViewById(R.id.crosswordView);
        RecyclerView WSV = findViewById(R.id.wordSearchView);
        ArrayList<Statistic> als = new ArrayList<>();
        int[] amount = amountGames("crossword", 0);
        als.add(new Statistic(0,amount[0],amount[1]));
        amount = amountGames("crossword", 1);
        als.add(new Statistic(1,amount[0],amount[1]));
        amount = amountGames("crossword", 2);
        als.add(new Statistic(2,amount[0],amount[1]));
        CWV.setHasFixedSize(true);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        CWV.setLayoutManager(lm);
        CWV.setAdapter(new StatisticAdapter(als));
        als = new ArrayList<>();
        amount = amountGames("wordSearch", 0);
        als.add(new Statistic(0,amount[0],amount[1]));
        amount = amountGames("wordSearch", 1);
        als.add(new Statistic(1,amount[0],amount[1]));
        amount = amountGames("wordSearch", 2);
        als.add(new Statistic(2,amount[0],amount[1]));
        WSV.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        WSV.setLayoutManager(lm);
        WSV.setAdapter(new StatisticAdapter(als));

        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                setUpViewsSudokuStatistics();
            }
        });

        findViewById(R.id.next_arrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                setUpViewsGuessHangStatistics();
            }
        });
    }

    private void setUpViewsGuessHangStatistics() {
        setContentView(R.layout.activity_statistics_guess_hang);
        RecyclerView GWV = findViewById(R.id.guessView);
        RecyclerView HMV = findViewById(R.id.hangView);
        ArrayList<Statistic> als = new ArrayList<>();
        int[] amount = amountGames("guessWork", 0);
        als.add(new Statistic(0,amount[0],amount[1]));
        amount = amountGames("guessWork", 1);
        als.add(new Statistic(1,amount[0],amount[1]));
        amount = amountGames("guessWork", 2);
        als.add(new Statistic(2,amount[0],amount[1]));
        GWV.setHasFixedSize(true);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        GWV.setLayoutManager(lm);
        GWV.setAdapter(new StatisticAdapter(als));
        als = new ArrayList<>();
        amount = amountGames("hangman", 0);
        als.add(new Statistic(0,amount[0],amount[1]));
        amount = amountGames("hangman", 1);
        als.add(new Statistic(1,amount[0],amount[1]));
        amount = amountGames("hangman", 2);
        als.add(new Statistic(2,amount[0],amount[1]));
        HMV.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        HMV.setLayoutManager(lm);
        HMV.setAdapter(new StatisticAdapter(als));

        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                setUpViewsCrossSearchStatistics();
            }
        });

        findViewById(R.id.next_arrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                setUpViews();
            }
        });
    }

    private int[] amountGames(String gameType, int gameLevel) {
        app.gameType = gameType;
        app.gameLevel = gameLevel;
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
        return new int[]{amountGames, amountWin};
        
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






