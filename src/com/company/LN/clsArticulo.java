package com.company.LN;

/**
 * Clase padre. Contiene atributos comunes de clsLibro, clsMusica y clsPelicula.
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsArticulo {
    /*atributos de la clase articulo*/
    String Titulo;
    String Titulo_original;
    //ESTE SERA UN DATE O ALGO
    String Anno_de_publicacion;
    String Tipo_DoA;
    String Formato;
    boolean En_propiedad;
    boolean En_busqueda;
    double Precio;
    String Genero;
    //Tiene miga premios eh
    String Premios;

    //Constructor
    public clsArticulo() {
    }
}
