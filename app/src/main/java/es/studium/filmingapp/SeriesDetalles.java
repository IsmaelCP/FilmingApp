package es.studium.filmingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SeriesDetalles extends AppCompatActivity implements View.OnClickListener
{
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_detalles);

        ImageView imgSerie = (ImageView) findViewById(R.id.imgSerieDetalle);
        TextView tituloSerie = (TextView) findViewById(R.id.txtTituloSerieDetalle);
        TextView directorSerie = (TextView) findViewById(R.id.director_detalle_serie);
        TextView repartoSerie = (TextView) findViewById(R.id.reparto_detalle_serie);
        TextView sinopsiSerie = (TextView) findViewById(R.id.sinopsi_detalle_serie);
        TextView temporadaSerie = (TextView) findViewById(R.id.temporada_detalle_serie);
        ImageView imgClasificacion = (ImageView) findViewById(R.id.clasificacion_detalle_serie);
        Button btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(this);

        String director = getString(R.string.director);
        String reparto = getString(R.string.reparto);
        String sinopsis = getString(R.string.sinopsis);
        String temporadas = getString(R.string.temporadas);

        Intent intent = getIntent();

        bundle = intent.getExtras();
        if (bundle != null) {
            tituloSerie.setText(bundle.getString("txtTituloSerieDetalle"));
            imgSerie.setImageResource(bundle.getInt("imgSerieDetalle"));
            directorSerie.setText(director + " -> " + bundle.getString("director_detalle_serie"));
            repartoSerie.setText(reparto + " -> " + bundle.getString("reparto_detalle_serie"));
            sinopsiSerie.setText(sinopsis + " -> " + bundle.getString("sinopsi_detalle_serie"));
            temporadaSerie.setText(temporadas + " -> " + bundle.getString("temporada_detalle_serie"));
            imgClasificacion.setImageResource(bundle.getInt("clasificacion_detalle_serie"));
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
