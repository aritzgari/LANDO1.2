package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * @see itfPropertyV2
 * @see clsPropiedadNonExistantException
 */
public class clsActor implements itfPropertyV2 {
    private int idActores;
    private String Nombre;
    private String Apellido;

    public int getIdActores() {
        return idActores;
    }

    public void setIdActores(int idActores) {
        this.idActores = idActores;
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

    //Constructor
    public clsActor(int _idActor, String _Nombre, String _Apellido) {
        idActores=_idActor;
        Nombre=_Nombre;
        Apellido=_Apellido;
    }
    @Override
    public String toString() {
        return Nombre;
    }

    @Override
    public Object getObjectProperty(String propiedad) {
        Object retorno = new Object();

        switch (propiedad) {
            case "idActores":
                retorno = this.getIdActores();
                break;
            case "Nombre":
                retorno =  this.getNombre();
                break;
            case "Apellido":
                retorno =  this.getApellido();
                break;
            case "Clase":
                retorno = 3;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }

   }
