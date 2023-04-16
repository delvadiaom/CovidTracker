package com.degtu.cowid_19casesdata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIStateInterface {

    static final String BASE_URL = "https://data.covid19india.org/";

    @GET("data.json")
    Call<mainStates> getStateData();
}
