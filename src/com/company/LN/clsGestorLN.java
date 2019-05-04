package com.company.LN;

//import com.company.LD.clsCompareLibreriaMultimedia;

import com.company.Comun.itfPropertyV2;
import com.company.LD.clsLibreria_MultimediaBD;
import com.company.LD.clsPeliculaBD;
import com.company.LD.clsLibrosBD;
import com.company.LD.clsDirectorBD;
import com.company.LD.clsActoresBD;
import com.company.LD.clsPremios_PeliculaBD;
import com.company.LD.clsGeneroPeliBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import static com.company.Comun.clsConstantes.queryConsultaLibreria;
import static com.company.Comun.clsConstantes.queryInsertLibreria;
import static com.company.Comun.clsConstantes.queryConsultaPelicula;
import static com.company.Comun.clsConstantes.queryInsertPelicula;
import static com.company.Comun.clsConstantes.queryConsultaLibro;
import static com.company.Comun.clsConstantes.queryInsertLibro;
import static com.company.Comun.clsConstantes.queryConsultaActores;
import static com.company.Comun.clsConstantes.queryInsertActores;
import static com.company.Comun.clsConstantes.queryConsultaDirector;
import static com.company.Comun.clsConstantes.queryInsertDirector;
import static com.company.Comun.clsConstantes.queryConsultaPremiosPeli;
import static com.company.Comun.clsConstantes.queryInsertPremiosPeli;
import static com.company.Comun.clsConstantes.queryConsultaGeneroPeli;
import static com.company.Comun.clsConstantes.queryInsertGeneroPeli;


/**
 * Clase que intercomunica LP con LN
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsGestorLN {

    /*Los arrays que contienen los datos de los diferentes articulos*/

    private static ArrayList<itfProperty> datosItf;
    private static ArrayList<itfPropertyV2> datosItfV2;
    private static ArrayList<clsPelicula> datosPeliculas;
    private static ArrayList<clsLibro> datosLibros;
    private static ArrayList<clsMusica> datosMusicas;
    //Estos tres de arriba, para mi que no los usamos.
    private static ArrayList<clsArticulo> datosArticulos;
    private ArrayList<clsLibreriaMultimedia> datosLibrerias;
    private static ArrayList<clsActor> datosActor;
    private static ArrayList<clsGeneroPeli> datosGeneroPeli;
    private static ArrayList<clsPremios> datosPremios;
    private static ArrayList<clsPremios_Pelicula> datosPremiosPeli;
    private static ArrayList<clsDirector> datosDirector;


    public clsGestorLN() {
        datosItf = new ArrayList<itfProperty>();
        datosItfV2 = new ArrayList<itfPropertyV2>();
        datosPeliculas = new ArrayList<clsPelicula>();
        datosLibros = new ArrayList<clsLibro>();
        datosMusicas = new ArrayList<clsMusica>();
        datosArticulos = new ArrayList<clsArticulo>();
        datosLibrerias = new ArrayList<clsLibreriaMultimedia>();
        datosActor = new ArrayList<clsActor>();
        datosGeneroPeli = new ArrayList<clsGeneroPeli>();
        datosPremios = new ArrayList<clsPremios>();
        datosPremiosPeli = new ArrayList<clsPremios_Pelicula>();
        datosDirector = new ArrayList<clsDirector>();
    }


    public static ArrayList<itfProperty> getDatosItf() {
        return datosItf;
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

    public ArrayList<clsLibreriaMultimedia> getDatosLibrerias() {
        return datosLibrerias;
    }

    public static ArrayList<clsActor> getDatosActor() {
        return datosActor;
    }

    public static ArrayList<clsGeneroPeli> getDatosGeneroPeli() {
        return datosGeneroPeli;
    }

    public static ArrayList<clsPremios> getDatosPremios() {
        return datosPremios;
    }

    public static ArrayList<clsPremios_Pelicula> getDatosPremiosPeli() {
        return datosPremiosPeli;
    }

    public static ArrayList<clsDirector> getDatosDirector() {
        return datosDirector;
    }

    public static void crearLibreria(/*int idLibreria_Multimedia, */String Nombre, String Descripcion) /*Excepcion no tratadathrows SQLException */ {
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
        clsLibreria_MultimediaBD objLibreria_MultimediaBD = new clsLibreria_MultimediaBD(Nombre, Descripcion);
        //objLibreria_MultimediaBD.sendInsert(queryInsertLibreria);
        objLibreria_MultimediaBD.sendInsert(queryInsertLibreria);
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


    public static void crearPelicula(int Libreria_Multimedia_idLibreria_Multimedia, String Titulo, String Titulo_original, int Anno_de_publicacion, int Duracion, int Calificacion, int Calporedad, String Tipo_DoA, double Precio, boolean En_propiedad, boolean En_busqueda, String Formato, String Saga, Double Orden, String Sinopsis, String Enlace_a_trailer) {
        /**
         * Metodo para crear peliculas en el Gestor con datos que recibamos de LP
         * @author RubenD AritzG
         */
        clsPeliculaBD objPeliculaBD = new clsPeliculaBD(Libreria_Multimedia_idLibreria_Multimedia, Titulo, Titulo_original, Anno_de_publicacion, Duracion, Calificacion, Calporedad, Tipo_DoA, Precio, En_propiedad, En_busqueda, Formato, Saga, Orden, Sinopsis, Enlace_a_trailer);
        objPeliculaBD.sendInsert(queryInsertPelicula);
    }

    public static void crearLibro(int Libreria_Multimedia_idLibreria_Multimedia, String ISBN, String Titulo, String Titulo_original, int Anno_de_publicacion, String Tipo_DoA, double Precio, boolean En_propiedad, boolean En_busqueda, String Formato, int Paginas, String Resumen, boolean Serie_SoN, String Nombre_serie, double Orden_serie, int idGenero, int idAutor) {
        /**
         * Metodo para crear Libros en el Gestor con datos que recibamos de LP
         * @author RubenD AritzG
         */
        clsLibrosBD objLibroBD = new clsLibrosBD(Libreria_Multimedia_idLibreria_Multimedia, ISBN, Titulo, Titulo_original, Anno_de_publicacion, Tipo_DoA, Precio, En_propiedad, En_busqueda, Formato, Paginas, Resumen, Serie_SoN, Nombre_serie, Orden_serie, idGenero, idAutor);
        objLibroBD.sendInsert(queryInsertLibro);
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

    public static void crearActor(String Nombre, String Apellido) {
        /**
         * Metodo para crear actores en el Gestor con datos que recibamos de LP
         *  @author RubenD AritzG
         */
        clsActoresBD objActorBD = new clsActoresBD(Nombre, Apellido);
        objActorBD.sendInsert(queryInsertActores);
    }

    public static void crearDirector(String Nombre, String Apellido) {

        clsDirectorBD objDirectorBD = new clsDirectorBD(Nombre, Apellido);
        objDirectorBD.sendInsert(queryInsertDirector);
    }

    public static void crearGeneroPeli(String Nombre) {

        clsGeneroPeliBD objGeneroPeliBD = new clsGeneroPeliBD(Nombre);
        objGeneroPeliBD.sendInsert(queryInsertGeneroPeli);
    }

    public static void crearPremiosPeli(String Nombre, String Categoria, int Anno) {

        clsPremios_PeliculaBD objPremiosPeliBD = new clsPremios_PeliculaBD(Nombre, Categoria, Anno);
        objPremiosPeliBD.sendInsert(queryInsertDirector);
    }

    public ArrayList<itfProperty> consultarActoresEnBD() {
        ResultSet resultado = null;

        //Declarado mas abajo, ignorar: clsLibreriaMultimedia objLibreriaMultimedia = new clsLibreriaMultimedia();
        clsActoresBD objActoresBD = new clsActoresBD();
        //En este metodo tendremos que crear librerias y asignarles de alguna manera los valores antes de cerrar la conexuión
        //Para ello:
        //...
        //ABRIR CONEXION:
        objActoresBD.conectarBD();
        resultado = objActoresBD.sendSelect(queryConsultaActores);
        //Meto rs en objeto
        try {
            while (resultado.next()) {
                clsActor objActores = new clsActor(resultado.getInt(1), resultado.getString(2), resultado.getString(3));
                datosActor.add(objActores);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
            System.out.println(e);
        }
        //Cierro conexion
        objActoresBD.desconectarBD(objActoresBD.getObjCon());

        return castclsActoresToItfProperty(datosActor);
    }

    public ArrayList<itfProperty> consultarDirectorEnBD() {
        ResultSet resultado = null;
        //Declarado mas abajo, ignorar: clsLibreriaMultimedia objLibreriaMultimedia = new clsLibreriaMultimedia();
        clsDirectorBD objDirectorBD = new clsDirectorBD();
        //En este metodo tendremos que crear librerias y asignarles de alguna manera los valores antes de cerrar la conexuión
        //Para ello:
        //...
        //ABRIR CONEXION:
        objDirectorBD.conectarBD();
        resultado = objDirectorBD.sendSelect(queryConsultaDirector);
        //Meto rs en objeto
        try {
            while (resultado.next()) {
                clsDirector objDirector = new clsDirector(resultado.getInt(1), resultado.getString(2), resultado.getString(3));
                datosDirector.add(objDirector);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
            System.out.println(e);
        }
        //Cierro conexion
        objDirectorBD.desconectarBD(objDirectorBD.getObjCon());

        return castclsDirectorToItfProperty(datosDirector);
    }

    public ArrayList<itfPropertyV2> consultarGeneroPeliEnBD() {
        ResultSet resultado = null;
        //Declarado mas abajo, ignorar: clsLibreriaMultimedia objLibreriaMultimedia = new clsLibreriaMultimedia();
        clsGeneroPeliBD objGeneroPeliBD = new clsGeneroPeliBD();
        //En este metodo tendremos que crear librerias y asignarles de alguna manera los valores antes de cerrar la conexuión
        //Para ello:
        //...
        //ABRIR CONEXION:
        objGeneroPeliBD.conectarBD();
        resultado = objGeneroPeliBD.sendSelect(queryConsultaGeneroPeli);
        //Meto rs en objeto
        try {
            while (resultado.next()) {
                clsGeneroPeli objGeneroPeli = new clsGeneroPeli(resultado.getInt(1), resultado.getString(2));
                datosGeneroPeli.add(objGeneroPeli);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
            System.out.println(e);
        }
        //Cierro conexion
        objGeneroPeliBD.desconectarBD(objGeneroPeliBD.getObjCon());

        return castclsGeneroPeliToItfProperty(datosGeneroPeli);
    }


    public ArrayList<itfProperty> consultarLibrosEnBD() {
        ResultSet resultado = null;

        //Declarado mas abajo, ignorar: clsLibreriaMultimedia objLibreriaMultimedia = new clsLibreriaMultimedia();
        clsLibrosBD objLibrosBD = new clsLibrosBD();
        //En este metodo tendremos que crear librerias y asignarles de alguna manera los valores antes de cerrar la conexuión
        //Para ello:
        //...
        //ABRIR CONEXION:
        objLibrosBD.conectarBD();
        resultado = objLibrosBD.sendSelect(queryConsultaLibro);
        //Meto rs en objeto
        try {
            while (resultado.next()) {
                clsLibro objLibros = new clsLibro(resultado.getInt(17), resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getInt(4), resultado.getString(5), resultado.getDouble(6), resultado.getBoolean(7), resultado.getBoolean(8), resultado.getString(9), resultado.getInt(10), resultado.getString(11), resultado.getBoolean(12), resultado.getString(13), resultado.getDouble(14), resultado.getInt(15), resultado.getInt(16));
                //Esto era para visualizar: System.out.println("id: " + resultado.getInt(1) + " Nombre: " + resultado.getString(2) + " Descripción: " + resultado.getString(3));
                datosLibros.add(objLibros);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
            System.out.println(e);
        }
        //Cierro conexion
        objLibrosBD.desconectarBD(objLibrosBD.getObjCon());

        return castclsLibroToItfProperty(datosLibros);
    }


    public ArrayList<itfProperty> consultarPeliculaEnBD() {
        ResultSet resultado = null;
        //Declarado mas abajo, ignorar: clsLibreriaMultimedia objLibreriaMultimedia = new clsLibreriaMultimedia();
        clsPeliculaBD objPeliculaBD = new clsPeliculaBD();
        //En este metodo tendremos que crear librerias y asignarles de alguna manera los valores antes de cerrar la conexuión
        //Para ello:
        //...
        //ABRIR CONEXION:
        objPeliculaBD.conectarBD();
        resultado = objPeliculaBD.sendSelect(queryConsultaPelicula);
        //Meto rs en objeto
        try {
            while (resultado.next()) {
                clsPelicula objPelicula = new clsPelicula(resultado.getInt(16), resultado.getString(1), resultado.getString(2), resultado.getInt(3), resultado.getInt(4), resultado.getInt(5), resultado.getInt(6), resultado.getString(7), resultado.getDouble(8), resultado.getBoolean(9), resultado.getBoolean(10), resultado.getString(11), resultado.getString(12), resultado.getDouble(13), resultado.getString(14), resultado.getString(15));
                //Esto era para visualizar: System.out.println("id: " + resultado.getInt(1) + " Nombre: " + resultado.getString(2) + " Descripción: " + resultado.getString(3));
                datosPeliculas.add(objPelicula);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
            System.out.println(e);
        }
        //Cierro conexion
        objPeliculaBD.desconectarBD(objPeliculaBD.getObjCon());

        return castclsPeliculaToItfProperty(datosPeliculas);
    }


    public ArrayList<itfProperty> consultarLibreriasEnBD() {
        //Declaraciones
        ResultSet resultado;
        //datosLibrerias = new ArrayList<>();
        clsLibreria_MultimediaBD objLibreria_MultimediaBD = new clsLibreria_MultimediaBD();

        //Reiniciamos el ArrayList en la RAM para no duplicar entradas en esta (Poco eficiente pero eficaz)
        datosLibrerias.clear();

        //Conexion
        objLibreria_MultimediaBD.conectarBD();
        //Consulta
        resultado = objLibreria_MultimediaBD.sendSelect(queryConsultaLibreria);
        //Codigo
        try {
            while (resultado.next()) {

                clsLibreriaMultimedia objLibreriaMultimedia = new clsLibreriaMultimedia(resultado.getInt(1), resultado.getString(2), resultado.getString(3));
                datosLibrerias.add(objLibreriaMultimedia);

            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
            System.out.println(e);
        }
        //Cierro conexion
        objLibreria_MultimediaBD.desconectarBD(objLibreria_MultimediaBD.getObjCon());
        return castclsLibreriaMultimediaToItfProperty(datosLibrerias);
    }

    public void updateGeneroPeliEnBD(String _query) {
        clsGeneroPeliBD objGeneroPeliBD = new clsGeneroPeliBD();
        objGeneroPeliBD.sendUpdate(_query);
    }

    private ArrayList<itfProperty> castclsDirectorToItfProperty(ArrayList<clsDirector> _datosDirector) {
        //Creamos el objeto en el que vamos a castear las pelicualas
        itfProperty castObject;
        //Las casteamos y metemos en datosItf
        //Limpiamos datosItf para no duplicar
        datosItf.clear();
        for (clsDirector o : _datosDirector
        ) {
            castObject = (itfProperty) o;
            datosItf.add(castObject);
        }
        return datosItf;
    }

    private ArrayList<itfPropertyV2> castclsGeneroPeliToItfProperty(ArrayList<clsGeneroPeli> _datosGeneroPeli) {
        //Creamos el objeto en el que vamos a castear los generos
        itfPropertyV2 castObject;
        //Las casteamos y metemos en datosItf
        //Limpiamos datosItf para no duplicar
        datosItf.clear();
        for (clsGeneroPeli o : _datosGeneroPeli
        ) {
            castObject = (itfPropertyV2) o;
            datosItfV2.add(castObject);
        }
        return datosItfV2;
    }


    public ArrayList<itfProperty> castclsLibreriaMultimediaToItfProperty(ArrayList</*Aqui me gustaria que fueran objects pero no traga*/clsLibreriaMultimedia> AO) {
        //Ordenamos por Nombre:
        Collections.sort(AO, new clsCompareLibreriaMultimedia());
        //Creamos el objeto en el que vamos a castear las librerias
        itfProperty castObject;
        //Las casteamos y metemos en datosItf
        //Limpiamos datosItf para no duplicar
        datosItf.clear();
        for (clsLibreriaMultimedia o : AO
        ) {
            castObject = (itfProperty) o;
            datosItf.add(castObject);
        }
        return datosItf;
    }

    public ArrayList<itfProperty> castclsPeliculaToItfProperty(ArrayList</*Aqui me gustaria que fueran objects pero no traga*/clsPelicula> AO) {
        //Ordenamos por Nombre:
        //NO CONFIGURADO PARA PELICULAS Collections.sort(AO, new clsCompareLibreriaMultimedia());
        //Creamos el objeto en el que vamos a castear las pelicualas
        itfProperty castObject;
        //Las casteamos y metemos en datosItf
        //Limpiamos datosItf para no duplicar
        datosItf.clear();
        for (clsPelicula o : AO
        ) {
            castObject = (itfProperty) o;
            datosItf.add(castObject);
        }
        return datosItf;
    }

    public ArrayList<itfProperty> castclsLibroToItfProperty(ArrayList<clsLibro> AO) {
        //Ordenamos por Nombre:
        //NO CONFIGURADO PARA LIBROS TAMPOCO Collections.sort(AO, new clsCompareLibreriaMultimedia());
        //Creamos el objeto en el que vamos a castear los libros
        itfProperty castObject;
        //Las casteamos y metemos en datosItf
        //Limpiamos datosItf para no duplicar
        datosItf.clear();
        for (clsLibro o : AO
        ) {
            castObject = (itfProperty) o;
            datosItf.add(castObject);
        }
        return datosItf;
    }

    public ArrayList<itfProperty> castclsActoresToItfProperty(ArrayList<clsActor> AO) {
        //Ordenamos por Nombre:
        //NO CONFIGURADO PARA Actores Collections.sort(AO, new clsCompareLibreriaMultimedia());
        //Creamos el objeto en el que vamos a castear las pelicualas
        itfProperty castObject;
        //Las casteamos y metemos en datosItf
        //Limpiamos datosItf para no duplicar
        datosItf.clear();
        for (clsActor o : AO
        ) {
            castObject = (itfProperty) o;
            datosItf.add(castObject);
        }
        return datosItf;
    }
}
