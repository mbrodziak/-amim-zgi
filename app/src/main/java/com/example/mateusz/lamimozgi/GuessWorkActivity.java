package com.example.mateusz.lamimozgi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GuessWorkActivity extends AppCompatActivity implements GameActivity {

    private GameApplication app;
    private TextView answerView;
    private String answer;
    private String solution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (GameApplication) getApplication();
        String save = app.selectedStage.getSave();
        String mark = app.selectedStage.getExtra();
        fromPuzzleString("", save, "", mark);
        setUpViews();
    }

    @Override
    public void setUpViews() {
        setContentView(R.layout.activity_guess_work);
        TextView guess = findViewById(R.id.guess);
        guess.setText(app.selectedStage.getStage());
        TextView text = findViewById(R.id.Text);
        text.setText(app.selectedStage.getName());
        answerView = findViewById(R.id.txt);
        answerView.setText(answer);
        findViewById(R.id.buttonA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("A");
            }
        });
        findViewById(R.id.buttonB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("B");
            }
        });
        findViewById(R.id.buttonC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("C");
            }
        });
        findViewById(R.id.buttonD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("D");
            }
        });
        findViewById(R.id.buttonE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("E");
            }
        });
        findViewById(R.id.buttonF).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("F");
            }
        });
        findViewById(R.id.buttonG).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("G");
            }
        });
        findViewById(R.id.buttonH).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("H");
            }
        });
        findViewById(R.id.buttonI).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("I");
            }
        });
        findViewById(R.id.buttonJ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("J");
            }
        });
        findViewById(R.id.buttonK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("K");
            }
        });
        findViewById(R.id.buttonL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("L");
            }
        });
        findViewById(R.id.buttonM).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("M");
            }
        });
        findViewById(R.id.buttonN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("N");
            }
        });
        findViewById(R.id.buttonO).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("O");
            }
        });
        findViewById(R.id.buttonP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("P");
            }
        });
        findViewById(R.id.buttonQ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("Q");
            }
        });
        findViewById(R.id.buttonR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("R");
            }
        });
        findViewById(R.id.buttonS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("S");
            }
        });
        findViewById(R.id.buttonT).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("T");
            }
        });
        findViewById(R.id.buttonU).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("U");
            }
        });
        findViewById(R.id.buttonV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("V");
            }
        });
        findViewById(R.id.buttonW).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("W");
            }
        });
        findViewById(R.id.buttonX).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("X");
            }
        });
        findViewById(R.id.buttonY).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("Y");
            }
        });
        findViewById(R.id.buttonZ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLetter("Z");
            }
        });
        findViewById(R.id.buttonCHECK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    Toast.makeText(getApplicationContext(), "Zrobiłeś to! Gratulacje!", Toast.LENGTH_SHORT).show();
                    app.selectedStage.setComplete(true);
                } else {
                    Toast.makeText(getApplicationContext(), "Nie... Nie poprawne.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.buttonDELETE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteLetter();
            }
        });
    }

    private void deleteLetter() {
        int len = answer.length();
        answer = answer.substring(0,len-1);
        answerView.setText(answer);
    }

    private void writeLetter(String Letter) {
        answer += Letter;
        answerView.setText(answer);
    }

    @Override
    public void fromPuzzleString(String board, String save, String type, String mark) {
        answer = save;
        solution = mark;
    }

    @Override
    public boolean check() {
        return answer.equals(solution);
    }

    @Override
    public void toPuzzleString() {
        app.selectedStage.setSave(answer);
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
