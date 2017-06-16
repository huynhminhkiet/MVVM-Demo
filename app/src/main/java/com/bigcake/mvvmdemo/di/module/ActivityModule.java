package com.bigcake.mvvmdemo.di.module;

import android.app.Activity;
import android.content.Context;

import com.bigcake.mvvmdemo.di.PerActivity;
import com.bigcake.mvvmdemo.ui.main.MainViewModel;
import com.bigcake.mvvmdemo.ui.main.colorbar.ColorFragment;
import com.bigcake.mvvmdemo.ui.main.colorbar.ColorViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kiethuynh on 15/06/2017
 */

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Context provideContext() {
        return activity;
    }

    @PerActivity
    @Provides
    MainViewModel provideMainViewModel() {
        return new MainViewModel();
    }

    @PerActivity
    @Provides
    ColorViewModel provideColorViewModel() {
        return new ColorViewModel();
    }
}
