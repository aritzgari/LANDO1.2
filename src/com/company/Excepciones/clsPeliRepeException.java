package com.company.Excepciones;

/**
 * Excepci�n en caso de que se repita el insert de pel�cula.
 *
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */

public class clsPeliRepeException extends Exception {

    public final String mensaje = "Titulo repetido";

    @Override
    public String getMessage() {

        return mensaje;
    }
}
