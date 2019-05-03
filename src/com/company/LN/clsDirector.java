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

    //Constructor sin Parámetros
    public clsDirector(int idDirector, String Nombre, String Apelido) {
    }

    @Override
    public Object getObjectProperty(String propiedad) {
        Object retorno = new Object();

        switch (propiedad) {
            case "idDirector":
                retorno = idDirector;
                break;
            case "Nombre":
                retorno = Nombre;
                break;
            case "Apellido":
                retorno = Apellido;
                break;
            case "Clase":
                retorno = 4;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }

    @Override
    public String toString() {
        return Nombre + " " + Apellido;
    }
}
