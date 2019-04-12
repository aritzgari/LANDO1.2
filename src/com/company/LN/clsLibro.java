package com.company.LN;

/**
 * Clase para guardar datos de Libros en nuestra Base de Datos
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsLibro extends clsArticulo implements itfProperty {

    /*atributos de la clase libro*/
    private String Autor;
    private String Resumen;
    private String Editorial;
    //Formato se hereda
    private boolean Serie_SoN;
    private String Nombre_serie;
    private double Orden_serie;
    //ISBN no es un int porque es demasiado grande.
    private String ISBN;
    private int Paginas;

    public clsLibro(String _Autor, String _Resumen, String _Editorial, boolean _Serie_SoN, String _Nombre_serie, double _Orden_serie, String _ISBN, int _Paginas) {
        //Tal ves haya que usar setters aqui.
        Autor = _Autor;
        Resumen = _Resumen;
        Editorial = _Editorial;
        Serie_SoN = _Serie_SoN;
        Nombre_serie = _Nombre_serie;
        Orden_serie = _Orden_serie;
        ISBN = _ISBN;
        Paginas = _Paginas;


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
}
