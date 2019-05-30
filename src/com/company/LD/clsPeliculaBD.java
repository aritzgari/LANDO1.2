package com.company.LD;

import java.sql.SQLException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * <p>
 * Clase para crear y almacenar peliculas.
 * @see SQLException
 */

public class clsPeliculaBD extends clsConexionBD {
    //Atributos de Pelicula en BD
    private int Libreria_Multimedia_idLibreria_Multimedia;
    private String Titulo;
    private String Titulo_original;
    private int Anno_de_publicacion;
    private int Duracion;
    private int Calificacion;
    private int Calporedad;
    private String Tipo_DoA;
    private double Precio;
    private boolean En_propiedad;
    private boolean En_busqueda;
    private String Formato;
    private String Saga;
    private Double Orden;
    private String Sinopsis;
    private String Enlace_a_trailer;

    //No utilizados en esta clase
    private String Genero;
    private String Premios;
    private String Director;
    private int Cantidad_actores;
    private String Actor1;
    private String Actor2;
    private String Actor3;


    //Constructor con parametros, pensado para el insert
    public clsPeliculaBD(int _libreria_Multimedia_idLibreria_Multimedia, String _titulo, String _titulo_original, int _anno_de_publicacion, int _duracion, int _calificacion, int _calporedad, String _tipo_DoA, double _precio, boolean _en_propiedad, boolean _en_busqueda, String _formato, String _saga, Double _orden, String _sinopsis, String _enlace_a_trailer) {
        setLibreria_Multimedia_idLibreria_Multimedia(_libreria_Multimedia_idLibreria_Multimedia);
        setTitulo(_titulo);
        setTitulo_original(_titulo_original);
        setAnno_de_publicacion(_anno_de_publicacion);
        setDuracion(_duracion);
        setCalificacion(_calificacion);
        setCalporedad(_calporedad);
        setTipo_DoA(_tipo_DoA);
        setPrecio(_precio);
        setEn_propiedad(_en_propiedad);
        setEn_busqueda(_en_busqueda);
        setFormato(_formato);
        setSaga(_saga);
        setOrden(_orden);
        setSinopsis(_sinopsis);
        setEnlace_a_trailer(_enlace_a_trailer);
    }

    //Constructor sin parametros, pensado para el select
    public clsPeliculaBD() {

    }


    public int getLibreria_Multimedia_idLibreria_Multimedia() {
        return Libreria_Multimedia_idLibreria_Multimedia;
    }

    public void setLibreria_Multimedia_idLibreria_Multimedia(int libreria_Multimedia_idLibreria_Multimedia) {
        Libreria_Multimedia_idLibreria_Multimedia = libreria_Multimedia_idLibreria_Multimedia;
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

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int duracion) {
        Duracion = duracion;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int calificacion) {
        Calificacion = calificacion;
    }

    public int getCalporedad() {
        return Calporedad;
    }

    public void setCalporedad(int calporedad) {
        Calporedad = calporedad;
    }

    public String getTipo_DoA() {
        return Tipo_DoA;
    }

    public void setTipo_DoA(String tipo_DoA) {
        Tipo_DoA = tipo_DoA;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
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

    public String getFormato() {
        return Formato;
    }

    public void setFormato(String formato) {
        Formato = formato;
    }

    public String getSaga() {
        return Saga;
    }

    public void setSaga(String saga) {
        Saga = saga;
    }

    public Double getOrden() {
        return Orden;
    }

    public void setOrden(Double orden) {
        Orden = orden;
    }

    public String getSinopsis() {
        return Sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        Sinopsis = sinopsis;
    }

    public String getEnlace_a_trailer() {
        return Enlace_a_trailer;
    }

    public void setEnlace_a_trailer(String enlace_a_trailer) {
        Enlace_a_trailer = enlace_a_trailer;
    }

    @Override
    public int sendInsert(String query) {
        this.conectarBD();
        int regActualizados = 0;
        int retorno = 0;


        try {
            this.setObjSt(this.getObjCon().prepareStatement(query, this.getObjSt().RETURN_GENERATED_KEYS));

            this.getObjSt().setInt(1, getLibreria_Multimedia_idLibreria_Multimedia());
            this.getObjSt().setString(2, getTitulo());
            this.getObjSt().setString(3, getTitulo_original());
            this.getObjSt().setInt(4, getAnno_de_publicacion());
            this.getObjSt().setInt(5, getDuracion());
            this.getObjSt().setInt(6, getCalificacion());
            this.getObjSt().setInt(7, getCalporedad());
            this.getObjSt().setString(8, getTipo_DoA());
            this.getObjSt().setDouble(9, getPrecio());
            this.getObjSt().setBoolean(10, getEn_propiedad());
            this.getObjSt().setBoolean(11, getEn_busqueda());
            this.getObjSt().setString(12, getFormato());
            this.getObjSt().setString(13, getSaga());
            this.getObjSt().setDouble(14, getOrden());
            this.getObjSt().setString(15, getSinopsis());
            this.getObjSt().setString(16, getEnlace_a_trailer());

            regActualizados = this.getObjSt().executeUpdate();
            retorno = regActualizados;

            /*if (regActualizados == 1) {
                this.setObjRs(this.getObjSt().getGeneratedKeys());
                if (this.getObjRs().next()) {
                    //En este retorno me da el AutoIncremental con el +1 hecho, es decir, listo para insertarlo.
                    retorno = this.getObjRs().getInt(1);
                }
            }*/


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.desconectarBD(this.getObjCon());
        return retorno;
    }

    @Override
    public int sendUpdate(String query) {
        return 0;
    }
}
