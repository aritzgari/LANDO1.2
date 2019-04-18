package com.company.Comun;

/**
 * Clase para albergar las constante de insercion, consulta y demas.
 *<p>
 * @author Ruben Domínguez
 * Aritz Garitano
 */
public class clsConstantes {
    //INTENTOquery3:*/  public static final String queryInsertLibreria = "insert into Libreria_Multimedia (idLibreria_Multimedia, Nombre, Descripcion) values (null, ?, ?)";
    public static final String queryInsertLibreria = "insert into Libreria_Multimedia (Nombre, Descripcion) values (?, ?)";
    //INTENTOquery4:*/ public static final String queryInsertLibreria = "insert into Libreria_Multimedia (idLibreria_Multimedia, Nombre, Descripcion) values (null, ?, ?)";
    //INTENTOquery1:*/ public static final String queryInsertLibreria = "insert into Libreria_Multimedia (idLibreria_Multimedia, Nombre, Descripcion) values (?, ?, ?)";
    public static final String queryConsultaLibreria = "SELECT * FROM lando.libreria_multimedia;";
    public static final String queryInsertPelicula = "insert into Películas (Libreria_Multimedia_idLibreria_Multimedia, Título, Título_original, Año, Duración, Puntuación, Calporedad, Tipo_DoA, Precio, En_propiedad, En_busqueda, Formato, Saga, Orden_en_Saga, Sinopsis, Enlace_al_trailer) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    public static final String queryConsultaPelicula = "SELECT * FROM lando.películas";
    public static final String queryInsertLibro = "insert into Películas (Libreria_Multimedia_idLibreria_Multimedia, String ISBN, Título, Título_original, Año, Tipo_DoA, Precio, En_propiedad, En_busqueda, Formato, Paginas, Resumen, Serie_SoN, Nombre_serie, Orden_serie)  values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    public static final String queryConsultaLibro = "SELECT * FROM lando.libros";
}