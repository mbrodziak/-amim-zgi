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

import java.util.ArrayList;
import java.util.HashMap;

public class CrosswordActivity extends AppCompatActivity {
    private GameApplication app;
    private int BOARD_WIDTH;
    private int BOARD_HEIGHT;
    private CrosswordCell[] content;
    private GridView gameBoard;
    private int positionInFocus = -1;
    private boolean isHorizontal;
    private int lastPositionInFocus;
    private ArrayList<Integer> highlightPositions = new ArrayList<>();
    private TextView hint;
    private HashMap crosswordClues;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (GameApplication) getApplication();
        String board = app.selectedStage.getStage();
        String save = app.selectedStage.getSave();
        String clue = app.selectedStage.getExtra();
        String type = app.selectedStage.getType();
        BOARD_WIDTH = app.selectedStage.getWidth();
        BOARD_HEIGHT = app.selectedStage.getHeight();
        crosswordClues = clueMaker(clue);
        content = fromPuzzleString(board, save, type);
        setUpViews();
    }

    private HashMap clueMaker(String clue) {
        HashMap Clues = new HashMap();
        String[] splitClue = clue.split("/");
        for (String e :splitClue){
            System.out.println(e);
            String[] split = e.split(";");
            Clues.put(split[0]+split[1],split[3]);
        }
        return Clues;
    }

    private CrosswordCell[] fromPuzzleString(String board, String save, String type) {
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
        hint = findViewById(R.id.hint);
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
                if (positionInFocus != -1) {
                    content[lastPositionInFocus].setSelected(false);
                    for (int e : highlightPositions) {
                        content[e].setHighlight(false);
                        content[e].setSelected(false);
                    }
                    highlightPositions = new ArrayList<>();
                }
                if (position == positionInFocus){
                    content[positionInFocus].setSelected(true);
                    if (!isHorizontal){
                        if (position % BOARD_WIDTH > 0 && position % BOARD_WIDTH < BOARD_WIDTH - 1) {
                            if (content[position + 1].isEven() || content[position - 1].isEven()) {
                                isHorizontal = !isHorizontal;
                            }
                        }else if(position % BOARD_WIDTH == 0){
                            if (content[position + 1].isEven()){
                                isHorizontal = !isHorizontal;
                            }
                        }else if(position % BOARD_WIDTH == BOARD_WIDTH - 1){
                            if (content[position - 1].isEven()){
                                isHorizontal = !isHorizontal;
                            }
                        }
                    }else{
                        if (position - BOARD_WIDTH >= 0 && position + BOARD_WIDTH <= BOARD_WIDTH * BOARD_HEIGHT - 1) {
                            if (content[position + BOARD_WIDTH].isEven() || content[position - BOARD_WIDTH].isEven()) {
                                isHorizontal = !isHorizontal;
                            }
                        }else if(position - BOARD_WIDTH < 0){
                            if (content[position + BOARD_WIDTH].isEven()){
                                isHorizontal = !isHorizontal;
                            }
                        }else if(position + BOARD_WIDTH > BOARD_HEIGHT * BOARD_WIDTH - 1){
                            if (content[position - BOARD_WIDTH].isEven()){
                                isHorizontal = !isHorizontal;
                            }
                        }
                    }

                    highlight(position);
                }else {
                    positionInFocus = position;
                    content[positionInFocus].setSelected(true);
                    lastPositionInFocus = positionInFocus;

                    if (position % BOARD_WIDTH > 0 && position % BOARD_WIDTH < BOARD_WIDTH - 1) {
                        if (content[position + 1].isEven() || content[position - 1].isEven()) {
                            isHorizontal = true;
                        }
                    }else if(position % BOARD_WIDTH == 0){
                        if (content[position + 1].isEven()){
                            isHorizontal = true;
                        }
                    }else if(position % BOARD_WIDTH == BOARD_WIDTH - 1){
                        if (content[position - 1].isEven()){
                            isHorizontal = true;
                        }
                    }
                    if (position - BOARD_WIDTH >= 0 && position + BOARD_WIDTH <= BOARD_WIDTH * BOARD_HEIGHT - 1) {
                        if (content[position + BOARD_WIDTH].isEven() || content[position - BOARD_WIDTH].isEven()) {
                            isHorizontal = false;
                        }
                    }else if(position - BOARD_WIDTH < 0){
                        if (content[position + BOARD_WIDTH].isEven()){
                            isHorizontal = false;
                        }
                    }else if(position + BOARD_WIDTH > BOARD_HEIGHT * BOARD_WIDTH - 1){
                        if (content[position - BOARD_WIDTH].isEven()){
                            isHorizontal = false;
                        }
                    }
                    highlight(position);
                }
                int pos = positionInFocus;
                System.out.println(pos);
                if (isHorizontal){
                    while ((pos - 1) % BOARD_WIDTH != BOARD_WIDTH - 1 && pos > 0 && content[pos - 1].isEven()){
                        pos = pos - 1;
                    }
                    System.out.println(pos);
                    hint.setText((String) crosswordClues.get("H"+pos));
                }else{
                    while (pos > BOARD_WIDTH - 1 && content[pos - BOARD_WIDTH].isEven()){
                        pos = pos - BOARD_WIDTH;
                    }
                    System.out.println(pos);
                    hint.setText((String) crosswordClues.get("V"+pos));
                }
                ((ArrayAdapter) gameBoard.getAdapter()).notifyDataSetChanged();
            }
        });
    }

    private void highlight(int position){
        int stablePosition = position;
        if (isHorizontal) {
            if (position < BOARD_HEIGHT * BOARD_WIDTH - 1) {
                while ((position + 1) % BOARD_WIDTH != 0 && content[position + 1].isEven()) {
                    content[position + 1].setHighlight(true);
                    highlightPositions.add(position + 1);
                    position = position + 1;

                    if (position >= BOARD_HEIGHT * BOARD_WIDTH - 1) {
                        break;
                    }
                }
            }
            position = stablePosition;
            if (position > 0) {
                while ((position - 1) % BOARD_WIDTH != BOARD_WIDTH - 1 && content[position - 1].isEven()) {
                    content[position - 1].setHighlight(true);
                    highlightPositions.add(position - 1);
                    position = position - 1;

                    if (position <= 0) {
                        break;
                    }
                }
            }
        }
        if (!isHorizontal) {
            if (position < BOARD_HEIGHT * BOARD_WIDTH - BOARD_WIDTH) {
                while (content[position + BOARD_WIDTH].isEven()) {
                    content[position + BOARD_WIDTH].setHighlight(true);
                    highlightPositions.add(position + BOARD_WIDTH);
                    position = position + BOARD_WIDTH;

                    if (position >= BOARD_HEIGHT * BOARD_WIDTH - BOARD_WIDTH) {
                        break;
                    }
                }
            }
            position = stablePosition;
            if (position >= BOARD_WIDTH) {
                while (content[position - BOARD_WIDTH].isEven()) {
                    content[position - BOARD_WIDTH].setHighlight(true);
                    highlightPositions.add(position - BOARD_WIDTH);
                    position = position - BOARD_WIDTH;

                    if (position <= BOARD_WIDTH - 1) {
                        break;
                    }
                }
            }
        }
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
                if (isHorizontal) {
                    if (!(content.length - 1 <= positionInFocus)) {
                        if ((positionInFocus + 1) % BOARD_WIDTH != 0 && content[positionInFocus + 1].isEven()) {
                            lastPositionInFocus = positionInFocus;
                            positionInFocus = positionInFocus + 1;
                            content[positionInFocus].setSelected(true);
                            content[positionInFocus].setHighlight(false);
                            content[lastPositionInFocus].setSelected(false);
                            content[lastPositionInFocus].setHighlight(true);
                            highlightPositions.add(lastPositionInFocus);
                            }
                        }
                    }
                else{
                    if (!(content.length - BOARD_WIDTH <= positionInFocus)) {
                        if (content[positionInFocus + BOARD_WIDTH].isEven()) {
                            lastPositionInFocus = positionInFocus;
                            positionInFocus = positionInFocus + BOARD_WIDTH;
                            content[positionInFocus].setSelected(true);
                            content[positionInFocus].setHighlight(false);
                            content[lastPositionInFocus].setSelected(false);
                            content[lastPositionInFocus].setHighlight(true);
                            highlightPositions.add(lastPositionInFocus);
                        }
                    }
                }
            }
        }
        ((ArrayAdapter) gameBoard.getAdapter()).notifyDataSetChanged();
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
