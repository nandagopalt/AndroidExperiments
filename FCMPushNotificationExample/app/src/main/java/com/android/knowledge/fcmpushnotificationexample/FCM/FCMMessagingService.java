package com.android.knowledge.fcmpushnotificationexample.FCM;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import com.android.knowledge.fcmpushnotificationexample.MainActivity;
import com.android.knowledge.fcmpushnotificationexample.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Nandagopal T on 3/13/2017.
 */

public class FCMMessagingService extends FirebaseMessagingService {
    private static final String TAG = FCMMessagingService.class.getSimpleName();
    private static final int NOTIFICATION_ID = 500;
    private static final int REQUEST_CODE = 501;
    private static final String KEY_LOCATION = "KEY_LOCATION";

    public FCMMessagingService() {
        Log.d(TAG, "Constructor FCMMessagingService");
    }

    /**
     * Callback to be received, when the notification message is received
     * Handle the FCM messages in this section
     * <p>
     * // There are two types of messages data messages and notification messages. Data messages are handled
     * // here in onMessageReceived whether the app is in the foreground or background. Data messages are the type
     * // traditionally used with GCM. Notification messages are only received here in onMessageReceived when the app
     * // is in the foreground. When the app is in the background an automatically generated notification is displayed.
     * // When the user taps on the notification they are returned to the app. Messages containing both notification
     * // and data payloads are treated as notification messages. The Firebase console always sends notification
     * // messages. For more see: https://firebase.google.com/docs/cloud-messaging/concept-options
     *
     * @param remoteMessage
     */
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "START of onMessageRecieved");

        String from = remoteMessage.getFrom();
        Log.d(TAG, "From :" + from);

        // Check whether the message contains data payload
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Data payload :" + remoteMessage.getData());
        }
        // Check if the message contains the notification payload
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Notification payload body :" + remoteMessage.getNotification().getBody() +
                    " Title :" + remoteMessage.getNotification().getTitle() +
                    "Notification : " + remoteMessage.getNotification().toString());
        }
        generateLocalNotification(remoteMessage);
        Log.d(TAG, "COMPLETION of onMessageReceived");
    }

    /**
     * @param remoteMessage
     */
    private void generateLocalNotification(RemoteMessage remoteMessage) {
        Log.d(TAG, "START of generateLocalNotification");
        String location = "Coimbatore";
        Uri ringToneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        // Generate the intent
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(KEY_LOCATION, location);
        // Generate the pending intent
        PendingIntent pendingIntent = PendingIntent.getActivity(this, REQUEST_CODE, intent, PendingIntent.FLAG_ONE_SHOT);
        // Create the notification builder instance
        Notification.Builder builder = new Notification.Builder(this)
                .setContentTitle("Title")
                .setContentText("Text Information")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setSound(ringToneUri)
                .setAutoCancel(true);

        // Create a notification instance
        Notification notification = builder.build();

        // Get the notification manager service from the system service
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // notify the user
        notificationManager.notify(NOTIFICATION_ID, notification);

        Log.d(TAG, "COMPLETION of generateLocalNotification");
    }
}
