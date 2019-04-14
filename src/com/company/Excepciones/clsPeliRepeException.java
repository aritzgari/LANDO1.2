package com.company.Excepciones;

/**
 * Excepción en caso de que se repita el insert de película.
 *<p>
 * @author Ruben Domínguez
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
