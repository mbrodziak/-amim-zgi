package com.example.mateusz.lamimozgi.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mateusz.lamimozgi.R;
import com.example.mateusz.lamimozgi.items.WordSearchCell;

import java.util.Objects;

public class WordSearchGridAdapter extends ArrayAdapter<WordSearchCell> {

    public WordSearchGridAdapter(Context context, int textViewResId, WordSearchCell[] cells) {
        super(context, textViewResId, cells);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return (Objects.requireNonNull(this.getItem(position))).isEven();
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        if (Objects.requireNonNull(this.getItem(position)).isSelected()){
            view.setBackgroundResource(R.drawable.selected_cell_background);
            ((TextView) view).setTextAppearance(R.style.textStyle);
        }else if (Objects.requireNonNull(this.getItem(position)).isHighlighted()){
            view.setBackgroundResource(R.drawable.highlight_cell_background);
            ((TextView) view).setTextAppearance(R.style.textStyle);
        }else if (Objects.requireNonNull(this.getItem(position)).isEven()){
            view.setBackgroundResource(R.drawable.even_cell_background);
            ((TextView) view).setTextAppearance(R.style.textStyle);
        }
        return view;
    }
}
