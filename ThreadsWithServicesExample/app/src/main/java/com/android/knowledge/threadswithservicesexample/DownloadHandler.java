package com.android.knowledge.threadswithservicesexample;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by Nandagopal T on 3/16/2017.
 */

public class DownloadHandler extends Handler {

    private static final String TAG = DownloadHandler.class.getSimpleName();
    private DownloadService mService;


    /**
     * Subclasses must implement this to receive messages.
     *
     * @param msg
     */
    @Override
    public void handleMessage(Message msg) {
        downloadSong(msg.obj.toString());
        mService.stopSelf(msg.arg1);
    }

    /**
     *
     */
    private void downloadSong(String song) {
        Log.d(TAG, "START of downloadSong :" + song);
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis() + (10 * 1000);
        while(System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "COMPLETION of downloadSong :" + song);
    }

    public void setService(DownloadService service) {
        mService = service;
    }
}
