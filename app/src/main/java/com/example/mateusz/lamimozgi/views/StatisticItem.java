package com.example.mateusz.lamimozgi.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mateusz.lamimozgi.R;
import com.example.mateusz.lamimozgi.items.Statistic;

import java.util.Locale;

public class StatisticItem extends LinearLayout {
    private TextView progress;
    private TextView difficulty;

    public StatisticItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        difficulty = findViewById(R.id.si_difficulty);
        progress = findViewById(R.id.si_progress);
    }

    public void setStatistic(Statistic statistic){
        difficulty.setText(statistic.getDifficulty());
        difficulty.setText(String.format(Locale.US,"%d/%d", statistic.getAmountWin(), statistic.getAmountGames()));
    }
}
