package com.company.Excepciones;

/**
 * Excepci�n en caso de que se repita el insert de pel�cula.
 *<p>
 * @author Ruben Dom�nguez
 * Aritz Garitano
 * @return Devuelve un mensaje de error para cuando se intente realizar una insercci�n con un parametro NN vac�o.
 */

public class clsCampoContenidoVacio extends Exception {

    public final String mensaje = "Alg�n campo obligatorio vac�o, revise los campos";

    @Override
    public String getMessage() {

        return mensaje;
    }
}
