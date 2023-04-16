package com.degtu.cowid_19casesdata;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APITestingHistory {

    static final String BASE_URL = "https://api.rootnet.in/covid19-in/stats/testing/";

    @GET("history")
    Call<TestHistory> getTistingHistory();
}
