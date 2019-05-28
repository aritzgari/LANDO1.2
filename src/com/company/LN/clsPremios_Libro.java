package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

public class clsPremios_Libro extends clsPremios implements itfPropertyV2 {

    private String Libros_ISBN;


    //Constructor con Parametros: Aun no.

    //Constructor sin Parametros
    public clsPremios_Libro(String _Nombre, String _Categoria, int _A�o) {
        setNombre(_Nombre);
        setCategoria(_Categoria);
        setA�o(_A�o);
    }

    @Override
    public String toString() {
        return getNombre();
    }

    @Override
    public Object getObjectProperty(String propiedad) {

        Object retorno = new Object();

        switch (propiedad) {
            case "idPremios":
                retorno =  getIdPremios();
                break;
            case "Nombre":
                retorno =  getNombre();
                break;
            case "Categoria":
                retorno =  getCategoria();
                break;
            case "A�o":
                retorno =  getA�o();
                break;
            case "Libros_ISBN":
                retorno = Libros_ISBN;
                break;
            case "Clase":
                retorno = 6;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }
}
