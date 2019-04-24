package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

public class clsAutor {
    /**
     * @author Ruben Domínguez
     * Aritz Garitano
     * @see itfPropertyV2
     * @see clsPropiedadNonExistantException
     */
    public class clsActor implements itfPropertyV2 {
        //Atributos
        private int idAutor;
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
                case "idAutor":
                    retorno = (Object) idAutor;
                    break;
                case "Nombre":
                    retorno = (Object) Nombre;
                    break;
                case "Apellido":
                    retorno = (Object) Apellido;
                default:
                    throw new clsPropiedadNonExistantException();
            }
            return retorno;
        }
    }

}
