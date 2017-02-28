package com.knowledge.android.mvpdaggerexample;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Nandagopal on 2/27/2017.
 */

@Singleton
@Module
public class MainModule {
    DaggerApplication application;

    public MainModule(DaggerApplication daggerApplication) {
        application = daggerApplication;

    }

    @Singleton
    @Provides
    public IGreetService provideGreetServiceInstance() {
        return new GreetServiceImpl();
    }

    @Singleton
    @Provides
    public Application provideApplicationInstance() {
        return application;
    }
}
