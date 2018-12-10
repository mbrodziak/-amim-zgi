package com.example.mateusz.lamimozgi.views;

import android.content.Context;
import android.util.AttributeSet;

public class CrosswordGridViewItem extends android.support.v7.widget.AppCompatTextView {

    public CrosswordGridViewItem(Context context) {
        super(context);
    }

    public CrosswordGridViewItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CrosswordGridViewItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}