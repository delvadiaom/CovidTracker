package com.degtu.cowid_19casesdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.degtu.cowid_19casesdata.databinding.ActivityScratchBinding;
import com.google.firebase.auth.FirebaseAuth;

public class ScratchActivity extends AppCompatActivity {

    ActivityScratchBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScratchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser()!=null){
            Intent intent = new Intent(ScratchActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }



        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScratchActivity.this,Scratch1Activity.class);
                startActivity(intent);
            }
        });

    }
}