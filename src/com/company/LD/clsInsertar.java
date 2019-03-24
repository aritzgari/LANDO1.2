package com.company.LD;

//import java.sql.* ---->importamos todas las clases del paquete java.sql

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Ruben Dom�nguez
 * Aritz Garitano
 * <p>
 * La clase sirve para insertar un registro en la base de datos. Previamente, realiza una
 * conexi�n con la base de datos, y despu�s de realizar el insert, vuelve a cerrar la conexi�n.
 */
public class clsInsertar {

    public void insertarBD(String Titulo, int A�o, String Duraci�n, int Puntuaci�n, int Calporedad, int Libreria_Multimedia_idLibreria_Multimedia) {

        // Instancias la clase que hemos creado anteriormente
        clsConexionBD SQL = new clsConexionBD();

        // Llamas al m�todo que tiene la clase y te devuelve una conexi�n
        Connection objConn = SQL.conectarBD();

        try {
            if (objConn != null) {
                // Preparamos la insert
                String query = "insert into Peliculas (T�tulo, A�o, Duraci�n, Puntuaci�n, Calporedad, Libreria_Multimedia_idLibreria_Multimedia) values (?, ?, ?, ?, ?, ?)";

                //Creamos las preparedstaments
                PreparedStatement objSt = objConn.prepareStatement(query);
                objSt.setString(1, Titulo);
                objSt.setInt(2, A�o);
                objSt.setString(3, Duraci�n);
                objSt.setInt(4, Puntuaci�n);
                objSt.setInt(5, Calporedad);
                objSt.setInt(6, Libreria_Multimedia_idLibreria_Multimedia);

                //Ejecutamos la query que hemos preparado
                objSt.execute();

                System.out.println("Se ha insertado el registro correctamente");

                //Cerramos el preparedStatement
                objSt.close();

                //Cerramos la conexi�n
                objConn.close();

            } else {
                System.out.println("No existe conexi�n");
            }

        } catch (SQLException e) {
            System.out.println("No se ha podido realizar el insert: " + e);
        }
    }

}

