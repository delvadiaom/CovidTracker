package com.degtu.cowid_19casesdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;

import com.degtu.cowid_19casesdata.databinding.ActivityCovidPreventionBinding;

public class CovidPreventionActivity extends AppCompatActivity {

    ActivityCovidPreventionBinding binding;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCovidPreventionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

            getSupportActionBar().hide();
            url = "file:///android_asset/covidprevention.html";
            binding.webview.loadUrl(url);

            WebSettings webSettings = binding.webview.getSettings();
            webSettings.setDisplayZoomControls(false);
            webSettings.setJavaScriptEnabled(true);
            webSettings.setBuiltInZoomControls(true);

    }
}