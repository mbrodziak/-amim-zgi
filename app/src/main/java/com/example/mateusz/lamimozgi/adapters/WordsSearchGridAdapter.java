package com.example.mateusz.lamimozgi.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mateusz.lamimozgi.R;
import com.example.mateusz.lamimozgi.items.WordsSearchCell;

import java.util.Objects;

public class WordsSearchGridAdapter extends ArrayAdapter<WordsSearchCell> {

    public WordsSearchGridAdapter(Context context, int textViewResId, WordsSearchCell[] cells) {
        super(context, textViewResId, cells);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        if (Objects.requireNonNull(this.getItem(position)).isFound()){
            view.setBackgroundResource(R.drawable.zero_cell_background);
            ((TextView) view).setTextAppearance(R.style.textStyle);
            ((TextView) view).setTextColor(Color.parseColor("#808080"));
        }else {
            view.setBackgroundResource(R.drawable.zero_cell_background);
            ((TextView) view).setTextAppearance(R.style.textStyle);
        }
        return view;
    }
}
