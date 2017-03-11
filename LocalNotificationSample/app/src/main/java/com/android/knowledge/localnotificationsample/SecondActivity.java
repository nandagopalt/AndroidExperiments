package com.android.knowledge.localnotificationsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();
    @BindView(R.id.textView4)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        Log.d(TAG, "Information :" + getIntent().getStringExtra(LaunchActivity.KEY_EXTRA_MESSAGE));
        mTextView.setText(getIntent().getStringExtra(LaunchActivity.KEY_EXTRA_MESSAGE));
    }


}
