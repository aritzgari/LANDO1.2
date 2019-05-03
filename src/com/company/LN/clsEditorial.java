package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

public class clsEditorial {
    /**
     * @author Ruben Domínguez
     * Aritz Garitano
     * @see itfPropertyV2
     * @see clsPropiedadNonExistantException
     */
    public class clsActor implements itfPropertyV2 {
        //Atributos
        private int idActores;
        private String Nombre;
        private String Apellido;

        //Constructor con Parametros: Aun no

        //Constructor sin Parametros
        public clsActor() {
        }

        @Override
        public Object getObjectProperty(String propiedad) {
            Object retorno = new Object();

            switch (propiedad) {
                case "idActores":
                    retorno =  idActores;
                    break;
                case "Nombre":
                    retorno =  Nombre;
                    break;
                case "Apellido":
                    retorno =  Apellido;
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

}
