package com.example.mateusz.lamimozgi.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class GameSQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper{
    private static final String DB_NAME = "tasks_db.sqllite";
    private static final int VERSION = 1;
    public static final String STAGE_ID = "ID";
    public static final String STAGE_NAME = "name";
    public static final String STAGE = "stage";
    public static final String COMPLETE = "complete";
    public static final String STAGE_SAVE = "save";
    public static final String STAGE_EXTRA = "extra";
    public static final String STAGE_TYPE = "type";
    public static final String STAGE_WIDTH = "width";
    public static final String STAGE_HEIGHT = "height";

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
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table normalSudoku1 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table normalSudoku2 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table unNormalSudoku0 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table unNormalSudoku1 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table unNormalSudoku2 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table crossword0 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                STAGE_HEIGHT + " integer, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table crossword1 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                STAGE_HEIGHT + " integer, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table crossword2 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                STAGE_HEIGHT + " integer, " +
                COMPLETE + " text " +
                ")");


        db.execSQL("insert into normalSudoku0 (ID, name, stage, save, extra, complete) VALUES ('200','Simple 1', '080020673307105200024073010602010408108006052700842090410208007050760900076400581','000000000000000000000000000000000000000000000000000000000000000000000000000000000','000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into normalSudoku1 (ID, name, stage, save, extra, complete) VALUES ('200','Medium 1', '000100300504030000000200098740980230100020004062045019250007000000090105009002000','000000000000000000000000000000000000000000000000000000000000000000000000000000000','000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into normalSudoku2 (ID, name, stage, save, extra, complete) VALUES ('200','Hard 1', '000000025003900004010560900070600540000000000032005060006078090800001200240000000','000000000000000000000000000000000000000000000000000000000000000000000000000000000','000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into normalSudoku0 (ID, name, stage, save, extra, complete) VALUES ('300','Simple 2', '073650001080070009050001002000000060012058003000000070070006010008007020000169400','000000000000000000000000000000000000000000000000000000000000000000000000000000000','000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into normalSudoku1 (ID, name, stage, save, extra, complete) VALUES ('300','Medium 2', '000052096020097001000400007260000150300000002057000043400006000700940020930570000','000000000000000000000000000000000000000000000000000000000000000000000000000000000','000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into normalSudoku2 (ID, name, stage, save, extra, complete) VALUES ('300','Hard 2', '006027000150030000400000007080100040500704009070008010200000006000080034000970100','000000000000000000000000000000000000000000000000000000000000000000000000000000000','000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into normalSudoku0 (ID, name, stage, save, extra, complete) VALUES ('400','Simple 3', '048005007300000406002700000003606000200000001000501300000003100140400000880060200','000000000000000000000000000000000000000000000000000000000000000000000000000000000','000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into normalSudoku1 (ID, name, stage, save, extra, complete) VALUES ('400','Medium 3', '200300046006005100450000070207000100002000080040030600000805002800600180004002050','000000000000000000000000000000000000000000000000000000000000000000000000000000000','000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into normalSudoku2 (ID, name, stage, save, extra, complete) VALUES ('400','Hard 3', '007450300500008000090027501040000900900000003005000040206870030000600005003019200','000000000000000000000000000000000000000000000000000000000000000000000000000000000','000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into unNormalSudoku0 (ID, name, type, stage, save, extra, width, complete) VALUES ('200','6x6 1', '000111000111222333222333444555444555','216000300261000315531420620004004632','000000000000000000000000000000000000','000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into unNormalSudoku0 (ID, name, type, stage, save, extra, width, complete) VALUES ('300','6x6 2', '000111000111222333222333444555444555','050001004600400050100004043000060240','000000000000000000000000000000000000','000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into unNormalSudoku0 (ID, name, type, stage, save, extra, width, complete) VALUES ('400','6x6 3', '000111000111222333222333444555444555','504000600035120000000600001003403062','000000000000000000000000000000000000','000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into unNormalSudoku1 (ID, name, type, stage, save, extra, width, complete) VALUES ('200','6x6 1', '000111000111222333222333444555444555','030605040000300000000360505006000501','000000000000000000000000000000000000','000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into unNormalSudoku1 (ID, name, type, stage, save, extra, width, complete) VALUES ('300','6x6 2', '000111000111222333222333444555444555','102000000030060200000403050004400601','000000000000000000000000000000000000','000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into unNormalSudoku1 (ID, name, type, stage, save, extra, width, complete) VALUES ('400','6x6 3', '000111000111222333222333444555444555','000013102000006500200301000006050030','000000000000000000000000000000000000','000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into unNormalSudoku2 (ID, name, type, stage, save, extra, width, complete) VALUES ('200','6x6 1', '000111000111222333222333444555444555','506000000020060000000501004000000103','000000000000000000000000000000000000','000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into unNormalSudoku2 (ID, name, type, stage, save, extra, width, complete) VALUES ('300','6x6 2', '000111000111222333222333444555444555','006040000500030001400003004010000600','000000000000000000000000000000000000','000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into unNormalSudoku2 (ID, name, type, stage, save, extra, width, complete) VALUES ('400','6x6 3', '000111000111222333222333444555444555','106000000003000500053020000260010000','000000000000000000000000000000000000','000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into crossword0 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('200','CROSS&DOWN 1', " +
                "'-----.------.-.---.-.------.------.-.---.-.------.------.....-.-.-.---------.-.-.-.....------.------.-.---.-.------.------.-.---.-.------.-----'," +
                "'URLOP.POMOCC.A.LEE.I.HZAMKI.LEGARO.U.SKI.L.ZNISZA.KRATAA.....A.N.N.BRATANICA.O.E.R.....SDYCHA.DEDALS.I.MAZ.E.EKOTEW.WYSYPO.A.ALI.E.IKULEJ.GORCE'," +
                "'-----.------.-.---.-.------.------.-.---.-.------.------.....-.-.-.---------.-.-.-.....------.------.-.---.-.------.------.-.---.-.------.-----'," +
                "'H;0;5;Tacierzyński/H;6;10;Pierwsza - udzielana ofierze wypadku/H;15;17;Marka spodni dżinsowych/H;22;26;Na lodzie lepiej ich nie budować/H;28;32;Gruba belka podłogowa/H;37;39;Daw. narty/H;44;48;Wnęka w murze/H;50;54;Zabezpieczenie okna/H;67;75;Dawniej nazywana synowicą/H;88;92;W gwarze miejskiej dziesięciozłotówka/H;94;98;Uciekał z synem z Krety/H;103;105;Gęsta, kleista substancja/H;110;114;Łączy maszynę z fundamentem/H;116;120;Urodzaj grzybów/H;125;127;... Baba, drwal z arabskiej baśni/H;132;136;Jerzy (zm. 2012), słynny bokser/H;138;142;Pasmo górskie ze szczytem Turbacz/V;0;55;Kobieta naukowiec/V;2;46;Zbiór niepotrzebnych staroci/V;4;48;Fałda na koszuli/V;6;72;Ptak pływający z workiem u dzioba/V;8;74;Pot. nierób, cwaniak/V;10;65;Niezbędny do ćwikły/V;68;134;Solowy koncert Krzysztofa Krawczyka/V;70;136;Prowadzi go motorniczy/V;77;132;Uzyskanie dystansu/V;87;142;Oko wilka/V;94;138;Kran w porcie/V;96;140;Lody po obiedzie ',11,13,'false');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
