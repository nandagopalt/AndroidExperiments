package com.android.knowledge.localnotificationsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity<T> extends AppCompatActivity implements NumberAdapter.onItemClickListener {

    private static final String TAG = SecondActivity.class.getSimpleName();

    @BindView(R.id.textView4)
    TextView mTextView;

    @BindView(R.id.listItems)
    ListView mListView;

    String[] mListElements = new String[] {"One", "Two" ,"Three", "Four" , "Five", "Six" , "Seven" , "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen" , "Nineteen", "Twenty"};

    ArrayList<String> mArrayListElements = new ArrayList<String>(Arrays.asList(mListElements));
    NumberAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        Log.d(TAG, "Information :" + getIntent().getStringExtra(LaunchActivity.KEY_EXTRA_MESSAGE));
        mTextView.setText(getIntent().getStringExtra(LaunchActivity.KEY_EXTRA_MESSAGE));
        //mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, mListElements));

        /* mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SecondActivity.this, ((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });*/

        mAdapter = new NumberAdapter(this, mArrayListElements);
        mListView.setAdapter(mAdapter);
    }

    /*@OnItemClick(R.id.listItems)
    void OnItemClick(int position) {
        Toast.makeText(SecondActivity.this, "Hi, I am here !!!!! ,"  + mListElements[position], Toast.LENGTH_SHORT).show();
    }*/

    @Override
    public void onItemClick(int position, Object listEntry, String listItem, View view, Boolean state) {
        Toast.makeText(this, "Position :" + position
                + ", Element : " + listEntry.toString() + ", View name :" + ((Button)view).getText() , Toast.LENGTH_SHORT).show();
        mArrayListElements.remove(position);
        mAdapter.notifyDataSetChanged();
    }




}
