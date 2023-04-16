package com.degtu.cowid_19casesdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.degtu.cowid_19casesdata.databinding.ActivityTestingHistoryBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestingHistoryActivity extends AppCompatActivity {

    ActivityTestingHistoryBinding binding;
    ArrayList<TestingHistoryData> testingHistoryDataArrayList;
    TestingHistoryAdapter testingHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestingHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        testingHistoryDataArrayList = new ArrayList<>();
        testingHistoryAdapter = new TestingHistoryAdapter(getApplicationContext(),testingHistoryDataArrayList);
        binding.testinghistorylist.setLayoutManager(new LinearLayoutManager(this));
        binding.testinghistorylist.setHasFixedSize(true);
        binding.testinghistorylist.setAdapter(testingHistoryAdapter);

        APITestingHistoryUtilities.gettesting().getTistingHistory().enqueue(new Callback<TestHistory>() {
            @Override
            public void onResponse(Call<TestHistory> call, Response<TestHistory> response) {
                assert response.body() != null;
                testingHistoryDataArrayList.addAll(response.body().getData());
                testingHistoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TestHistory> call, Throwable t) {

            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}