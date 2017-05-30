package com.android.knowledge.appdynamicsexperiment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appdynamics.eumagent.runtime.Instrumentation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AppDynamics
        Instrumentation.start("AD-AAB-AAD-WED", getApplicationContext());

        // Trying to pass the custom metric to the agent through reportMetric
        Instrumentation.reportMetric("Activity load count", 1);

        Instrumentation.setUserData("Policy Number", "12345");
        Instrumentation.setUserData("Product Line", "India");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Instrumentation.startTimer("In mainactivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Instrumentation.stopTimer("In mainactivity");
    }
}
