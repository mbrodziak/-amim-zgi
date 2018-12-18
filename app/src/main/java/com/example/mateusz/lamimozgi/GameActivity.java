package com.example.mateusz.lamimozgi;

public interface GameActivity {
    void setUpViews();

    void fromPuzzleString(String board, String save, String type, String mark);

    boolean check();

    void toPuzzleString();
}
