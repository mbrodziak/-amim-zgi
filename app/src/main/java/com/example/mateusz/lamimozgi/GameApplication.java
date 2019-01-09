package com.example.mateusz.lamimozgi;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;

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
    public float volumeMusic = (float) 0.5;
    public Stage selectedStage;
    public float volumeSound = (float) 0.5;
    private ArrayList<Stage> currentStages;
    private SQLiteDatabase database;
    private MediaPlayer soundPlayer;
    private MediaPlayer musicPlayer;
    private int CurrentMusic = -1;
    private Context context;
    private int GameMusic;
    private GameSQLiteOpenHelper helper;

    @Override
    public void onCreate() {
        super.onCreate();
        helper = new GameSQLiteOpenHelper(this);
        database = helper.getWritableDatabase();
        context = getApplicationContext();
        playMusic();
    }

    private void playMusic() {
        if (CurrentMusic == 0){
            musicPlayer = MediaPlayer.create(context, R.raw.black_gloves);
            CurrentMusic += 1;
        }else if (CurrentMusic == 1){
            musicPlayer = MediaPlayer.create(context, R.raw.driven_to_success);
            CurrentMusic += 1;
        }else if (CurrentMusic == 2){
            musicPlayer = MediaPlayer.create(context, R.raw.epic_song);
            CurrentMusic += 1;
        }else if (CurrentMusic == 3){
            musicPlayer = MediaPlayer.create(context, R.raw.martina_and_the_air_plan);
            CurrentMusic += 1;
        }else if (CurrentMusic == 4){
            musicPlayer = MediaPlayer.create(context, R.raw.mt_fox_shop);
            CurrentMusic += 1;
        }else if (CurrentMusic == 5){
            musicPlayer = MediaPlayer.create(context, R.raw.rolling);
            CurrentMusic += 1;
        }else if (CurrentMusic == 6){
            musicPlayer = MediaPlayer.create(context, R.raw.running_with_wise_fools);
            CurrentMusic += 1;
        }else if (CurrentMusic == 7){
            musicPlayer = MediaPlayer.create(context, R.raw.upbeat);
            CurrentMusic += 1;
        }else if (CurrentMusic == 8){
            musicPlayer = MediaPlayer.create(context, R.raw.wonderland_instrumental);
            CurrentMusic = 0;
        }else if (CurrentMusic == -1){
            musicPlayer = MediaPlayer.create(context, R.raw.seeing_the_future);
        }
        musicPlayer.setVolume(volumeMusic,volumeMusic);
        musicPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playMusic();
            }
        });
        musicPlayer.start();
    }

    public void gameStart() {
        musicPlayer.release();
        CurrentMusic = GameMusic;
        playMusic();
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
            case "wordSearch": {
                Intent intent = new Intent(getApplicationContext(), WordSearchActivity.class);
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
            case "guessWork": {
                Intent intent = new Intent(getApplicationContext(), GuessWorkActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            }
            case "hangman": {
                Intent intent = new Intent(getApplicationContext(), HangmanActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            }
        }
    }

    public void resetAllGames() {
        helper.dropTable(database);
        helper.createTable(database);
    }

    public void resetGame(String game) {
        switch (game) {
            case "sudoku": {
                helper.dropTableSudoku(database);
                helper.createTableSudoku(database);
            }
            case "wordSearch": {
                helper.dropTableWordSearch(database);
                helper.createTableWordSearch(database);
            }
            case "crossword": {
                helper.dropTableCrossword(database);
                helper.createTableCrossword(database);
            }
            case "guessWork": {
                helper.dropTableGuessWork(database);
                helper.createTableGuessWork(database);
            }
            case "hangman": {
                helper.dropTableHangman(database);
                helper.createTableHangman(database);
            }
        }
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
            case "wordSearch":
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
            case "guessWork":
                do {
                    String stage_id = tasksCursor.getString(0);
                    String name = tasksCursor.getString(1);
                    String stage = tasksCursor.getString(2);
                    String save = tasksCursor.getString(3);
                    String extra = tasksCursor.getString(4);
                    String boolValue = tasksCursor.getString(5);
                    boolean complete = Boolean.parseBoolean(boolValue);
                    s = new Stage(name, stage, 0, 0, "", complete);
                    s.setID(stage_id);
                    s.setSave(save);
                    s.setExtra(extra);
                    currentStages.add(s);
                } while (tasksCursor.moveToNext());
                break;
            case "hangman":
                do {
                    String stage_id = tasksCursor.getString(0);
                    String name = tasksCursor.getString(1);
                    String stage = tasksCursor.getString(3);
                    String save = tasksCursor.getString(4);
                    String extra = tasksCursor.getString(5);
                    String type = tasksCursor.getString(2);
                    String boolValue = tasksCursor.getString(6);
                    boolean complete = Boolean.parseBoolean(boolValue);
                    s = new Stage(name, stage, 0, 0, type, complete);
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
                values.put(COMPLETE, Boolean.toString(selectedStage.isComplete()));

                String id = selectedStage.getID();
                String where = String.format("%s = '%s'", STAGE_ID, id);
                String STAGE_TABLE = gameType + gameLevel;
                database.update(STAGE_TABLE, values, where, null);
                break;
            }
            case "wordSearch": {
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
            case "guessWork": {
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
            case "hangman": {
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
                break;
            }
        }
        musicPlayer.release();
        GameMusic = CurrentMusic;
        CurrentMusic = -1;
        playMusic();
    }

    public void clickSound() {
        soundPlayer = MediaPlayer.create(context,R.raw.click);
        soundPlayer.setVolume(volumeSound,volumeSound);
        soundPlayer.start();
    }

    public void loserSound(){
        soundPlayer = MediaPlayer.create(context,R.raw.loser);
        soundPlayer.setVolume(volumeSound,volumeSound);
        soundPlayer.start();
    }

    public void notGoodSound(){
        soundPlayer = MediaPlayer.create(context,R.raw.not_good);
        soundPlayer.setVolume(volumeSound,volumeSound);
        soundPlayer.start();
    }

    public void selectionSound() {
        soundPlayer = MediaPlayer.create(context,R.raw.selection);
        soundPlayer.setVolume(volumeSound,volumeSound);
        soundPlayer.start();
    }

    public void winnerSound(){
        soundPlayer = MediaPlayer.create(context,R.raw.winner);
        soundPlayer.setVolume(volumeSound,volumeSound);
        soundPlayer.start();
    }

    public void writingSound(){
        soundPlayer = MediaPlayer.create(context,R.raw.writing);
        soundPlayer.setVolume(volumeSound,volumeSound);
        soundPlayer.start();
    }

    public void setMusicVolume() {
        musicPlayer.setVolume(volumeMusic,volumeMusic);
    }
}
