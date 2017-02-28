package com.knowledge.android.mvpdaggerexample;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Nandagopal T on 2/27/2017.
 */

@Singleton
@Component(modules = {MainModule.class})
public interface DaggerGraphComponent {
    void inject(MainFragment fragment);

    void inject(MainActivity activity);
}
