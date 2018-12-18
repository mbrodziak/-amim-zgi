package com.example.mateusz.lamimozgi.items;

import android.support.annotation.NonNull;

public class WordsSearchCell {

    private String value;
    private boolean isFound;

    public WordsSearchCell(String value, boolean isFound){
        this.value = value;
        this.isFound = isFound;
    }

    public String getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = (String) value;
    }

    public void setFound(boolean found) {
        isFound = found;
    }

    public boolean isFound() {
        return isFound;
    }

    @NonNull
    public String toString() {
        if (value.equals(" ")) {
            return "";
        } else {
            return value;
        }
    }

    public boolean compare(String word) {
        return value.equals(word);
    }
}
