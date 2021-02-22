package es.studium.filmingapp.ui.pelicula;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.studium.filmingapp.Peliculas;
import es.studium.filmingapp.PeliculasAdapter;
import es.studium.filmingapp.PeliculasDetalles;
import es.studium.filmingapp.PeliculasImagenDetalles;
import es.studium.filmingapp.PeliculasInterface;
import es.studium.filmingapp.R;

public class PeliculaFragment extends Fragment
{
    private PeliculasInterface peliculasInterface;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    public static java.util.List<Peliculas> datos;
    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_pelicula, container, false);
        datos = new ArrayList<>();
        datos.add(new Peliculas(R.drawable.anillos, "El señor de los Anillos: El Retorno del Rey", "Peter Jackson", "Elijah Wood, Ian McKellen, Viggo Mortensen, Orlando Bloom, ...", "Hombres, elfos y enanos unen sus fuerzas para presentar batalla a Sauron y sus huestes. Ajenos a estos preparativos, Frodo y Sam siguen adentrándose en el país de Mordor en su heroico viaje para destruir el Anillo de Poder en las Grietas del Destino.", R.drawable.cincoestrellas));
        datos.add(new Peliculas(R.drawable.avatar, "Avatar", "James Cameron", "Sam Worthington, Zoe Saldaña, Sigourney Weaver, Stephen Lang y Michelle Rodríguez.", "AVATAR nos lleva a un mundo situado más allá de la imaginación, en donde un recién llegado de la Tierra se embarca en una aventura épica, llegando a luchar, al final, por salvar el extraño mundo al que ha aprendido a llamar su hogar.", R.drawable.cincoestrellas));
        datos.add(new Peliculas(R.drawable.ryan, "Salvar al soldado Ryan", "Steven Spielberg", "Tom Hanks, tom Sizemore, Edward Burns, Matt Damon, Giovanni Ribisi, ...", "Tras el desembarco de Normandía durante la Segunda Guerra Mundial, un grupo de soldados americanos es elegido para llevar a cabo su última misión: salvar a un solo hombre que se encuentra al otro lado de las líneas enemigas.", R.drawable.cincoestrellas));
        datos.add(new Peliculas(R.drawable.titanic, "Titanic","James Cameron", "Leonardo DiCaprio, Kate Winslet, Billy Zane, ...", "Un joven artista, en una partida de cartas gana un pasaje para América, en el Titanic, el trasatlántico más grande y seguro jamás construido. ... Jack y Rose se enamoran, pero Cal y la madre de Rose ponen todo tipo de trabas a su relación.", R.drawable.cincoestrellas));
        datos.add(new Peliculas(R.drawable.trescientos, "300", "Zack Snyder", "Gerard Butler, Lena Headey, David Wenham, ...", "300 describe la historia del Rey Espartano Leónidas (Gerard Butler) y sus 300 guerreros espartanos que pelearon a muerte contra el dios-rey persa Jerjes I y su ejército de más de 100.000 soldados.", R.drawable.cuatroestrellas));
        datos.add(new Peliculas(R.drawable.eli, "El libro de Eli", "Hermanos Hughes", "Denzel Washington, Gary Oldman, Mila Kunis, ...", "En un futuro no muy lejano, unos 30 años después de la guerra final, un hombre solitario camina sobre la desolada tierra que una vez fue los Estados Unidos. Ciudades vacías, autovías destrozadas, la tierra yerma. Todo a su alrededor denota la catástrofe de la destrucción total.", R.drawable.tresestrellas));

        // Obtenemos el Recycler
        recycler = (RecyclerView) rootView.findViewById(R.id.myRecyclerViewPeliculas);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        //Crear un nuevo adaptador
        adapter = new PeliculasAdapter(datos, peliculasInterface);
        recycler.setAdapter(adapter);

        setupRecyclerView();
        return rootView;
    }

    private void setupRecyclerView()
    {
        RecyclerView recyclerView = recycler.findViewById(R.id.myRecyclerViewPeliculas);
        recyclerView.setAdapter(new PeliculasAdapter(datos, new PeliculasInterface()
        {
            @Override
            public void onClick(View v, int position)
            {
                if (v.getId()==R.id.tituloPelic)
                {
                    Intent pelisDetalles = new Intent(rootView.getContext(), PeliculasDetalles.class);
                    pelisDetalles.putExtra("imgPeliculaDetalle", datos.get(position).getImagen());
                    pelisDetalles.putExtra("txtTituloPeliculaDetalle", datos.get(position).getTitulo());
                    pelisDetalles.putExtra("director_detalle_pelicula", datos.get(position).getDirector());
                    pelisDetalles.putExtra("reparto_detalle_pelicula", datos.get(position).getReparto());
                    pelisDetalles.putExtra("sinopsi_detalle_pelicula", datos.get(position).getSinopsi());
                    pelisDetalles.putExtra("clasificacion_detalle_pelicula", datos.get(position).getClasificacion());
                    startActivity(pelisDetalles);
                }

                if (v.getId()==R.id.imgPelic)
                {
                    Intent pelisImagenDetalles = new Intent(rootView.getContext(), PeliculasImagenDetalles.class);
                    pelisImagenDetalles.putExtra("peliculaImagenDetalle", datos.get(position).getImagen());
                    startActivity(pelisImagenDetalles);
                }
            }
        }));
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
    }
}