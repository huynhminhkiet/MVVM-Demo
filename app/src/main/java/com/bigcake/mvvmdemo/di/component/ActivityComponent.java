package com.bigcake.mvvmdemo.di.component;

import com.bigcake.mvvmdemo.di.PerActivity;
import com.bigcake.mvvmdemo.di.module.ActivityModule;
import com.bigcake.mvvmdemo.ui.main.MainActivity;
import com.bigcake.mvvmdemo.ui.main.colorbar.ColorFragment;

import dagger.Component;

/**
 * Created by kiethuynh on 15/06/2017
 */

@PerActivity
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
    void inject(ColorFragment colorFragment);
}
