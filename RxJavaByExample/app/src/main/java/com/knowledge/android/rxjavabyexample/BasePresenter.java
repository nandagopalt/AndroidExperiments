package com.knowledge.android.rxjavabyexample;

import rx.Subscription;

/**
 * Created by Nandagopal T on 2/17/2017.
 * <p>
 * Base presenter that will be inherited by all the presenters
 */

public interface BasePresenter {
    void foo();

    void unSubscribe();

    Subscription getSubscription();
}
