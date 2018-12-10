package com.example.mateusz.lamimozgi.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mateusz.lamimozgi.R;
import com.example.mateusz.lamimozgi.items.SudokuCell;

import java.util.Objects;

public class SudokuGridAdapter extends ArrayAdapter<SudokuCell> {

    public SudokuGridAdapter(Context context, int textViewResId, SudokuCell[] cells) {
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

        if (Objects.requireNonNull(this.getItem(position)).isEven()){
            view.setBackgroundResource(R.drawable.even_cell_background);
            ((TextView) view).setTextAppearance(R.style.textStyle);
        }
        if (!Objects.requireNonNull(this.getItem(position)).isEven()){
            view.setBackgroundResource(R.drawable.odd_cell_background);
            ((TextView) view).setTextAppearance(R.style.textStyle);
        }
        if (Objects.requireNonNull(this.getItem(position)).isHighlighted()) {
            ((TextView) view).setTextColor(Color.parseColor("#CF1020"));
        } else {
            ((TextView) view).setTextColor(Color.parseColor("#ffffff"));
        }if (Objects.requireNonNull(this.getItem(position)).isInitialValue()){
            ((TextView) view).setTextColor(Color.parseColor("#00DA00"));
        }

        return view;
    }
}
