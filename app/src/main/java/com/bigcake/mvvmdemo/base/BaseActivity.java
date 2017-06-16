package com.bigcake.mvvmdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bigcake.mvvmdemo.di.component.ActivityComponent;
import com.bigcake.mvvmdemo.di.component.DaggerActivityComponent;
import com.bigcake.mvvmdemo.di.module.ActivityModule;
import com.bigcake.mvvmdemo.util.ActivityUtils;


/**
 * Created by kiethuynh on 15/06/2017
 */

public abstract class BaseActivity<VM> extends AppCompatActivity {
    private ActivityComponent mActivityComponent;

    protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .build();
        injectViewModel();
        mViewModel = findOrCreateViewModel();
    }

    public VM findOrCreateViewModel() {
        @SuppressWarnings("unchecked")
        ViewModelHolder<VM> retainedViewModel =
                (ViewModelHolder<VM>) getSupportFragmentManager()
                        .findFragmentByTag(getTag());

        if (retainedViewModel != null && retainedViewModel.getViewModel() != null) {
            return retainedViewModel.getViewModel();
        } else {
            mViewModel = createViewModel();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(),
                    ViewModelHolder.createContainer(mViewModel),
                    getTag());
            return mViewModel;
        }
    }

    protected abstract String getTag();

    protected abstract VM createViewModel();

    protected abstract void injectViewModel();

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    protected VM getViewModel() {
        return mViewModel;
    }
}
