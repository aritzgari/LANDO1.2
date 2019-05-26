package com.company.LN;

/**
 * Clase padre. Contiene atributos comunes de clsLibro, clsMusica y clsPelicula.
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public abstract class clsArticulo {
    /*atributos de la clase articulo*/
    private String Titulo;
    private String Titulo_original;
    //ESTE SERA UN DATE O ALGO
    private int Anno_de_publicacion;
    private String Tipo_DoA;
    private String Formato;
    private boolean En_propiedad;
    private boolean En_busqueda;
    private double Precio;
    private String Genero;
    //Tiene miga premios eh
    private String Premios;

    //Constructor vacío
    public clsArticulo() {
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getTitulo_original() {
        return Titulo_original;
    }

    public void setTitulo_original(String titulo_original) {
        Titulo_original = titulo_original;
    }

    public int getAnno_de_publicacion() {
        return Anno_de_publicacion;
    }

    public void setAnno_de_publicacion(int anno_de_publicacion) {
        Anno_de_publicacion = anno_de_publicacion;
    }

    public String getTipo_DoA() {
        return Tipo_DoA;
    }

    public void setTipo_DoA(String tipo_DoA) {
        Tipo_DoA = tipo_DoA;
    }

    public String getFormato() {
        return Formato;
    }

    public void setFormato(String formato) {
        Formato = formato;
    }

    public boolean getEn_propiedad() {
        return En_propiedad;
    }

    public void setEn_propiedad(boolean en_propiedad) {
        En_propiedad = en_propiedad;
    }

    public boolean getEn_busqueda() {
        return En_busqueda;
    }

    public void setEn_busqueda(boolean en_busqueda) {
        En_busqueda = en_busqueda;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getPremios() {
        return Premios;
    }

    public void setPremios(String premios) {
        Premios = premios;
    }

    public abstract Object getObjectProperty(String propiedad);
}
