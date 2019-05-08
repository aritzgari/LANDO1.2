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

    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    //Constructor con Parámetros
    public clsDirector(int _idDirector, String _Nombre, String _Apellido) {
        idDirector=_idDirector;
        Nombre= _Nombre;
        Apellido= _Apellido;
    }

    @Override
    public String toString() {
        return Nombre + " " + Apellido;
    }

    @Override
    public Object getObjectProperty(String propiedad) {
        Object retorno = new Object();

        switch (propiedad) {
            case "idDirector":
                retorno = this.idDirector;
                break;
            case "Nombre":
                retorno = this.Nombre;
                break;
            case "Apellido":
                retorno = this.Apellido;
                break;
            case "Clase":
                retorno = 4;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }}
