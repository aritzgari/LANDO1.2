package com.company.LD;

import java.sql.SQLException;

public class clsPremios_PeliculaBD extends clsConexionBD {
    private String Nombre;
    private String Categoria;
    private int Anno;
    private String Películas_Título;

    //Constructor con parametros, pensado para el insert
    public clsPremios_PeliculaBD(String _Nombre, String _Categoria, int _Anno, String _Películas_Título) {
        setNombre(_Nombre);
        setCategoria(_Categoria);
        setAño(_Anno);
        setPelículas_Título(_Películas_Título);
    }

    //Constructor sin parametros, pensado para el select
    public clsPremios_PeliculaBD() {
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

    public void setAño(int anno) {
        Anno = anno;
    }

    public String getPelículas_Título() {
        return Películas_Título;
    }

    public void setPelículas_Título(String titulodepeliculas) {
        this.Películas_Título = titulodepeliculas;
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
            this.getObjSt().setString(4, getPelículas_Título());

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
