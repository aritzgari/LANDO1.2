package com.company.LN;

/**
 * Clase para guardar datos de Música en nuestra Base de Datos
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsMusica extends clsArticulo implements itfProperty {

    /*atributos de la clase musica*/
    private int Cantidad_musicos;
    private String Musico1;
    private String Musico2;
    private String Musico3;
    private String Musico4;
    private String Musico5;
    private String Album;
    private String Enlace_a_youtube;
    private boolean Videoclip;

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
                propResultado = getPrecio();
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
                propResultado = getEn_propiedad();
                break;
            case "En_busqueda":
                propResultado = getEn_busqueda();
                break;
            default:
                System.out.println("Propiedad no encontrada.");
                break;
        }
        return propResultado;
    }

    public int getCantidad_musicos() {
        return Cantidad_musicos;
    }

    public void setCantidad_musicos(int cantidad_musicos) {
        Cantidad_musicos = cantidad_musicos;
    }

    public String getMusico1() {
        return Musico1;
    }

    public void setMusico1(String musico1) {
        Musico1 = musico1;
    }

    public String getMusico2() {
        return Musico2;
    }

    public void setMusico2(String musico2) {
        Musico2 = musico2;
    }

    public String getMusico3() {
        return Musico3;
    }

    public void setMusico3(String musico3) {
        Musico3 = musico3;
    }

    public String getMusico4() {
        return Musico4;
    }

    public void setMusico4(String musico4) {
        Musico4 = musico4;
    }

    public String getMusico5() {
        return Musico5;
    }

    public void setMusico5(String musico5) {
        Musico5 = musico5;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }

    public String getEnlace_a_youtube() {
        return Enlace_a_youtube;
    }

    public void setEnlace_a_youtube(String enlace_a_youtube) {
        Enlace_a_youtube = enlace_a_youtube;
    }

    public boolean getVideoclip() {
        return Videoclip;
    }

    public void setVideoclip(boolean videoclip) {
        Videoclip = videoclip;
    }
}
