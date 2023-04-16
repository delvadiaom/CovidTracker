package com.degtu.cowid_19casesdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.degtu.cowid_19casesdata.databinding.ActivityScratch1Binding;

public class Scratch1Activity extends AppCompatActivity {

    ActivityScratch1Binding binding;
    ViewAdapter viewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScratch1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        viewAdapter = new ViewAdapter(this);
        binding.viewpager.setAdapter(viewAdapter);
        binding.dots.setViewPager(binding.viewpager);
    }
}