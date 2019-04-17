package com.example.androidmvvmrxjava.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.androidmvvmrxjava.data.model.RepositoryModel;
import com.example.androidmvvmrxjava.data.rest.ApiRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ListViewModel extends ViewModel {

    private final ApiRepository apiRepository;
    private CompositeDisposable disposable;

    private final MutableLiveData<List<RepositoryModel>> repos = new MutableLiveData<>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public ListViewModel(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
        disposable = new CompositeDisposable();
        fetchRepos();
    }

    LiveData<List<RepositoryModel>> getRepos() {
        return repos;
    }
    LiveData<Boolean> getError() {
        return repoLoadError;
    }
    LiveData<Boolean> getLoading() {
        return loading;
    }

    private void fetchRepos() {
        loading.setValue(true);
        disposable.add(apiRepository.getRepositories().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<RepositoryModel>>() {
                    @Override
                    public void onSuccess(List<RepositoryModel> value) {
                        repoLoadError.setValue(false);
                        repos.setValue(value);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        repoLoadError.setValue(true);
                        loading.setValue(false);
                    }
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
