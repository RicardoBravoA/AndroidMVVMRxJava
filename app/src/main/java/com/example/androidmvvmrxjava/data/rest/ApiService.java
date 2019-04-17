package com.example.androidmvvmrxjava.data.rest;

import com.example.androidmvvmrxjava.data.model.RepositoryModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("orgs/Google/repos")
    Single<List<RepositoryModel>> getRepositories();

    @GET("repos/{owner}/{name}")
    Single<RepositoryModel> getRepository(@Path("owner") String owner, @Path("name") String name);

}
