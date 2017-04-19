package com.example.shivanshu.alumniconnect;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shivanshu on 2/22/2017.
 */

public class RetrofitObject {
    public static final String BASE_URL="http://192.168.43.118/Register/";

  public static MailChimpApi getRetrofitObject()

    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(MailChimpApi.class);
    }
}
