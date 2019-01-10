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
        if (statistic.getDifficulty()==0){
            difficulty.setText(R.string.easy);
        }else if (statistic.getDifficulty()==1){
            difficulty.setText(R.string.medium);
        }else if (statistic.getDifficulty()==2){
            difficulty.setText(R.string.hard);
        }
        if (statistic.getAmountGames()==1){
            progress.setText(String.format(Locale.US,"%d " + getContext().getString(R.string.win1) + "% d " + getContext().getString(R.string.game1), statistic.getAmountWin(), statistic.getAmountGames()));
        }else if (statistic.getAmountGames()==2 || statistic.getAmountGames()==3 || statistic.getAmountGames()==4 ){
            progress.setText(String.format(Locale.US,"%d " + getContext().getString(R.string.win2) + "% d " + getContext().getString(R.string.game2), statistic.getAmountWin(), statistic.getAmountGames()));
        }else{
            progress.setText(String.format(Locale.US,"%d " + getContext().getString(R.string.win5) + "% d " + getContext().getString(R.string.game5), statistic.getAmountWin(), statistic.getAmountGames()));
        }
    }
}