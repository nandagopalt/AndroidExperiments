package com.android.knowledge.launchmodesandroidexampleimplementation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = FirstActivity.class.getSimpleName();
    public static final String ACTION = "com.android.knowledge.launchMode";
    public static final String MESSAGE = "key_message";

    private BroadcastReceiver mBroadcastReceiver;
    private IntentFilter mIntentFilter;

    @BindView(R.id.button01)
    Button activityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "START of onCreate method.....");
        Log.d(TAG, "COMPLETION of onCreate method.....");
        setContentView(R.layout.activity_first);

        mIntentFilter = new IntentFilter(ACTION);
        mBroadcastReceiver = new FirstBroadcastReciever();
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcastReceiver, mIntentFilter);
        LocalBroadcastManager.getInstance(this).registerReceiver(new LocalBroadcastReceiver(), mIntentFilter);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button01)
    public void startActivity() {
        Log.d(TAG, "START of startActivity method.....");
        Intent intent = new Intent();
        intent.setAction(FirstActivity.ACTION);
        intent.putExtra(MESSAGE, "This is the message from Activity");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        Log.d(TAG, "COMPLETION of startActivity method......");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcastReceiver);
    }

    private class LocalBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "I am here in activity");
        }
    }

}
