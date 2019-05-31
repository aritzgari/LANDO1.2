package com.company.LD;


//import java.sql.* ---->importamos todas las clases del paquete java.sql

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * <p>
 * La clase sirve para eliminar un registro de la base de datos. Previamente, realiza una
 * conexión con la base de datos, y después de eliminar el registro, vuelve a cerrar la conexión.
 * @deprecated Sustituida.
 */
public class clsEliminar {
/*
    public void eliminarBD(int id) {

        // Instancias la clase que hemos creado anteriormente
        clsConexionBD SQL = new clsConexionBD();

        // Llamas al método que tiene la clase y te devuelve una conexión
        Connection objConn = SQL.conectarBD();

        try {
            if (objConn != null) {
                // Preparamos el delete
                String query = "delete from Peliculas where id = ?";

                //Creamos las preparedstaments
                PreparedStatement objSt = objConn.prepareStatement(query);
                objSt.setInt(1, id);

                //Ejecutamos la query que hemos preparado
                objSt.execute();

                System.out.println("Se ha eliminado el registro correctamente");

                //Cerramos el preparedStatement
                objSt.close();

                //Cerramos la conexión
                objConn.close();

            } else {
                System.out.println("No existe conexión");
            }

        } catch (SQLException e) {
            System.out.println("No se ha podido eliminar el registro: " + e);
        }
    }*/

}
