package com.company.LN;

/**
 * Clase para guardar datos de Peliculas en nuestra Base de Datos
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsPelicula extends clsArticulo implements itfProperty {

    /*atributos de la clase pelicula*/

    String Director;
    String Enlace_a_trailer;
    String Sinopsis;
    int Cantidad_actores;
    String Actor1;
    String Actor2;
    String Actor3;
    String Saga;
    Double Orden;
    // el siguiente es la duracion (Puede ser un TIME o algo asi)
    int Duracion;
    int Calporedad;
    int Calificacion;

    //Constructor (No se usa)
    public clsPelicula(/*String Titulo, String Titulo_original, String Anno_de_publicacion, String Tipo_DoA, String Formato, boolean En_propiedad, boolean En_busqueda, double Precio, String Genero, String Premios, */String _Director, String _Enlace_a_trailer, String _Sinopsis, int _Cantidad_actores, String _Actor1, String _Actor2, String _Actor3, String _Saga, Double _Orden, int _Duracion, int _Calporedad, int _Calificacion) {
        //Variables "Heredadas":

        //super.Titulo = _Titulo;

        //Variables de la clase:
        Director = _Director;
        Enlace_a_trailer = _Enlace_a_trailer;
        Sinopsis = _Sinopsis;
        Cantidad_actores = _Cantidad_actores;
        Actor1 = _Actor1;
        Actor2 = _Actor2;
        Actor3 = _Actor3;
        Saga = _Saga;
        Orden = _Orden;
        Duracion = _Duracion;
        Calporedad = _Calporedad;
        Calificacion = _Calificacion;
    }

    @Override
    public String getStringProperty(String propiedad) {
        String propResultado = "";
        switch (propiedad) {
            case "Titulo":
                propResultado = Titulo;
                break;
            case "Titulo_original":
                propResultado = Titulo_original;
                break;
            case "Anno_de_publicacion":
                propResultado = Anno_de_publicacion;
                break;
            case "Tipo_DoA":
                propResultado = Tipo_DoA;
                break;
            case "Formato":
                propResultado = Formato;
                break;
            case "Genero":
                propResultado = Genero;
                break;
            case "Premios":
                propResultado = Premios;
                break;
            default:
                System.out.println("Propiedad no encontrada.");
                break;
        }
        return propResultado;
    }

    @Override
    public Integer getIntegerProperty(String propiedad) {
        int propResultado = 0;
        switch (propiedad) {
            case "":
                break;
            default:
                System.out.println("Propiedad no encontrada.");
                break;
        }
        return propResultado;
    }

    @Override
    public Float getFloatProperty(String propiedad) {
        Float propResultado = null;
        switch (propiedad) {
            case "":
                break;
            default:
                System.out.println("Propiedad no encontrada.");
                break;
        }
        return propResultado;
    }

    @Override
    public Double getDoubleProperty(String propiedad) {
        Double propResultado = 0.0;
        switch (propiedad) {
            case "Precio":
                propResultado = Precio;
                break;
            default:
                System.out.println("Propiedad no encontrada.");
                break;
        }
        return propResultado;
    }

    @Override
    public char getCharProperty(String propiedad) {
        char propResultado = ' ';
        switch (propiedad) {
            case "":
                break;
            default:
                System.out.println("Propiedad no encontrada.");
                break;
        }
        return propResultado;
    }

    @Override
    public boolean getBooleanProperty(String propiedad) {
        boolean propResultado = false;
        switch (propiedad) {
            case "En_propiedad":
                propResultado = En_propiedad;
                break;
            case "En_busqueda":
                propResultado = En_busqueda;
                break;
            default:
                System.out.println("Propiedad no encontrada.");
                break;
        }
        return propResultado;
    }
}
