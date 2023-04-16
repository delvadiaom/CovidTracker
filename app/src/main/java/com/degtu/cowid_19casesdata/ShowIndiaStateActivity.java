package com.degtu.cowid_19casesdata;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.degtu.cowid_19casesdata.databinding.ActivityShowIndiaStateBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowIndiaStateActivity extends AppCompatActivity {

    ActivityShowIndiaStateBinding binding;
    StateAdapter stateAdapter;
    List<StateCaseData> stateCaseDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowIndiaStateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        stateCaseDataList = new ArrayList<>();
        stateAdapter = new StateAdapter(this,stateCaseDataList);
        binding.states.setLayoutManager(new LinearLayoutManager(this));
        binding.states.setHasFixedSize(true);
        binding.states.setAdapter(stateAdapter);

        binding.searchstate.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });


        APIStateUtilities.getapistateinterface().getStateData().enqueue(new Callback<mainStates>() {
            @Override
            public void onResponse(Call<mainStates> call, Response<mainStates> response) {
                try {
                    stateCaseDataList.addAll(response.body().getStatewise());
                    stateAdapter.notifyDataSetChanged();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<mainStates> call, Throwable t) {
                Toast.makeText(ShowIndiaStateActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void filterList(String newText) {
        List<StateCaseData> stateCaseDataList1 = new ArrayList<>();
        for (StateCaseData stateCaseData : stateCaseDataList){
            if (stateCaseData.getState().toLowerCase().contains(newText.toLowerCase())){
                stateCaseDataList1.add(stateCaseData);
            }
        }

        if (stateCaseDataList1.isEmpty()){
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }else {
            stateAdapter.setStateCaseDataList(stateCaseDataList1);
        }
    }
}