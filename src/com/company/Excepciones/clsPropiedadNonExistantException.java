package com.company.Excepciones;

/**
 * Exception en caso de pedir una propiedad que no existe.
 *
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */
public class clsPropiedadNonExistantException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Error 404: Property not found";
    }
}
