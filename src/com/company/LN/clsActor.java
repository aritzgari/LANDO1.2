package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 */
public class clsActor implements itfPropertyV2 {
    //Atributos
    private int idActores;
    private String Nombre;
    private String Apellido;

    //Constructor con Parametros: Aun no

    //Constructor sin Parametros
    public clsActor() {
    }

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
