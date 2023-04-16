package com.degtu.cowid_19casesdata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {

    static final String BASE_URL = "https://disease.sh/v3/covid-19/";

   @GET("countries")
        Call<List<CountryData>> getCountryData();
        }
