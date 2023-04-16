package com.degtu.cowid_19casesdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebViewClient;

import com.degtu.cowid_19casesdata.databinding.ActivityPrecautionsBinding;

public class PrecautionsActivity extends AppCompatActivity {

    ActivityPrecautionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrecautionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.webview.setWebViewClient(new WebViewClient());
        binding.webview.getSettings().setJavaScriptEnabled(true);
        binding.webview.getSettings().setBuiltInZoomControls(true);
        binding.webview.loadUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public");
    }
}