package com.liucheng.android.guessnumber;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GuessNumberActivity extends AppCompatActivity {

    private EditText edtNumber;
    private TextView txvHint;
    private int rightNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_number);
        edtNumber = (EditText)findViewById(R.id.edtNumber);
        txvHint = (TextView)findViewById(R.id.txvHint);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void clickButton(View view){
        switch(view.getId()){
            case R.id.bunGuess:
                if (rightNumber > 0){
                    if (edtNumber.getText().toString().isEmpty()){
                        txvHint.setText(R.string.input);
                        txvHint.setTextColor(Color.parseColor("#FF0000"));
                    }else {
                        int number;
                        number = Integer.parseInt(edtNumber.getText().toString());
                        if(number > rightNumber){
                            String string = this.getString(R.string.big);
                            txvHint.setText(number + string);
                            txvHint.setTextColor(Color.parseColor("#FF0000"));
                        }
                        else if(number < rightNumber){
                            String string = this.getString(R.string.small);
                            txvHint.setText(number + string);
                            txvHint.setTextColor(Color.parseColor("#FF0000"));
                        }
                        else{
                            txvHint.setText(R.string.right);
                            txvHint.setTextColor(Color.parseColor("#00FF00"));
                        }
                    }
                }else {
                    txvHint.setText(R.string.create);
                    txvHint.setTextColor(Color.parseColor("#FF0000"));
                }
                break;
            case R.id.bunCreate:
                rightNumber = (int) (Math.random() * 100 + 1);
                txvHint.setText(R.string.success);
                txvHint.setTextColor(Color.parseColor("#0000FF"));
                break;
            case R.id.bunShowAnswer:
                if (rightNumber > 0){
                    Intent i = ShowAnswerActivity.newIntent(GuessNumberActivity.this, rightNumber);
                    startActivity(i);
                }else {
                    txvHint.setText(R.string.create);
                    txvHint.setTextColor(Color.parseColor("#FF0000"));
                }
                break;
        }
    }
}
