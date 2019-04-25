package com.company.Comun;

/**
 * Clase para albergar las constante de insercion, consulta y demas.
 *<p>
 * @author Ruben Domínguez
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
    public static final String queryInsertPelicula = "insert into Películas (Libreria_Multimedia_idLibreria_Multimedia, Título, Título_original, Año, Duración, Puntuación, Calporedad, Tipo_DoA, Precio, En_propiedad, En_busqueda, Formato, Saga, Orden_en_Saga, Sinopsis, Enlace_al_trailer) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    public static final String queryConsultaPelicula = "SELECT * FROM lando.películas";
    /**
     * Constantes para querys de Libros.
     */
    public static final String queryInsertLibro = "insert into Libros (Libreria_Multimedia_idLibreria_Multimedia, ISBN, Título, Título_original, Año, Tipo_DoA, Precio, En_propiedad, En_busqueda, Formato, Paginas, Resumen, Serie_SoN, Nombre_serie, Orden_serie, Género_Libro_idGénero_Libro, Autor_idAutor)  values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    public static final String queryConsultaLibro = "SELECT * FROM lando.libros";

    /**
     * Constantes para querys de actores de peliculas.
     */

    public static final String queryInsertActores = "insert into Actores (Nombre, Apellido) values (?, ?)";
    public static final String queryConsultaActores = "SELECT * FROM lando.actores;";

    /**
     * Constantes para querys de director de peliculas.
     */

    public static final String queryInsertDirector = "insert into Director (Nombre, Apellido) values (?, ?)";
    public static final String queryConsultaDirector = "SELECT * FROM lando.director;";

    /**
     * Constantes para querys de premios de peliculas.
     */

    public static final String queryInsertPremiosPeli = "insert into Premios_Película (Nombre, Categoria, Año) values (?, ?, ?)";
    public static final String queryConsultaPremiosPeli = "SELECT * FROM lando.premios_película;";
    /**
     * Constantes para querys de genero de peliculas.
     */

    public static final String queryInsertGeneroPeli = "insert into Género_Película (Nombre) values (?)";
    public static final String queryConsultaGeneroPeli = "SELECT * FROM lando.género_película;";
}