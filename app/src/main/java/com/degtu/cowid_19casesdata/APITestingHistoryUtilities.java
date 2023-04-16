package com.degtu.cowid_19casesdata;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APITestingHistoryUtilities {

    public static Retrofit retrofit = null;

    public static APITestingHistory gettesting(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(APITestingHistory.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(APITestingHistory.class);
    }
}
