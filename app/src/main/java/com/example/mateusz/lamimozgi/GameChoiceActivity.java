package com.example.mateusz.lamimozgi;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GameChoiceActivity extends AppCompatActivity {

    private GameApplication app;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (GameApplication) getApplication();
        setUpViewsGameChoice();
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
        setUpViewsLevel();
    }

    private void setUpViewsGameChoice(){
        setContentView(R.layout.activity_game_choice);
        findViewById(R.id.sudoku).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.clickSound();
                choiceSudokuDialog();
            }
        });

        findViewById(R.id.wordSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.clickSound();
                app.gameType = "wordSearch";
                setUpViewsLevel();
            }
        });

        findViewById(R.id.crossword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.clickSound();
                app.gameType = "crossword";
                setUpViewsLevel();
            }
        });

        findViewById(R.id.guesswork).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.clickSound();
                app.gameType = "guessWork";
                setUpViewsLevel();
            }
        });

        findViewById(R.id.hangman).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.clickSound();
                app.gameType = "hangman";
                setUpViewsLevel();
            }
        });
    }

    private void setUpViewsLevel(){
        setContentView(R.layout.activity_level);
        findViewById(R.id.Easy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.clickSound();
                app.gameLevel = 0;
                app.stageChoice();
                activityFinish();
            }
        });

        findViewById(R.id.Medium).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.clickSound();
                app.gameLevel = 1;
                app.stageChoice();
                activityFinish();
            }
        });

        findViewById(R.id.Hard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.clickSound();
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
            setUpViews();
        }

        private void setUpViews(){
            setContentView(R.layout.dialog_choice_sudoku);

            findViewById(R.id.normalButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    app.clickSound();
                    app.gameType = "normalSudoku";
                    dialogDismiss();
                }
            });

            findViewById(R.id.unNormal).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    app.clickSound();
                    app.gameType = "unNormalSudoku";
                    dialogDismiss();
                }
            });
        }
    }
}
