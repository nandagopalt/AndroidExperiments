package com.android.knowledge.utility;

import android.support.compat.BuildConfig;
import android.util.Log;

/**
 * Created by M1034567 on 7/25/2017.
 */

public class LogUtil {

    public static void d(String tag, String message) {
       // if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        //}
    }
}
