package com.knowledge.android.mvpdaggerexample;


import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

import android.util.Log;

/**
 * Activity responsible for holding the fragment || MainFragment || dynamically when the onCreate of the life cycle method is called
 * from the activity
 */

public class MainActivity extends Activity implements MainFragment.MainFragmentListener, IGreetService {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Adding the fragment to teh activity dynamically
        FragmentManager fragmentManager = this.getFragmentManager();
        if (null == fragmentManager.findFragmentByTag(MainFragment.class.getSimpleName())) {
            fragmentManager.beginTransaction().add(R.id.activity_main, new MainFragment(),
                    MainFragment.class.getSimpleName()).commit();
        }
    }

    /**
     *
     * @param message
     * Method to be called when pressing the button in the fragment 1
     */
    @Override
    public void onMainButtonClick(String message) {
        Log.d(TAG, "Message from Mian fragment : " + message);
        // Instantiate the MainFragment and call one of the public method
        MainFragment mainFragment = new MainFragment();
        mainFragment.addFragment(new ChildFragment(), getFragmentManager());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "==============onBackPressed=====================");
        Log.d(TAG, "Count of backstack :"+ getFragmentManager().getBackStackEntryCount());
    }

    @Override
    public String greet(String name) {
        return "Hi " + name + " !!!!! , Welcome";
    }
}
