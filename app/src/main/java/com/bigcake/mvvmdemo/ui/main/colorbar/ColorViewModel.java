package com.bigcake.mvvmdemo.ui.main.colorbar;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * Created by kiethuynh on 14/06/2017
 */

public class ColorViewModel extends BaseObservable {

    public final ObservableField<Integer> number = new ObservableField<>(5);

    public ColorViewModel() {

    }

    public void setNumber() {
        this.number.set(number.get() + 1);
    }
}
