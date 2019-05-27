package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

/**
 * Clase para guardar datos de Libros en nuestra Base de Datos
 *
 * @author Ruben Domínguez
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
    private int idEditorial;

    public int getLibreria_Multimedia_idLibreria_Multimedia() {
        return Libreria_Multimedia_idLibreria_Multimedia;
    }

    public void setLibreria_Multimedia_idLibreria_Multimedia(int libreria_Multimedia_idLibreria_Multimedia) {
        Libreria_Multimedia_idLibreria_Multimedia = libreria_Multimedia_idLibreria_Multimedia;
    }

    public String getResumen() {
        return Resumen;
    }

    public void setResumen(String resumen) {
        Resumen = resumen;
    }

    public boolean isSerie_SoN() {
        return Serie_SoN;
    }

    public void setSerie_SoN(boolean serie_SoN) {
        Serie_SoN = serie_SoN;
    }

    public String getNombre_serie() {
        return Nombre_serie;
    }

    public void setNombre_serie(String nombre_serie) {
        Nombre_serie = nombre_serie;
    }

    public double getOrden_serie() {
        return Orden_serie;
    }

    public void setOrden_serie(double orden_serie) {
        Orden_serie = orden_serie;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPaginas() {
        return Paginas;
    }

    public void setPaginas(int paginas) {
        Paginas = paginas;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    //--> creados las clases editorial y autor.

    //FALTAN AUTOR Y GENERO @importante #Urgente

    public clsLibro(int _libreria_Multimedia_idLibreria_Multimedia, String _ISBN, String _titulo, String _titulo_original, int _anno_de_publicacion, String _tipo_DoA, double _precio, boolean _en_propiedad, boolean _en_busqueda, String _formato, int _Paginas, String _Resumen, boolean _Serie_SoN, String _Nombre_serie, double _Orden_serie, int _idGenero, int _idAutor, int _idEditorial) {
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
        idEditorial=_idEditorial;
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
            case "Título":
                retorno =  this.getTitulo();
                break;
            case "Título_original":
                retorno =  this.getTitulo_original();
                break;
            case "Año":
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
            case "Género_Libro_idGénero_Libro":
                retorno = idGenero;
                break;
            case "Autor_idAutor":
                retorno = idAutor;
                break;
            case "Editorial_idEditorial":
                retorno = idEditorial;
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
