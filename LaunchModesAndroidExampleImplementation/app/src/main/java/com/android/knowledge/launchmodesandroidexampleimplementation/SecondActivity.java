package com.android.knowledge.launchmodesandroidexampleimplementation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();
    public static final String ACTION = "com.android.knowledge.launchMode";
    public static final String MESSAGE = "key_message";

    private LocalBroadcastManager mLocalBroadcastManager;
    //private IntentFilter

    @BindView(R.id.button01)
    Button activityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "START of onCreate method.....");
        Log.d(TAG, "COMPLETION of onCreate method.....");
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button01)
    public void startActivity() {
        Log.d(TAG, "START of startActivity method.....");
        Intent intent = new Intent(this, SecondActivity.class);
        intent.setAction(SecondActivity.ACTION);
        intent.putExtra(MESSAGE, "This is the message from Activity");
        sendBroadcast(intent);
        Log.d(TAG, "COMPLETION of startActivity method......");
    }

}
