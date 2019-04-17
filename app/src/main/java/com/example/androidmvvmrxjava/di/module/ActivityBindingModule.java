package com.example.androidmvvmrxjava.di.module;

import com.example.androidmvvmrxjava.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();
}
