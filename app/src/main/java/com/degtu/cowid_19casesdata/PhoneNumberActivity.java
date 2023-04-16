package com.degtu.cowid_19casesdata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.degtu.cowid_19casesdata.databinding.ActivityPhoneNumberBinding;
import com.google.firebase.auth.FirebaseAuth;

public class PhoneNumberActivity extends AppCompatActivity {

    ActivityPhoneNumberBinding binding;
    FirebaseAuth auth;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();


        binding.continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = binding.phone.getText().toString();
                if (phoneNumber.isEmpty()){
                    binding.phone.setError("This field is required");
                    Toast.makeText(PhoneNumberActivity.this, "Please enter your phone number to preceed further", Toast.LENGTH_SHORT).show();
                }else if (phoneNumber.length()==10){
                    binding.phone.setError("Include Country Code");
                    Toast.makeText(PhoneNumberActivity.this, "Include Country Code", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(PhoneNumberActivity.this,OTPActivity.class);
                    intent.putExtra("phoneNumber",phoneNumber);
                    startActivity(intent);
                }
            }
        });
    }
}