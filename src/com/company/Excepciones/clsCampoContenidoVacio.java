package com.company.Excepciones;

/**
 * Excepción en caso de que se repita el insert de película.
 *<p>
 * @author Ruben Domínguez
 * Aritz Garitano
 * @return Devuelve un mensaje de error para cuando se intente realizar una insercción con un parametro NN vacío.
 */

public class clsCampoContenidoVacio extends Exception {

    public final String mensaje = "Algún campo obligatorio vacío, revise los campos";

    @Override
    public String getMessage() {

        return mensaje;
    }
}
