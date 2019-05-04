package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * Clase para guardar datos de Libros en nuestra Base de Datos
 *
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */

public class clsLibro extends clsArticulo implements itfPropertyV2 {

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
    private int idGenero;
    private int idAutor;

    //--> creados las clases editorial y autor.

    //FALTAN AUTOR Y GENERO @importante #Urgente

    public clsLibro(int _libreria_Multimedia_idLibreria_Multimedia, String _ISBN, String _titulo, String _titulo_original, int _anno_de_publicacion, String _tipo_DoA, double _precio, boolean _en_propiedad, boolean _en_busqueda, String _formato, int _Paginas, String _Resumen, boolean _Serie_SoN, String _Nombre_serie, double _Orden_serie, int _idGenero, int _idAutor) {
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
        idGenero = _idGenero;
        idAutor = _idAutor;
    }


    @Override
    public String toString() {
        return ISBN;
    }

    @Override
    public Object getObjectProperty(String propiedad) {
        Object retorno = new Object();

        switch (propiedad) {
            case "Libreria_Multimedia_idLibreria_Multimedia":
                retorno = Libreria_Multimedia_idLibreria_Multimedia;
                break;
            case "ISBN":
                retorno = ISBN;
                break;
            case "T�tulo":
                retorno =  this.getTitulo();
                break;
            case "T�tulo_original":
                retorno =  this.getTitulo_original();
                break;
            case "A�o":
                retorno =  this.getAnno_de_publicacion();
                break;
            case "Tipo_DoA":
                retorno =  this.getTipo_DoA();
                break;
            case "Precio":
                retorno =  this.getPrecio();
                break;
            case "En_propiedad":
                retorno =  this.getEn_propiedad();
                break;
            case "En_busqueda":
                retorno =  this.getEn_busqueda();
                break;
            case "Formato":
                retorno = this.getFormato();
                break;
            case "Paginas":
                retorno = Paginas;
                break;
            case "Resumen":
                retorno = Resumen;
                break;
            case "Serie_SoN":
                retorno = Serie_SoN;
                break;
            case "Nombre_serie":
                retorno = Nombre_serie;
                break;
            case "Orden_serie":
                retorno = Orden_serie;
                break;
            case "G�nero_Libro_idG�nero_Libro":
                retorno = idGenero;
                break;
            case "Autor_idAutor":
                retorno = idAutor;
                break;
            case "Clase":
                retorno = 7;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }
}
