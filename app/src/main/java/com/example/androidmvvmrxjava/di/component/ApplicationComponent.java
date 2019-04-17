package com.example.androidmvvmrxjava.di.component;

import android.app.Application;

import com.example.androidmvvmrxjava.base.BaseApplication;
import com.example.androidmvvmrxjava.di.module.ActivityBindingModule;
import com.example.androidmvvmrxjava.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class
})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }

    void inject(BaseApplication application);

}
