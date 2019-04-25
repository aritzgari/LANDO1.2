package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * @see itfPropertyV2
 * @see clsPropiedadNonExistantException
 */
public class clsActor implements itfProperty {
    private int idActores;
    private String Nombre;
    private String Apellido;


    //Constructor
    public clsActor(int _idActor, String _Nombre, String _Apellido) {
        idActores=_idActor;
        Nombre=_Nombre;
        Apellido=_Apellido;
    }


    @Override
    public String getStringProperty(String propiedad) throws clsPropiedadNonExistantException {
        String propResultado = "";
        switch (propiedad) {
            case "Nombre":
                propResultado = Nombre;
                break;
            case "Apellido":
                propResultado = Apellido;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return propResultado;
    }

    @Override
    public Integer getIntegerProperty(String propiedad) throws clsPropiedadNonExistantException {
        int propResultado = 0;
        switch (propiedad) {
            case "idActores":
                propResultado = idActores;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return propResultado;
    }
    @Override
    public String toString() {
        return Nombre;
    }

    @Override
    public Float getFloatProperty(String propiedad) {
        return null;
    }

    @Override
    public Double getDoubleProperty(String propiedad) {
        return null;
    }

    @Override
    public char getCharProperty(String propiedad) {
        return 0;
    }

    @Override
    public boolean getBooleanProperty(String propiedad) {
        return false;
    }
}