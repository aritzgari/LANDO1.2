package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */

public class clsGeneroPeli implements itfPropertyV2 {
    //Atributos
    private int idG�nero;
    private String Nombre;

    //Constructor sin Parametros
    public clsGeneroPeli() {
    }

    @Override
    public Object getObjectProperty(String propiedad) {
        Object retorno = new Object();

        switch (propiedad) {
            case "idG�nero":
                retorno = (Object) idG�nero;
                break;
            case "Nombre":
                retorno = (Object) Nombre;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }
}
