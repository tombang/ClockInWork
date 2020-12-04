package com.org.tcl.clockinwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String link = "https://weixinqy.tclcom.com/MobilePage/#/WifiClockForm/state/1000018/UserId/11035684";
    private static final String test = "https://www.baidu.com";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.org.tcl.clockinwork","com.org.tcl.clockinwork.TimeListenService"));
        Log.i(TAG,"--mainactivity start--");
        startService(intent);
    }
}