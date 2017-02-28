package com.knowledge.android.mvpdaggerexample;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {

    private static final String TAG = BaseFragment.class.getSimpleName();

    protected FragmentManager fragmentManager;

    public BaseFragment() {
        // Required empty public constructor
        Log.d(TAG, "================BaseFragment constructor=====================");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
        Log.d(TAG, "===================onCreate====================================");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "==========================onActivityCreated===================");
        initializeFragment(savedInstanceState);
    }

    protected abstract void initializeFragment(@Nullable Bundle savedInstanceState);


}
