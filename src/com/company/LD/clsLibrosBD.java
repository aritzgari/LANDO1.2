package com.company.LD;

import java.sql.SQLException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * <p>
 * Clase para crear y almacenar libros.
 * @see SQLException
 */
public class clsLibrosBD extends clsConexionBD {
    //Atributos de Pelicula en BD
    private int Libreria_Multimedia_idLibreria_Multimedia;
    private String ISBN;
    private String Titulo;
    private String Titulo_original;
    private int Anno_de_publicacion;
    private String Tipo_DoA;
    private double Precio;
    private boolean En_propiedad;
    private boolean En_busqueda;
    private String Formato;
    private int Paginas;
    private String Resumen;
    private boolean Serie_SoN;
    private String Nombre_serie;
    private double Orden_serie;
    //Prueba
    private int idAutor;
    private int idGenero;
    private int idEditorial;
    //no utilizados pero deberian id_genero, id_autor, id_editorial y id_premios.


    //Constructor con parametros, pensado para el insert
    public clsLibrosBD(int _libreria_Multimedia_idLibreria_Multimedia, String _ISBN, String _titulo, String _titulo_original, int _anno_de_publicacion, String _tipo_DoA, double _precio, boolean _en_propiedad, boolean _en_busqueda, String _formato, int _Paginas, String _Resumen, boolean _Serie_SoN, String _Nombre_serie, double _Orden_serie, int _idAutor, int _idGenero, int _idEditorial) {
        setLibreria_Multimedia_idLibreria_Multimedia(_libreria_Multimedia_idLibreria_Multimedia);
        setISBN(_ISBN);
        setTitulo(_titulo);
        setTitulo_original(_titulo_original);
        setAnno_de_publicacion(_anno_de_publicacion);
        setTipo_DoA(_tipo_DoA);
        setPrecio(_precio);
        setEn_propiedad(_en_propiedad);
        setEn_busqueda(_en_busqueda);
        setFormato(_formato);
        setPaginas(_Paginas);
        setResumen(_Resumen);
        setSerie_SoN(_Serie_SoN);
        setNombre_serie(_Nombre_serie);
        setOrden_serie(_Orden_serie);
        setIdAutor(_idAutor);
        setIdGenero(_idGenero);
        setIdEditorial(_idEditorial);
    }

    // Para select sin parametros
    public clsLibrosBD() {

    }

    public int getLibreria_Multimedia_idLibreria_Multimedia() {
        return Libreria_Multimedia_idLibreria_Multimedia;
    }

    public void setLibreria_Multimedia_idLibreria_Multimedia(int libreria_Multimedia_idLibreria_Multimedia) {
        Libreria_Multimedia_idLibreria_Multimedia = libreria_Multimedia_idLibreria_Multimedia;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public int getPaginas() {
        return Paginas;
    }

    public void setPaginas(int paginas) {
        Paginas = paginas;
    }

    public String getResumen() {
        return Resumen;
    }

    public void setResumen(String resumen) {
        Resumen = resumen;
    }

    public boolean getSerie_SoN() {
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

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    @Override
    public int sendInsert(String query) {
        this.conectarBD();
        int regActualizados = 0;
        int retorno = 0;


        try {
            this.setObjSt(this.getObjCon().prepareStatement(query, this.getObjSt().RETURN_GENERATED_KEYS));
            this.getObjSt().setInt(1, getLibreria_Multimedia_idLibreria_Multimedia());
            this.getObjSt().setString(2, getISBN());
            this.getObjSt().setString(3, getTitulo());
            this.getObjSt().setString(4, getTitulo_original());
            this.getObjSt().setInt(5, getAnno_de_publicacion());
            this.getObjSt().setString(6, getTipo_DoA());
            this.getObjSt().setDouble(7, getPrecio());
            this.getObjSt().setBoolean(8, getEn_propiedad());
            this.getObjSt().setBoolean(9, getEn_busqueda());
            this.getObjSt().setString(10, getFormato());
            this.getObjSt().setInt(11, getPaginas());
            this.getObjSt().setString(12, getResumen());
            this.getObjSt().setBoolean(13, getSerie_SoN());
            this.getObjSt().setString(14, getNombre_serie());
            this.getObjSt().setDouble(15, getOrden_serie());
            this.getObjSt().setInt(16, getIdGenero());
            this.getObjSt().setInt(17, getIdAutor());
            this.getObjSt().setInt(18, getIdEditorial());


            regActualizados = this.getObjSt().executeUpdate();

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
