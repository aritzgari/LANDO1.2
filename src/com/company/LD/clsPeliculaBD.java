package com.company.LD;

import java.sql.SQLException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * <p>
 * Clase para crear y almacenar peliculas.
 */
public class clsPeliculaBD extends clsConexionBD {
    private String Titulo;
    private String Titulo_original;
    private String Anno_de_publicacion;
    private String Tipo_DoA;
    private String Formato;
    private boolean En_propiedad;
    private boolean En_busqueda;
    private double Precio;
    private String Genero;
    private String Premios;
    private String Director;
    private String Enlace_a_trailer;
    private String Sinopsis;
    private int Cantidad_actores;
    private String Actor1;
    private String Actor2;
    private String Actor3;
    private String Saga;
    private Double Orden;
    private int Duracion;
    private int Calporedad;
    private int Calificacion;
    private int Libreria_Multimedia_idLibreria_Multimedia = 0;

    public clsPeliculaBD(String titulo, String titulo_original, String anno_de_publicacion, String tipo_doA, String formato, boolean en_propiedad, boolean en_busqueda, int duracion, int calporedad, int calificacion, int libreria_multimedia_idLibreria_multimedia) {
        super();
    }

    public clsPeliculaBD() {

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

    public String getAnno_de_publicacion() {
        return Anno_de_publicacion;
    }

    public void setAnno_de_publicacion(String anno_de_publicacion) {
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

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getEnlace_a_trailer() {
        return Enlace_a_trailer;
    }

    public void setEnlace_a_trailer(String enlace_a_trailer) {
        Enlace_a_trailer = enlace_a_trailer;
    }

    public String getSinopsis() {
        return Sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        Sinopsis = sinopsis;
    }

    public int getCantidad_actores() {
        return Cantidad_actores;
    }

    public void setCantidad_actores(int cantidad_actores) {
        Cantidad_actores = cantidad_actores;
    }

    public String getActor1() {
        return Actor1;
    }

    public void setActor1(String actor1) {
        Actor1 = actor1;
    }

    public String getActor2() {
        return Actor2;
    }

    public void setActor2(String actor2) {
        Actor2 = actor2;
    }

    public String getActor3() {
        return Actor3;
    }

    public void setActor3(String actor3) {
        Actor3 = actor3;
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

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int duracion) {
        Duracion = duracion;
    }

    public int getCalporedad() {
        return Calporedad;
    }

    public void setCalporedad(int calporedad) {
        Calporedad = calporedad;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int calificacion) {
        Calificacion = calificacion;
    }

    public int getLibreria_Multimedia_idLibreria_Multimedia() {
        return Libreria_Multimedia_idLibreria_Multimedia;
    }

    public void setLibreria_Multimedia_idLibreria_Multimedia(int libreria_Multimedia_idLibreria_Multimedia) {
        Libreria_Multimedia_idLibreria_Multimedia = libreria_Multimedia_idLibreria_Multimedia;
    }

    @Override
    public int sendInsert(String query) {
        this.conectarBD();
        int regActualizados = 0;
        int retorno = 0;


        try {

            this.setObjSt(this.getObjCon().prepareStatement(query, this.getObjSt().RETURN_GENERATED_KEYS));
            this.getObjSt().setString(1, getTitulo());
            this.getObjSt().setString(2, getTitulo_original());
            this.getObjSt().setString(3, getAnno_de_publicacion());
            this.getObjSt().setString(4, getTipo_DoA());
            this.getObjSt().setString(5, getFormato());
            this.getObjSt().setBoolean(6, getEn_propiedad());
            this.getObjSt().setBoolean(7, getEn_busqueda());
            this.getObjSt().setDouble(8, getPrecio());
            this.getObjSt().setString(9, getGenero());
            this.getObjSt().setString(10, getPremios());
            this.getObjSt().setString(11, getDirector());
            this.getObjSt().setString(12, getEnlace_a_trailer());
            this.getObjSt().setString(13, getSinopsis());
            this.getObjSt().setInt(14, getCantidad_actores());
            this.getObjSt().setString(15, getActor1());
            this.getObjSt().setString(16, getActor2());
            this.getObjSt().setString(17, getActor3());
            this.getObjSt().setString(18, getSaga());
            this.getObjSt().setDouble(19, getOrden());
            this.getObjSt().setInt(20, getDuracion());
            this.getObjSt().setInt(21, getCalporedad());
            this.getObjSt().setInt(22, getCalificacion());
            this.getObjSt().setInt(23, getLibreria_Multimedia_idLibreria_Multimedia());


            regActualizados = this.getObjSt().executeUpdate();

            if (regActualizados == 1) {
                this.setObjRs(this.getObjSt().getGeneratedKeys());
                if (this.getObjRs().next()) {
                    //En este retorno me da el AutoIncremental con el +1 hecho, es decir, listo para insertarlo.
                    retorno = this.getObjRs().getInt(1);
                }
            }

            //AQUI tenemos que insertar teniendo en id el valor de retorno(?)


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
