package com.company.LN;

/**
 * Clase para guardar datos de Libros en nuestra Base de Datos
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsLibro extends clsArticulo implements itfProperty {

    /*atributos de la clase libro*/
    //-->private String Autor;
    private int Libreria_Multimedia_idLibreria_Multimedia;
    private String Resumen;
    //-->private String Editorial;
    //Formato se hereda
    private boolean Serie_SoN;
    private String Nombre_serie;
    private double Orden_serie;
    //ISBN no es un int porque es demasiado grande.
    private String ISBN;
    private int Paginas;

    //--> creados las clases editorial y autor.
    public clsLibro(int _libreria_Multimedia_idLibreria_Multimedia, String _ISBN, String _titulo, String _titulo_original, int _anno_de_publicacion, String _tipo_DoA, double _precio, boolean _en_propiedad, boolean _en_busqueda, String _formato, int _Paginas, String _Resumen, boolean _Serie_SoN, String _Nombre_serie, double _Orden_serie) {
        //Tal ves haya que usar setters aqui.
        //-->Autor = _Autor;
        //-->Editorial = _Editorial;
        Libreria_Multimedia_idLibreria_Multimedia = _libreria_Multimedia_idLibreria_Multimedia;
        ISBN = _ISBN;
        setTitulo(_titulo);
        setTitulo_original(_titulo_original);
        setAnno_de_publicacion(_anno_de_publicacion);
        setTipo_DoA(_tipo_DoA);
        setPrecio(_precio);
        setEn_propiedad(_en_propiedad);
        setEn_busqueda(_en_busqueda);
        setFormato(_formato);
        Paginas = _Paginas;
        Resumen = _Resumen;
        Serie_SoN = _Serie_SoN;
        Nombre_serie = _Nombre_serie;
        Orden_serie = _Orden_serie;

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
            case "Tipo_DoA":
                propResultado = getTipo_DoA();
                break;
            case "Formato":
                propResultado = getFormato();
                break;
            case "Genero":
                propResultado = getGenero();// no usado pero esta
                break;
            case "Premios":
                propResultado = getPremios();// no usado pero esta
                break;
            case "ISBN":
                propResultado = ISBN;
                break;
            case "Resumen":
                propResultado = Resumen;
                break;
            case "Nombre_serie":
                propResultado = Nombre_serie;
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
            case "Anno_de_publicacion":
                propResultado = getAnno_de_publicacion();
                break;
            case "Paginas":
                propResultado = Paginas;
                break;
            case "Libreria_Multimedia_idLibreria_Multimedia":
                propResultado = Libreria_Multimedia_idLibreria_Multimedia;
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
            case "Orden_serie":
                propResultado = Orden_serie;
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
            case "Serie_SoN":
                propResultado = Serie_SoN;
                break;
            default:
                System.out.println("Propiedad no encontrada.");
                break;
        }
        return propResultado;
    }
}
