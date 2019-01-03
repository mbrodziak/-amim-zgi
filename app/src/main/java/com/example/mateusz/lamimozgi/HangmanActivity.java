package com.example.mateusz.lamimozgi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class HangmanActivity extends AppCompatActivity implements GameActivity {
    private static int HangStage;
    private GameApplication app;
    private ArrayList<String> saveArray;
    private String typeString;
    private ArrayList<String> phraseArray;
    private TextView txt;
    private ImageView hang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (GameApplication) getApplication();
        String board = app.selectedStage.getStage();
        String type = app.selectedStage.getType();
        String save = app.selectedStage.getSave();
        String mark = app.selectedStage.getExtra();
        fromPuzzleString(board, save, type, mark);
        setUpViews();
    }

    @Override
    public void setUpViews() {
        setContentView(R.layout.activity_hangman);
        txt = findViewById(R.id.txt);
        hang = findViewById(R.id.hang);
        TextView text = findViewById(R.id.Text);
        text.setText(app.selectedStage.getName());
        findViewById(R.id.buttonA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("A");
            }
        });
        findViewById(R.id.buttonB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("B");
            }
        });
        findViewById(R.id.buttonC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("C");
            }
        });
        findViewById(R.id.buttonD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("D");
            }
        });
        findViewById(R.id.buttonE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("E");
            }
        });
        findViewById(R.id.buttonF).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("F");
            }
        });
        findViewById(R.id.buttonG).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("G");
            }
        });
        findViewById(R.id.buttonH).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("H");
            }
        });
        findViewById(R.id.buttonI).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("I");
            }
        });
        findViewById(R.id.buttonJ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("J");
            }
        });
        findViewById(R.id.buttonK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("K");
            }
        });
        findViewById(R.id.buttonL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("L");
            }
        });
        findViewById(R.id.buttonM).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("M");
            }
        });
        findViewById(R.id.buttonN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("N");
            }
        });
        findViewById(R.id.buttonO).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("O");
            }
        });
        findViewById(R.id.buttonP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("P");
            }
        });
        findViewById(R.id.buttonQ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("Q");
            }
        });
        findViewById(R.id.buttonR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("R");
            }
        });
        findViewById(R.id.buttonS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("S");
            }
        });
        findViewById(R.id.buttonT).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("T");
            }
        });
        findViewById(R.id.buttonU).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("U");
            }
        });
        findViewById(R.id.buttonV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("V");
            }
        });
        findViewById(R.id.buttonW).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("W");
            }
        });
        findViewById(R.id.buttonX).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("X");
            }
        });
        findViewById(R.id.buttonY).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("Y");
            }
        });
        findViewById(R.id.buttonZ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter("Z");
            }
        });
        setSaveString();
        setHangImage();
    }

    private void setHangImage() {
        int resource;
        switch (HangStage) {
            case 0:
                resource = R.drawable.hangman0;
                break;
            case 1:
                resource = R.drawable.hangman1;
                break;
            case 2:
                resource = R.drawable.hangman2;
                break;
            case 3:
                resource = R.drawable.hangman3;
                break;
            case 4:
                resource = R.drawable.hangman4;
                break;
            case 5:
                resource = R.drawable.hangman5;
                break;
            case 6:
                resource = R.drawable.hangman6;
                break;
            case 7:
                resource = R.drawable.hangman7;
                break;
            case 8:
                resource = R.drawable.hangman8;
                break;
            case 9:
                resource = R.drawable.hangman9;
                break;
            default:
                resource = R.drawable.hangman10;
                break;
        }
        hang.setImageResource(resource);
    }

    private void setSaveString() {
        String save = "";
        for(String letter : saveArray){
            save = String.format("%s%s", save, letter);
        }
        txt.setText(save);
    }

    private void checkLetter(String Letter){
        if ((!app.selectedStage.isComplete())) {
            if (typeString.contains(Letter)) {
                Toast.makeText(getApplicationContext(), "Było", Toast.LENGTH_SHORT).show();
            } else if (phraseArray.contains(Letter)) {
                ArrayList<String> phrase = new ArrayList<>(phraseArray);
                while (phrase.contains(Letter)) {
                    System.out.println(phraseArray);
                    System.out.println(phrase);
                    System.out.println(saveArray);
                    int index = phrase.indexOf(Letter);
                    phrase.set(index, "-");
                    saveArray.set(index, Letter);
                }
                typeString = String.format("%s%s", typeString, Letter);
            } else {
                HangStage = HangStage + 1;
                typeString = String.format("%s%s", typeString, Letter);
            }
            setSaveString();
            setHangImage();
            if (HangStage == 10) {
                Toast.makeText(getApplicationContext(), "Ech", Toast.LENGTH_SHORT).show();
                reset();
                this.finish();
            } else if (check()) {
                Toast.makeText(getApplicationContext(), "Zrobiłeś to! Gratulacje!", Toast.LENGTH_SHORT).show();
                app.selectedStage.setComplete(true);
            }
        }
    }

    private void reset() {
        saveArray = new ArrayList<>();
        for (String type : phraseArray){
            System.out.println(phraseArray);
            System.out.println(saveArray);
            switch (type) {
                case " ":
                    saveArray.add(" ");
                    break;
                case "":
                    saveArray.add("");
                    break;
                default:
                    saveArray.add("-");
                    break;
            }
        }
        HangStage = 0;
        typeString = "";
    }

    @Override
    public void fromPuzzleString(String board, String save, String type, String mark) {
        phraseArray = new ArrayList<>();
        phraseArray.addAll(Arrays.asList(type.split("")));
        saveArray = new ArrayList<>();
        saveArray.addAll(Arrays.asList(board.split("")));
        HangStage = Integer.parseInt(mark);
        typeString = save;
    }

    @Override
    public boolean check() {
        return phraseArray.equals(saveArray);
    }

    @Override
    public void toPuzzleString() {
        String save = "";
        for(String letter : saveArray){
            save = String.format("%s%s", save, letter);
        }

        app.selectedStage.setSave(typeString);
        app.selectedStage.setExtra(String.valueOf(HangStage));
        app.selectedStage.setStage(save);
    }

    @Override
    protected void onPause() {
        super.onPause();
        toPuzzleString();
        app.saveStage();
    }

    @Override
    protected void onStop() {
        super.onStop();
        toPuzzleString();
        app.saveStage();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        toPuzzleString();
        app.saveStage();
    }
}
