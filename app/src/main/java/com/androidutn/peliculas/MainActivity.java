package com.androidutn.peliculas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidutn.peliculas.api.Api;
import com.androidutn.peliculas.model.TmdbQueryResult;
import com.androidutn.peliculas.sample.SampleData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLista = (RecyclerView) findViewById(R.id.lista);
        mLista.setLayoutManager(new LinearLayoutManager(this));

        PeliculaAdapter adapter = new PeliculaAdapter();
        //adapter.setPeliculas(SampleData.getPeliculas());

        mLista.setAdapter(adapter);

        buscarPeliculas("annabelle");
    }

    private void buscarPeliculas(String query) {
        Api.getMovieService().buscar(Api.API_KEY, query)
            .enqueue(new Callback<TmdbQueryResult>() {
                @Override
                public void onResponse(Call<TmdbQueryResult> call, Response<TmdbQueryResult> response) {
                    if (response.isSuccessful()) {
                        TmdbQueryResult result = response.body();
                        PeliculaAdapter adapter = (PeliculaAdapter) mLista.getAdapter();
                        adapter.setPeliculas(result.getResults());
                    }
                }

                @Override
                public void onFailure(Call<TmdbQueryResult> call, Throwable t) {

                }
            });
    }
}
