package com.company.LN;
import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * <p>
 * Clase para crear y almacenar generos de canciones.
 */

public class clsCantante implements itfPropertyV2 {
    private int idCantante = 0;
    private String Nombre = "";
    private String Apellido= "";


    public int getIdCantante() {
        return idCantante;
    }

    public void setIdCantante(int idCantante) {
        this.idCantante = idCantante;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
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
            case "idCantante":
                retorno = this.getIdCantante();
                break;
            case "Nombre":
                retorno =  Nombre;
                break;
            case "Apellido":
                retorno =  Apellido;
                break;
            case "Clase":
                retorno = 15;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }
}
