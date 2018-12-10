package com.example.mateusz.lamimozgi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mateusz.lamimozgi.adapters.CrosswordGridAdapter;
import com.example.mateusz.lamimozgi.items.CrosswordCell;

public class CrosswordActivity extends AppCompatActivity {
    private GameApplication app;
    private int BOARD_WIDTH;
    private int BOARD_HEIGHT;
    private CrosswordCell[] content;
    private GridView gameBoard;
    private int positionInFocus = -1;
    private boolean isHorizontal = true;
    private int lastPositionInFocus;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (GameApplication) getApplication();
        String board = app.selectedStage.getStage();
        String save = app.selectedStage.getSave();
        String clue = app.selectedStage.getExtra();
        String type = app.selectedStage.getType();
        BOARD_WIDTH = app.selectedStage.getWidth();
        BOARD_HEIGHT = app.selectedStage.getHeight();

        content = fromPuzzleString(board, save, clue, type);
        setUpViews();
    }

    private CrosswordCell[] fromPuzzleString(String board, String save, String clue, String type) {
        CrosswordCell[] puz = new CrosswordCell[type.length()];
        for (int i = 0; i < puz.length; i++) {
            String solution = String.valueOf(board.charAt(i));
            String typeValue = String.valueOf(type.charAt(i));
            String value = String.valueOf(save.charAt(i));
            boolean isEven = false;
            if (typeValue.equals("-")){
                isEven = true;
            }
            if (value.equals("-")){
                value = " ";
            }
            if (value.equals(".")){
                value = " ";
            }

            CrosswordCell sc = new CrosswordCell(value, solution, isEven);
            puz[i] = sc;
        }
        return puz;
    }

    private void setUpViews() {
        setContentView(R.layout.activity_crossword);
        gameBoard = findViewById(R.id.crosswordGrid);
        findViewById(R.id.buttonA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("A");
            }
        });
        findViewById(R.id.buttonB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("B");
            }
        });
        findViewById(R.id.buttonC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("C");
            }
        });
        findViewById(R.id.buttonD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("D");
            }
        });
        findViewById(R.id.buttonE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("E");
            }
        });
        findViewById(R.id.buttonF).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("F");
            }
        });
        findViewById(R.id.buttonG).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("G");
            }
        });
        findViewById(R.id.buttonH).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("H");
            }
        });
        findViewById(R.id.buttonI).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("I");
            }
        });
        findViewById(R.id.buttonJ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("J");
            }
        });
        findViewById(R.id.buttonK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("K");
            }
        });
        findViewById(R.id.buttonL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("L");
            }
        });
        findViewById(R.id.buttonM).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("M");
            }
        });
        findViewById(R.id.buttonN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("N");
            }
        });
        findViewById(R.id.buttonO).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("O");
            }
        });
        findViewById(R.id.buttonP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("P");
            }
        });
        findViewById(R.id.buttonQ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("Q");
            }
        });
        findViewById(R.id.buttonR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("R");
            }
        });
        findViewById(R.id.buttonS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("S");
            }
        });
        findViewById(R.id.buttonT).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("T");
            }
        });
        findViewById(R.id.buttonU).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("U");
            }
        });
        findViewById(R.id.buttonV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("V");
            }
        });
        findViewById(R.id.buttonW).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("W");
            }
        });
        findViewById(R.id.buttonX).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("X");
            }
        });
        findViewById(R.id.buttonY).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("Y");
            }
        });
        findViewById(R.id.buttonZ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView("Z");
            }
        });
        findViewById(R.id.buttonCHECK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    Toast.makeText(getApplicationContext(), "You did it! Congrats!",
                            Toast.LENGTH_SHORT).show();
                    app.selectedStage.setComplete(true);
                } else {
                    Toast.makeText(getApplicationContext(), "Nope... Not correct.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.buttonDELETE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(" ");
            }
        });

        TextView text = findViewById(R.id.Text);
        text.setText(app.selectedStage.getName());
        gameBoard.setNumColumns(BOARD_WIDTH);
        gameBoard.setAdapter(new CrosswordGridAdapter(this, R.layout.crossword_grid_cell_layout, content));
        gameBoard.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (positionInFocus != -1){
                    content[lastPositionInFocus].setSelected(false);
                }
                positionInFocus = position;
                content[positionInFocus].setSelected(true);
                lastPositionInFocus = positionInFocus;
                ((ArrayAdapter) gameBoard.getAdapter()).notifyDataSetChanged();
            }
        });
    }

    private boolean check() {
        boolean solved = true;
        for (int i = 0; i < BOARD_WIDTH*BOARD_HEIGHT; i++) {
            if (!content[i].check()){
                solved = false;
                break;
            }
        }
        return solved;
    }

    private void setValueInSelectedView(String value) {
        if (positionInFocus != -1) {
            if (content[positionInFocus].isEven()){
                content[positionInFocus].setValue(value);
                if (content[positionInFocus+1].isEven()) {
                    if (isHorizontal) {
                        lastPositionInFocus = positionInFocus;
                        positionInFocus = positionInFocus + 1;
                        content[positionInFocus].setSelected(true);
                        content[lastPositionInFocus].setSelected(false);

                    } else {
                        lastPositionInFocus = positionInFocus;
                        positionInFocus = positionInFocus + BOARD_WIDTH;
                        content[positionInFocus].setSelected(true);
                        content[lastPositionInFocus].setSelected(false);
                    }
                }
                ((ArrayAdapter) gameBoard.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    private void toPuzzleString() {
        StringBuilder bufSave = new StringBuilder();
        for (CrosswordCell cell : content) {
            if (cell.isEven()) {
                String value = cell.getValue();
                if (value.equals(" ")){
                    bufSave.append("-");
                }else{
                    bufSave.append(value);
                }
            }else{
                bufSave.append(".");
            }
        }
        app.selectedStage.setSave(bufSave.toString());
    }

    protected void onPause() {
        super.onPause();
        toPuzzleString();
        app.saveStage();
    }

    protected void onStop() {
        super.onStop();
        toPuzzleString();
        app.saveStage();
    }

    protected void onDestroy() {
        super.onDestroy();
        toPuzzleString();
        app.saveStage();
    }
}
