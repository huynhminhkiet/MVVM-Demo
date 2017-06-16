package com.bigcake.mvvmdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.bigcake.mvvmdemo.di.component.ActivityComponent;
import com.bigcake.mvvmdemo.di.component.DaggerActivityComponent;
import com.bigcake.mvvmdemo.di.module.ActivityModule;
import com.bigcake.mvvmdemo.util.ActivityUtils;

/**
 * Created by kiethuynh on 16/06/2017
 */

public abstract class BaseFragment<VM> extends Fragment {
    private ActivityComponent mActivityComponent;
    private VM mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(getActivity()))
                .build();
        injectViewModel();
        mViewModel = findOrCreateViewModel();
    }

    public VM findOrCreateViewModel() {
        @SuppressWarnings("unchecked")
        ViewModelHolder<VM> retainedViewModel =
                (ViewModelHolder<VM>) getActivity().getSupportFragmentManager()
                        .findFragmentByTag(getFragTag());

        if (retainedViewModel != null && retainedViewModel.getViewModel() != null) {
            return retainedViewModel.getViewModel();
        } else {
            mViewModel = createViewModel();
            ActivityUtils.addFragmentToActivity(
                    getActivity().getSupportFragmentManager(),
                    ViewModelHolder.createContainer(mViewModel),
                    getFragTag());
            return mViewModel;
        }
    }

    protected abstract String getFragTag();
    protected abstract VM createViewModel();
    protected abstract void injectViewModel();

    protected VM getViewModel() {
        return mViewModel;
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }
}


