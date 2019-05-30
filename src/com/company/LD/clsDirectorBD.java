package com.company.LD;


import java.sql.SQLException;

public class clsDirectorBD extends clsConexionBD{
    private String Nombre;
    private String Apellido;

    //Constructor con parametros, pensado para el insert
    public clsDirectorBD(String _Nombre, String _Apellido) {
        setNombre(_Nombre);
        setApellido(_Apellido);
    }

    //Constructor sin parametros, pensado para el select
    public clsDirectorBD() {

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }


    public int sendInsert(String query) {
        this.conectarBD();
        int regActualizados = 0;
        int retorno = 0;


        try {
            //Con la siguiente linea me hace la prepareStatement con mi query y el AI. Se supone que lo hace solo.
            this.setObjSt(this.getObjCon().prepareStatement(query, this.getObjSt().RETURN_GENERATED_KEYS));
            this.getObjSt().setString(1, getNombre());
            this.getObjSt().setString(2, getApellido());

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
