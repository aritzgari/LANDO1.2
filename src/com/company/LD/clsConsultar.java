package com.company.LD;


//import java.sql.* ---->importamos todas las clases del paquete java.sql

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Ruben Dom�nguez
 * Aritz Garitano
 * <p>
 * La clase sirve para ejecutar una consulta en la base de datos. Previamente, realiza una
 * conexi�n con la base de datos, y despu�s de realizar la consulta, vuelve a cerrar la conexi�n.
 * @deprecated Sustituida.
 */
public class clsConsultar {
    private Statement objSt;
    private ResultSet objrs;
    private Connection objCon;

    public clsConsultar() {
        objSt = null;
        objrs = null;
        objCon = null;
    }
/*

    public void consultarPeliculasEnBD() {
        // Instancias la clase que hemos creado anteriormente

        clsConexionBD SQL = new clsConexionBD();

        // Llamas al m�todo que tiene la clase y te devuelve una conexi�n
        Connection objConn = SQL.conectarBD();

        try {
            if (objConn != null) {
                // Preparamos la consulta
                Statement st = objConn.createStatement();
                ResultSet rs = st.executeQuery("select * from lando.Peliculas");

                System.out.println("PELICULAS RECUPERADOS");
                System.out.println("-------------------");

                // Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
                while (rs.next()) {
                    System.out.println(rs.getString("T�tulo") + " " + rs.getInt("A�o") + " " +
                            rs.getString("Duraci�n") + " " + rs.getInt("Puntuaci�n") + " " + rs.getInt("Calporedad") + " " + rs.getInt("Libreria_Multimedia_idLibreria_Multimedia"));
                }

                //Cerramos el resulset
                rs.close();
                //Cerramos el statement
                st.close();
                //Cerramos la conexi�n
                objConn.close();

            } else {
                System.out.println("No existe conexi�n");
            }

        } catch (SQLException e) {
            System.out.println("Ha fallado la consulta: " + e);
        }
    }

    public void consultarLibreriasEnBD() {
        // Instancias la clase que hemos creado anteriormente
        clsConexionBD SQL = new clsConexionBD();

        // Llamas al m�todo que tiene la clase y te devuelve una conexi�n
        Connection objConn = SQL.conectarBD();

        try {
            if (objConn != null) {
                // Preparamos la consulta
                Statement st = objConn.createStatement();
                ResultSet rs = st.executeQuery("select * from lando.Libreria_Multimedia");

                System.out.println("Liberias RECUPERADAS");
                System.out.println("-------------------");
                System.out.println("ID  Nombre     Descripci�n");

                // Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
                while (rs.next()) {
                    System.out.println(rs.getInt("idLibreria_Multimedia") + "   " + rs.getString("Nombre") + "      " +
                            rs.getString("Descripcion"));
                }

                //Cerramos el resulset
                rs.close();
                //Cerramos el statement
                st.close();
                //Cerramos la conexi�n
                objConn.close();

            } else {
                System.out.println("No existe conexi�n");
            }

        } catch (SQLException e) {
            System.out.println("Ha fallado la consulta: " + e);
        }
    }*/
}


