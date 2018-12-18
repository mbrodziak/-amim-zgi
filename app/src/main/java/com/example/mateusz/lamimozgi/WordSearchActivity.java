package com.example.mateusz.lamimozgi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.mateusz.lamimozgi.adapters.WordSearchGridAdapter;
import com.example.mateusz.lamimozgi.adapters.WordsSearchGridAdapter;
import com.example.mateusz.lamimozgi.items.WordSearchCell;
import com.example.mateusz.lamimozgi.items.WordsSearchCell;

import java.util.ArrayList;

public class WordSearchActivity extends AppCompatActivity implements GameActivity {

    private GameApplication app;
    private int BOARD_WIDTH;
    private int BOARD_HEIGHT;
    private GridView gameBoard;
    private GridView words;
    private WordSearchCell[] content;
    private int positionInFocus = -1;
    private int lastPositionInFocus;
    private WordsSearchCell[] Words;
    private ArrayList<Integer> positionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (GameApplication) getApplication();
        String board = app.selectedStage.getStage();
        String save = app.selectedStage.getSave();
        String word = app.selectedStage.getExtra();
        String type = app.selectedStage.getType();
        BOARD_WIDTH = app.selectedStage.getWidth();
        BOARD_HEIGHT = app.selectedStage.getHeight();
        String[] saveSplit = save.split("/");
        fromPuzzleString(board, saveSplit[0], type, "");
        wordMaker(word, saveSplit[1]);
        setUpViews();
    }

    private void wordMaker(String word, String s) {
        String[] splitWords = word.split("/");
        WordsSearchCell[] wordSearch = new WordsSearchCell[s.length()];
        for (int i = 0; i < splitWords.length; i++){
            String splitWord = splitWords[i];
            String found = String.valueOf(s.charAt(i));
            boolean isFound = false;
            if (found.equals("1")){
                isFound = true;
            }
            WordsSearchCell wc = new WordsSearchCell(splitWord, isFound);
            wordSearch[i] = wc;
        }
        Words = wordSearch;
    }

    @Override
    public void fromPuzzleString(String board, String save, String type, String mark) {
        WordSearchCell[] puz = new WordSearchCell[board.length()];
        for (int i = 0; i < puz.length; i++) {
            String value = String.valueOf(board.charAt(i));
            int typeValue = Integer.parseInt(String.valueOf(type.charAt(i)));
            String saveValue = String.valueOf(save.charAt(i));
            boolean isHighlighted = false;
            if (saveValue.equals("1")){
                isHighlighted = true;
            }
            WordSearchCell wc = new WordSearchCell(value, typeValue, isHighlighted);
            puz[i] = wc;
        }
        content = puz;
    }

    @Override
    public void setUpViews() {
        setContentView(R.layout.activity_word_search);
        gameBoard = findViewById(R.id.wordSearchGrid);
        words = findViewById(R.id.wordsSearchGrid);
        TextView text = findViewById(R.id.Text);
        text.setText(app.selectedStage.getName());
        words.setNumColumns(5);
        words.setAdapter(new WordsSearchGridAdapter(this, R.layout.grid_cell_layout, Words));
        gameBoard.setNumColumns(BOARD_WIDTH);
        gameBoard.setAdapter(new WordSearchGridAdapter(this, R.layout.grid_cell_layout, content));
        gameBoard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (positionInFocus != -1) {
                    content[lastPositionInFocus].setSelected(false);
                    int difference = lastPositionInFocus - positionInFocus;
                    if (difference > 0) {
                        if (difference <= BOARD_WIDTH){
                            if (checkWord(1)){
                                highlight();
                            }else {

                            }
                        }
                    }else if (difference < 0) {

                    }
                }else{
                    positionInFocus = position;
                    content[positionInFocus].setSelected(true);
                    lastPositionInFocus = positionInFocus;
                }
                ((ArrayAdapter) gameBoard.getAdapter()).notifyDataSetChanged();
            }
        });
    }

    private boolean checkWord(int increment) {
        StringBuilder bufWord = new StringBuilder();
        positionsList = new ArrayList<>();
        int maxPIF = Math.max(positionInFocus, lastPositionInFocus);
        int minPIF = Math.min(positionInFocus, lastPositionInFocus);
        for (int j = minPIF; j <= maxPIF; j = j + increment){
            positionsList.add(j);
            bufWord.append(content[j].getValue());
        }
        boolean compare = false;
        for (WordsSearchCell WSC : Words){
            if (WSC.compare(bufWord.toString())){
                compare = true;
                break;
            }
        }
        return compare;
    }

    private void highlight() {
        for (Integer position : positionsList){
            content[position].setHighlighted(true);
        }
    }

    @Override
    public boolean check() {
        return false;
    }

    @Override
    public void toPuzzleString() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        check();
        toPuzzleString();
        app.saveStage();
    }

    @Override
    protected void onStop() {
        super.onStop();
        check();
        toPuzzleString();
        app.saveStage();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        check();
        toPuzzleString();
        app.saveStage();
    }
}
