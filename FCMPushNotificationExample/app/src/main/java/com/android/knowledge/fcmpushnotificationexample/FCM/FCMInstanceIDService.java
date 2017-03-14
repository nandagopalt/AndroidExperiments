package com.android.knowledge.fcmpushnotificationexample.FCM;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Nandagopal T on 3/13/2017.
 */

public class FCMInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = FCMInstanceIDService.class.getSimpleName();

    public FCMInstanceIDService() {
        Log.d(TAG, "Constructor :: FCMInstanceIDService");
    }

    /**
     * Called, if the InstanceID token is updated. This may be called, when the previously generated token is invalid or security
     * of the previous token is been compromised. This is called, when the instanceID token is initially generated so this is where you retrieve the token
     */
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        Log.d(TAG, "START of onTokenRefersh");
        String instanceID = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "InstanceID :" + instanceID);
        Log.d(TAG, "COMPLETION of onTokenReferesh");
    }
}
