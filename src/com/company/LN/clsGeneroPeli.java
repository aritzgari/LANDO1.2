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

    public int getIdG�nero() {
        return idG�nero;
    }

    public void setIdG�nero(int idG�nero) {
        this.idG�nero = idG�nero;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    //Constructor sin Parametros
    public clsGeneroPeli(int _idG�nero, String _Nombre) {
        idG�nero = _idG�nero;
        Nombre = _Nombre;
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
