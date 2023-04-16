package com.degtu.cowid_19casesdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.degtu.cowid_19casesdata.databinding.ActivityAboutUsBinding;

public class AboutUsActivity extends AppCompatActivity {

    ActivityAboutUsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.loadUrl("file:///android_asset/aboutus.html");

        WebSettings webSettings = binding.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        binding.webView.getSettings().setBuiltInZoomControls(true);
        binding.webView.getSettings().setDisplayZoomControls(true);
    }
}