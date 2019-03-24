package com.company.LD;

/**
 * Clase que intercomunica LN con LD
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */
public class clsDatos {
    public void insertarPeliculaBD(String _Título, int _Año, String _Duración, int _Puntuación, int _Calporedad/*, int _Libreria_Multimedia_idLibreria_Multimedia*/) {
        clsInsertar objInsertor = new clsInsertar();
        objInsertor.insertarBD(_Título, _Año, _Duración, _Puntuación, _Calporedad/*, _Libreria_Multimedia_idLibreria_Multimedia*/);
    }
}