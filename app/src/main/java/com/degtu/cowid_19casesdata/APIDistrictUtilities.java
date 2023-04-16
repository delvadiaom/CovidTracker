package com.degtu.cowid_19casesdata;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIDistrictUtilities {

    public static Retrofit retrofit = null;

    public static APIDistrict getdistrictinterface(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(APIDistrict.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(APIDistrict.class);
    }
}
