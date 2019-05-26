package com.company.LD;

import java.sql.SQLException;

public class clsCancionBD extends clsConexionBD {
    private int Libreria_Multimedia_idLibreria_Multimedia;
    private String Titulo;
    private String Titulo_original;
    private int Anno_de_publicacion;
    private String Tipo_DoA;
    private double Precio;
    private boolean En_propiedad;
    private boolean En_busqueda;
    private String Formato;
    private String Videoclip;
    private String Enlace_a_YT;
    private int Género_Canción_idGénero_Canción;
    private int Album_idAlbum;
    private int Album_Cantante_idCantante;



    //Constructor con parametros, pensado para el insert
    public clsCancionBD(int _libreria_Multimedia_idLibreria_Multimedia, String _titulo, String _titulo_original, int _anno_de_publicacion,  String _tipo_DoA, double _precio, boolean _en_propiedad, boolean _en_busqueda, String _formato, String _Videoclip, String _Enlace_a_YT, int _Género_Canción_idGénero_Canción, int _Album_idAlbum, int _Album_Cantante_idCantante) {
        setLibreria_Multimedia_idLibreria_Multimedia(_libreria_Multimedia_idLibreria_Multimedia);
        setTitulo(_titulo);
        setTitulo_original(_titulo_original);
        setAnno_de_publicacion(_anno_de_publicacion);
        setTipo_DoA(_tipo_DoA);
        setPrecio(_precio);
        setEn_propiedad(_en_propiedad);
        setEn_busqueda(_en_busqueda);
        setFormato(_formato);
        setVideoclip(_Videoclip);
        setEnlace_a_YT(_Enlace_a_YT);
        setGénero_Canción_idGénero_Canción(_Género_Canción_idGénero_Canción);
        setAlbum_idAlbum(_Album_idAlbum);
        setAlbum_Cantante_idCantante(_Album_Cantante_idCantante);
    }

    //Constructor sin parametros, pensado para el select
    public clsCancionBD() {

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

    public String getVideoclip() {
        return Videoclip;
    }

    public void setVideoclip(String videoclip) {
        Videoclip = videoclip;
    }

    public String getEnlace_a_YT() {
        return Enlace_a_YT;
    }

    public void setEnlace_a_YT(String enlace_a_YT) {
        Enlace_a_YT = enlace_a_YT;
    }

    public int getGénero_Canción_idGénero_Canción() {
        return Género_Canción_idGénero_Canción;
    }

    public void setGénero_Canción_idGénero_Canción(int género_Canción_idGénero_Canción) {
        Género_Canción_idGénero_Canción = género_Canción_idGénero_Canción;
    }

    public int getAlbum_idAlbum() {
        return Album_idAlbum;
    }

    public void setAlbum_idAlbum(int album_idAlbum) {
        Album_idAlbum = album_idAlbum;
    }

    public int getAlbum_Cantante_idCantante() {
        return Album_Cantante_idCantante;
    }

    public void setAlbum_Cantante_idCantante(int album_Cantante_idCantante) {
        Album_Cantante_idCantante = album_Cantante_idCantante;
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
            this.getObjSt().setString(8, getTipo_DoA());
            this.getObjSt().setDouble(9, getPrecio());
            this.getObjSt().setBoolean(10, getEn_propiedad());
            this.getObjSt().setBoolean(11, getEn_busqueda());
            this.getObjSt().setString(12, getFormato());
            this.getObjSt().setString(13, getVideoclip());
            this.getObjSt().setString(14, getEnlace_a_YT());
            this.getObjSt().setInt(15, getGénero_Canción_idGénero_Canción());
            this.getObjSt().setInt(16, getAlbum_idAlbum());
            this.getObjSt().setInt(17, getAlbum_Cantante_idCantante());


            regActualizados = this.getObjSt().executeUpdate();
            retorno = regActualizados;

            if (regActualizados == 1) {
                this.setObjRs(this.getObjSt().getGeneratedKeys());
                if (this.getObjRs().next()) {
                    //En este retorno me da el AutoIncremental con el +1 hecho, es decir, listo para insertarlo.
                    retorno = this.getObjRs().getInt(1);
                }
            }


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
