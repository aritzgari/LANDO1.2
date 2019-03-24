package com.company.LN;

import com.company.LD.clsDatos;

import java.util.ArrayList;

/**
 * Clase que intercomunica LP con LN
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsGestorLN {

    /*Los arrays que contienen los datos de los diferentes articulos*/

    private static ArrayList<clsPelicula> datosPeliculas;
    private static ArrayList<clsLibro> datosLibros;
    private static ArrayList<clsMusica> datosMusicas;
    //Estos tres de arriba, para mi que no los usamos.
    private static ArrayList<clsArticulo> datosArticulos;
    private static ArrayList<clsLibreriaMultimedia> datosLibrerias;

    public clsGestorLN() {
        datosPeliculas = new ArrayList<clsPelicula>();
        datosLibros = new ArrayList<clsLibro>();
        datosMusicas = new ArrayList<clsMusica>();
        datosArticulos = new ArrayList<clsArticulo>();
        datosLibrerias = new ArrayList<clsLibreriaMultimedia>();

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

    public static void crearLiberia(int idLibreria_Multimedia, String Nombre, String Descripcion) {
        /**
         * Metodo para crear Librerias en el Gestor con datos que recibamos de LP
         * @author RubenD AritzG
         */
        clsLibreriaMultimedia objLibreria;
        objLibreria = new clsLibreriaMultimedia(idLibreria_Multimedia, Nombre, Descripcion);
        datosLibrerias.add(objLibreria);
        //Vale, aquí, que esto es LN, voy a crear un objGestorLD, creo que esto se puede hacer,
        // y con este obj voy a intentar añadir las pelis directamente a la BBDD. Ni yo me creo lo que digo, pero en teoría esto está bien.
        clsDatos objDatos = new clsDatos();
        objDatos.insertarLiberiaBD(idLibreria_Multimedia, Nombre, Descripcion);
    }

    public static void crearPelicula(String Titulo, String Titulo_original, String Anno_de_publicacion, String Tipo_DoA, String Formato, boolean En_propiedad, boolean En_busqueda, double Precio, String Genero, String Premios, String Director, String Enlace_a_trailer, String Sinopsis, int Cantidad_actores, String Actor1, String Actor2, String Actor3, String Saga, Double Orden, int Duracion, int Calporedad, int Calificacion, int Libreria_Multimedia_idLibreria_Multimedia) {
        /**
         * Metodo para crear peliculas en el Gestor con datos que recibamos de LP
         * @author RubenD AritzG
         */
        clsPelicula objPelicula;
        objPelicula = new clsPelicula(Director, Enlace_a_trailer, Sinopsis, Cantidad_actores, Actor1, Actor2, Actor3, Saga, Orden, Duracion, Calporedad, Calificacion, Libreria_Multimedia_idLibreria_Multimedia);
        datosArticulos.add(objPelicula);
        //Vale, aquí, que esto es LN, voy a crear un objGestorLD, creo que esto se puede hacer,
        // y con este obj voy a intentar añadir las pelis directamente a la BBDD. Ni yo me creo lo que digo, pero en teoría esto está bien.
        clsDatos objDatos = new clsDatos();
        objDatos.insertarPeliculaBD(Titulo, Integer.parseInt(Anno_de_publicacion), Integer.toString(Duracion), Calificacion, Calporedad, Libreria_Multimedia_idLibreria_Multimedia);
    }

    public static void crearLibro(String Titulo, String Titulo_original, String Anno_de_publicacion, String Tipo_DoA, String Formato, boolean En_propiedad, boolean En_busqueda, double Precio, String Genero, String Premios, String Autor, String Resumen, String Editorial, boolean Serie_SoN, String Nombre_serie, double Orden_serie, String ISBN, int Paginas) {
        /**
         * Metodo para crear Libros en el Gestor con datos que recibamos de LP
         * @author RubenD AritzG
         */
        clsLibro objLibro;
        objLibro = new clsLibro(/*Titulo, Titulo_original, Anno_de_publicacion, Tipo_DoA, Formato,En_propiedad, En_busqueda, Precio, Genero, Premiosint,*/Autor, Resumen, Editorial, Serie_SoN, Nombre_serie, Orden_serie, ISBN, Paginas);
        datosArticulos.add(objLibro);
    }

    public static void crearMusica(String Titulo, String Titulo_original, String Anno_de_publicacion, String Tipo_DoA, String Formato, boolean En_propiedad, boolean En_busqueda, double Precio, String Genero, String Premiosint, int Cantidad_musicos, String Musico1, String Musico2, String Musico3, String Musico4, String Musico5, String Album, String Enlace_a_youtube, boolean Videoclip) {
        /**
         * Metodo para crear Musica en el Gestor con datos que recibamos de LP
         * @author RubenD AritzG
         */
        clsMusica objMusica;
        objMusica = new clsMusica(/*Titulo, Titulo_original, Anno_de_publicacion, Tipo_DoA, Formato,En_propiedad, En_busqueda, Precio, Genero, Premiosint,*/ Cantidad_musicos, Musico1, Musico2, Musico3, Musico4, Musico5, Album, Enlace_a_youtube, Videoclip);
        datosArticulos.add(objMusica);
    }
}
