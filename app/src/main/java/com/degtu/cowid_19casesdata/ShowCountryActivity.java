package com.degtu.cowid_19casesdata;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.os.ConfigurationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.anychart.anychart.Geo;
import com.anychart.anychart.Item;
import com.degtu.cowid_19casesdata.databinding.ActivityShowCountryBinding;
import com.degtu.cowid_19casesdata.databinding.CountryItemBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowCountryActivity extends AppCompatActivity {

    ActivityShowCountryBinding binding;
    Adapter adapter;
    private List<CountryData> countryData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowCountryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        countryData = new ArrayList<>();
        adapter = new Adapter(this,countryData);
        binding.countries.setLayoutManager(new LinearLayoutManager(this));
        binding.countries.setHasFixedSize(true);
        binding.countries.setAdapter(adapter);

        binding.searchcountry.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

        APIUtilities.getAPIinterface().getCountryData().enqueue(new Callback<List<CountryData>>() {
            @Override
            public void onResponse(Call<List<CountryData>> call, Response<List<CountryData>> response) {
                assert response.body() != null;
                try {
                    countryData.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<List<CountryData>> call, Throwable t) {
                Toast.makeText(ShowCountryActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void filterList(String newText) {
        List<CountryData> countryData1 = new ArrayList<>();
        for (CountryData countryData : countryData){
            if (countryData.getCountry().toLowerCase().contains(newText.toLowerCase())){
                countryData1.add(countryData);
            }
        }

        if (countryData1.isEmpty()){
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }else {
            adapter.setCountryData(countryData1);
        }
    }
}