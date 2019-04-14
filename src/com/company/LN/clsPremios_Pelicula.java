package com.company.LN;

import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Dom�nguez
 * Aritz Garitano
 * <p>
 * @version 2.0 En la versi�n 1.0 esta clase no necesitaba implementar getObjectProperty porque lo heredaba.
 */
public class clsPremios_Pelicula extends clsPremios {
    //Atributos concretos (Tener en cuenta los heredados)
    private String Pel�culas_T�tulo;
    private String Pel�culas_Libreria_Multimedia_idLibreria_Multimedia;

    //Constructor con Parametros: Aun no.

    //Constructor sin Parametros
    public clsPremios_Pelicula() {
    }

    public Object getObjectProperty(String propiedad) {

        Object retorno = new Object();

        switch (propiedad) {
            case "idPremios":
                retorno = (Object) getIdPremios();
                break;
            case "Nombre_del_Premio":
                retorno = (Object) getNombre_del_Premio();
                break;
            case "Categoria":
                retorno = (Object) getCategoria();
                break;
            case "A�o":
                retorno = (Object) getA�o();
                break;
            case "Pel�culas_T�tulo":
                retorno = (Object) Pel�culas_T�tulo;
                break;
            case "Pel�culas_Libreria_Multimedia_idLibreria_Multimedia":
                retorno = (Object) Pel�culas_Libreria_Multimedia_idLibreria_Multimedia;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }
}
