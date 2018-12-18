package com.example.mateusz.lamimozgi.items;

import android.support.annotation.NonNull;

public class SudokuCell implements Cell{
    private int value;
    private boolean isInitialValue;
    private boolean isEven;
    private boolean isHighlighted;
    private boolean isSelected;

    public SudokuCell(int val, boolean isInitial, boolean isEven) {
        this.value = val;
        this.isInitialValue = isInitial;
        this.isHighlighted = false;
        this.isEven = isEven;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = (int) value;
    }

    public boolean isInitialValue() {
        return isInitialValue;
    }

    @Override
    public boolean isEven(){
        return isEven;
    }

    @Override
    public boolean isHighlighted() {
        return isHighlighted;
    }

    @Override
    public void setHighlighted(boolean isHighlighted) {
        this.isHighlighted = isHighlighted;
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
