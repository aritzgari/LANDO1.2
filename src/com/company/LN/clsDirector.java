package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */
public class clsDirector implements itfPropertyV2 {
    //Atributos
    private int idDirector;
    private String Nombre;
    private String Apellido;
    //Constructor con Par�metros: Aun no

    //Constructor sin Par�metros
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
