package com.knowledge.android.rxjavabyexample.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.knowledge.android.rxjavabyexample.R;
import com.knowledge.android.rxjavabyexample.model.GitHubRepo;
import com.knowledge.android.rxjavabyexample.presenter.ActivityOperationsView;
import com.knowledge.android.rxjavabyexample.presenter.ActivityPresenterImpl;
import com.knowledge.android.rxjavabyexample.presenter.ActivityPresenterView;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import rx.Subscription;

public class MainActivity extends AppCompatActivity implements ActivityOperationsView {
    private Subscription mSubcription;
    private static final String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog mProgressDialog;

    @Nullable
    @BindView(R.id.txt_name)
    TextView mTextViewName;

    @Nullable
    @BindView(R.id.edt_username)
    EditText mGitUserName;

    @Nullable
    @BindView(R.id.btn_hitbutton)
    Button mHitGitService;

    @Nullable
    @BindString(R.string.app_name)
    String mRepoNames = "";

    @Override
    public void showProgressDialog() {
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        mProgressDialog.hide();
    }

    private ActivityPresenterView mPresenterView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //mTextViewName = (TextView) findViewById(R.id.name);
        mPresenterView = new ActivityPresenterImpl(this);
    }

    @Optional
    @OnClick(R.id.btn_hitbutton)
    public void submit() {
        mProgressDialog = ProgressDialog.show(this, "Loading", "Please wait");
        if (!TextUtils.isEmpty(mGitUserName.getText().toString().trim())) {
            mPresenterView.fetchStarredProjects(mGitUserName.getText().toString().trim());
        }
    }

    @Override
    public void loadStarredProjects(List<GitHubRepo> gitHubRepoList) {
        for (GitHubRepo repo : gitHubRepoList) {
            Log.d(TAG, "Name :" + repo.name);
            mRepoNames += "\n" + repo.getName();
        }
        mTextViewName.setText(mRepoNames);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
