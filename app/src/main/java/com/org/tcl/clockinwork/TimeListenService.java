package com.org.tcl.clockinwork;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

public class TimeListenService extends Service {
    private static final String TAG = "TimeListenService";
    Context mContext;
    private boolean istest = true;
    private static final String test = "https://www.baidu.com";
    public TimeListenService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"+ oncreate +");
        mContext = this;
        final Uri uri = Uri.parse(test);
        Intent mIntent = new Intent(Intent.ACTION_VIEW, uri);
        mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mIntent);
        //mContext.registerReceiver(dataChangeBroadcast, new IntentFilter(Intent.ACTION_TIME_TICK));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //mContext.unregisterReceiver(dataChangeBroadcast);
    }

    private BroadcastReceiver dataChangeBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case Intent.ACTION_TIME_TICK:
                    while (istest) {
                        final Uri uri = Uri.parse(test);
                        Intent mIntent = new Intent(Intent.ACTION_VIEW, uri);
//                        ComponentName componentName = new ComponentName("com.org.tcl.clockinwork","com.org.tcl.clockinwork.MainActivity");
//                        mIntent.setComponent(componentName);
                        startActivity(mIntent);
                        istest = false;
                        break;
                    }

            }
        }
    };
}
