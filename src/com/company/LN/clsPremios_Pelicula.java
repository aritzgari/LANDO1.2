package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Dom�nguez
 * Aritz Garitano
 * <p>
 * @version 2.0 En la versi�n 1.0 esta clase no necesitaba implementar getObjectProperty porque lo heredaba.
 */
public class clsPremios_Pelicula extends clsPremios implements itfPropertyV2 {
    //Atributos concretos (Tener en cuenta los heredados)
    private String Titulodepeliculas;


    //Constructor con Parametros:
    public clsPremios_Pelicula(String _Nombre, String _Categoria, int _A�o, String _Titulodepeliculas) {
        setNombre(_Nombre);
        setCategoria(_Categoria);
        setA�o(_A�o);
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
            case "A�o":
                retorno =  getA�o();
                break;
            case "Pel�culas_T�tulo":
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
