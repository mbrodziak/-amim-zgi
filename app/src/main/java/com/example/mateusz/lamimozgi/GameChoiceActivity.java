package com.example.mateusz.lamimozgi;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GameChoiceActivity extends AppCompatActivity {

    private GameApplication app;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutGameChoice();
    }

    private void activityFinish(){
        finish();
    }

    private void choiceSudokuDialog() {
        dialog = new choiceSudokuDialog(this);
        dialog.show();
    }

    private void dialogDismiss() {
        dialog.dismiss();
        layoutLevel();
    }

    private void layoutGameChoice(){
        setContentView(R.layout.activity_game_choice);
        setUpViewsGameChoice();
    }

    private void layoutLevel(){
        setContentView(R.layout.activity_level);
        setUpViewsLevel();
    }

    private void setUpViewsGameChoice() {
        Button sudokuButton = findViewById(R.id.sudoku);
        Button wsButton = findViewById(R.id.wordSearch);
        Button crossButton = findViewById(R.id.crossword);
        Button guessButton = findViewById(R.id.guesswork);
        Button hangButton = findViewById(R.id.hangman);
        app = (GameApplication) getApplication();
        sudokuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choiceSudokuDialog();
            }
        });

        wsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.gameType = "wordSearch";
                layoutLevel();
            }
        });

        crossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.gameType = "crossword";
                layoutLevel();
            }
        });

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.gameType = "quesswork";
                layoutLevel();
            }
        });

        hangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.gameType = "hangman";
                layoutLevel();
            }
        });
    }

    private void setUpViewsLevel() {
        ImageView Easy = findViewById(R.id.Easy);
        ImageView Medium = findViewById(R.id.Medium);
        ImageView Hard = findViewById(R.id.Hard);
        app = (GameApplication) getApplication();
        Easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.gameLevel = 0;
                app.stageChoice();
                activityFinish();
            }
        });

        Medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.gameLevel = 1;
                app.stageChoice();
                activityFinish();
            }
        });

        Hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.gameLevel = 2;
                app.stageChoice();
                activityFinish();
            }
        });

    }

    private class choiceSudokuDialog extends Dialog {

        choiceSudokuDialog(@NonNull Context context) {
            super(context);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dialog_choice_sudoku);
            setUpViews();
        }

        private void setUpViews(){
            Button normal = findViewById(R.id.normalButton);
            Button unNormal = findViewById(R.id.unNormal);

            normal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    app.gameType = "normalSudoku";
                    dialogDismiss();
                }
            });

            unNormal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    app.gameType = "unNormalSudoku";
                    dialogDismiss();
                }
            });
        }
    }
}
