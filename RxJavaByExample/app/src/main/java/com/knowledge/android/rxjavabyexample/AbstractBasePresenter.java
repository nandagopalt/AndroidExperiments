package com.knowledge.android.rxjavabyexample;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

/**
 * Created by Nandagopal on 2/17/2017.
 */

public abstract class AbstractBasePresenter<M, V> {
    protected M genericModel;
    private WeakReference<V> genericView;

    public void setModel(M model) {
        genericModel = model;
        if (setUpDone()) {
            updateView();
        }
    }

    public void bindView(@NonNull V view) {
        genericView = new WeakReference<V>(view);
        if (setUpDone()) {
            updateView();
        }
    }

    public void unBindView() {
        genericView = null;
    }

    protected boolean setUpDone() {
        return null != view() && null != genericModel;
    }

    protected V view() {
        if (genericView == null) {
            return null;
        } else {
            return genericView.get();
        }
    }

    public abstract void updateView();

    protected void resetState() {

    }

}
