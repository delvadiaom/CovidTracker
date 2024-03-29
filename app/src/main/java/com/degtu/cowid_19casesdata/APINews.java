package com.degtu.cowid_19casesdata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public abstract interface APINews {

    public String BASE_URL = "https://newsapi.org/v2/";

    @GET("top-headlines")
    abstract Call<mainNews> getNews(
            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("category") String category,
            @Query("apiKey") String apikey
    );
}
