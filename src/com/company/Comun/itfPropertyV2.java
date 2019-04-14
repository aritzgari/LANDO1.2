package com.company.Comun;

/**
 * Interfaz para la independencia entre la LN y la LP.
 * En la versi�n anterior (itfProperty) us�bamos un switch por cada tipo de variable.
 * En esta versi�n devolveremos cualquier tipo como Object y luego ya castearemos.
 *<p>
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */
public interface itfPropertyV2 {


    /**
     * @param propiedad nombre de la propiedad a devolver del objeto.
     * @return Devuelve la propiedad solicitada por nombre, como tipo Object.
     */
    Object getObjectProperty(String propiedad);
}