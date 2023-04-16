package com.degtu.cowid_19casesdata;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIUtilities {

    public static Retrofit retrofit = null;

    public static APIinterface getAPIinterface(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(APIinterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(APIinterface.class);
    }
}

