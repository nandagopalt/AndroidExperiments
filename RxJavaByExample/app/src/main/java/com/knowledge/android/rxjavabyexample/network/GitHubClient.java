package com.knowledge.android.rxjavabyexample.network;

import com.knowledge.android.rxjavabyexample.model.GitHubRepo;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by M1034567 on 2/15/2017.
 * <p>
 * This will be the object we will interact with to make network calls from the UI level
 */

public class GitHubClient {

    private static GitHubClient gitGitHubClient;
    private GitHubService gitHubService;

    // Making the constructor private, so other classes will not have the option to instantiate through constructor
    private GitHubClient() {
        final Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
        gitHubService = retrofit.create(GitHubService.class);
    }


    public static GitHubClient getGitGitHubClient() {
        if (null == gitGitHubClient) {
            gitGitHubClient = new GitHubClient();
        }
        return gitGitHubClient;
    }

    public Observable<List<GitHubRepo>> fetchStarredRepositories(String username) {
        return gitHubService.getStarredRepositories(username);
    }
}
