package es.studium.filmingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PeliculasDetalles extends AppCompatActivity implements View.OnClickListener
{
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_detalles);

        ImageView imgPeli = (ImageView) findViewById(R.id.imgPeliculaDetalle);
        TextView tituloPeli = (TextView) findViewById(R.id.txtTituloPeliculaDetalle);
        TextView directorPeli = (TextView) findViewById(R.id.director_detalle_pelicula);
        TextView repartoPeli = (TextView) findViewById(R.id.reparto_detalle_pelicula);
        TextView sinopsiPeli = (TextView) findViewById(R.id.sinopsi_detalle_pelicula);
        ImageView imgClasificacion = (ImageView) findViewById(R.id.clasificacion_detalle_pelicula);
        Button btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(this);

        String director = getString(R.string.director);
        String reparto = getString(R.string.reparto);
        String sinopsis = getString(R.string.sinopsis);

        Intent intent = getIntent();

        bundle = intent.getExtras();
        if (bundle != null) {
            tituloPeli.setText(bundle.getString("txtTituloPeliculaDetalle"));
            imgPeli.setImageResource(bundle.getInt("imgPeliculaDetalle"));
            directorPeli.setText(director + " -> " + bundle.getString("director_detalle_pelicula"));
            repartoPeli.setText(reparto + " -> " + bundle.getString("reparto_detalle_pelicula"));
            sinopsiPeli.setText(sinopsis + " -> " + bundle.getString("sinopsi_detalle_pelicula"));
            imgClasificacion.setImageResource(bundle.getInt("clasificacion_detalle_pelicula"));
        }
    }

    @Override
    public void onClick(View v)
    {
        // Botón VOLVER -> vuelve al listado de películas
        if (v.getId() == (R.id.btnVolver))
        {
            finish();
        }
    }
}


