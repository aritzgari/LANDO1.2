package com.company.LN;

/**
 * Clase para guardar datos de Musica en nuestra Base de Datos
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsMusica extends clsArticulo implements itfProperty {

    /*atributos de la clase musica*/
    int Cantidad_musicos;
    String Musico1;
    String Musico2;
    String Musico3;
    String Musico4;
    String Musico5;
    String Album;
    String Enlace_a_youtube;
    boolean Videoclip;

    public clsMusica(int _Cantidad_musicos, String _Musico1, String _Musico2, String _Musico3, String _Musico4, String _Musico5, String _Album, String _Enlace_a_youtube, boolean _Videoclip) {
        //Constructor
        Cantidad_musicos = _Cantidad_musicos;
        Musico1 = _Musico1;
        Musico2 = _Musico2;
        Musico3 = _Musico3;
        Musico4 = _Musico4;
        Musico5 = _Musico5;
        Album = _Album;
        Enlace_a_youtube = _Enlace_a_youtube;
        Videoclip = _Videoclip;
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
