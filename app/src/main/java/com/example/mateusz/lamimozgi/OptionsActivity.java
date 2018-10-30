package com.example.mateusz.lamimozgi;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class OptionsActivity extends AppCompatActivity {
    private GameApplication app;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        setUpViewsOptions();
    }

    private void dialogDismiss() {
        dialog.dismiss();
    }

    private void layoutOptions(){
        setContentView(R.layout.activity_options);
        setUpViewsOptions();
    }

    private void layoutReset(){
        setContentView(R.layout.activity_reset);
        setUpViewsReset();
    }

    private void resetDialog() {
        dialog = new resetDialog(this);
        dialog.show();
    }

    private void setUpViewsOptions() {
        Button sound  = findViewById(R.id.sound);
        Button music = findViewById(R.id.music);
        Button reset = findViewById(R.id.reset);

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volumeSoundDialog();
            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volumeMusicDialog();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetDialog();
            }
        });
    }

    private void setUpViewsReset() {
        Button sudokuReset = findViewById(R.id.sudokuReset);
        Button wsReset = findViewById(R.id.wordSearchReset);
        Button crossReset = findViewById(R.id.crosswordReset);
        Button guessReset = findViewById(R.id.guessworkReset);
        Button hangReset = findViewById(R.id.hangmanReset);
        app = (GameApplication) getApplication();

        sudokuReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.resetGame("sudoku");
                layoutOptions();
            }
        });

        wsReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.resetGame("wordSearch");
                layoutOptions();
            }
        });

        crossReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.resetGame("crossword");
                layoutOptions();
            }
        });

        guessReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.resetGame("guesswork");
                layoutOptions();
            }
        });

        hangReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.resetGame("hangman");
                layoutOptions();
            }
        });
    }

    private void volumeMusicDialog() {
        dialog = new volumeMusicDialog(this);
        dialog.show();
    }

    private void volumeSoundDialog() {
        dialog = new volumeSoundDialog(this);
        dialog.show();
    }

    private class resetDialog extends Dialog{

        resetDialog(@NonNull Context context) {
            super(context);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dialog_reset);
            setUpViews();
        }

        private void setUpViews(){
            Button all = findViewById(R.id.all);
            Button chosen = findViewById(R.id.chosen);

            all.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    app.resetAllGames();
                    dialogDismiss();
                }
            });

            chosen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layoutReset();
                    dialogDismiss();
                }
            });
        }
    }

    private class volumeMusicDialog extends Dialog{

        volumeMusicDialog(@NonNull Context context) {
            super(context);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dialog_volume_music);
            setUpViews();
        }

        private void setUpViews(){
            SeekBar musicVolume = findViewById(R.id.volume_music);
            musicVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    app.volumeMusic = progress;
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        }
    }

    private class volumeSoundDialog extends Dialog{

        volumeSoundDialog(@NonNull Context context) {
            super(context);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dialog_volume_sound);
            setUpViews();
        }

        private void setUpViews(){
            SeekBar soundVolume = findViewById(R.id.volume_sound);
            soundVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    app.volumeMusic = progress;
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        }
    }
}
