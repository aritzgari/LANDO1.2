package com.company.LN;

import com.company.LD.clsDatos;
import com.company.LD.clsLibreria_MultimediaBD;
//import com.company.Común.clsConstantes;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public static void crearLiberia(int idLibreria_Multimedia, String Nombre, String Descripcion) /*Excepcion no tratadathrows SQLException */ {
        /**
         * Metodo para crear Librerias en el Gestor con datos que recibamos de LP
         * @author RubenD AritzG
         */
        //UPDATE 05/04: Aqui creamos la query con los parametros que nos pasan a este metodo;
        //con esta query llamamos a clsLibreriaMultimediaBD.sendInsert(query)
        //QUE PASA, que el id es AutoIncremental, asique igual conviene mandar la query sin el AutoIncremental,
        // y este añadirlo con el retorno (L39) del metodo de clsLibreriaMultimediaBD.sendInsert.
        // (mas bien se añadirá solo)
        //La siguiente linea convendría que fuera una constante:
        String query = "insert into Libreria_Multimedia (idLibreria_Multimedia, Nombre, Descripcion) values (?, ?, ?)";
        clsLibreria_MultimediaBD objLibreria_MultimediaBD = new clsLibreria_MultimediaBD(Nombre, Descripcion);
        //objLibreria_MultimediaBD.sendInsert(queryInsertLibreria);
        objLibreria_MultimediaBD.sendInsert("insert into Libreria_Multimedia (idLibreria_Multimedia, Nombre, Descripcion) values (?, ?, ?)");
        /*try {

            objLibreria_MultimediaBD.getObjSt().setString(2, Nombre);
            objLibreria_MultimediaBD.getObjSt().setString(3, Descripcion);
            objLibreria_MultimediaBD.sendInsert(query);
        } catch (SQLException e) {
            System.out.println("ERROR FATAL DE SQL");
        }*/

        //10/04/2019: Quito esto siguiente porque lo haremos con el nuevo metodo: (4 lineas)
        /*clsLibreriaMultimedia objLibreria;
        //Esto habrá que cambiarlo porque no podemos crear las librerias en la RAM con el id proporcionado.
        objLibreria = new clsLibreriaMultimedia(idLibreria_Multimedia, Nombre, Descripcion);
        datosLibrerias.add(objLibreria);*/

        //Vale, aquí, que esto es LN, voy a crear un objGestorLD, creo que esto se puede hacer,
        // y con este obj voy a intentar añadir las librerias directamente a la BBDD. Ni yo me creo lo que digo, pero en teoría esto está bien.

        //METODO ANTIGUO:
        /* clsDatos objDatos = new clsDatos();
        objDatos.insertarLiberiaBD(idLibreria_Multimedia, Nombre, Descripcion);*/
        //FIN METODO ANTIGUO
    }

    public static void crearPelicula(String Titulo, String Titulo_original, String Anno_de_publicacion, String Tipo_DoA, String Formato, boolean En_propiedad, boolean En_busqueda, double Precio, String Genero, String Premios, String Director, String Enlace_a_trailer, String Sinopsis, int Cantidad_actores, String Actor1, String Actor2, String Actor3, String Saga, Double Orden, int Duracion, int Calporedad, int Calificacion, int Libreria_Multimedia_idLibreria_Multimedia) {
        /**
         * Metodo para crear peliculas en el Gestor con datos que recibamos de LP
         * @author RubenD AritzG
         */
        clsPelicula objPelicula;
        objPelicula = new clsPelicula(Director, Enlace_a_trailer, Sinopsis, Cantidad_actores, Actor1, Actor2, Actor3, Saga, Orden, Duracion, Calporedad, Calificacion, Libreria_Multimedia_idLibreria_Multimedia);
        //LINEA PARA PROBAR EXCEPCION - BORRAR AL ACABAR
        //objPelicula.getBooleanProperty("PropiedadMAL");
        //LINEA PARA PROBAR EXCEPCION - BORRAR AL ACABAR
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

    public ResultSet consultarLibreriasEnBD() {
        ResultSet retorno = null;
        clsLibreria_MultimediaBD objLibreria_MultimediaBD = new clsLibreria_MultimediaBD();
        //Ojo aquí la query como constante:
        retorno = objLibreria_MultimediaBD.sendSelect("SELECT * FROM lando.libreria_multimedia;");
        return retorno;
    }
}
