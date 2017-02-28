package com.knowledge.android.mvpdaggerexample;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChildFragment extends Fragment {


    private static final String TAG = ChildFragment.class.getName();

    public ChildFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "================= onCreate =================");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "==================== onCreateView ========================");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "==================== onDetach ===============================");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "================= onDestroy ===========================");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "====================onDestroyView=========================");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "===========================onPause=========================");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "=======================onStop===================================");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "====================onResume===============================");
    }


}
