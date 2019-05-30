package com.company.LN;
import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * <p>
 * Clase para crear y almacenar generos de canciones.
 */

public class clsGeneroCancion implements itfPropertyV2 {
    private int idGénero_Canción = 0;
    private String Nombre= "";


    public int getIdGénero_Canción() {
        return idGénero_Canción;
    }

    public void setIdGénero_Canción(int idGénero_Canción) {
        this.idGénero_Canción = idGénero_Canción;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return Nombre;
    }

    @Override
    public Object getObjectProperty(String propiedad) throws clsPropiedadNonExistantException {
        Object retorno = new Object();

        switch (propiedad) {
            case "idGénero_Canción":
                retorno = this.getIdGénero_Canción();
                break;
            case "Nombre":
                retorno =  Nombre;
                break;
            case "Clase":
                retorno = 13;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }
}
