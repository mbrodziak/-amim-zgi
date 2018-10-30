package com.example.mateusz.lamimozgi;

import android.app.Application;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mateusz.lamimozgi.helpers.GameSQLiteOpenHelper;
import com.example.mateusz.lamimozgi.items.Stage;

import java.util.ArrayList;

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
            do {
                String stage_id = tasksCursor.getString(0);
                String name = tasksCursor.getString(1);
                String stage = tasksCursor.getString(2);
                String boolValue = tasksCursor.getString(3);
                boolean complete = Boolean.parseBoolean(boolValue);
                s = new Stage(name, stage, complete);
                s.setID(stage_id);
                currentStages.add(s);
                currentStagesId.add(stage_id);
            } while(tasksCursor.moveToNext());
        }
        tasksCursor.close();
    }

    public ArrayList<Stage> getCurrentStages() {
        return currentStages;
    }

    public void saveStage() {

    }
}
