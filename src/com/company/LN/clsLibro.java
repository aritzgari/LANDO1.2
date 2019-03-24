package com.company.LN;

/**
 * Clase para guardar datos de Libros en nuestra Base de Datos
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsLibro extends clsArticulo implements itfProperty{

    /*atributos de la clase libro*/
    String Autor;
    String Resumen;
    String Editorial;
    //Formato se hereda
    boolean Serie_SoN;
    String Nombre_serie;
    double Orden_serie;
    //ISBN no es un int porque es demasiado grande.
    String ISBN;
    int Paginas;

    public clsLibro(String _Autor, String _Resumen, String _Editorial, boolean _Serie_SoN, String _Nombre_serie, double _Orden_serie, String _ISBN, int _Paginas) {
        //Constructor (No se usa porque el padre tiene constructor)
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
