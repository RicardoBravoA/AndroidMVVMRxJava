package com.example.androidmvvmrxjava.data.rest;

import com.example.androidmvvmrxjava.data.model.RepositoryModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class ApiRepository {

    private final ApiService apiService;

    @Inject
    public ApiRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Single<List<RepositoryModel>> getRepositories() {
        return apiService.getRepositories();
    }

    public Single<RepositoryModel> getRepository(String owner, String name) {
        return apiService.getRepository(owner, name);
    }

}
