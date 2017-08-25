package com.example.woojinkim.databindingpractice.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.woojinkim.databindingpractice.databinding.ActivityMainBinding;
import com.jakewharton.rxbinding2.widget.RxAdapterView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by woojinkim on 2017. 8. 25..
 */

public class MainViewModel extends ViewModel {
    @NonNull
    public ObservableField<String> mTitle = new ObservableField<>("initial");

    @NonNull
    public ObservableField<Integer> mProgressbarStatus = new ObservableField<>(View.GONE);
    @NonNull
    public ObservableField<Integer> mSpinnerVisibility = new ObservableField<>(View.GONE);
    public ObservableField<List<String>> mCompanies = new ObservableField<>();

    @NonNull
    public ObservableField<Integer> mProgressStatus2 = new ObservableField<>(View.GONE);

    @NonNull
    public ObservableField<Integer> mProductSpinnerVisibility = new ObservableField<>(View.GONE);
    public ObservableField<List<String>> mProductSpinner = new ObservableField<>();

    public MainViewModel() {
        Handler handler = new Handler();

        mProgressbarStatus.set(View.VISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressbarStatus.set(View.GONE);
                mSpinnerVisibility.set(View.VISIBLE);
                mTitle.set("data loading");

                ArrayList<String> companies = new ArrayList<String>();
                companies.add("smarts");
                companies.add("samsung");

                mCompanies.set(companies);
            }
        },5000);
    }

    public void attachViews(ActivityMainBinding binding) {
        Observable<Integer> observable=
                RxAdapterView.itemSelections(binding.spinnerCompanies);


        observable.subscribe(
                (position) -> {
                    mTitle.set("item selection called with position = ["+position+"]");
                    if(position==0){
                        Handler anohandler = new Handler();
                        mProgressStatus2.set(View.VISIBLE);
                        mProductSpinnerVisibility.set(View.GONE);
                        anohandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //server에서 이름 받아주기
                                mTitle.set("smarts");
                                mProgressStatus2.set(View.GONE);
                                mProductSpinnerVisibility.set(View.VISIBLE);

                                //server에서 받은거 for문으로 돌려주기
                                ArrayList<String> companies2 = new ArrayList<String>();
                                companies2.add("전구");
                                companies2.add("에어컨");

                                mProductSpinner.set(companies2);
                            }
                        },3000);
                    }
                    else if(position==1) {
                        Handler anohandler = new Handler();
                        mProgressStatus2.set(View.VISIBLE);
                        mProductSpinnerVisibility.set(View.GONE);
                        anohandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                 //server에서 이름 받아주기
                                mTitle.set("samsung");
                                mProgressStatus2.set(View.GONE);
                                mProductSpinnerVisibility.set(View.VISIBLE);

                                //server에서 받은거 for문으로 돌려주기
                                ArrayList<String> companies2 = new ArrayList<String>();
                                companies2.add("냉장고");
                                companies2.add("로봇청소기");

                                mProductSpinner.set(companies2);
                            }
                        },3000);

                    }
                    else {

                    }

                }
        );
    }
}
