package com.example.mateusz.lamimozgi.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mateusz.lamimozgi.R;
import com.example.mateusz.lamimozgi.items.Stage;

public class StageListItem extends LinearLayout {
    private Stage stage;
    private TextView complete;
    private TextView title;

    public StageListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        complete = findViewById(R.id.tli_finished);
        title = findViewById(R.id.tli_title);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        if (stage.isComplete()){
            complete.setText(R.string.finished);
        }else{
            complete.setText(R.string.not_finished);
        }

        title.setText(stage.getName());
    }
}
