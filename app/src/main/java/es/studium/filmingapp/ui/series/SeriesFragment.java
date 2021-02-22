package es.studium.filmingapp.ui.series;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.studium.filmingapp.R;
import es.studium.filmingapp.Series;
import es.studium.filmingapp.SeriesAdapter;
import es.studium.filmingapp.SeriesDetalles;
import es.studium.filmingapp.SeriesImagenDetalles;
import es.studium.filmingapp.SeriesInterface;

public class SeriesFragment extends Fragment
{
    private SeriesInterface seriesInterface;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private java.util.List<Series> datos;
    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_serie, container, false);
        datos = new ArrayList<>();
        datos.add(new Series(R.drawable.cuentame, "Cuéntame", "Agustín Crespi", "Imanol Arias, Ana Duato, María Galiana, Pablo Rivero, Irene Visedo, ...", "La historia está narrada desde la perspectiva ya madura de Carlos, el hijo menor de la familia, que evoca en tono de humor unas décadas de transformación. «Cuéntame» es la crónica humana y cotidiana del pasado inmediato de España, que busca retratar la memoria colectiva de un país.", "21", R.drawable.cincoestrellas));
        datos.add(new Series(R.drawable.dead, "The walking dead", "Frank Darabont", "Andrew Lincoln, Jon Bernthal, Sarah Wayne Callies, Laure Holden, ...", "Seremos testigo de la lucha de un grupo de supervivientes por mantenerse a salvo en este entorno infestado de zombis o, como ellos prefieren llamarlos, caminantes. Nuestro protagonista, Rick Grimes es un policía que despierta de un estado comatoso y encuentra este desolador panorama.", "10", R.drawable.cincoestrellas));
        datos.add(new Series(R.drawable.house, "House", "David Shore", "Hugh Laurie, Lisa Edelstein, Omar Epps, Robert Sean Leonard, ...", "El personaje central es el Dr. Gregory House (Hugh Laurie), un médico poco convencional, malhumorado, borde, misántropo, ególatra y adicto a la vicodina que evita el trato directo con sus pacientes y encabeza un equipo de diagnóstico en el ficticio Hospital Universitario Princeton-Plainsboro de Nueva Jersey.", "8", R.drawable.cincoestrellas));
        datos.add(new Series(R.drawable.serranos, "Los serrano", "Daniel Écija y Álex Pina", "Antonio Resines, Belén Rueda,Jesús Bonilla, Verónica Sánchez, Fran Perea, ...", "Diego Serrano es un padre viudo de familia al cargo de sus tres hijos, Marcos, Guille y Curro. ... Después de casarse, las dos familias tendrán que convivir bajo el mismo techo y están obligados a entenderse, a pesar de que, van a surgir muchos obstáculos en la convivencia.", "8", R.drawable.cuatroestrellas));
        datos.add(new Series(R.drawable.casapapel, "La casa de papel", "Álex Pina", "Úrsula Corberó, Itziar Ituño, Paco Tous, Álvaro Montes, ...", "La casa de papel cuenta la historia de un atraco perfecto, el más grande y sofisticado de la historia, en la Fábrica de Moneda y Timbre. Quien idea este plan es El Profesor, lleva años diseñando hasta el más mínimo detalle y nada tiene que fallar.", "2", R.drawable.tresestrellas));
        datos.add(new Series(R.drawable.hombrespaco, "Los hombres de Paco", "Daniel Écija y Álex Pina", "Paco Tous, Hugo Silva, Pepón Nieto, Juan Diego, ...", "Paco Miranda es un inspector jefe de policía, de carácter bonachón e incapaz de enfrentarse a las situaciones de crisis, que trabaja junto a sus dos hombres de confianza: los agentes Mariano y Lucas.", "9", R.drawable.tresestrellas));

        // Obtenemos el Recycler
        recycler = (RecyclerView) rootView.findViewById(R.id.myRecyclerViewSeries);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        //Crear un nuevo adaptador
        adapter = new SeriesAdapter(datos, seriesInterface);
        recycler.setAdapter(adapter);

        setupRecyclerView();
        return rootView;
    }

    private void setupRecyclerView()
    {
        RecyclerView recyclerView = recycler.findViewById(R.id.myRecyclerViewSeries);
        recyclerView.setAdapter(new SeriesAdapter(datos, new SeriesInterface()
        {
            @Override
            public void onClick(View v, int position)
            {
                if (v.getId()==R.id.tituloSerie)
                {
                    Intent seriesDetalles = new Intent(rootView.getContext(), SeriesDetalles.class);
                    seriesDetalles.putExtra("imgSerieDetalle", datos.get(position).getImagen());
                    seriesDetalles.putExtra("txtTituloSerieDetalle", datos.get(position).getTitulo());
                    seriesDetalles.putExtra("director_detalle_serie", datos.get(position).getDirector());
                    seriesDetalles.putExtra("reparto_detalle_serie", datos.get(position).getReparto());
                    seriesDetalles.putExtra("sinopsi_detalle_serie", datos.get(position).getSinopsi());
                    seriesDetalles.putExtra("temporada_detalle_serie", datos.get(position).getTemporadas());
                    seriesDetalles.putExtra("clasificacion_detalle_serie", datos.get(position).getClasificacion());
                    startActivity(seriesDetalles);
                }

                if (v.getId()==R.id.imgSerie)
                {
                    Intent seriesImagenDetalles = new Intent(rootView.getContext(), SeriesImagenDetalles.class);
                    seriesImagenDetalles.putExtra("serieImagenDetalle", datos.get(position).getImagen());
                    startActivity(seriesImagenDetalles);
                }
            }
        }));
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
    }
}