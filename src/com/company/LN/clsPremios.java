package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Dom�nguez
 * Aritz Garitano
 * <p>
 * @version 2.0 En la versi�n 1.0 esta clase no era abstracta y el metodo getObjectProperty se implementaba en ella. No se descarta volver a ese modelo.
 */

public abstract class clsPremios implements itfPropertyV2 {
    //Atributos, por ahora son protected.
    private int idPremios;
    private String Nombre;
    private String Categoria;
    private int A�o;

    public int getIdPremios() {
        return idPremios;
    }

    public void setIdPremios(int idPremios) {
        this.idPremios = idPremios;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public int getA�o() {
        return A�o;
    }

    public void setA�o(int a�o) {
        A�o = a�o;
    }
}
