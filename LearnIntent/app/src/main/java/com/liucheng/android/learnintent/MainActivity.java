package com.liucheng.android.learnintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    public static final String MYACTION = "com.liucheng.ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickButton(View view){
        switch (view.getId()){
            case R.id.btnStartExplicit:
                Intent explicitIntent = new Intent(this, IntentActivity.class);
                startActivity(explicitIntent);
                break;
            case R.id.btnStartImplicit:
                Intent implicitIntent = new Intent();
                implicitIntent.setAction(MYACTION);
                if (implicitIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(implicitIntent);
                }
                break;
            case R.id.btnDial:
                Intent dialIntent = new Intent();
                dialIntent.setAction(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("Tel:12345678901"));
                startActivity(dialIntent);

                break;
//            case R.id.btnSMS:
//                Intent smsIntent = new Intent();
//                smsIntent.setAction(Intent.ACTION_SENDTO);
//                smsIntent.setData(Uri.parse("smsto:123"));
//                smsIntent.putExtra("sms_body","hello");
//                startActivity(smsIntent);
//                break;
        }
    }
}
