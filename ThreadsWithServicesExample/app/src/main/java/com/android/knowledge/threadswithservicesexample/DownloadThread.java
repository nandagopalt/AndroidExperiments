package com.android.knowledge.threadswithservicesexample;

import android.os.Looper;

/**
 * Created by Nandagopal T on 3/15/2017.
 */

public class DownloadThread extends Thread {
    private static final String TAG = DownloadThread.class.getSimpleName();
    public DownloadHandler mDownloadHandler;


    public DownloadThread() {

    }

    @Override
    public void run() {
        /*for(String song: Playlist.SONGS) {
            downloadSong(song);
        }*/

        // This will create the looper and the message queue
        Looper.prepare();
        // Instantiate the handler
        mDownloadHandler = new DownloadHandler();
        // Makes the looper to loop over the message queue
        Looper.loop();
    }

    /**
     *
     */
    /*private void downloadSong(String song) {
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
    }*/
}
