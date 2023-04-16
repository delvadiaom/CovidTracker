package com.degtu.cowid_19casesdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.degtu.cowid_19casesdata.databinding.ActivityHelplineNumberBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HelplineNumberActivity extends AppCompatActivity {

    ActivityHelplineNumberBinding binding;
    HelplineNumberAdapter helplineNumberAdapter;
    private List<HelplineNumberData> helplineNumberData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHelplineNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        helplineNumberData = new ArrayList<HelplineNumberData>();
        helplineNumberAdapter = new HelplineNumberAdapter(this,helplineNumberData);
        binding.helplinenumers.setLayoutManager(new LinearLayoutManager(this));
        binding.helplinenumers.setHasFixedSize(true);
        binding.helplinenumers.setAdapter(helplineNumberAdapter);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        APIHelplineUtilities.getapihelpline().getHelplineNumber().enqueue(new Callback<List<HelplineNumberData>>() {
            @Override
            public void onResponse(Call<List<HelplineNumberData>> call, Response<List<HelplineNumberData>> response) {
                assert response.body() != null;
                try {
                    helplineNumberData.addAll(response.body());
                    helplineNumberAdapter.notifyDataSetChanged();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<HelplineNumberData>> call, Throwable t) {

            }
        });

    }
}