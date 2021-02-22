package es.studium.filmingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static es.studium.filmingapp.R.id.serieImagenDetalle;

public class SeriesImagenDetalles extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_imagen_detalles);

        ImageView imgPeli = findViewById(serieImagenDetalle);
        imgPeli.setOnClickListener(this);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        if (bundle != null)
        {
            imgPeli.setImageResource(bundle.getInt("serieImagenDetalle"));
        }
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId()==serieImagenDetalle)
        {
            finish();
        }
    }
}