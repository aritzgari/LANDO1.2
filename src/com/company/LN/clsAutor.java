package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

public class clsAutor implements itfPropertyV2 {
    /**
     * @author Ruben Domínguez
     * Aritz Garitano
     * @see itfPropertyV2
     * @see clsPropiedadNonExistantException
     */
    //Atributos
    private int idAutor;
    private String Nombre;
    private String Apellido;

    public clsAutor(int _idAutor, String _Nombre, String _Apellido) {
        idAutor=_idAutor;
        Nombre=_Nombre;
        Apellido=_Apellido;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }
    //Constructor con Parametros: Aun no

    //Constructor sin Parametros


    @Override
    public String toString() {
        return Nombre;
    }

    @Override
    public Object getObjectProperty(String propiedad) {
        Object retorno = new Object();

        switch (propiedad) {
            case "idAutor":
                retorno = (Object) idAutor;
                break;
            case "Nombre":
                retorno = (Object) Nombre;
                break;
            case "Apellido":
                retorno = (Object) Apellido;
                break;
            case "Clase":
                retorno = 8;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }
}


