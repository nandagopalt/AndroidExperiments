package com.knowledge.android.rxjavabyexample.presenter;

import com.knowledge.android.rxjavabyexample.model.GitHubRepo;

import java.util.List;

/**
 * Created by M1034567 on 2/15/2017.
 */

public interface ActivityOperationsView {
    void loadStarredProjects(List<GitHubRepo> gitHubRepoList);

    void showProgressDialog();

    void hideProgressDialog();
}
