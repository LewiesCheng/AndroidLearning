package com.liucheng.android.guessnumber;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowAnswerActivity extends AppCompatActivity {

    private static final String EXTER_ANSWER = "com.liucheng.android.guessnumber.answer";
    private int mAnswer;
    private TextView mTextViewAnswer;

    public static Intent newIntent(Context packageContent, int answer){
        Intent i = new Intent(packageContent, ShowAnswerActivity.class);
        i.putExtra(EXTER_ANSWER, answer);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_answer);
        mAnswer = getIntent().getIntExtra(EXTER_ANSWER, 0);
        mTextViewAnswer = (TextView)findViewById(R.id.txvAnswer);
    }

    public void clickButton(View view){
        switch (view.getId()){
            case R.id.bunYes:
                String string = this.getString(R.string.answer);
                mTextViewAnswer.setText(string+ mAnswer);
                mTextViewAnswer.setTextColor(Color.parseColor("#00FF00"));
                break;
            case R.id.bunNo:
                finish();
        }
    }
}
