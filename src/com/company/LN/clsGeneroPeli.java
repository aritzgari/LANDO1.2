package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsGeneroPeli implements itfPropertyV2 {
    //Atributos
    private int idGénero;
    private String Nombre;

    //Constructor sin Parametros
    public clsGeneroPeli() {
    }

    @Override
    public Object getObjectProperty(String propiedad) {
        Object retorno = new Object();

        switch (propiedad) {
            case "idGénero":
                retorno = (Object) idGénero;
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
