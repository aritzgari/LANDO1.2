package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * <p>
 * @version 2.0 En la versión 1.0 esta clase no necesitaba implementar getObjectProperty porque lo heredaba.
 */
public class clsPremios_Pelicula extends clsPremios implements itfPropertyV2 {
    //Atributos concretos (Tener en cuenta los heredados)
    private String Titulodepeliculas;


    //Constructor con Parametros:
    public clsPremios_Pelicula(String _Nombre, String _Categoria, int _Año, String _Titulodepeliculas) {
        setNombre(_Nombre);
        setCategoria(_Categoria);
        setAño(_Año);
        Titulodepeliculas = _Titulodepeliculas;
    }
    //Constructor sin Parametros


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
            case "Películas_Título":
                retorno = Titulodepeliculas;
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
