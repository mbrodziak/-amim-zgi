package com.example.mateusz.lamimozgi.items;

import android.support.annotation.NonNull;

public class WordSearchCell implements Cell {
    private boolean isEven;
    private boolean isHighlighted;
    private boolean isSelected;
    private int numberOfWords;
    private String value;
    private boolean isWrong;

    public WordSearchCell(String value, int nOW, boolean isHighlighted) {
        this.value = value;
        this.numberOfWords = nOW;
        this.isEven = true;
        this.isHighlighted = isHighlighted;
        this.isSelected = false;
    }

    @Override
    public String getValue() {
        return value;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    @Override
    public void setValue(Object value) {
        this.value = (String) value;
    }

    @Override
    public boolean isEven() {
        return isEven;
    }

    @Override
    public boolean isHighlighted() {
        return isHighlighted;
    }

    @Override
    public void setHighlighted(boolean highlight) {
        this.isHighlighted = highlight;
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    @NonNull
    public String toString() {
        if (value.equals(" ")) {
            return "";
        } else {
            return value;
        }
    }

    public boolean isWrong() {
        return isWrong;
    }

    public void setWrong(boolean wrong) {
        isWrong = wrong;
    }
}
