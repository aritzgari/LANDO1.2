package com.company.LN;

import java.util.ArrayList;

/**
 * Clase que intercomunica LP con LN
 *
 * @author RubenD AritzG
 */

public class clsGestorLN {

    private static ArrayList<clsPelicula> datosPeliculas;
    private static ArrayList<clsLibro> datosLibros;
    private static ArrayList<clsMusica> datosMusicas;
    private static ArrayList<clsArticulo> datosArticulos;

    public clsGestorLN() {
        datosPeliculas = new ArrayList<clsPelicula>();
        datosLibros = new ArrayList<clsLibro>();
        datosMusicas = new ArrayList<clsMusica>();
        datosArticulos = new ArrayList<clsArticulo>();

    }

    public static ArrayList<clsPelicula> getDatosPeliculas() {
        return datosPeliculas;
    }

    public static ArrayList<clsLibro> getDatosLibros() {
        return datosLibros;
    }

    public static ArrayList<clsMusica> getDatosMusicas() {
        return datosMusicas;
    }

    public static ArrayList<clsArticulo> getDatosArticulos() {

        return datosArticulos;
    }

    public static void crearPelicula(String Titulo, String Titulo_original, String Anno_de_publicacion, String Tipo_DoA, String Formato, boolean En_propiedad, boolean En_busqueda, double Precio, String Genero, String Premios, String Director, String Enlace_a_trailer, String Sinopsis, int Cantidad_actores, String Actor1, String Actor2, String Actor3, String Saga, Double Orden, int Duracion, int Calporedad, int Calificacion) {
        /**
         * Metodo para crear peliculas en el Gestor con datos que recibamos de LP
         * @author RubenD AritzG
         */
        clsPelicula objPelicula;
        objPelicula = new clsPelicula(Director,Enlace_a_trailer,Sinopsis,Cantidad_actores,Actor1,Actor2,Actor3,Saga,Orden,Duracion,Calporedad,Calificacion);
        datosArticulos.add(objPelicula);
    }

    public static void crearLibro(String Titulo, String Titulo_original, String Anno_de_publicacion, String Tipo_DoA, String Formato, boolean En_propiedad, boolean En_busqueda, double Precio, String Genero, String Premios, String Autor, String Resumen, String Editorial, boolean Serie_SoN, String Nombre_serie, double Orden_serie, String ISBN, int Paginas) {
        /**
         * Metodo para crear Libros en el Gestor con datos que recibamos de LP
         * @author RubenD AritzG
         */
        clsLibro objLibro;
        objLibro = new clsLibro();
        datosArticulos.add(objLibro);
    }

    public static void crearMusica(String Titulo, String Titulo_original, String Anno_de_publicacion, String Tipo_DoA, String Formato, boolean En_propiedad, boolean En_busqueda, double Precio, String Genero, String Premiosint, int Cantidad_musicos, String Musico1, String Musico2, String Musico3, String Musico4, String Musico5, String Album, String Enlace_a_youtube, boolean Videoclip) {
        /**
         * Metodo para crear Musica en el Gestor con datos que recibamos de LP
         * @author RubenD AritzG
         */
        clsMusica objMusica;
        objMusica = new clsMusica();
        datosArticulos.add(objMusica);
    }
}
