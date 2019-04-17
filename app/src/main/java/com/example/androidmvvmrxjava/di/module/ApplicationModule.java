package com.example.androidmvvmrxjava.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.androidmvvmrxjava.data.rest.ApiService;
import com.example.androidmvvmrxjava.di.util.ViewModelFactory;

import java.util.Map;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = ViewModelSubComponent.class)
public class ApplicationModule {

    private static final String BASE_URL = "https://api.github.com/";

    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();
    }

    @Singleton
    @Provides
    OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(logging).build();
    }

    @Singleton
    @Provides
    ApiService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }


    /*
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
    */

    /*
    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
        return new ViewModelFactory(creators);
    }
    */


}
