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
import com.company.LD.clsCancionBD;
import com.company.LD.clsAutorBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import static com.company.Comun.clsConstantes.*;


/**
 * Clase que intercomunica LP con LN
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsGestorLN {

    /**
     * Los arrays que contienen los datos de los diferentes artículos. Creados como Private y Static.
     */

    private static ArrayList<itfProperty> datosItf;
    private static ArrayList<itfPropertyV2> datosItfV2;
    private static ArrayList<clsPelicula> datosPeliculas;
    private static ArrayList<clsLibro> datosLibros;
    private static ArrayList<clsCancion> datosCancion;
    //Estos tres de arriba, para mi que no los usamos.
    private static ArrayList<clsArticulo> datosArticulos;
    private ArrayList<clsLibreriaMultimedia> datosLibrerias;
    private static ArrayList<clsActor> datosActor;
    private static ArrayList<clsGeneroPeli> datosGeneroPeli;
    private static ArrayList<clsPremios> datosPremios;
    private static ArrayList<clsPremios_Pelicula> datosPremiosPeli;
    private static ArrayList<clsDirector> datosDirector;
    private static ArrayList<clsAutor> datosAutor;


    public clsGestorLN() {
        datosItf = new ArrayList<itfProperty>();
        datosItfV2 = new ArrayList<itfPropertyV2>();
        datosPeliculas = new ArrayList<clsPelicula>();
        datosLibros = new ArrayList<clsLibro>();
        datosCancion = new ArrayList<clsCancion>();
        datosArticulos = new ArrayList<clsArticulo>();
        datosLibrerias = new ArrayList<clsLibreriaMultimedia>();
        datosActor = new ArrayList<clsActor>();
        datosGeneroPeli = new ArrayList<clsGeneroPeli>();
        datosPremios = new ArrayList<clsPremios>();
        datosPremiosPeli = new ArrayList<clsPremios_Pelicula>();
        datosDirector = new ArrayList<clsDirector>();
        datosAutor = new ArrayList<clsAutor>();
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

    public static ArrayList<clsCancion> getDatosMusicas() {
        return datosCancion;
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

    public static ArrayList<clsAutor> getDatosAutor() {
        return datosAutor;
    }

    /**
     * A partir de aquí van las creaciones en base de datos.
     * @author RubenD AritzG
     * @return void
     */

    /**
     * Metodo para crear Librerias en el Gestor con datos que recibamos de LP
     *
     * @author RubenD AritzG
     */
    public static int crearLibreria(/*int idLibreria_Multimedia, */String Nombre, String Descripcion) /*Excepcion no tratadathrows SQLException */ {
        int retorno = 0;
        //UPDATE 05/04: Aqui creamos la query con los parametros que nos pasan a este metodo;
        //con esta query llamamos a clsLibreriaMultimediaBD.sendInsert(query)
        //QUE PASA, que el id es AutoIncremental, asique igual conviene mandar la query sin el AutoIncremental,
        // y este añadirlo con el retorno (L39) del metodo de clsLibreriaMultimediaBD.sendInsert.
        // (mas bien se añadirá solo)
        //La siguiente linea convendría que fuera una constante:
        clsLibreria_MultimediaBD objLibreria_MultimediaBD = new clsLibreria_MultimediaBD(Nombre, Descripcion);
        //objLibreria_MultimediaBD.sendInsert(queryInsertLibreria);
        retorno = objLibreria_MultimediaBD.sendInsert(queryInsertLibreria);
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
        return retorno;
    }

    /**
     * Metodo para crear peliculas en el Gestor con datos que recibamos de LP
     *
     * @author RubenD AritzG
     */
    public static int crearPelicula(int Libreria_Multimedia_idLibreria_Multimedia, String Titulo, String Titulo_original, int Anno_de_publicacion, int Duracion, int Calificacion, int Calporedad, String Tipo_DoA, double Precio, boolean En_propiedad, boolean En_busqueda, String Formato, String Saga, Double Orden, String Sinopsis, String Enlace_a_trailer) {
        int retorno = 0;
        clsPeliculaBD objPeliculaBD = new clsPeliculaBD(Libreria_Multimedia_idLibreria_Multimedia, Titulo, Titulo_original, Anno_de_publicacion, Duracion, Calificacion, Calporedad, Tipo_DoA, Precio, En_propiedad, En_busqueda, Formato, Saga, Orden, Sinopsis, Enlace_a_trailer);
        retorno = objPeliculaBD.sendInsert(queryInsertPelicula);
        System.out.println(retorno);
        return retorno;
    }

    /**
     * Metodo para crear Libros en el Gestor con datos que recibamos de LP
     *
     * @author RubenD AritzG
     */
    public static int crearLibro(int Libreria_Multimedia_idLibreria_Multimedia, String ISBN, String Titulo, String Titulo_original, int Anno_de_publicacion, String Tipo_DoA, double Precio, boolean En_propiedad, boolean En_busqueda, String Formato, int Paginas, String Resumen, boolean Serie_SoN, String Nombre_serie, double Orden_serie, int idGenero, int idAutor) {
        int retorno=0;
        clsLibrosBD objLibroBD = new clsLibrosBD(Libreria_Multimedia_idLibreria_Multimedia, ISBN, Titulo, Titulo_original, Anno_de_publicacion, Tipo_DoA, Precio, En_propiedad, En_busqueda, Formato, Paginas, Resumen, Serie_SoN, Nombre_serie, Orden_serie, idGenero, idAutor);
        objLibroBD.sendInsert(queryInsertLibro);
        System.out.println(retorno);
        return retorno;
    }

    /**
     * Metodo para crear Musica en el Gestor con datos que recibamos de LP
     *
     * @author RubenD AritzG
     */
    public static int crearMusica(String Titulo, String Titulo_original, String Anno_de_publicacion, String Tipo_DoA, String Formato, boolean En_propiedad, boolean En_busqueda, double Precio, String Genero, String Premiosint, int Cantidad_musicos, String Musico1, String Musico2, String Musico3, String Musico4, String Musico5, String Album, String Enlace_a_youtube, boolean Videoclip) {
        int retorno = 0;
        clsCancionBD objCancionBD;
        objCancionBD = new clsCancionBD(Titulo, Titulo_original, Anno_de_publicacion, Tipo_DoA, Formato,En_propiedad, En_busqueda, Precio, Genero, Premiosint, Cantidad_musicos, Musico1, Musico2, Musico3, Musico4, Musico5, Album, Enlace_a_youtube, Videoclip);
        retorno = objCancionBD.sendInsert(queryInsertCancion);
        System.out.println(retorno);
        return retorno;
    }

    /**
     * Metodo para crear actores en el Gestor con datos que recibamos de LP
     *
     * @author RubenD AritzG
     */
    public static int crearActor(String Nombre, String Apellido) {
        int retorno = 0;
        clsActoresBD objActorBD = new clsActoresBD(Nombre, Apellido);
        retorno = objActorBD.sendInsert(queryInsertActores);
        System.out.println(retorno);
        return retorno;
    }

    /**
     * Metodo para crear autores en el Gestor con datos que recibamos de LP
     *
     * @author RubenD AritzG
     */

    public static int crearAutor(String Nombre, String Apellido) {
        int retorno = 0;
        clsAutorBD objAutorBD = new clsAutorBD(Nombre, Apellido);
        retorno = objAutorBD.sendInsert(queryInsertAutores);
        System.out.println(retorno);
        return retorno;
    }

    /**
     * Metodo para crear Directores en el Gestor con datos que recibamos de LP
     *
     * @author RubenD AritzG
     */
    public static int crearDirector(String Nombre, String Apellido) {
        int retorno = 0;
        clsDirectorBD objDirectorBD = new clsDirectorBD(Nombre, Apellido);
        retorno = objDirectorBD.sendInsert(queryInsertDirector);
        System.out.println(retorno);
        return retorno;
    }

    /**
     * Metodo para crear Generos en el Gestor con datos que recibamos de LP
     *
     * @author RubenD AritzG
     */
    public static void crearGeneroPeli(String Nombre) {

        clsGeneroPeliBD objGeneroPeliBD = new clsGeneroPeliBD(Nombre);
        objGeneroPeliBD.sendInsert(queryInsertGeneroPeli);
    }

    /**
     * Metodo para crear Premios de Peliculas en el Gestor con datos que recibamos de LP
     *
     * @author RubenD AritzG
     */
    public static void crearPremiosPeli(String Nombre, String Categoria, int Anno) {

        clsPremios_PeliculaBD objPremiosPeliBD = new clsPremios_PeliculaBD(Nombre, Categoria, Anno);
        objPremiosPeliBD.sendInsert(queryInsertDirector);
    }

    /**
     * A partir de aquí van las consultas.
     *
     * @return ArrayList<itfPropertyV2>
     * @author RubenD AritzG
     */

    /**
     * Método para consultar Actores
     */
    public ArrayList<itfPropertyV2> consultarActoresEnBD() {
        //Declaraciones
        ResultSet resultado = null;
        clsActoresBD objActoresBD = new clsActoresBD();

        //Código
        //Abrir conexión:
        objActoresBD.conectarBD();
        resultado = objActoresBD.sendSelect(queryConsultaActores);
        //Reiniciamos el ArrayList en la RAM para no duplicar entradas en esta (Poco eficiente pero eficaz)
        datosActor.clear();
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


    /**
     * Método para consultar Autores
     */
    public ArrayList<itfPropertyV2> consultarAutoresEnBD() {
        //Declaraciones
        ResultSet resultado = null;
        clsAutorBD objAutorBD = new clsAutorBD();

        //Código
        //Abrir conexión:
        objAutorBD.conectarBD();
        resultado = objAutorBD.sendSelect(queryConsultaAutores);
        //Reiniciamos el ArrayList en la RAM para no duplicar entradas en esta (Poco eficiente pero eficaz)
        datosAutor.clear();
        //Meto rs en objeto
        try {
            while (resultado.next()) {
                clsAutor objAutor = new clsAutor(resultado.getInt(1), resultado.getString(2), resultado.getString(3));
                datosAutor.add(objAutor);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
            System.out.println(e);
        }
        //Cierro conexion
        objAutorBD.desconectarBD(objAutorBD.getObjCon());

        return castclsAutoresToItfProperty(datosAutor);
    }
    /**
     * Método para consultar Directores
     *
     * @return
     */
    public ArrayList<itfPropertyV2> consultarDirectorEnBD() {
        ResultSet resultado = null;
        clsDirectorBD objDirectorBD = new clsDirectorBD();

        //Código
        //Abrir conexión
        objDirectorBD.conectarBD();
        resultado = objDirectorBD.sendSelect(queryConsultaDirector);
        //Reiniciamos el ArrayList en la RAM para no duplicar entradas en esta (Poco eficiente pero eficaz)
        datosDirector.clear();
        //Meto rs en objeto
        try {
            while (resultado.next()) {
                clsDirector objDirector = new clsDirector(resultado.getInt(1), resultado.getString(2), resultado.getString(3));
                //Esto era para visualizar: System.out.println("id: " + resultado.getInt(1) + " Nombre: " + resultado.getString(2) + " Descripción: " + resultado.getString(3));
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

    /**
     * Método para consultar Géneros de películas.
     */
    public ArrayList<itfPropertyV2> consultarGeneroPeliEnBD() {
        //Declaraciones
        ResultSet resultado = null;
        clsGeneroPeliBD objGeneroPeliBD = new clsGeneroPeliBD();

        //Código
        //Abrir conexión
        objGeneroPeliBD.conectarBD();
        resultado = objGeneroPeliBD.sendSelect(queryConsultaGeneroPeli);
        //Reiniciamos el ArrayList en la RAM para no duplicar entradas en esta (Poco eficiente pero eficaz)
        datosGeneroPeli.clear();
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

    /**
     * Método para consultar Libros.
     */
    public ArrayList<itfPropertyV2> consultarLibrosEnBD() {
        //Declaraciones
        ResultSet resultado = null;
        clsLibrosBD objLibrosBD = new clsLibrosBD();

        //Código
        //Abrir conexión
        objLibrosBD.conectarBD();
        resultado = objLibrosBD.sendSelect(queryConsultaLibro);
        //Reiniciamos el ArrayList en la RAM para no duplicar entradas en esta (Poco eficiente pero eficaz)
        datosLibros.clear();
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

    /**
     * Método para consultar Películas
     */
    public ArrayList<itfPropertyV2> consultarPeliculaEnBD() {
        //Declaraciones
        ResultSet resultado = null;
        clsPeliculaBD objPeliculaBD = new clsPeliculaBD();

        //Código
        //Abrir conexión
        objPeliculaBD.conectarBD();
        resultado = objPeliculaBD.sendSelect(queryConsultaPelicula);
        //Reiniciamos el ArrayList en la RAM para no duplicar entradas en esta (Poco eficiente pero eficaz)
        datosPeliculas.clear();
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

    /**
     * Método para consultar Librerías
     */
    public ArrayList<itfPropertyV2> consultarLibreriasEnBD() {
        //Declaraciones
        ResultSet resultado;
        clsLibreria_MultimediaBD objLibreria_MultimediaBD = new clsLibreria_MultimediaBD();

        //Código
        //Conexion
        objLibreria_MultimediaBD.conectarBD();
        //Consulta
        resultado = objLibreria_MultimediaBD.sendSelect(queryConsultaLibreria);
        //Reiniciamos el ArrayList en la RAM para no duplicar entradas en esta (Poco eficiente pero eficaz)
        datosLibrerias.clear();
        //Llenamos el ArrayList
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
    /**
     * A partir de aquí van las Updates - son querys para actualizar valores.
     *
     * @return ArrayList<itfProperty>
     * @author RubenD AritzG
     */

    /**
     * Método para actualizar Géneros de películas
     */
    public void updateGeneroPeliEnBD(String _query) {
        clsGeneroPeliBD objGeneroPeliBD = new clsGeneroPeliBD();
        objGeneroPeliBD.sendUpdate(_query);
    }

    /**
     * A partir de aquí van lo que hemos llamado casteos.
     * Son métodos para meter los datos de diferentes ArrayList en iffDatos, que es un ArrayList de itfProperty.
     *
     * @return ArrayList<itfProperty>
     * @author RubenD AritzG
     */

    /**
     * Método para castear Directores.
     */
    private ArrayList<itfPropertyV2> castclsDirectorToItfProperty(ArrayList<clsDirector> _datosDirector) {
        //Creamos el objeto en el que vamos a castear las pelicualas
        itfPropertyV2 castObject;
        //Las casteamos y metemos en datosItf
        //Limpiamos datosItf para no duplicar
        datosItfV2.clear();
        for (clsDirector o : _datosDirector
        ) {
            castObject = (itfPropertyV2) o;
            datosItfV2.add(castObject);
        }
        return datosItfV2;
    }

    /**
     * Método para castear Géneros de películas.
     */
    private ArrayList<itfPropertyV2> castclsGeneroPeliToItfProperty(ArrayList<clsGeneroPeli> _datosGeneroPeli) {
        //Creamos el objeto en el que vamos a castear los generos
        itfPropertyV2 castObject;
        //Las casteamos y metemos en datosItf
        //Limpiamos datosItf para no duplicar
        datosItfV2.clear();
        for (clsGeneroPeli o : _datosGeneroPeli
        ) {
            castObject = (itfPropertyV2) o;
            datosItfV2.add(castObject);
        }
        return datosItfV2;
    }

    /**
     * Método para castear Librerías multimedia.
     */
    public ArrayList<itfPropertyV2> castclsLibreriaMultimediaToItfProperty(ArrayList<clsLibreriaMultimedia> AO) {
        //Ordenamos por Nombre:
        Collections.sort(AO, new clsCompareLibreriaMultimedia());
        //Creamos el objeto en el que vamos a castear las librerias
        itfPropertyV2 castObject;
        //Las casteamos y metemos en datosItf
        //Limpiamos datosItf para no duplicar
        datosItfV2.clear();
        for (clsLibreriaMultimedia o : AO
        ) {
            castObject = (itfPropertyV2) o;
            datosItfV2.add(castObject);
        }
        return datosItfV2;
    }

    /**
     * Método para castear Películas.
     */
    public ArrayList<itfPropertyV2> castclsPeliculaToItfProperty(ArrayList<clsPelicula> AO) {
        //Ordenamos por Nombre:
        //NO CONFIGURADO PARA PELICULAS Collections.sort(AO, new clsCompareLibreriaMultimedia());
        //Creamos el objeto en el que vamos a castear las pelicualas
        itfPropertyV2 castObject;
        //Las casteamos y metemos en datosItf
        //Limpiamos datosItf para no duplicar
        datosItfV2.clear();
        for (clsPelicula o : AO
        ) {
            castObject = (itfPropertyV2) o;
            datosItfV2.add(castObject);
        }
        return datosItfV2;
    }

    /**
     * Método para castear Libros.
     *
     * @return
     */
    public ArrayList<itfPropertyV2> castclsLibroToItfProperty(ArrayList<clsLibro> AO) {

        itfPropertyV2 castObject;

        datosItfV2.clear();
        for (clsLibro o : AO
        ) {
            castObject = (itfPropertyV2) o;
            datosItfV2.add(castObject);
        }
        return datosItfV2;
    }

    /**
     * Método para castear Actores.
     */
    public ArrayList<itfPropertyV2> castclsActoresToItfProperty(ArrayList<clsActor> AO) {
        //Ordenamos por Nombre:
        //NO CONFIGURADO PARA Actores Collections.sort(AO, new clsCompareLibreriaMultimedia());
        //Creamos el objeto en el que vamos a castear las pelicualas
        itfPropertyV2 castObject;
        //Las casteamos y metemos en datosItf
        //Limpiamos datosItf para no duplicar
        datosItfV2.clear();
        for (clsActor o : AO
        ) {
            castObject = (itfPropertyV2) o;
            datosItfV2.add(castObject);
        }
        return datosItfV2;
    }

    /**
     * Método para castear Autores.
     */
    public ArrayList<itfPropertyV2> castclsAutoresToItfProperty(ArrayList<clsAutor> AO) {
        //Ordenamos por Nombre:
        //NO CONFIGURADO PARA Actores Collections.sort(AO, new clsCompareLibreriaMultimedia());
        //Creamos el objeto en el que vamos a castear las pelicualas
        itfPropertyV2 castObject;
        //Las casteamos y metemos en datosItf
        //Limpiamos datosItf para no duplicar
        datosItfV2.clear();
        for (clsAutor o : AO
        ) {
            castObject = (itfPropertyV2) o;
            datosItfV2.add(castObject);
        }
        return datosItfV2;
    }
}
