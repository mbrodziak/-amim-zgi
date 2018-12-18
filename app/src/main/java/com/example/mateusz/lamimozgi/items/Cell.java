package com.example.mateusz.lamimozgi.items;

import android.support.annotation.NonNull;

public interface Cell {

    Object getValue();

    void setValue(Object value);

    boolean isEven();

    boolean isHighlighted();

    void setHighlighted(boolean highlight);

    boolean isSelected();

    void setSelected(boolean selected);

    @NonNull
    String toString();
}
