package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * <p>
 * Clase para crear y almacenar generos de canciones.
 */
public class clsAlbum implements itfPropertyV2 {

    private int Cantante_idCantante = 0;
    private String Nombre = "";


    public int getCantante_idCantante() {
        return Cantante_idCantante;
    }

    public void setCantante_idCantante(int cantante_idCantante) {
        Cantante_idCantante = cantante_idCantante;
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
            case "Cantante_idCantante":
                retorno = this.getCantante_idCantante();
                break;
            case "Nombre":
                retorno =  Nombre;
                break;
            case "Clase":
                retorno = 16;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }
}
