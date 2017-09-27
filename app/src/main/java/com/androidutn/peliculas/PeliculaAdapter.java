package com.androidutn.peliculas;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.androidutn.peliculas.model.Pelicula;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Instructor on 19/09/2017.
 */

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.PeliculaViewHolder> {

    private List<Pelicula> peliculas;

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
        notifyDataSetChanged();
    }

    @Override
    public PeliculaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pelicula, parent, false);
        return new PeliculaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PeliculaViewHolder holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        holder.setPelicula(pelicula);
    }

    @Override
    public int getItemCount() {
        return peliculas != null ? peliculas.size() : 0;
    }

    public class PeliculaViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_titulo) TextView mTitulo;
        @BindView(R.id.item_poster) ImageView mPoster;
        @BindView(R.id.item_fecha) TextView mFecha;
        @BindView(R.id.item_rating) RatingBar mRating;
        @BindView(R.id.item_rating_valor) TextView mRatingValor;
        @BindView(R.id.item_resumen) TextView mResumen;

        public PeliculaViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int idPelicula = getAdapterPosition();
                    Intent i = new Intent(view.getContext(), PeliculaActivity.class);
                    i.putExtra(PeliculaActivity.EXTRA_ID_PELICULA, idPelicula);
                    view.getContext().startActivity(i);
                }
            });
        }

        public void setPelicula(Pelicula p) {
            mTitulo.setText(p.getTitulo());
            mFecha.setText(p.getFecha());
            mRating.setRating((float) p.getPuntaje());
            mRatingValor.setText("" + p.getPuntaje());
            mResumen.setText(p.getResumen());

            Picasso.with(itemView.getContext())
                    .load(p.getImagenUrl())
                    .into(mPoster);
        }

    }

}
