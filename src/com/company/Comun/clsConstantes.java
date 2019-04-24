package com.company.Comun;

/**
 * Clase para albergar las constante de insercion, consulta y demas.
 *<p>
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */
public class clsConstantes {
    //INTENTOquery3:*/  public static final String queryInsertLibreria = "insert into Libreria_Multimedia (idLibreria_Multimedia, Nombre, Descripcion) values (null, ?, ?)";

    //INTENTOquery4:*/ public static final String queryInsertLibreria = "insert into Libreria_Multimedia (idLibreria_Multimedia, Nombre, Descripcion) values (null, ?, ?)";
    //INTENTOquery1:*/ public static final String queryInsertLibreria = "insert into Libreria_Multimedia (idLibreria_Multimedia, Nombre, Descripcion) values (?, ?, ?)";
    /**
     * Constantes para querys de Librerias.
     */
    public static final String queryInsertLibreria = "insert into Libreria_Multimedia (Nombre, Descripcion) values (?, ?)";
    public static final String queryConsultaLibreria = "SELECT * FROM lando.libreria_multimedia;";
    /**
     * Constantes para querys de Peliculas.
     */
    public static final String queryInsertPelicula = "insert into Pel�culas (Libreria_Multimedia_idLibreria_Multimedia, T�tulo, T�tulo_original, A�o, Duraci�n, Puntuaci�n, Calporedad, Tipo_DoA, Precio, En_propiedad, En_busqueda, Formato, Saga, Orden_en_Saga, Sinopsis, Enlace_al_trailer) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    public static final String queryConsultaPelicula = "SELECT * FROM lando.pel�culas";
    /**
     * Constantes para querys de Libros.
     */
    public static final String queryInsertLibro = "insert into libros (Libreria_Multimedia_idLibreria_Multimedia, ISBN, T�tulo, T�tulo_original, A�o, Tipo_DoA, Precio, En_propiedad, En_busqueda, Formato, Paginas, Resumen, Serie_SoN, Nombre_serie, Orden_serie, G�nero_Libro_idG�nero_Libro, Autor_idAutor)  values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    public static final String queryConsultaLibro = "SELECT * FROM lando.libros";
}