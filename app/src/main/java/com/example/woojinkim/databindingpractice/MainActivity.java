package com.example.woojinkim.databindingpractice;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.woojinkim.databindingpractice.databinding.ActivityMainBinding;
import com.example.woojinkim.databindingpractice.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding.setMainviewmodel(mainViewModel);

    }
}
