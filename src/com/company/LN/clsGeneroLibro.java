package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

public class clsGeneroLibro implements itfPropertyV2 {
    private String Nombre;
    private int idGénero_Libro;

    public clsGeneroLibro (int _idGénero_Libro, String _Nombre){
        idGénero_Libro=_idGénero_Libro;
        Nombre=_Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getIdGénero_Libro() {
        return idGénero_Libro;
    }

    public void setIdGénero_Libro(int idGénero_Libro) {
        this.idGénero_Libro = idGénero_Libro;
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
                retorno = this.getIdGénero_Libro();
                break;
            case "Nombre":
                retorno =  this.getNombre();
                break;
            case "Clase":
                retorno = 10;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }
}