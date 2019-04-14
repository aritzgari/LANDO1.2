package com.company.LN;

//import com.company.LD.clsCompareLibreriaMultimedia;

import com.company.LD.clsLibreria_MultimediaBD;
import com.company.LD.clsPeliculaBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import static com.company.Comun.clsConstantes.queryConsultaLibreria;
import static com.company.Comun.clsConstantes.queryInsertLibreria;
import static com.company.Comun.clsConstantes.queryConsultaPelicula;
import static com.company.Comun.clsConstantes.queryInsertPelicula;

/**
 * Clase que intercomunica LP con LN
 *
 * @author Ruben Domínguez
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
        clsPeliculaBD objPeliculaBD = new clsPeliculaBD(Libreria_Multimedia_idLibreria_Multimedia, Titulo, Titulo_original,Anno_de_publicacion, Duracion,Calificacion, Calporedad, Tipo_DoA,Precio,En_propiedad,En_busqueda,Formato, Saga,Orden, Sinopsis, Enlace_a_trailer);
        objPeliculaBD.sendInsert(queryInsertPelicula);
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


    public static ArrayList<clsPelicula> consultarPeliculaEnBD() {
        ResultSet resultado = null;
        //Declarado mas abajo, ignorar: clsLibreriaMultimedia objLibreriaMultimedia = new clsLibreriaMultimedia();
        clsPeliculaBD objPelicula = new clsPeliculaBD();
        //En este metodo tendremos que crear librerias y asignarles de alguna manera los valores antes de cerrar la conexuión
        //Para ello:
        //...
        //ABRIR CONEXION:
        objPelicula.conectarBD();
        resultado = objPelicula.sendSelect(queryConsultaPelicula);
        //Meto rs en objeto
        try {
            while (resultado.next()) {
                clsLibreriaMultimedia objLibreriaMultimedia = new clsLibreriaMultimedia(resultado.getInt(1), resultado.getString(2), resultado.getString(3));
                //Esto era para visualizar: System.out.println("id: " + resultado.getInt(1) + " Nombre: " + resultado.getString(2) + " Descripción: " + resultado.getString(3));
                datosLibrerias.add(objLibreriaMultimedia);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
            System.out.println(e);
        }
        //Cierro conexion
        objPelicula.desconectarBD(objPelicula.getObjCon());

        return datosPeliculas;
    }


    public /*DevuelvoObjeto:*/ArrayList<itfProperty> consultarLibreriasEnBD() {
        ResultSet resultado = null;
        clsLibreria_MultimediaBD objLibreria_MultimediaBD = new clsLibreria_MultimediaBD();
        //En este metodo tendremos que crear librerias y asignarles de alguna manera los valores antes de cerrar la conexuión
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
}
