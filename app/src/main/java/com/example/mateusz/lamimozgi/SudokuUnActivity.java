package com.example.mateusz.lamimozgi;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mateusz.lamimozgi.adapters.GridAdapter;
import com.example.mateusz.lamimozgi.items.SudokuCell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuUnActivity extends AppCompatActivity {
    private GameApplication app;
    private SudokuCell[] content;
    private GridView gameBoard;
    private int BOARD_SIZE;
    private TextView viewInFocus;
    private int positionInFocus;
    private Drawable res;
    ArrayList<ArrayList<Integer>> group;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (GameApplication) getApplication();
        String board = app.selectedStage.getStage();
        String save = app.selectedStage.getSave();
        String mark = app.selectedStage.getExtra();
        String type = app.selectedStage.getType();
        BOARD_SIZE = (int) Math.sqrt(app.selectedStage.getType().length());
        group = new ArrayList<>();
        for (int i = 0; i < BOARD_SIZE; i++){
            group.add(new ArrayList<Integer>());
        }
        content = fromPuzzleString(board, save, mark, type);
        if (BOARD_SIZE == 9){
            setContentView(R.layout.activity_9x9sudoku);
            setUpViews9x9();
        }else if(BOARD_SIZE == 6){
            setContentView(R.layout.activity_6x6sudoku);
            setUpViews6x6();
        }else if(BOARD_SIZE == 12){
            setContentView(R.layout.activity_12x12sudoku);
            setUpViews12x12();
        }
    }

    private SudokuCell[] fromPuzzleString(String string, String save, String mark, String type) {
        SudokuCell[] puz = new SudokuCell[string.length()];
        for (int i = 0; i < puz.length; i++) {
            int value = string.charAt(i) - '0';
            int saveValue = save.charAt(i) - '0';
            int markValue = mark.charAt(i) - '0';
            int typeValue = type.charAt(i) - '0';
            boolean isHighlighted = false;
            boolean isInitial = true;
            boolean isEven = false;

            if (value == 0) {
                isInitial = false;
            }
            if (!(saveValue == 0)){
                value = saveValue;
            }
            if (!(markValue == 0)){
                value = markValue;
                isHighlighted = true;
            }
            if (BOARD_SIZE == 6){
                isEven = typeValue==0||typeValue==3||typeValue==4;
            }else if (BOARD_SIZE == 9){
                isEven = typeValue==0||typeValue==2||typeValue==4||typeValue==6||typeValue==8;
            }else if (BOARD_SIZE == 12){
                isEven = typeValue==0||typeValue==2||typeValue==4||typeValue==6||typeValue==8||typeValue==10;
            }
            add(typeValue, i);
            SudokuCell sc = new SudokuCell(value, isInitial, isEven);
            sc.setHighlighted(isHighlighted);
            puz[i] = sc;
        }
        return puz;
    }

    private void add(int typeValue, int e) {
        group.get(typeValue).add(e);
    }

    private void setUpViews6x6() {
        gameBoard = findViewById(R.id.sudokuGrid);
        Button one = findViewById(R.id.button1Value);
        Button two = findViewById(R.id.button2Value);
        Button three = findViewById(R.id.button3Value);
        Button four = findViewById(R.id.button4Value);
        Button five = findViewById(R.id.button5Value);
        Button six = findViewById(R.id.button6Value);
        Button check = findViewById(R.id.buttonCheckBoard);
        Button mark = findViewById(R.id.buttonMarkValue);
        Button clear = findViewById(R.id.buttonNullValue);
        TextView text = findViewById(R.id.Text);
        text.setText(app.selectedStage.getName());
        ListAdapter adapter = new GridAdapter(this, R.layout.grid_cell_layout, content);
        gameBoard.setNumColumns(BOARD_SIZE);
        gameBoard.setAdapter(adapter);
        gameBoard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (viewInFocus != null) {
                    viewInFocus.setBackground(res);
                }
                viewInFocus = (TextView) view;
                positionInFocus = position;
                res = view.getBackground();
                view.setBackgroundResource(R.drawable.selected_cell_background);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(1);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(2);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(3);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(4);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(5);

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(6);
            }
        });

        mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positionInFocus != -1) {
                    boolean isMarked = content[positionInFocus].isHighlighted();
                    content[positionInFocus].setHighlighted(!isMarked);
                    ((ArrayAdapter) gameBoard.getAdapter()).notifyDataSetChanged();
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(0);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean solved = true;

                for (int i = 0; i < BOARD_SIZE; i++) {
                    if (traverseHorizontal(i) || traverseVertical(i) || traverseSquareGroups(i)) {
                        solved = false;
                        break;
                    }
                }
                if (solved) {
                    Toast.makeText(getApplicationContext(), "You did it! Congrats!",
                            Toast.LENGTH_SHORT).show();
                    app.selectedStage.setComplete(true);
                } else {
                    Toast.makeText(getApplicationContext(), "Nope... Not correct.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setUpViews9x9() {
        gameBoard = findViewById(R.id.sudokuGrid);
        Button one = findViewById(R.id.button1Value);
        Button two = findViewById(R.id.button2Value);
        Button three = findViewById(R.id.button3Value);
        Button four = findViewById(R.id.button4Value);
        Button five = findViewById(R.id.button5Value);
        Button six = findViewById(R.id.button6Value);
        Button seven = findViewById(R.id.button7Value);
        Button eight = findViewById(R.id.button8Value);
        Button nine = findViewById(R.id.button9Value);
        Button check = findViewById(R.id.buttonCheckBoard);
        Button mark = findViewById(R.id.buttonMarkValue);
        Button clear = findViewById(R.id.buttonNullValue);
        TextView text = findViewById(R.id.Text);
        text.setText(app.selectedStage.getName());
        ListAdapter adapter = new GridAdapter(this, R.layout.grid_cell_layout, content);
        gameBoard.setNumColumns(BOARD_SIZE);
        gameBoard.setAdapter(adapter);
        gameBoard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (viewInFocus != null) {
                    viewInFocus.setBackground(res);
                }
                viewInFocus = (TextView) view;
                positionInFocus = position;
                res = view.getBackground();
                view.setBackgroundResource(R.drawable.selected_cell_background);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(1);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(2);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(3);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(4);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(5);

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(6);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(7);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(8);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(9);
            }
        });

        mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positionInFocus != -1) {
                    boolean isMarked = content[positionInFocus].isHighlighted();
                    content[positionInFocus].setHighlighted(!isMarked);
                    ((ArrayAdapter) gameBoard.getAdapter()).notifyDataSetChanged();
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(0);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean solved = true;

                for (int i = 0; i < BOARD_SIZE; i++) {
                    if (traverseHorizontal(i) || traverseVertical(i) || traverseSquareGroups(i)) {
                        solved = false;
                        break;
                    }
                }
                if (solved) {
                    Toast.makeText(getApplicationContext(), "You did it! Congrats!",
                            Toast.LENGTH_SHORT).show();
                    app.selectedStage.setComplete(true);
                } else {
                    Toast.makeText(getApplicationContext(), "Nope... Not correct.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setUpViews12x12() {
        gameBoard = findViewById(R.id.sudokuGrid);
        Button one = findViewById(R.id.button1Value);
        Button two = findViewById(R.id.button2Value);
        Button three = findViewById(R.id.button3Value);
        Button four = findViewById(R.id.button4Value);
        Button five = findViewById(R.id.button5Value);
        Button six = findViewById(R.id.button6Value);
        Button seven = findViewById(R.id.button7Value);
        Button eight = findViewById(R.id.button8Value);
        Button nine = findViewById(R.id.button9Value);
        Button ten = findViewById(R.id.button10Value);
        Button eleven = findViewById(R.id.button11Value);
        Button twelve = findViewById(R.id.button12Value);
        Button check = findViewById(R.id.buttonCheckBoard);
        Button mark = findViewById(R.id.buttonMarkValue);
        Button clear = findViewById(R.id.buttonNullValue);
        TextView text = findViewById(R.id.Text);
        text.setText(app.selectedStage.getName());
        ListAdapter adapter = new GridAdapter(this, R.layout.grid_cell_layout, content);
        gameBoard.setNumColumns(BOARD_SIZE);
        gameBoard.setAdapter(adapter);
        gameBoard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (viewInFocus != null) {
                    viewInFocus.setBackground(res);
                }
                viewInFocus = (TextView) view;
                positionInFocus = position;
                res = view.getBackground();
                view.setBackgroundResource(R.drawable.selected_cell_background);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(1);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(2);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(3);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(4);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(5);

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(6);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(7);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(8);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(9);
            }
        });

        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(10);
            }
        });

        eleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(11);
            }
        });

        twelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(12);
            }
        });

        mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positionInFocus != -1) {
                    boolean isMarked = content[positionInFocus].isHighlighted();
                    content[positionInFocus].setHighlighted(!isMarked);
                    ((ArrayAdapter) gameBoard.getAdapter()).notifyDataSetChanged();
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueInSelectedView(0);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean solved = true;

                for (int i = 0; i < BOARD_SIZE; i++) {
                    if (traverseHorizontal(i) || traverseVertical(i) || traverseSquareGroups(i)) {
                        solved = false;
                        break;
                    }
                }
                if (solved) {
                    Toast.makeText(getApplicationContext(), "You did it! Congrats!",
                            Toast.LENGTH_SHORT).show();
                    app.selectedStage.setComplete(true);
                } else {
                    Toast.makeText(getApplicationContext(), "Nope... Not correct.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean traverseSquareGroups(int gp) {
        Set<SudokuCell> gElements = new HashSet<>();
        boolean isEven = gp % 2 == 0;
        for (int i = 0; i < BOARD_SIZE; i++){
            gElements.add(content[group.get(gp).get(i)]);
        }
        return gElements.contains(new SudokuCell(0, false, isEven)) || gElements.size() != BOARD_SIZE;
    }

    private boolean traverseVertical(int column) {
        Set<SudokuCell> vElements = new HashSet<>();
        for (int i = column; i < content.length; i += BOARD_SIZE) {
            vElements.add(content[i]);
        }
        return vElements.contains(new SudokuCell(0, false, false)) || vElements.contains(new SudokuCell(0, false, true)) || vElements.size() != BOARD_SIZE;
    }

    private boolean traverseHorizontal(int line) {
        int startPoint = line*BOARD_SIZE;
        int endPoint = startPoint+(BOARD_SIZE);
        Set<SudokuCell> hElements = new HashSet<>(Arrays.asList(content).subList(startPoint, endPoint));

        return hElements.contains(new SudokuCell(0, false, false)) || hElements.contains(new SudokuCell(0, false, true)) || hElements.size() != BOARD_SIZE;
    }

    private void setValueInSelectedView(int value) {
        if (positionInFocus != -1) {
            content[positionInFocus].setValue(value);
            ((ArrayAdapter) gameBoard.getAdapter()).notifyDataSetChanged();
        }
    }

    private void toPuzzleString() {
        StringBuilder bufSave = new StringBuilder();
        StringBuilder bufMark = new StringBuilder();
        for (SudokuCell cell : content) {
            if (!cell.isInitialValue()) {
                if (cell.isHighlighted()) {
                    bufMark.append(cell.getValue());
                    bufSave.append(0);
                } else {
                    bufSave.append(cell.getValue());
                    bufMark.append(0);
                }
            }else{
                bufMark.append(0);
                bufSave.append(0);
            }
        }
        app.selectedStage.setExtra(bufMark.toString());
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
