package com.example.navigationdrawer_2.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String Base_Url="http://192.168.1.110/";
    public static Retrofit retrofit=null;


    public static Retrofit getApiClient()
    {
        if(retrofit==null)
        {
            Gson gson= new GsonBuilder().setLenient().create();

            retrofit=new Retrofit.Builder().baseUrl(Base_Url).addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }
}
