package com.company.LN;

public class clsLibreriaMultimedia {
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
}
