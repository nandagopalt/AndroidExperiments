package com.knowledge.android.rxjavabyexample.presenter;

import com.knowledge.android.rxjavabyexample.BasePresenter;
import com.knowledge.android.rxjavabyexample.BaseView;
import com.knowledge.android.rxjavabyexample.model.GitHubRepo;

import java.util.List;

/**
 * Created by Nandagopal on 2/17/2017.
 */

public class MainScreenActivityContract {

    public interface MainScreenActivityOperationsView extends BaseView<MainScreenActivityPresenterView> {
        void loadStarredProjects(List<GitHubRepo> gitHubRepoList);

        void showProgressDialog();

        void hideProgressDialog();
    }

    public interface MainScreenActivityPresenterView extends BasePresenter {
        void fetchStarredProjects(String username);


    }
}
