package com.example.woojinkim.databindingpractice.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by woojinkim on 2017. 8. 25..
 */

public class MainViewModel extends ViewModel {
    @NonNull
    public ObservableField<String> mTitle = new ObservableField<>("initial");

    public ObservableField<Integer> mProgressbarStatus = new ObservableField<>(View.GONE);

}
