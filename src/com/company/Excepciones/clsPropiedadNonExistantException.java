package com.company.Excepciones;

/**
 * Exception en caso de pedir una propiedad que no existe.
 *
 * @author Ruben Dom�nguez
 * Aritz Garitano
 * @return Devuelve un mensaje de error para cuando programamos mal la petici�n de una propiedad, y para la ejecuci�n.
 */
public class clsPropiedadNonExistantException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Error 404: Property not found";
    }
}
