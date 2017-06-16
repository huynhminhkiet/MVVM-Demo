package com.bigcake.mvvmdemo.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bigcake.mvvmdemo.R;
import com.bigcake.mvvmdemo.base.BaseActivity;
import com.bigcake.mvvmdemo.databinding.ActivityMainBinding;
import com.bigcake.mvvmdemo.ui.main.colorbar.ColorFragment;
import com.bigcake.mvvmdemo.util.ActivityUtils;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<MainViewModel> {
    public static final String TAG = "tag_main_activity";

    @Inject
    MainViewModel mMainViewModel;

    @Override
    protected String getTag() {
        return TAG;
    }

    @Override
    protected MainViewModel createViewModel() {
        return mMainViewModel;
    }

    @Override
    protected void injectViewModel() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainViewModel = getViewModel();
        activityMainBinding.setViewModel(mMainViewModel);

        if (getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container) == null)
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), new ColorFragment(), R.id.fragment_container);
    }
}
