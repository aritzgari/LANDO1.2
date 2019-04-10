package com.company.Comun;

public class clsConstantes {
    //INTENTOquery3:*/  public static final String queryInsertLibreria = "insert into Libreria_Multimedia (idLibreria_Multimedia, Nombre, Descripcion) values (null, ?, ?)";
    /*INTENTOquery2:*/ public static final String queryInsertLibreria = "insert into Libreria_Multimedia (Nombre, Descripcion) values (?, ?)";
    //INTENTOquery4:*/ public static final String queryInsertLibreria = "insert into Libreria_Multimedia (idLibreria_Multimedia, Nombre, Descripcion) values (null, ?, ?)";
    //INTENTOquery1:*/ public static final String queryInsertLibreria = "insert into Libreria_Multimedia (idLibreria_Multimedia, Nombre, Descripcion) values (?, ?, ?)";
    public static final String queryConsultaLibreria = "SELECT * FROM lando.libreria_multimedia;";
    public static final String queryInsertPelicula= "insert into Películas (Titulo, Titulo_original, Anno_de_publicacion, Tipo_DoA, Formato, En_propiedad, En_busqueda, Precio, Genero, Premios,Director, Enlace_a_trailer, Sinopsis, Cantidad_actores, Actor1, Actor2, Actor3, Saga, Orden, Duracion, Calporedad, Calificacion, Libreria_Multimedia_idLibreria_Multimedia) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    public static final String queryConsultaPelicula= "SELECT * FROM lando.Película";
}