package com.company.LD;

import java.sql.SQLException;

public class clsAlbumBD extends clsConexionBD {

    private String Nombre;
    private int IdCantante;

    //Constructor con parametros, pensado para el insert
    public clsAlbumBD(String _Nombre, int _idCantante) {
        setIdCantante(_idCantante);
        setNombre(_Nombre);

    }

    //Constructor sin parametros, pensado para el select
    public clsAlbumBD() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getIdCantante() {
        return IdCantante;
    }

    public void setIdCantante(int idCantante) {
        IdCantante = idCantante;
    }

    public int sendInsert(String query) {
        this.conectarBD();
        int regActualizados = 0;
        int retorno = 0;


        try {
            //Con la siguiente linea me hace la prepareStatement con mi query y el AI. Se supone que lo hace solo.
            this.setObjSt(this.getObjCon().prepareStatement(query, this.getObjSt().RETURN_GENERATED_KEYS));
            this.getObjSt().setString(1, getNombre());
            this.getObjSt().setInt(2, getIdCantante());

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
