package com.android.knowledge.fcmpushnotificationexample;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.knowledge.fcmpushnotificationexample.FCM.RemoveTokenIntentService;
import com.google.firebase.iid.FirebaseInstanceId;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


   ;
    private Button mButton1, mButton2, mButton3, mButton4, mButton5;

    private static final String TAG = MainActivity.class.getSimpleName();

    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_ID = "EXTRA_ID";
    public static final String EXTRA_TOKEN = "EXTRA_TOKEN";
    public static final String ACTION_FCM_TOKEN_REMOVAL_CODE = "com.android.knowledge.fcmpushnotificationexample.FCM.remove.token";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "START of onCreate");
        setContentView(R.layout.activity_main);

        // FCM registeration key
        String registerationKey = FirebaseInstanceId.getInstance().getToken();
        String instanceId = FirebaseInstanceId.getInstance().getId();

        Log.d(TAG, "Key :" + registerationKey + "," + "id :" + instanceId);

        mButton1 = (Button) findViewById(R.id.button2);
        mButton2 = (Button) findViewById(R.id.button3);
        mButton3 = (Button) findViewById(R.id.button4);
        mButton4 = (Button) findViewById(R.id.button5);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, FirebaseInstanceId.getInstance().getToken(), Toast.LENGTH_LONG).show();
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, FirebaseInstanceId.getInstance().getId(), Toast.LENGTH_LONG).show();
            }
        });

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Removal of access token", Toast.LENGTH_LONG).show();
                Intent removeAccessTokenIntent = new Intent(MainActivity.this, RemoveTokenIntentService.class);
                removeAccessTokenIntent.setAction(ACTION_FCM_TOKEN_REMOVAL_CODE);
                removeAccessTokenIntent.putExtra(EXTRA_NAME, "Vinayak");
                removeAccessTokenIntent.putExtra(EXTRA_ID, FirebaseInstanceId.getInstance().getId());
                removeAccessTokenIntent.putExtra(EXTRA_TOKEN, FirebaseInstanceId.getInstance().getToken());
                startService(removeAccessTokenIntent);
            }
        });

        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FirebaseInstanceId.getInstance().deleteInstanceId();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


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
