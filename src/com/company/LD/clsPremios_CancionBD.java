package com.company.LD;

import java.sql.SQLException;

public class clsPremios_CancionBD extends clsConexionBD  {

    private String Nombre;
    private String Categoria;
    private int A�o;
    private int Canciones_idCanciones;
    private int Canciones_G�nero_Canci�n_idG�nero_Canci�n;
    private int Canciones_Album_idAlbum;
    private int Canciones_Album_Cantante_idCantante;
    private int Canciones_Libreria_Multimedia_idLibreria_Multimedia;

    //Constructor con parametros, pensado para el insert
    public clsPremios_CancionBD(String _Nombre, String _Categoria, int _A�o, int _Canciones_idCanciones, int _Canciones_G�nero_Canci�n_idG�nero_Canci�n,  int _Canciones_Album_idAlbum, int _Canciones_Album_Cantante_idCantante,int _Canciones_Libreria_Multimedia_idLibreria_Multimedia ) {
        setNombre(_Nombre);
        setCategoria(_Categoria);
        setA�o(_A�o);
        setCanciones_idCanciones(_Canciones_idCanciones);
        setCanciones_G�nero_Canci�n_idG�nero_Canci�n(_Canciones_G�nero_Canci�n_idG�nero_Canci�n);
        setCanciones_Album_idAlbum(_Canciones_Album_idAlbum);
        setCanciones_Album_Cantante_idCantante(_Canciones_Album_Cantante_idCantante);
        setCanciones_Libreria_Multimedia_idLibreria_Multimedia(_Canciones_Libreria_Multimedia_idLibreria_Multimedia);

    }

    //Constructor sin parametros, pensado para el select
    public clsPremios_CancionBD() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public int getA�o() {
        return A�o;
    }

    public void setA�o(int a�o) {
        A�o = a�o;
    }

    public int getCanciones_idCanciones() {
        return Canciones_idCanciones;
    }

    public void setCanciones_idCanciones(int canciones_idCanciones) {
        Canciones_idCanciones = canciones_idCanciones;
    }

    public int getCanciones_G�nero_Canci�n_idG�nero_Canci�n() {
        return Canciones_G�nero_Canci�n_idG�nero_Canci�n;
    }

    public void setCanciones_G�nero_Canci�n_idG�nero_Canci�n(int canciones_G�nero_Canci�n_idG�nero_Canci�n) {
        Canciones_G�nero_Canci�n_idG�nero_Canci�n = canciones_G�nero_Canci�n_idG�nero_Canci�n;
    }

    public int getCanciones_Album_idAlbum() {
        return Canciones_Album_idAlbum;
    }

    public void setCanciones_Album_idAlbum(int canciones_Album_idAlbum) {
        Canciones_Album_idAlbum = canciones_Album_idAlbum;
    }

    public int getCanciones_Album_Cantante_idCantante() {
        return Canciones_Album_Cantante_idCantante;
    }

    public void setCanciones_Album_Cantante_idCantante(int canciones_Album_Cantante_idCantante) {
        Canciones_Album_Cantante_idCantante = canciones_Album_Cantante_idCantante;
    }

    public int getCanciones_Libreria_Multimedia_idLibreria_Multimedia() {
        return Canciones_Libreria_Multimedia_idLibreria_Multimedia;
    }

    public void setCanciones_Libreria_Multimedia_idLibreria_Multimedia(int canciones_Libreria_Multimedia_idLibreria_Multimedia) {
        Canciones_Libreria_Multimedia_idLibreria_Multimedia = canciones_Libreria_Multimedia_idLibreria_Multimedia;
    }

    public int sendInsert(String query) {
        this.conectarBD();
        int regActualizados = 0;
        int retorno = 0;


        try {
            //Con la siguiente linea me hace la prepareStatement con mi query y el AI. Se supone que lo hace solo.
            this.setObjSt(this.getObjCon().prepareStatement(query, this.getObjSt().RETURN_GENERATED_KEYS));
            this.getObjSt().setString(1, getNombre());
            this.getObjSt().setString(2, getCategoria());
            this.getObjSt().setInt(3, getA�o());
            this.getObjSt().setInt(4, getCanciones_idCanciones());
            this.getObjSt().setInt(5, getCanciones_G�nero_Canci�n_idG�nero_Canci�n());
            this.getObjSt().setInt(6, getCanciones_Album_idAlbum());
            this.getObjSt().setInt(7, getCanciones_Album_Cantante_idCantante());
            this.getObjSt().setInt(8, getCanciones_Libreria_Multimedia_idLibreria_Multimedia());



            regActualizados = this.getObjSt().executeUpdate();

            if (regActualizados == 1) {
                this.setObjRs(this.getObjSt().getGeneratedKeys());
                if (this.getObjRs().next()) {
                    //En este retorno me da el AutoIncremental con el +1 hecho.
                    retorno = this.getObjRs().getInt(1);
                }
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //CERRAMOS AQUI LA CONEXION, TAL VEZ MAS TARDE MEJOR
        this.desconectarBD(this.getObjCon());
        return retorno;


    }

    @Override
    public int sendUpdate(String query) {
        //Conectamos
        this.conectarBD();
        //Updateamos
        try {
            this.setObjSt(this.getObjCon().prepareStatement(query));
            this.getObjSt().executeUpdate();
        } catch (SQLException e) {
            //Hay que decidir que gesti?n queremos hacer aqu?
            // e.printStackTrace();
        }
        //Desconectamos
        this.desconectarBD(this.getObjCon());
        return 0;
    }

}
