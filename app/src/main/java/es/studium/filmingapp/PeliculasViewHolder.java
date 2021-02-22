package es.studium.filmingapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class PeliculasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public ImageView imagen;
    public TextView titulo;
    private final PeliculasInterface listener;

    public PeliculasViewHolder(@NonNull View itemView, @NonNull PeliculasInterface listener)
    {
        super(itemView);
        imagen = (ImageView) itemView.findViewById(R.id.imgPelic);
        titulo = (TextView) itemView.findViewById(R.id.tituloPelic);
        imagen.setOnClickListener(this);
        titulo.setOnClickListener(this);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void bindRow(Peliculas peliculas)
    {
        imagen.setImageResource(peliculas.getImagen());
        titulo.setText(peliculas.getTitulo());
    }

    @Override
    public void onClick(View v){
        listener.onClick(v, getAdapterPosition());
    }
}
