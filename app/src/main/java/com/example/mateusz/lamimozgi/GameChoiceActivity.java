package com.example.mateusz.lamimozgi;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class GameChoiceActivity extends AppCompatActivity {

    private GameApplication app;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_choice);
        setUpViews();
    }

    private void choiceSudokuDialog() {
        dialog = new choiceSudokuDialog(this);
        dialog.show();
    }

    private void activityFinish(){
        startActivity(new Intent(getApplicationContext(), LevelActivity.class));
        finish();
    }

    private void dialogDismiss() {
        dialog.dismiss();
        activityFinish();
    }

    private void setUpViews() {
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
                activityFinish();
            }
        });

        crossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.gameType = "crossword";
                activityFinish();
            }
        });

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.gameType = "quesswork";
                activityFinish();
            }
        });

        hangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.gameType = "hangman";
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
