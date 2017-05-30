package com.android.knowledge.fcmpushnotificationexample.FCM;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.android.knowledge.fcmpushnotificationexample.MainActivity;
import com.google.firebase.iid.FirebaseInstanceId;

import java.io.IOException;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 *
 */
public class RemoveTokenIntentService extends IntentService {

    private static final String TAG = RemoveTokenIntentService.class.getSimpleName();

    public RemoveTokenIntentService() {
        super("RemoveTokenIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
            String id = intent.getStringExtra(MainActivity.EXTRA_ID);
            String token = intent.getStringExtra(MainActivity.EXTRA_TOKEN);
            Log.d(TAG, "Action :" + action + ", Name :" + name + ", Id :" + id + ", token :" + token);
            try {
                FirebaseInstanceId.getInstance().deleteInstanceId();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "New FB id :" + FirebaseInstanceId.getInstance().getToken());
        }
    }



}
