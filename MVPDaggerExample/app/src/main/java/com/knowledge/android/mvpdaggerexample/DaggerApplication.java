package com.knowledge.android.mvpdaggerexample;

import android.app.Application;
import android.content.Context;

/**
 * Created by Nandagopal T on 2/27/2017.
 */

public class DaggerApplication extends Application {

    private static DaggerGraphComponent mAppComponent;
    private static DaggerApplication mInstance;

    public DaggerApplication() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initAppComponents();
    }

    public static DaggerApplication getAppInstance(Context context) {
        return (DaggerApplication) context;
    }

    public DaggerGraphComponent getDaggerGraphComponent() {
        return mAppComponent;
    }

    private void initAppComponents() {
        mAppComponent = DaggerDaggerGraphComponent.builder().mainModule(new MainModule(this)).build();
    }
}
