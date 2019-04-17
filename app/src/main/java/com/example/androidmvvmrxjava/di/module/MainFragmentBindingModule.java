package com.example.androidmvvmrxjava.di.module;

import com.example.androidmvvmrxjava.list.ListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract ListFragment provideListFragment();
}
