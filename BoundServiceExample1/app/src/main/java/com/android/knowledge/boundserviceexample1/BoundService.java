package com.android.knowledge.boundserviceexample1;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by M1034567 on 6/2/2017.
 */

public class BoundService extends Service {
    private MediaPlayer mPlayer;


    @Override
    public void onCreate() {
        mPlayer = MediaPlayer.create(this, Uri.parse("/sdcard/Music/sample.mp3"));
        mPlayer.
        try {
            mPlayer.setDataSource("/sdcard/Music/sample.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
