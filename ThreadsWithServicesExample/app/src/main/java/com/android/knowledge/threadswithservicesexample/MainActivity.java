package com.android.knowledge.threadswithservicesexample;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Fragment mMainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "START of onCreate");
        setContentView(R.layout.activity_main);
        // Get the fragment instance
        mMainFragment = MainFragment.getInstance();
        // Check whether the fragment is already loaded
        if(null == getFragmentManager().findFragmentByTag(mMainFragment.getClass().getSimpleName())) {
            getFragmentManager().beginTransaction().add(R.id.fragment_container, mMainFragment, mMainFragment.getClass().
                    getSimpleName()).commit();
        }

        Log.d(TAG, "COMPLETION of onCreate");
    }


}
