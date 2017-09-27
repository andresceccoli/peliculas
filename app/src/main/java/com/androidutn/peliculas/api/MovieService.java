package com.androidutn.peliculas.api;

import com.androidutn.peliculas.model.TmdbQueryResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET("search/movie")
    Call<TmdbQueryResult> buscar(
            @Query("api_key") String apiKey,
            @Query("query") String query);

}
