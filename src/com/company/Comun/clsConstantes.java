package com.company.Comun;

/**
 * Clase para albergar las constante de insercion, consulta y demás.
 * <p>
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */
public class clsConstantes {
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
     * Constantes para querys de Música.
     */
    public static final String queryInsertCancion = "insert into Canciones (Libreria_Multimedia_idLibreria_Multimedia, Título, Título_original, Año, Tipo_DoA, Precio, En_propiedad, En_busqueda, Formato, Videoclip, Enlace_a_YT, Género_Canción_idGénero_Canción, Album_idAlbum, Album_Cantante_idCantante)  values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    public static final String queryConsultaCancion = "SELECT * FROM lando.canciones";

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

    /**
     * Constantes para querys de autor de libro.
     */

    public static final String queryInsertAutores = "insert into Autor (Nombre, Apellido) values (?, ?)";
    public static final String queryConsultaAutores = "SELECT * FROM lando.autor;";

    /**
     * Constantes para querys de editorial de libro.
     */

    public static final String queryInsertEditorial = "insert into Editorial (Nombre, Libros_ISBN) values (?, ?)";
    public static final String queryConsultaEditorial = "SELECT * FROM lando.editorial;";

    /**
     * Constantes para querys de genero de libros.
     */

    public static final String queryInsertGeneroLibro = "insert into Género_Libro (Nombre) values (?)";
    public static final String queryConsultaGeneroLibro = "SELECT * FROM lando.género_libro;";
    /**
     * Constantes para querys de premios de libros.
     */

    public static final String queryInsertPremiosLibros = "insert into Premios_Libro (Nombre_Del_Premio, Categoria, Año, Libros_ISBN) values (?, ?, ?, ?)";
    public static final String queryConsultaPremiosLibros = "SELECT * FROM lando.premios_libro;";

    /**
     * Constantes para querys de genero de canciones.
     */

    public static final String queryInsertGeneroCancion = "insert into Género_Canción (Nombre) values (?)";
    public static final String queryConsultaGeneroCancion = "SELECT * FROM lando.género_canción;";

    /**
     * Constantes para querys de premios de canciones.
     */

    public static final String queryInsertPremiosCancion = "insert into Premios_Canción (Nombre_Del_Premio, Categoria, Año, Canciones_idCanciones, Canciones_Género_Canción_idGénero_Canción, Canciones_Album_idAlbum, Canciones_Album_Cantante_idCantante, Canciones_Libreria_Multimedia_idLibreria_Multimedia) values (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String queryConsultaPremiosCancion = "SELECT * FROM lando.premios_canción;";

    /**
     * Constantes para querys de albumes de canciones.
     */
    public static final String queryInsertAlbum = "insert into Album (Nombre, Cantante_idCantante) values (?, ?)";
    public static final String queryConsultaAlbum = "SELECT * FROM lando.album;";

    /**
     * Constantes para querys de cantante.
     */
    public static final String queryInsertCantante = "insert into Cantante (Nombre) values (?)";
    public static final String queryConsultaCantante = "SELECT * FROM lando.cantante;";
}