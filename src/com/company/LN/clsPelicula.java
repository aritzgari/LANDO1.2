package com.company.LN;

import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * Clase para guardar datos de Peliculas en nuestra Base de Datos
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsPelicula extends clsArticulo implements itfProperty {

    /*atributos de la clase pelicula*/

    private String Director;
    private String Enlace_a_trailer;
    private String Sinopsis;
    private int Cantidad_actores;
    private String Actor1;
    private String Actor2;
    private String Actor3;
    private String Saga;
    private Double Orden;
    // el siguiente es la duración (Puede ser un TIME o algo asi)
    private int Duracion;
    private int Calporedad;
    private int Calificacion;
    //Añadidos a posteriori para identificarlos de forma relacional:
    private int Libreria_Multimedia_idLibreria_Multimedia = 0;


    //Constructor (No se usa / o sí, parece que si, en teoría debería)
    public clsPelicula(/*String Titulo, String Titulo_original, String Anno_de_publicacion, String Tipo_DoA, String Formato, boolean En_propiedad, boolean En_busqueda, double Precio, String Genero, String Premios, */String _Director, String _Enlace_a_trailer, String _Sinopsis, int _Cantidad_actores, String _Actor1, String _Actor2, String _Actor3, String _Saga, Double _Orden, int _Duracion, int _Calporedad, int _Calificacion, int _Libreria_Multimedia_idLibreria_Multimedia) {
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
        Libreria_Multimedia_idLibreria_Multimedia = _Libreria_Multimedia_idLibreria_Multimedia;
    }

    @Override
    public String getStringProperty(String propiedad) throws clsPropiedadNonExistantException {
        String propResultado = "";
        switch (propiedad) {
            case "Titulo":
                propResultado = getTitulo();
                break;
            case "Titulo_original":
                propResultado = getTitulo_original();
                break;
            case "Anno_de_publicacion":
                propResultado = getAnno_de_publicacion();
                break;
            case "Tipo_DoA":
                propResultado = getTipo_DoA();
                break;
            case "Formato":
                propResultado = getFormato();
                break;
            case "Genero":
                propResultado = getGenero();
                break;
            case "Premios":
                propResultado = getPremios();
                break;
            case "Director":
                propResultado = Director;
                break;
            case "Enlace_a_trailer":
                propResultado = Enlace_a_trailer;
                break;
            case "Sinopsis":
                propResultado = Sinopsis;
                break;
            case "Actor1":
                propResultado = Actor1;
                break;
            case "Actor2":
                propResultado = Actor2;
                break;
            case "Actor3":
                propResultado = Actor3;
                break;
            case "Saga":
                propResultado = Saga;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return propResultado;
    }

    @Override
    public Integer getIntegerProperty(String propiedad) throws clsPropiedadNonExistantException {
        int propResultado = 0;
        switch (propiedad) {
            case "Cantidad_actores":
                propResultado = Cantidad_actores;
                break;
            case "Duracion":
                propResultado = Duracion;
                break;
            case "Calporedad":
                propResultado = Calporedad;
                break;
            case "Calificacion":
                propResultado = Calificacion;
                break;
            case "Libreria_Multimedia_idLibreria_Multimedia":
                propResultado = Libreria_Multimedia_idLibreria_Multimedia;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return propResultado;
    }

    @Override
    public Float getFloatProperty(String propiedad) throws clsPropiedadNonExistantException {
        Float propResultado = null;
        switch (propiedad) {
            case "":
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return propResultado;
    }

    @Override
    public Double getDoubleProperty(String propiedad) throws clsPropiedadNonExistantException {
        Double propResultado = 0.0;
        switch (propiedad) {
            case "Precio":
                propResultado = getPrecio();
                break;
            case "Orden":
                propResultado = Orden;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return propResultado;
    }

    @Override
    public char getCharProperty(String propiedad) throws clsPropiedadNonExistantException {
        char propResultado = ' ';
        switch (propiedad) {
            case "":
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return propResultado;
    }

    @Override
    public boolean getBooleanProperty(String propiedad) throws clsPropiedadNonExistantException {
        boolean propResultado = false;
        switch (propiedad) {
            case "En_propiedad":
                propResultado = getEn_propiedad();
                break;
            case "En_busqueda":
                propResultado = getEn_busqueda();
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return propResultado;
    }
}
