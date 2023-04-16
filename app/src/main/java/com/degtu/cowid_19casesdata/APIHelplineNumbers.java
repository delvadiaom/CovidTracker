package com.degtu.cowid_19casesdata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIHelplineNumbers {

    static final String BASE_URL = "https://run.mocky.io/v3/";

    @GET("9a27b494-94bf-4abb-a9fb-13d96a24b3e5")
    Call<List<HelplineNumberData>> getHelplineNumber();
}
