package com.company.LD;

/**
 * Clase que intercomunica LN con LD
 *
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */
public class clsDatos {
    public void insertarPeliculaBD(String _T�tulo, int _A�o, String _Duraci�n, int _Puntuaci�n, int _Calporedad/*, int _Libreria_Multimedia_idLibreria_Multimedia*/) {
        clsInsertar objInsertor = new clsInsertar();
        objInsertor.insertarBD(_T�tulo, _A�o, _Duraci�n, _Puntuaci�n, _Calporedad/*, _Libreria_Multimedia_idLibreria_Multimedia*/);
    }
}