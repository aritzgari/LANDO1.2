package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsGeneroPeli implements itfPropertyV2 {
    //Atributos
    private int idGenero;
    private String Nombre;

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGénero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    //Constructor sin Parametros
    public clsGeneroPeli(int _idGenero, String _Nombre) {
        idGenero = _idGenero;
        Nombre = _Nombre;
    }

    @Override
    public String toString() {
        return Nombre;
    }

    @Override
    public Object getObjectProperty(String propiedad) {
        Object retorno = new Object();

        switch (propiedad) {
            case "idGénero":
                retorno = (Object) this.getIdGenero();
                break;
            case "Nombre":
                retorno = (Object) this.getNombre();
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }
}
