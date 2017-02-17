package com.knowledge.android.rxjavabyexample;

import java.lang.ref.WeakReference;

/**
 * Created by Nandagopal on 2/15/2017.
 */

public abstract class AbstractBaseView<V> {
    protected WeakReference<V> view;

    public void setUpView(V view) {
        this.view = new WeakReference<V>(view);
    }

    protected void loadProgress() {
        if (null != getView()) {

        }
    }

    protected void hideProgress() {

    }

    private V getView() {
        if (null == this.view) {
            return null;
        } else {
            return this.view.get();
        }
    }
}
