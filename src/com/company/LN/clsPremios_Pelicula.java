package com.company.LN;

import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * <p>
 * @version 2.0 En la versión 1.0 esta clase no necesitaba implementar getObjectProperty porque lo heredaba.
 */
public class clsPremios_Pelicula extends clsPremios {
    //Atributos concretos (Tener en cuenta los heredados)
    private String Películas_Título;
    private String Películas_Libreria_Multimedia_idLibreria_Multimedia;

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
            case "Año":
                retorno = (Object) getAño();
                break;
            case "Películas_Título":
                retorno = (Object) Películas_Título;
                break;
            case "Películas_Libreria_Multimedia_idLibreria_Multimedia":
                retorno = (Object) Películas_Libreria_Multimedia_idLibreria_Multimedia;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }
}
