package com.example.mateusz.lamimozgi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mateusz.lamimozgi.adapters.WordSearchGridAdapter;
import com.example.mateusz.lamimozgi.adapters.WordsSearchGridAdapter;
import com.example.mateusz.lamimozgi.items.SudokuCell;
import com.example.mateusz.lamimozgi.items.WordSearchCell;
import com.example.mateusz.lamimozgi.items.WordsSearchCell;

import java.util.ArrayList;

public class WordSearchActivity extends AppCompatActivity implements GameActivity {

    private GameApplication app;
    private int BOARD_WIDTH;
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
                    positionInFocus = position;
                    content[lastPositionInFocus].setSelected(false);
                    int difference = positionInFocus - lastPositionInFocus;
                    if (checkWord(1)){
                        highlight();
                    }else if(checkWord(BOARD_WIDTH)){
                        highlight();
                    }else if (checkWord(BOARD_WIDTH + 1)) {
                        highlight();
                    }
                    positionInFocus = -1;
                }else{
                    positionInFocus = position;
                    content[positionInFocus].setSelected(true);
                    lastPositionInFocus = positionInFocus;
                }
                ((ArrayAdapter) gameBoard.getAdapter()).notifyDataSetChanged();
                ((ArrayAdapter) words.getAdapter()).notifyDataSetChanged();
                if (check() && (!app.selectedStage.isComplete())){
                    Toast.makeText(getApplicationContext(), "Zrobiłeś to! Gratulacje!", Toast.LENGTH_SHORT).show();
                    app.selectedStage.setComplete(true);
                }
            }
        });
    }

    private boolean checkWord(int increment) {
        StringBuilder bufWord = new StringBuilder();
        StringBuilder revBufWord = new StringBuilder();
        positionsList = new ArrayList<>();
        int maxPIF = Math.max(positionInFocus, lastPositionInFocus);
        int minPIF = Math.min(positionInFocus, lastPositionInFocus);
        for (int j = minPIF; j <= maxPIF; j = j + increment){
            positionsList.add(j);
            bufWord.append(content[j].getValue());
            revBufWord.insert(0, content[j].getValue());
        }
        boolean compare = false;
        for (WordsSearchCell WSC : Words){
            if (WSC.compare(bufWord.toString())){
                compare = true;
                WSC.setFound(true);
                break;
            }
            if (WSC.compare(revBufWord.toString())) {
                compare = true;
                WSC.setFound(true);
                break;
            }
        }
        return compare;
    }

    private void highlight() {
        for (Integer position : positionsList){
            System.out.println(position + " position");
            content[position].setHighlighted(true);
        }
    }

    @Override
    public boolean check() {
        boolean solved = true;
        for (WordsSearchCell WSC : Words){
            System.out.println(WSC + " WSC");
            if (!WSC.isFound()){
                solved = false;
                break;
            }
        }
        return solved;
    }

    @Override
    public void toPuzzleString() {
        StringBuilder bufSave = new StringBuilder();
        for (WordSearchCell cell : content) {
            if (cell.isHighlighted()) {
                bufSave.append("1");
            }else{
                bufSave.append("0");
            }
        }
        bufSave.append("/");
        for (WordsSearchCell word : Words) {
            if (word.isFound()) {
                bufSave.append("1");
            }else{
                bufSave.append("0");
            }
        }
        app.selectedStage.setSave(bufSave.toString());
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
