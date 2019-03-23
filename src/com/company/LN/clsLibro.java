package com.company.LN;

/**
 * Clase para guardar datos de Libros en nuestra Base de Datos
 *
 * @author RubenD AritzG
 */

public class clsLibro extends clsArticulo {

    /*atributos de la clase libro*/
    String Autor;
    String Resumen;
    String Editorial;
    //Formato se hereda
    boolean Serie_SoN;
    String Nombre_serie;
    double Orden_serie;
    //ISBN no es un int porque es demasiado grande.
    String ISBN;
    int Paginas;

    public clsLibro(String _Autor, String _Resumen, String _Editorial, boolean _Serie_SoN, String _Nombre_serie, double _Orden_serie, String _ISBN, int _Paginas) {
        //Constructor (No se usa porque el padre tiene constructor)
        Autor = _Autor;
        Resumen = _Resumen;
        Editorial = _Editorial;
        Serie_SoN = _Serie_SoN;
        Nombre_serie = _Nombre_serie;
        Orden_serie = _Orden_serie;
        ISBN = _ISBN;
        Paginas = _Paginas;


    }
}
