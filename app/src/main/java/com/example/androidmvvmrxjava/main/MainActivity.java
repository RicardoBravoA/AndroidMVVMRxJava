package com.example.androidmvvmrxjava.main;

import android.os.Bundle;

import com.example.androidmvvmrxjava.R;
import com.example.androidmvvmrxjava.base.BaseActivity;
import com.example.androidmvvmrxjava.list.ListFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected int layout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.screenContainer, new ListFragment()).commit();
        }

    }

}
