package com.degtu.cowid_19casesdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.degtu.cowid_19casesdata.databinding.ActivityScratch2Binding;

import java.util.Timer;
import java.util.TimerTask;

public class Scratch2Activity extends AppCompatActivity {

    ActivityScratch2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScratch2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

    }
}