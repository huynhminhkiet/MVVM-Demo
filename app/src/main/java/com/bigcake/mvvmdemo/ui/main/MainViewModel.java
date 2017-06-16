package com.bigcake.mvvmdemo.ui.main;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * Created by kiethuynh on 14/06/2017
 */

public class MainViewModel extends BaseObservable {

    public final ObservableField<Integer> number = new ObservableField<>(5);

    public MainViewModel() {

    }

    public void setNumber() {
        this.number.set(number.get() + 1);
    }
}
