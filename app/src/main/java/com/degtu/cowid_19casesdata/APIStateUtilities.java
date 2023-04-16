package com.degtu.cowid_19casesdata;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIStateUtilities {

    public static Retrofit retrofit = null;

    public static APIStateInterface getapistateinterface(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(APIStateInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(APIStateInterface.class);
    }
}
