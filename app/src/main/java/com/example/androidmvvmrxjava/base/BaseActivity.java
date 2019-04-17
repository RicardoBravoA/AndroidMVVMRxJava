package com.example.androidmvvmrxjava.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    @LayoutRes
    protected abstract int layout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        ButterKnife.bind(this);
    }
}
