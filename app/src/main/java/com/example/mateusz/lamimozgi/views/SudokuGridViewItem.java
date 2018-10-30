package com.example.mateusz.lamimozgi.views;

import android.content.Context;
import android.util.AttributeSet;

public class SudokuGridViewItem extends android.support.v7.widget.AppCompatTextView {

    public SudokuGridViewItem(Context context) {
        super(context);
    }

    public SudokuGridViewItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SudokuGridViewItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}