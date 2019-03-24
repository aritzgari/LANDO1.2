package com.company.LD;

/**
 * Clase que intercomunica LN con LD
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */
public class clsDatos {
    public void insertarLiberiaBD(int idLibreria_Multimedia, String Nombre, String Descripcion) {
        clsInsertar objInsertor = new clsInsertar();

        objInsertor.insertarLibreriaEnBD(idLibreria_Multimedia, Nombre, Descripcion);
    }

    public void insertarPeliculaBD(String _Título, int _Año, String _Duración, int _Puntuación, int _Calporedad, int _Libreria_Multimedia_idLibreria_Multimedia) {
        clsInsertar objInsertor = new clsInsertar();

        objInsertor.insertarPeliculaEnBD(_Título, _Año, _Duración, _Puntuación, _Calporedad, _Libreria_Multimedia_idLibreria_Multimedia);
    }
}