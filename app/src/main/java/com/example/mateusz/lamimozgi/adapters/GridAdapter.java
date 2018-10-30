package com.example.mateusz.lamimozgi.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mateusz.lamimozgi.R;
import com.example.mateusz.lamimozgi.items.SudokuCell;

import java.util.Objects;

public class GridAdapter extends ArrayAdapter<SudokuCell> {

    public GridAdapter(Context context, int textViewResId, SudokuCell[] cells) {
        super(context, textViewResId, cells);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return !(Objects.requireNonNull(this.getItem(position))).isInitialValue();
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        if (Objects.requireNonNull(this.getItem(position)).isInitialValue()) {
            view.setBackgroundResource(R.drawable.initial_cell_background);
        }
        if (Objects.requireNonNull(this.getItem(position)).isHighlighted()) {
            ((TextView) view).setTextColor(Color.RED);
        } else {
            ((TextView) view).setTextColor(Color.BLACK);
        }

        return view;
    }
}
