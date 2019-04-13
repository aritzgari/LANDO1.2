package com.company.Excepciones;

/**
 * Exception en caso de pedir una propiedad que no existe.
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 * @return Devuelve un mensaje de error para cuando programamos mal la petición de una propiedad, y para la ejecución.
 */
public class clsPropiedadNonExistantException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Error 404: Property not found";
    }
}
