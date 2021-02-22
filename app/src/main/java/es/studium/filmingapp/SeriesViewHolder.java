package es.studium.filmingapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SeriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView imagen;
    public TextView titulo;
    private final SeriesInterface listener;

    public SeriesViewHolder(@NonNull View itemView, @NonNull SeriesInterface listener)
    {
        super(itemView);
        imagen = (ImageView) itemView.findViewById(R.id.imgSerie);
        titulo = (TextView) itemView.findViewById(R.id.tituloSerie);
        imagen.setOnClickListener(this);
        titulo.setOnClickListener(this);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void bindRow(Series series)
    {
        imagen.setImageResource(series.getImagen());
        titulo.setText(series.getTitulo());
    }

    @Override
    public void onClick(View v){
        listener.onClick(v, getAdapterPosition());
    }
}
