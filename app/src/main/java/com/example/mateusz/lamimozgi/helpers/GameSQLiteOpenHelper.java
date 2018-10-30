package com.example.mateusz.lamimozgi.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class GameSQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper{
    private static final String DB_NAME = "tasks_db.sqllite";
    private static final int VERSION = 1;
    private static final String STAGE_ID = "ID";
    private static final String STAGE_NAME = "name";
    private static final String STAGE = "stage";
    private static final String COMPLETE = "complete";

    public GameSQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    private void createTable(SQLiteDatabase db) {
        db.execSQL("create table normalSudoku0 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table normalSudoku1 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table normalSudoku2 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("insert into normalSudoku0 (ID, name, stage, complete) VALUES ('200','Simple 1', '080020673307105200024073010602010408108006052700842090410208007050760900076400581','false');");
        db.execSQL("insert into normalSudoku1 (ID, name, stage, complete) VALUES ('200','Medium 1', '000100300504030000000200098740980230100020004062045019250007000000090105009002000','false');");
        db.execSQL("insert into normalSudoku2 (ID, name, stage, complete) VALUES ('200','Hard 1', '000000025003900004010560900070600540000000000032005060006078090800001200240000000','false');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
