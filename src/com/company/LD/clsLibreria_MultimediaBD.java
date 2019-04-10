package com.company.LD;

import java.sql.SQLException;

public class clsLibreria_MultimediaBD extends clsConexionBD {


    private String Nombre;
    private String Descripcion;

    //Constructor con parametros, pensado para el insert
    public clsLibreria_MultimediaBD(String _Nombre, String _Descripcion) {
        setNombre(_Nombre);
        setDescripcion(_Descripcion);
    }

    //Constructor sin parametros, pensado para el select
    public clsLibreria_MultimediaBD() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }


    @Override
    public int sendInsert(String query/*, String _Nombre, String _Descripcion*/) {
        this.conectarBD();
        int regActualizados = 0;
        int retorno = 0;


        try {
            //con la siguiente linea me hace la prepareStatement con mi query y el AI. Se supone que lo hace solo.
            this.setObjSt(this.getObjCon().prepareStatement(query, this.getObjSt().RETURN_GENERATED_KEYS));
            this.getObjSt().setInt(1, this.getObjSt().RETURN_GENERATED_KEYS);

            this.getObjSt().setString(2, getNombre());
            this.getObjSt().setString(3, getDescripcion());

            /**
             ps.setString(1, dni);
             ps.setString(2, nombre);
             ps.setString(3, apellido);
             **/

            regActualizados = this.getObjSt().executeUpdate();

            if (regActualizados == 1) {
                this.setObjRs(this.getObjSt().getGeneratedKeys());
                if (this.getObjRs().next()) {
                    //En este retorno me da el AutoIncremental con el +1 hecho, es decir, listo para insertarlo.
                    retorno = this.getObjRs().getInt(1);
                }
            }

            //AQUI tenemos que insertar teniendo en id el valor de retorno(?) - Tiene pinta de que no, que lo ahce solo.


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
