package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 */
public class clsDirector implements itfPropertyV2 {
    //Atributos
    private int idDirector;
    private String Nombre;
    private String Apellido;
    //Constructor con Parámetros: Aun no

    //Constructor sin Parámetros
    public clsDirector() {
    }

    @Override
    public Object getObjectProperty(String propiedad) {
        Object retorno = new Object();

        switch (propiedad) {
            case "idDirector":
                retorno = (Object) idDirector;
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
