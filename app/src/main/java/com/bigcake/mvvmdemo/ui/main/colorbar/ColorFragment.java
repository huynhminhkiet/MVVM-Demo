package com.bigcake.mvvmdemo.ui.main.colorbar;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigcake.mvvmdemo.R;
import com.bigcake.mvvmdemo.base.BaseFragment;
import com.bigcake.mvvmdemo.databinding.MainFragBinding;

import javax.inject.Inject;

/**
 * Created by kiethuynh on 16/06/2017
 */

public class ColorFragment extends BaseFragment<ColorViewModel> {
    public static final String TAG = "tag_color_fragment";

    @Inject
    ColorViewModel mColorViewModel;

    @Override
    protected String getFragTag() {
        return TAG;
    }

    @Override
    protected ColorViewModel createViewModel() {
        return mColorViewModel;
    }

    @Override
    protected void injectViewModel() {
        getActivityComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainFragBinding mMainFragBinding = DataBindingUtil.inflate(inflater, R.layout.main_frag, container, false);
        mColorViewModel = getViewModel();
        mMainFragBinding.setViewModel(mColorViewModel);
        return mMainFragBinding.getRoot();
    }
}
