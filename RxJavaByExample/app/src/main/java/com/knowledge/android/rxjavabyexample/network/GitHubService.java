package com.knowledge.android.rxjavabyexample.network;

import com.knowledge.android.rxjavabyexample.model.GitHubRepo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by M1034567 on 2/15/2017.
 * <p>
 * We will pass this interface into Retrofit and Retrofit will create an implementation of GitHubService.
 */

public interface GitHubService {

    @GET("users/{user}/starred")
    Observable<List<GitHubRepo>> getStarredRepositories(@Path("user") String username);
}
