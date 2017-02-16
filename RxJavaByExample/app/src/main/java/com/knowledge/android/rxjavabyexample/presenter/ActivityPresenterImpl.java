package com.knowledge.android.rxjavabyexample.presenter;

import android.util.Log;

import com.knowledge.android.rxjavabyexample.model.GitHubRepo;
import com.knowledge.android.rxjavabyexample.network.GitHubClient;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by M1034567 on 2/15/2017.
 */

public class ActivityPresenterImpl implements ActivityPresenterView {
    private static final String TAG = ActivityPresenterImpl.class.getSimpleName();
    private ActivityOperationsView mOperations;
    private Subscription mSubcription;

    public ActivityPresenterImpl(ActivityOperationsView activity) {
        mOperations = activity;
    }

    public void fetchStarredProjects(String username) {
        mOperations.showProgressDialog();
        mSubcription = GitHubClient.getGitGitHubClient().fetchStarredRepositories(username)
                .subscribeOn(Schedulers.io())
                .map(new Func1<List<GitHubRepo>, List<GitHubRepo>>() {
                    @Override
                    public List<GitHubRepo> call(List<GitHubRepo> gitHubRepos) {
                        return gitHubRepos;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GitHubRepo>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "In onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "In Error: " + e.getLocalizedMessage());
                        mOperations.hideProgressDialog();
                    }

                    @Override
                    public void onNext(List<GitHubRepo> gitHubRepos) {
                        Log.d(TAG, "In onNext");
                        mOperations.loadStarredProjects(gitHubRepos);
                        mOperations.hideProgressDialog();
                    }
                });
    }

}
