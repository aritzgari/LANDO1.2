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

    public int getIdGénero() {
        return idGénero;
    }

    public void setIdGénero(int idGénero) {
        this.idGénero = idGénero;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    //Constructor sin Parametros
    public clsGeneroPeli(int _idGénero, String _Nombre) {
        idGénero = _idGénero;
        Nombre = _Nombre;
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
