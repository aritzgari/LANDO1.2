package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */
public class clsDirector implements itfPropertyV2 {
    //Atributos

    //Constructor sin Par�metros


    @Override
    public Object getObjectProperty(String propiedad) {
        Object retorno = new Object();

        switch (propiedad) {
            case "idActores":
                retorno = (Object) idActores;
                break;
            case "Nombre":
                retorno = (Object) Nombre;
                break;
            case "Apellido":
                retorno = (Object) Apellido;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }
}
