package com.company.Excepciones;

/**
 * Excepci�n en caso de que se repita el insert de pel�cula.
 *<p>
 * @author Ruben Dom�nguez
 * Aritz Garitano
 * @return Devuelve un mensaje de error para cuando repetimos una insercion en BD.
 */

public class clsPeliRepeException extends Exception {

    public final String mensaje = "Titulo repetido";

    @Override
    public String getMessage() {

        return mensaje;
    }
}
