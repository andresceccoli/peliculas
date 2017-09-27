package com.androidutn.peliculas.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static final String API_KEY = "d2da804e735404f8f3601949d1779038";
    private static final String API_URL = "https://api.themoviedb.org/3/";

    private static Retrofit retrofit;

    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static MovieService getMovieService() {
        return retrofit.create(MovieService.class);
    }

}
