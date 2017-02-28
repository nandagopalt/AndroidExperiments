package com.knowledge.android.mvpdaggerexample;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import javax.inject.Inject;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment implements View.OnClickListener  {

    private static final String TAG = MainFragment.class.getSimpleName();
    private Button mButton1;

    private MainFragmentListener mListener;
    private static FragmentManager mFragmentManager, mChildFragmentManager;

    @Inject
    IGreetService mGreetService;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "=================== onAttach (context) ==================");
        if (context instanceof MainFragmentListener) {
            mListener = (MainFragmentListener) context;
        } else {
            throw new ClassCastException("Class " + context.getClass().getSimpleName() + " not implementing " + MainFragmentListener.class.getSimpleName());
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(TAG, "=================== onAttach (activity) ===================");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "===============OnCreate========================");
        //mFragmentManager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "===============OnCreateView====================");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mButton1 = (Button) view.findViewById(R.id.button1);
        mButton1.setOnClickListener(this);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "================ onPause ======================");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "=============== onResume =======================");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "================ onStop ========================");
    }

    @Override
    public void onClick(View view) {
        mListener.onMainButtonClick("Message from Main Fragment");
        Log.d(TAG,mGreetService.greet("Vinayak"));
    }

    public interface MainFragmentListener {
        void onMainButtonClick(String message);
    }

    /**
     *
     * @param fragment
     * @param fragmentManager
     *
     * Adding the child fragment to the MainFragment(Parent fragment) :: fragment with fragment
     */
    public void addFragment(Fragment fragment, FragmentManager fragmentManager) {
        mChildFragmentManager = fragmentManager;
        if (null == mChildFragmentManager.findFragmentByTag(fragment.getClass().getSimpleName())) {
            mChildFragmentManager.beginTransaction().replace(R.id.child_fragment_container, fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(null).commit();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "====================== OnDestroyView =========================");
    }


    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "====================== onDetach ===============================");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "====================== onDestroy =================================");
    }

    /**
     *
     * @param savedInstanceState
     *
     * Responsible for injecting the required object in this section
     *
     */
    @Override
    protected void initializeFragment(@Nullable Bundle savedInstanceState) {
        DaggerApplication.getAppInstance(getActivity().getApplicationContext()).getDaggerGraphComponent().inject(this);
    }
}
