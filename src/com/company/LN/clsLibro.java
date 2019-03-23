package com.company.LN;

/**
 * Clase para guardar datos de Libros en nuestra Base de Datos
 *
 * @author RubenD AritzG
 */

public class clsLibro extends clsArticulo {
    //Constructor (No se usa porque el padre tiene constructor)
    public clsLibro() {

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
    }
}
