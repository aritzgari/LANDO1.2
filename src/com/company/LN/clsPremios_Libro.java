package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;


/**
 * Clase para guardar datos de premios de peliculas en nuestra Base de Datos
 * <p>
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */
public class clsPremios_Libro extends clsPremios implements itfPropertyV2 {

    private String Libros_ISBN;


    //Constructor con Parametros: Aun no.

    //Constructor sin Parametros
    public clsPremios_Libro(int _idPremios, String _Nombre, String _Categoria, int _Año, String _Libros_ISBN) {
        setNombre(_Nombre);
        setCategoria(_Categoria);
        setAño(_Año);
        Libros_ISBN=_Libros_ISBN;
        setIdPremios(_idPremios);
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
            case "Año":
                retorno =  getAño();
                break;
            case "Libro_ISBN":
                retorno = Libros_ISBN;
                break;
            case "Clase":
                retorno = 11;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }
}
