package com.knowledge.android.rxjavabyexample;

/**
 * Created by NandagopalT on 2/17/2017.
 * <p>
 * BaseView that will be implemented by all the views
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
}
