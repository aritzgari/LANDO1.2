package com.company.LN;


import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;


public class clsLibreriaMultimedia implements Comparable, itfPropertyV2 {
    /**
     * @author Ruben Domínguez
     * Aritz Garitano
     * <p>
     * Clase para crear y almacenar Liberrias de objetos multimedia.
     */
    private int idLibreria_Multimedia = 0;
    private String Nombre = "";
    private String Descripcion = "";

    public int getIdLibreria_Multimedia() {
        return idLibreria_Multimedia;
    }

    public void setIdLibreria_Multimedia(int idLibreria_Multimedia) {
        this.idLibreria_Multimedia = idLibreria_Multimedia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public clsLibreriaMultimedia(int _idLibreria_Multimedia, String _Nombre, String _Descripcion) {
        idLibreria_Multimedia = _idLibreria_Multimedia;
        Nombre = _Nombre;
        Descripcion = _Descripcion;
    }

    @Override
    public int compareTo(Object o) {
        /**
         * Método compareTo que ordena por Nombre, en orden ascendente (?)
         *
         */

        //Declaraciones
        clsLibreriaMultimedia objIn;

        //Para comprobar que son la misma clase y que el puntero no es null:
        if (o == null)
            throw new NullPointerException();
        if (o.getClass() != this.getClass())
            throw new ClassCastException();
        //Una vez comprobado, reconvertimos a o de object a clsLibreria

        objIn = (clsLibreriaMultimedia) o;


        return Nombre.compareTo(objIn.getNombre());
    }

    @Override
    public String toString() {
        return Nombre;
    }

    @Override
    public Object getObjectProperty(String propiedad) throws clsPropiedadNonExistantException {
        Object retorno = new Object();

        switch (propiedad) {
            case "idLibreria_Multimedia":
                retorno = this.getIdLibreria_Multimedia();
                break;
            case "Nombre":
                retorno =  this.getNombre();
                break;
            case "Descripción":
                retorno =  this.getDescripcion();
                break;
            case "Clase":
                retorno = 1;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }
}
