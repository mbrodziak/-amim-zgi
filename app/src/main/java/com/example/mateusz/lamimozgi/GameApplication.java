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
import static com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper.STAGE_ID;
import static com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper.STAGE_NAME;
import static com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper.STAGE_SAVE;
import static com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper.STAGE_TYPE;

public class GameApplication extends Application {
    public String gameType;
    public int gameLevel;
    public int volumeMusic;
    public Stage selectedStage;
    private ArrayList<Stage> currentStages;
    private ArrayList<String> currentStagesId;
    private SQLiteDatabase database;

    public void onCreate() {
        super.onCreate();
        GameSQLiteOpenHelper helper = new GameSQLiteOpenHelper(this);
        database = helper.getWritableDatabase();
    }

    public void gameStart() {
        if (gameType.equals("normalSudoku")){
            Intent intent = new Intent(getApplicationContext(), SudokuActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else if(gameType.equals("unNormalSudoku")){
            Intent intent = new Intent(getApplicationContext(), SudokuUnActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
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
        currentStagesId = new ArrayList<>();
        Cursor tasksCursor;
        String STAGE_TABLE = gameType + gameLevel;
        tasksCursor = database.rawQuery("select * from " + STAGE_TABLE, null);
        Stage s;
        tasksCursor.moveToFirst();
        if (! tasksCursor.isAfterLast()) {
            if (gameType.equals("normalSudoku")){
                do {
                    String stage_id = tasksCursor.getString(0);
                    String name = tasksCursor.getString(1);
                    String stage = tasksCursor.getString(2);
                    String save = tasksCursor.getString(3);
                    String extra = tasksCursor.getString(4);
                    String boolValue = tasksCursor.getString(5);
                    boolean complete = Boolean.parseBoolean(boolValue);
                    s = new Stage(name, stage, complete);
                    s.setID(stage_id);
                    s.setSave(save);
                    s.setExtra(extra);
                    currentStages.add(s);
                    currentStagesId.add(stage_id);
                } while(tasksCursor.moveToNext());
            }else if (gameType.equals("unNormalSudoku")){
                do {
                    String stage_id = tasksCursor.getString(0);
                    String name = tasksCursor.getString(1);
                    String stage = tasksCursor.getString(3);
                    String save = tasksCursor.getString(4);
                    String extra = tasksCursor.getString(5);
                    String type = tasksCursor.getString(2);
                    String boolValue = tasksCursor.getString(6);
                    boolean complete = Boolean.parseBoolean(boolValue);
                    s = new Stage(name, stage, type, complete);
                    s.setID(stage_id);
                    s.setSave(save);
                    s.setExtra(extra);
                    currentStages.add(s);
                    currentStagesId.add(stage_id);
                } while(tasksCursor.moveToNext());
            }
        }
        tasksCursor.close();
    }

    public ArrayList<Stage> getCurrentStages() {
        return currentStages;
    }

    public void saveStage() {
        assert (null != selectedStage);
        if (gameType.equals("normalSudoku")){
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
        }else if (gameType.equals("unNormalSudoku")){
            ContentValues values = new ContentValues();
            values.put(STAGE_NAME, selectedStage.getName());
            values.put(STAGE_TYPE, selectedStage.getType());
            values.put(STAGE, selectedStage.getStage());
            values.put(STAGE_SAVE, selectedStage.getSave());
            values.put(STAGE_EXTRA, selectedStage.getExtra());
            values.put(COMPLETE, Boolean.toString(selectedStage.isComplete()));

            String id = selectedStage.getID();
            String where = String.format("%s = '%s'", STAGE_ID, id);
            String STAGE_TABLE = gameType + gameLevel;
            database.update(STAGE_TABLE, values, where, null);
        }
    }
}
