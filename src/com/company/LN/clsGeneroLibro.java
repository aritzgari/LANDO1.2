package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

public class clsGeneroLibro implements itfPropertyV2 {
    private String Nombre;
    private int idG�nero_Libro;

    public clsGeneroLibro (int _idG�nero_Libro, String _Nombre){
        idG�nero_Libro=_idG�nero_Libro;
        Nombre=_Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getIdG�nero_Libro() {
        return idG�nero_Libro;
    }

    public void setIdG�nero_Libro(int idG�nero_Libro) {
        this.idG�nero_Libro = idG�nero_Libro;
    }

    @Override
    public String toString() {
        return Nombre;
    }

    @Override
    public Object getObjectProperty(String propiedad) {
        Object retorno = new Object();

        switch (propiedad) {
            case "idG�nero":
                retorno = this.getIdG�nero_Libro();
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