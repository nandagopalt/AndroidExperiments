package com.android.knowledge.fcmpushnotificationexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "START of onCreate");
        setContentView(R.layout.activity_main);

        /**
         * Get the bundle to query the custome data from the notification
         */
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            for (String key : bundle.keySet()) {
                Object value = bundle.get(key);
                Log.d(TAG, "Key " + key + "," + "Value :" + value.toString());
            }
        }

        Log.d(TAG, "COMPLETION of onCreate");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "START of onNewIntent");
        /**
         * Get the bundle to query the custome data from the notification
         */
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            for (String key : bundle.keySet()) {
                String value = bundle.getString(key);
                Log.d(TAG, "Key " + key + "," + "Value :" + value);
            }
        }
        Log.d(TAG, "COMPLETION of onNewIntent");
    }
}
