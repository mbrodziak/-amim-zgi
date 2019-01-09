package com.example.mateusz.lamimozgi;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

public class OptionsActivity extends AppCompatActivity {
    private GameApplication app;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (GameApplication) getApplication();
        setContentView(R.layout.activity_options);
        setUpViewsOptions();
    }

    private void dialogDismiss() {
        dialog.dismiss();
    }

    private void setUpViewsOptions(){
        setContentView(R.layout.activity_options);

        findViewById(R.id.sound).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                volumeSoundDialog();
            }
        });

        findViewById(R.id.music).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                volumeMusicDialog();
            }
        });

        findViewById(R.id.statistics).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                resetDialog();
            }
        });
    }

    private void setUpViewsReset(){
        setContentView(R.layout.activity_reset);

        findViewById(R.id.sudokuReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                app.resetGame("sudoku");
                setUpViewsOptions();
            }
        });

        findViewById(R.id.wordSearchReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                app.resetGame("wordSearch");
                setUpViewsOptions();
            }
        });

        findViewById(R.id.crosswordReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                app.resetGame("crossword");
                setUpViewsOptions();
            }
        });

        findViewById(R.id.guessworkReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                app.resetGame("guesswork");
                setUpViewsOptions();
            }
        });

        findViewById(R.id.hangmanReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.clickSound();
                app.resetGame("hangman");
                setUpViewsOptions();
            }
        });
    }

    private void resetDialog() {
        dialog = new resetDialog(this);
        dialog.show();
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
            findViewById(R.id.all).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    app.clickSound();
                    app.resetAllGames();
                    dialogDismiss();
                }
            });

            findViewById(R.id.chosen).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    app.clickSound();
                    setUpViewsReset();
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
            musicVolume.setProgress((int) (app.volumeMusic*100));
            musicVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    app.volumeMusic = (float)progress/100;
                    app.setMusicVolume();
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
            soundVolume.setProgress((int) (app.volumeSound*100));
            soundVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    app.volumeSound = (float)progress/100;
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
