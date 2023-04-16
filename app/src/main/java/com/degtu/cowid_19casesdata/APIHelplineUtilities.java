package com.degtu.cowid_19casesdata;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIHelplineUtilities {

    public static Retrofit retrofit = null;

    public static APIHelplineNumbers getapihelpline(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(APIHelplineNumbers.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(APIHelplineNumbers.class);
    }
}
