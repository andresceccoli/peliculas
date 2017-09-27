package com.androidutn.peliculas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.androidutn.peliculas.model.Pelicula;
import com.androidutn.peliculas.sample.SampleData;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PeliculaActivity extends AppCompatActivity {

    public static final String EXTRA_ID_PELICULA = "idPelicula";

    @BindView(R.id.pelicula_poster) ImageView mPoster;
    @BindView(R.id.pelicula_titulo) TextView mTitulo;
    @BindView(R.id.pelicula_fecha) TextView mFecha;
    @BindView(R.id.pelicula_rating) RatingBar mRating;
    @BindView(R.id.pelicula_rating_valor) TextView mRatingValor;
    @BindView(R.id.pelicula_resumen) TextView mResumen;
    @BindView(R.id.pelicula_idioma) TextView mIdioma;
    @BindView(R.id.pelicula_duracion) TextView mDuracion;

    private int idPelicula;
    private Pelicula pelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);

        ButterKnife.bind(this);

        idPelicula = getIntent().getIntExtra(EXTRA_ID_PELICULA, -1);
        if (idPelicula == -1) {
            finish();
            return;
        }

        // TODO: 26/09/2017 reemplazar por id de pelicula
        pelicula = SampleData.getPeliculas().get(idPelicula);
        cargarValores();
    }

    private void cargarValores() {
        mTitulo.setText(pelicula.getTitulo());
        mFecha.setText(pelicula.getFecha());
        mRating.setRating((float) pelicula.getPuntaje());
        mRatingValor.setText("" + pelicula.getPuntaje());
        mResumen.setText(pelicula.getResumen());

        mIdioma.setText(pelicula.getIdioma());
        mDuracion.setText(pelicula.getDuracion() + " mins");

        Picasso.with(this)
                .load(pelicula.getImagenUrl())
                .into(mPoster);
    }
}
