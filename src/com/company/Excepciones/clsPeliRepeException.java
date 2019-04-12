package com.company.Excepciones;

/**
 * Excepción en caso de que se repita el insert de película.
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsPeliRepeException extends Exception {

    public final String mensaje = "Titulo repetido";

    @Override
    public String getMessage() {

        return mensaje;
    }
}
