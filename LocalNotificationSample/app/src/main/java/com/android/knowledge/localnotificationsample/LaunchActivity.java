package com.android.knowledge.localnotificationsample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LaunchActivity extends AppCompatActivity {

    private static final String TAG = LaunchActivity.class.getSimpleName();
    private static final int NOTIFICATION_ID = 500;
    public static final String KEY_EXTRA_MESSAGE = "KEY_EXTRA_MESSAGE";
    public static final String EXTRA_MESSAGE = "Message is from Activity 1";
    private static final int REQUEST_CODE = 501;

    private Notification mNotification;
    private NotificationManager mNotificationManager;

    @BindView(R.id.button)
    Button mNotificationButton;

    @BindView(R.id.editText)
    EditText mNameEditText;

    @BindView(R.id.editText3)
    EditText mCityEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    void generateNotification() {
        Log.d(TAG, "Generating Notification :" + mNameEditText.getText().toString() + "," +
                mCityEditText.getText().toString());

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(KEY_EXTRA_MESSAGE, EXTRA_MESSAGE);
        intent.setAction(KEY_EXTRA_MESSAGE);
        

        Notification.Builder builder = new Notification.Builder(this)
                .setContentTitle("Notification Title")
                .setContentText("Notification Text")
                .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(PendingIntent.getActivity(this, REQUEST_CODE, intent, 0))
                        .setAutoCancel(true);

        mNotification = builder.build();

        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(NOTIFICATION_ID, mNotification);

    }
}
