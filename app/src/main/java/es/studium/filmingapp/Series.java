package es.studium.filmingapp;

import java.io.Serializable;

public class Series
{
    // Gestiona los datos de las películas: Imagen - Título - Director - Reparto - Sinopsis - clasificación
        private int imagen;
        private String titulo;
        private String director;
        private String reparto;
        private String sinopsi;
        private String temporadas;
        private int clasificacion;

        // Constructor para cuando instanciemos desde cada elemento
        public Series(int imagen, String titulo, String director, String reparto, String sinopsi, String temporadas, int clasificacion)
        {
            this.imagen = imagen;
            this.titulo = titulo;
            this.director = director;
            this.reparto = reparto;
            this.sinopsi = sinopsi;
            this.temporadas = temporadas;
            this.clasificacion = clasificacion;
        }

        public int getImagen(){return imagen;}
        public String getTitulo(){return titulo;}
        public String getDirector(){return director;}
        public String getReparto(){return reparto;}
        public String getSinopsi(){return sinopsi;}
        public String getTemporadas(){return temporadas;}
        public int getClasificacion(){return clasificacion;}
}
