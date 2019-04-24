package com.company.LN;

//import com.company.LD.clsCompareLibreriaMultimedia;

import com.company.LD.clsLibreria_MultimediaBD;
import com.company.LD.clsPeliculaBD;
import com.company.LD.clsLibrosBD;

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


/**
 * Clase que intercomunica LP con LN
 *
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */

public class clsGestorLN {

    /*Los arrays que contienen los datos de los diferentes articulos*/

    private static ArrayList<itfProperty> datosItf;
    private static ArrayList<clsPelicula> datosPeliculas;
    private static ArrayList<clsLibro> datosLibros;
    private static ArrayList<clsMusica> datosMusicas;
    //Estos tres de arriba, para mi que no los usamos.
    private static ArrayList<clsArticulo> datosArticulos;
    private static ArrayList<clsLibreriaMultimedia> datosLibrerias;

    public clsGestorLN() {
        datosItf = new ArrayList<itfProperty>();
        datosPeliculas = new ArrayList<clsPelicula>();
        datosLibros = new ArrayList<clsLibro>();
        datosMusicas = new ArrayList<clsMusica>();
        datosArticulos = new ArrayList<clsArticulo>();
        datosLibrerias = new ArrayList<clsLibreriaMultimedia>();
    }


    public static ArrayList<clsLibreriaMultimedia> getDatosLibrerias() {

        return datosLibrerias;
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

    public static void crearLibreria(/*int idLibreria_Multimedia, */String Nombre, String Descripcion) /*Excepcion no tratadathrows SQLException */ {
        /**
         * Metodo para crear Librerias en el Gestor con datos que recibamos de LP
         * @author RubenD AritzG
         */
        //UPDATE 05/04: Aqui creamos la query con los parametros que nos pasan a este metodo;
        //con esta query llamamos a clsLibreriaMultimediaBD.sendInsert(query)
        //QUE PASA, que el id es AutoIncremental, asique igual conviene mandar la query sin el AutoIncremental,
        // y este a�adirlo con el retorno (L39) del metodo de clsLibreriaMultimediaBD.sendInsert.
        // (mas bien se a�adir� solo)
        //La siguiente linea convendr�a que fuera una constante:
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
        //Esto habr� que cambiarlo porque no podemos crear las librerias en la RAM con el id proporcionado.
        objLibreria = new clsLibreriaMultimedia(idLibreria_Multimedia, Nombre, Descripcion);
        datosLibrerias.add(objLibreria);*/

        //Vale, aqu�, que esto es LN, voy a crear un objGestorLD, creo que esto se puede hacer,
        // y con este obj voy a intentar a�adir las librerias directamente a la BBDD. Ni yo me creo lo que digo, pero en teor�a esto est� bien.

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

    public static void crearLibro(int Libreria_Multimedia_idLibreria_Multimedia, String ISBN,  String Titulo, String Titulo_original, int Anno_de_publicacion, String Tipo_DoA, double Precio,  boolean En_propiedad, boolean En_busqueda, String Formato, int Paginas,  String Resumen, boolean Serie_SoN, String Nombre_serie, double Orden_serie, int idGenero, int idAutor) {
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

    public ArrayList<itfProperty> consultarLibrosEnBD() {
        ResultSet resultado = null;
        //Declarado mas abajo, ignorar: clsLibreriaMultimedia objLibreriaMultimedia = new clsLibreriaMultimedia();
        clsLibrosBD objLibrosBD = new clsLibrosBD();
        //En este metodo tendremos que crear librerias y asignarles de alguna manera los valores antes de cerrar la conexui�n
        //Para ello:
        //...
        //ABRIR CONEXION:
        objLibrosBD.conectarBD();
        resultado = objLibrosBD.sendSelect(queryConsultaLibro);
        //Meto rs en objeto
        try {
            while (resultado.next()) {
                clsLibro objLibros = new clsLibro(resultado.getInt(17), resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getInt(4), resultado.getString(5), resultado.getDouble(6), resultado.getBoolean(7), resultado.getBoolean(8), resultado.getString(9), resultado.getInt(10), resultado.getString(11), resultado.getBoolean(12), resultado.getString(13), resultado.getDouble(14), resultado.getInt(15), resultado.getInt(16) );
                //Esto era para visualizar: System.out.println("id: " + resultado.getInt(1) + " Nombre: " + resultado.getString(2) + " Descripci�n: " + resultado.getString(3));
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
        //En este metodo tendremos que crear librerias y asignarles de alguna manera los valores antes de cerrar la conexui�n
        //Para ello:
        //...
        //ABRIR CONEXION:
        objPeliculaBD.conectarBD();
        resultado = objPeliculaBD.sendSelect(queryConsultaPelicula);
        //Meto rs en objeto
        try {
            while (resultado.next()) {
                clsPelicula objPelicula = new clsPelicula(resultado.getInt(16), resultado.getString(1), resultado.getString(2), resultado.getInt(3), resultado.getInt(4), resultado.getInt(5), resultado.getInt(6), resultado.getString(7), resultado.getDouble(8), resultado.getBoolean(9), resultado.getBoolean(10), resultado.getString(11), resultado.getString(12), resultado.getDouble(13), resultado.getString(14), resultado.getString(15));
                //Esto era para visualizar: System.out.println("id: " + resultado.getInt(1) + " Nombre: " + resultado.getString(2) + " Descripci�n: " + resultado.getString(3));
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


    public /*DevuelvoObjeto:*/ArrayList<itfProperty> consultarLibreriasEnBD() {
        ResultSet resultado = null;
        clsLibreria_MultimediaBD objLibreria_MultimediaBD = new clsLibreria_MultimediaBD();
        //En este metodo tendremos que crear librerias y asignarles de alguna manera los valores antes de cerrar la conexui�n
        //Para ello:
        //...
        //ABRIR CONEXION:
        objLibreria_MultimediaBD.conectarBD();
        resultado = objLibreria_MultimediaBD.sendSelect(queryConsultaLibreria);
        //Meto rs en objeto

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

    public ArrayList<itfProperty> castclsLibreriaMultimediaToItfProperty(ArrayList</*Aqui me gustaria que fueran objects pero no traga*/clsLibreriaMultimedia> AO) {
        //Ordenamos por Nombre:
        Collections.sort(AO, new clsCompareLibreriaMultimedia());
        //Creamos el objeto en el que vamos a castear las librerias
        itfProperty castObject;
        //Las casteamos y metemos en datosItf
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
        for (clsLibro o : AO
        ) {
            castObject = (itfProperty) o;
            datosItf.add(castObject);
        }
        return datosItf;
    }
}
