package com.android.knowledge.launchmodesandroidexampleimplementation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

/**
 * Created by M1034567 on 4/7/2017.
 */

public class FirstBroadcastReciever extends BroadcastReceiver {

    private static final String TAG = FirstBroadcastReciever.class.getSimpleName();


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "START of onReceive method.....");
        String action;
        if(null != intent) {
            action = intent.getAction();
            if(null != action && action.equalsIgnoreCase(FirstActivity.ACTION)) {
                Log.d(TAG, "Broadcast receiver caputured the ACTION :" + intent.getAction() + " Message from intent :" + intent.getStringExtra(FirstActivity.MESSAGE));
            }
            Intent i = new Intent(intent.getAction());
            context.sendBroadcast(i);
            Log.d(TAG, "COMPLETION of onReceive method.....");
        }
    }
}
