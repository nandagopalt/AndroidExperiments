package com.android.knowledge.fcmpushnotificationexample;

import android.app.Application;
import android.util.Log;

import com.google.firebase.FirebaseApp;

/**
 * Created by Nandagopal T on 3/13/2017.
 */

public class FCMApplication extends Application {
    private static final String TAG = FCMApplication.class.getSimpleName();

    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     * Implementations should be as quick as possible (for example using
     * lazy initialization of state) since the time spent in this function
     * directly impacts the performance of starting the first activity,
     * service, or receiver in a process.
     * If you override this method, be sure to call super.onCreate().
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "START of onCreate");
        FirebaseApp.initializeApp(this);
        Log.d(TAG, "COMPLETION of onCreate");
    }
}
