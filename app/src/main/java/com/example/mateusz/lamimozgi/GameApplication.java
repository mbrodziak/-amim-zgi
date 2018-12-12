package com.example.mateusz.lamimozgi;

import android.app.Application;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper;
import com.example.mateusz.lamimozgi.items.Stage;

import java.util.ArrayList;

import static com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper.COMPLETE;
import static com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper.STAGE;
import static com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper.STAGE_EXTRA;
import static com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper.STAGE_HEIGHT;
import static com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper.STAGE_ID;
import static com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper.STAGE_NAME;
import static com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper.STAGE_SAVE;
import static com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper.STAGE_TYPE;
import static com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper.STAGE_WIDTH;

public class GameApplication extends Application {
    public String gameType;
    public int gameLevel;
    public int volumeMusic;
    public Stage selectedStage;
    private ArrayList<Stage> currentStages;
    private SQLiteDatabase database;

    public void onCreate() {
        super.onCreate();
        GameSQLiteOpenHelper helper = new GameSQLiteOpenHelper(this);
        database = helper.getWritableDatabase();
    }

    public void gameStart() {
        switch (gameType) {
            case "normalSudoku": {
                Intent intent = new Intent(getApplicationContext(), SudokuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            }
            case "unNormalSudoku": {
                Intent intent = new Intent(getApplicationContext(), SudokuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            }
            case "crossword": {
                Intent intent = new Intent(getApplicationContext(), CrosswordActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            }
        }
    }

    public void resetAllGames() {
    }

    public void resetGame(String game) {
    }

    public void stageChoice() {
        Intent intent = new Intent(getApplicationContext(), StageChoiceActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void loadStages() {
        currentStages = new ArrayList<>();
        Cursor tasksCursor;
        String STAGE_TABLE = gameType + gameLevel;
        tasksCursor = database.rawQuery("select * from " + STAGE_TABLE, null);
        Stage s;
        tasksCursor.moveToFirst();
        if (! tasksCursor.isAfterLast()) switch (gameType) {
            case "normalSudoku":
                do {
                    String stage_id = tasksCursor.getString(0);
                    String name = tasksCursor.getString(1);
                    String stage = tasksCursor.getString(2);
                    String save = tasksCursor.getString(3);
                    String extra = tasksCursor.getString(4);
                    String boolValue = tasksCursor.getString(5);
                    boolean complete = Boolean.parseBoolean(boolValue);
                    String type = "000111222000111222000111222333444555333444555333444555666777888666777888666777888";
                    s = new Stage(name, stage, 9, 9, type, complete);
                    s.setID(stage_id);
                    s.setSave(save);
                    s.setExtra(extra);
                    currentStages.add(s);
                } while (tasksCursor.moveToNext());
                break;
            case "unNormalSudoku":
                do {
                    String stage_id = tasksCursor.getString(0);
                    String name = tasksCursor.getString(1);
                    String stage = tasksCursor.getString(3);
                    String save = tasksCursor.getString(4);
                    String extra = tasksCursor.getString(5);
                    String type = tasksCursor.getString(2);
                    int width = tasksCursor.getInt(6);
                    String boolValue = tasksCursor.getString(7);
                    boolean complete = Boolean.parseBoolean(boolValue);
                    s = new Stage(name, stage, width, width, type, complete);
                    s.setID(stage_id);
                    s.setSave(save);
                    s.setExtra(extra);
                    currentStages.add(s);
                } while (tasksCursor.moveToNext());
                break;
            case "crossword":
                do {
                    String stage_id = tasksCursor.getString(0);
                    String name = tasksCursor.getString(1);
                    String stage = tasksCursor.getString(3);
                    String save = tasksCursor.getString(4);
                    String extra = tasksCursor.getString(5);
                    String type = tasksCursor.getString(2);
                    int width = tasksCursor.getInt(6);
                    int height = tasksCursor.getInt(7);
                    String boolValue = tasksCursor.getString(8);
                    boolean complete = Boolean.parseBoolean(boolValue);
                    s = new Stage(name, stage, width, height, type, complete);
                    s.setID(stage_id);
                    s.setSave(save);
                    s.setExtra(extra);
                    currentStages.add(s);
                } while (tasksCursor.moveToNext());
                break;
        }
        tasksCursor.close();
    }

    public ArrayList<Stage> getCurrentStages() {
        return currentStages;
    }

    public void saveStage() {
        assert (null != selectedStage);
        switch (gameType) {
            case "normalSudoku": {
                ContentValues values = new ContentValues();
                values.put(STAGE_NAME, selectedStage.getName());
                values.put(STAGE, selectedStage.getStage());
                values.put(STAGE_SAVE, selectedStage.getSave());
                values.put(STAGE_EXTRA, selectedStage.getExtra());
                values.put(COMPLETE, Boolean.toString(selectedStage.isComplete()));

                String id = selectedStage.getID();
                String where = String.format("%s = '%s'", STAGE_ID, id);
                String STAGE_TABLE = gameType + gameLevel;
                database.update(STAGE_TABLE, values, where, null);
                break;
            }
            case "unNormalSudoku": {
                ContentValues values = new ContentValues();
                values.put(STAGE_NAME, selectedStage.getName());
                values.put(STAGE_TYPE, selectedStage.getType());
                values.put(STAGE, selectedStage.getStage());
                values.put(STAGE_SAVE, selectedStage.getSave());
                values.put(STAGE_EXTRA, selectedStage.getExtra());
                values.put(STAGE_WIDTH, selectedStage.getWidth());
                values.put(STAGE_HEIGHT, selectedStage.getHeight());
                values.put(COMPLETE, Boolean.toString(selectedStage.isComplete()));

                String id = selectedStage.getID();
                String where = String.format("%s = '%s'", STAGE_ID, id);
                String STAGE_TABLE = gameType + gameLevel;
                database.update(STAGE_TABLE, values, where, null);
                break;
            }
            case "crossword": {
                ContentValues values = new ContentValues();
                values.put(STAGE_NAME, selectedStage.getName());
                values.put(STAGE_TYPE, selectedStage.getType());
                values.put(STAGE, selectedStage.getStage());
                values.put(STAGE_SAVE, selectedStage.getSave());
                values.put(STAGE_EXTRA, selectedStage.getExtra());
                values.put(STAGE_WIDTH, selectedStage.getWidth());
                values.put(STAGE_HEIGHT, selectedStage.getHeight());
                values.put(COMPLETE, Boolean.toString(selectedStage.isComplete()));

                String id = selectedStage.getID();
                String where = String.format("%s = '%s'", STAGE_ID, id);
                String STAGE_TABLE = gameType + gameLevel;
                database.update(STAGE_TABLE, values, where, null);
                break;
            }
        }
    }
}
