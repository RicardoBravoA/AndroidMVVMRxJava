package com.example.androidmvvmrxjava.di.module;

import com.example.androidmvvmrxjava.di.util.ViewModelKey;
import com.example.androidmvvmrxjava.list.ListViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    @ViewModelKey(ListViewModel.class)
    ListViewModel bindListViewModel();

}