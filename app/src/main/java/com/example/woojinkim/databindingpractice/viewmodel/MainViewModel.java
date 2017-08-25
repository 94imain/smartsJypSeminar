package com.example.woojinkim.databindingpractice.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by woojinkim on 2017. 8. 25..
 */

public class MainViewModel extends ViewModel {
    @NonNull
    public ObservableField<String> mTitle = new ObservableField<>("initial");

    @NonNull
    public ObservableField<Integer> mProgressbarStatus = new ObservableField<>(View.GONE);
    @NonNull
    public ObservableField<Integer> mSpinnerVisibility = new ObservableField<>(View.VISIBLE);
    public ObservableField<List<String>> mCompanies = new ObservableField<>();


    public MainViewModel() {
        Handler handler = new Handler();

        mProgressbarStatus.set(View.VISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressbarStatus.set(View.GONE);
                mTitle.set("data loading");

                ArrayList<String> companies = new ArrayList<String>();
                companies.add("smarts");
                companies.add("samsung");
                mCompanies.set(companies);
            }
        },5000);
    }
}
