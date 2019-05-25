package com.company.LD;

import java.sql.SQLException;

public class clsPremios_LibrosBD extends clsConexionBD {

    private String Nombre;
    private String Categoria;
    private int Anno;
    private String ISBNLibro;

    //Constructor con parametros, pensado para el insert
    public clsPremios_LibrosBD(String _Nombre, String _ISBNLibro, String _Categoria, int _Anno) {
        setAnno(_Anno);
        setCategoria(_Categoria);
        setISBNLibro(_ISBNLibro);
        setNombre(_Nombre);

    }

    //Constructor sin parametros, pensado para el select
    public clsPremios_LibrosBD() {
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

    public int getAnno() {
        return Anno;
    }

    public void setAnno(int anno) {
        Anno = anno;
    }

    public String getISBNLibro() {
        return ISBNLibro;
    }

    public void setISBNLibro(String ISBNLibro) {
        this.ISBNLibro = ISBNLibro;
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
            this.getObjSt().setInt(3, getAnno());
            this.getObjSt().setString(4, getISBNLibro());

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
        return 0;
    }


}
