package es.studium.filmingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PeliculasImagenDetalles extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_imagen_detalles);

        ImageView imgPeli = findViewById(R.id.peliculaImagenDetalle);
        imgPeli.setOnClickListener(this);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        if (bundle != null)
        {
            imgPeli.setImageResource(bundle.getInt("peliculaImagenDetalle"));
        }
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId()==R.id.peliculaImagenDetalle)
        {
            finish();
        }
    }
}