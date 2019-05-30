package com.company.LN;
import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Dom�nguez
 * Aritz Garitano
 * <p>
 * Clase para crear y almacenar generos de canciones.
 */

public class clsGeneroCancion implements itfPropertyV2 {
    private int idG�nero_Canci�n = 0;
    private String Nombre= "";


    public int getIdG�nero_Canci�n() {
        return idG�nero_Canci�n;
    }

    public void setIdG�nero_Canci�n(int idG�nero_Canci�n) {
        this.idG�nero_Canci�n = idG�nero_Canci�n;
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
            case "idG�nero_Canci�n":
                retorno = this.getIdG�nero_Canci�n();
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
