package com.android.knowledge.threadswithservicesexample;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Nandagopal T on 3/22/2017.
 */

public class DownloadIntentService extends IntentService {


    public DownloadIntentService() {
        super("DownloadIntentService");
        setIntentRedelivery(true);
    }

    /**
     * This method is invoked on the worker thread with a request to process.
     * Only one Intent is processed at a time, but the processing happens on a
     * worker thread that runs independently from other application logic.
     * So, if this code takes a long time, it will hold up other requests to
     * the same IntentService, but it will not hold up anything else.
     * When all requests have been handled, the IntentService stops itself,
     * so you should not call {@link #stopSelf}.
     *
     * @param intent The value passed to {@link
     *               Context#startService(Intent)}.
     *               This may be null if the service is being restarted after
     *               its process has gone away; see
     *               {@link Service#onStartCommand}
     *               for details.
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String song = intent.getStringExtra(MainFragment.KEY_SONG);
        downloadSong(song);
    }
    /**
     *
     */
    private void downloadSong(String song) {
        Log.d("DownloadIntentService", "START of downloadSong :" + song);
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis() + (10 * 1000);
        while(System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d("DownloadIntentService", "COMPLETION of downloadSong :" + song);
    }
}
