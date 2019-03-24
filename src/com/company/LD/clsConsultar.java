package com.company.LD;


//import java.sql.* ---->importamos todas las clases del paquete java.sql

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * <p>
 * La clase sirve para ejecutar una consulta en la base de datos. Previamente, realiza una
 * conexión con la base de datos, y después de realizar la consulta, vuelve a cerrar la conexión.
 */
public class clsConsultar {

    public void consultarBD() {
        // Instancias la clase que hemos creado anteriormente
        clsConexionBD SQL = new clsConexionBD();

        // Llamas al método que tiene la clase y te devuelve una conexión
        Connection objConn = SQL.conectarBD();

        try {
            if (objConn != null) {
                // Preparamos la consulta
                Statement st = objConn.createStatement();
                ResultSet rs = st.executeQuery("select * from Peliculas");

                System.out.println("PELICULAS RECUPERADOS");
                System.out.println("-------------------");

                // Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
                while (rs.next()) {
                    System.out.println(rs.getString("Título") + " " + rs.getInt("Año") + " " +
                            rs.getString("Duración") + " " + rs.getInt("Puntuación") + " " + rs.getInt("Calporedad") + " " + rs.getInt("Libreria_Multimedia_idLibreria_Multimedia"));
                }

                //Cerramos el resulset
                rs.close();
                //Cerramos el statement
                st.close();
                //Cerramos la conexión
                objConn.close();

            } else {
                System.out.println("No existe conexión");
            }

        } catch (SQLException e) {
            System.out.println("Ha fallado la consulta: " + e);
        }
    }

}

