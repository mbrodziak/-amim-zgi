package com.example.mateusz.lamimozgi.items;

import android.support.annotation.NonNull;

public class CrosswordCell {
    private String solution;
    private String value;
    private boolean isEven;
    private String hc = null;
    private String vc = null;
    private boolean isSelected;
    private boolean isHighlight;

    public CrosswordCell(String value, String solution, boolean isEven) {
        this.value = value;
        this.solution = solution;
        this.isEven = isEven;
        this.isHighlight = false;
        this.isSelected = false;
    }

    public boolean check(){
        if (isEven){
            return value.equals(solution);
        }else{
            return true;
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value)  {
        this.value = value;
    }

    public boolean isEven() {
        return isEven;
    }

    public boolean isHighlight() {
        return isHighlight;
    }

    public void setHighlight(boolean highlight) {
        this.isHighlight = highlight;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    @NonNull
    @Override
    public String toString() {
        if (value.equals(" ")) {
            return "";
        } else {
            return value;
        }
    }
}
