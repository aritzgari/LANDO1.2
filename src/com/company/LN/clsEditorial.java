package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

public class clsEditorial implements itfPropertyV2  {
    /**
     * @author Ruben Domínguez
     * Aritz Garitano
     * @see itfPropertyV2
     * @see clsPropiedadNonExistantException
     */
        //Atributos
        private int idEditorial;
        private String Nombre;

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    //Constructor con Parametros: Aun no

        //Constructor sin Parametros

        @Override
        public Object getObjectProperty(String propiedad) {
            Object retorno = new Object();

            switch (propiedad) {
                case "idEditorial":
                    retorno =  idEditorial;
                    break;
                case "Nombre":
                    retorno =  Nombre;
                    break;
                case "Clase":
                    retorno = 9;
                    break;
                default:
                    throw new clsPropiedadNonExistantException();
            }
            return retorno;
        }
    }

