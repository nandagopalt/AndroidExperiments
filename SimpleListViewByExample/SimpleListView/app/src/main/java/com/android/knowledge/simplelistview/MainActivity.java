package com.android.knowledge.simplelistview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.knowledge.utility.LogUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private String[] mFruits = {"Apple", "Banana", "Cherries", "Dates", "Eggfruit", "Fig", "HagBerry", "Apple", "Banana", "Cherries", "Dates", "Eggfruit", "Fig", "HagBerry", "Apple", "Banana", "Cherries", "Dates", "Eggfruit", "Fig", "HagBerry"};
    private int mImageResourceIds[] = {R.drawable.apricots, R.drawable.strawberry, R.drawable.apricots, R.drawable.apricots, R.drawable.strawberry, R.drawable.apricots, R.drawable.apricots};
    private ListView mListView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private ArrayList<String> mArrayListEntries = new ArrayList<>();
    private boolean isLoading = false;
    private final int INITIAL_COUNT = 10;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(TAG, "START of onCreate");
        setContentView(R.layout.activity_main);

        mArrayListEntries = fetchEntriesFromService(INITIAL_COUNT);

        mListView = (ListView) findViewById(R.id.listView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar2);
        mTextView = (TextView) findViewById(R.id.textView2);
        mProgressBar.setVisibility(View.INVISIBLE);
        mTextView.setVisibility(View.INVISIBLE);

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, mArrayListEntries);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int id, long position) {
                LogUtil.d(TAG, "Item clicked :" + ((TextView) view).getText().toString());
                Toast.makeText(getApplicationContext(), "Item clicked :" + ((TextView) view).getText() + ", Position :" + position, Toast.LENGTH_LONG).show();
            }
        });

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Toast.makeText(MainActivity.this, "FirstVisibleItem :" + firstVisibleItem + "," + "VisibleItemCount :" +
                        visibleItemCount + "," + "TotalItemCount :" + totalItemCount, Toast.LENGTH_LONG).show();
                final int count = totalItemCount;
                if (totalItemCount > 0 && (firstVisibleItem + visibleItemCount == totalItemCount)) {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mTextView.setVisibility(View.VISIBLE);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            final ArrayList<String> entries = fetchEntriesFromService(INITIAL_COUNT);
                            mListView.post(new Runnable() {
                                @Override
                                public void run() {
                                    mArrayListEntries.addAll(entries);
                                    mAdapter.notifyDataSetChanged();
                                    isLoading = false;
                                    mProgressBar.setVisibility(View.INVISIBLE);
                                    mTextView.setVisibility(View.INVISIBLE);
                                }
                            });
                        }
                    }).start();
                }

            }
        });

        LogUtil.d(TAG, "COMPLETION of onCreate");
    }

    private ArrayList<String> fetchEntriesFromService(int count) {
        LogUtil.d(TAG, "START of fetchEntriesFromService");
        ArrayList<String> items = new ArrayList<>();
        isLoading = true;
        for (int i = 0; i < count; i++) {
            items.add("item : " + (i));
        }
        LogUtil.d(TAG, "COMPLETION of fetchEntriesFromService");
        return items;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        LogUtil.d(TAG, "START of onSaveInstanceState");
        LogUtil.d(TAG, "COMPLETION of onSaveInstanceState");

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        LogUtil.d(TAG, "START of onRestoreInstanceState");
        LogUtil.d(TAG, "COMPLETION of onRestoreInstanceState");
    }


}
