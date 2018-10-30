package com.example.mateusz.lamimozgi.items;

import android.support.annotation.NonNull;

public class SudokuCell {
    private int value;
    private final boolean isInitialValue;
    private boolean isHighlighted;

    public SudokuCell(int val, boolean isInitial) {
        this.value = val;
        this.isInitialValue = isInitial;
        this.isHighlighted = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isInitialValue() {
        return isInitialValue;
    }

    public boolean isHighlighted() {
        return isHighlighted;
    }

    public void setHighlighted(boolean isHighlighted) {
        this.isHighlighted = isHighlighted;
    }

    @NonNull
    @Override
    public String toString() {
        if (value == 0) {
            return "";
        } else {
            return String.valueOf(value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuCell that = (SudokuCell) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
