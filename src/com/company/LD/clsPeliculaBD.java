package com.company.LD;

import java.sql.SQLException;

public class clsPeliculaBD extends clsConexionBD
{


    @Override
    public int sendInsert(String query)
    {

        int regActualizados=0;
        int retorno=0;




        try
        {

            this.setObjSt(this.getObjCon().prepareStatement(query,this.getObjSt().RETURN_GENERATED_KEYS));
            this.getObjSt().setString(1,"");

            /**
            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
             **/

            regActualizados=this.getObjSt().executeUpdate();

            if(regActualizados ==1)
            {
                this.setObjRs(this.getObjSt().getGeneratedKeys());
                if(this.getObjRs().next())
                {
                    retorno= this.getObjRs().getInt(1);
                }
            }


        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return retorno;




    }

    @Override
    public int sendUpdate(String query)
    {
        return 0;
    }
}
