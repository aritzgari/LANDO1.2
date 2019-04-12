package com.company.LN;


import com.company.Excepciones.clsPropiedadNonExistantException;

public class clsLibreriaMultimedia implements Comparable, itfProperty {
    /**
     * @author Ruben Domínguez
     * Aritz Garitano
     * <p>
     * Clase para crear y almacenar Liberrias de objetos multimedia.
     **/
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
         *
         * Método compareTo que ordena por Nombre, en orden ascendente (?)
         *
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
        return "clsLibreriaMultimedia{" +
                "idLibreria_Multimedia=" + idLibreria_Multimedia +
                ", Nombre='" + Nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }

    @Override
    public String getStringProperty(String propiedad) {
        String propResultado = "";
        switch (propiedad) {
            case "Nombre":
                propResultado = this.getNombre();
                break;
            case "Descripcion":
                propResultado = this.getDescripcion();
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return propResultado;
    }

    @Override
    public Integer getIntegerProperty(String propiedad) {
        Integer propResultado = 0;
        switch (propiedad) {
            case "IdLibreria_Multimedia":
                propResultado = this.getIdLibreria_Multimedia();
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return propResultado;
    }

    @Override
    public Float getFloatProperty(String propiedad) {
        throw new clsPropiedadNonExistantException();
    }

    @Override
    public Double getDoubleProperty(String propiedad) {
        throw new clsPropiedadNonExistantException();
    }

    @Override
    public char getCharProperty(String propiedad) {
        throw new clsPropiedadNonExistantException();
    }

    @Override
    public boolean getBooleanProperty(String propiedad) {
        throw new clsPropiedadNonExistantException();
    }
}
