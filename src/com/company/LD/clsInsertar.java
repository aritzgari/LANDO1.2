package com.company.LD;

//import java.sql.* ----> Importamos todas las clases del paquete java.sql

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * <p>
 * La clase sirve para insertar un registro en la base de datos. Previamente, realiza una
 * conexión con la base de datos, y después de realizar el insert, vuelve a cerrar la conexión.
 */
public class clsInsertar {

    public void insertarPeliculaEnBD(String Titulo, int Año, String Duración, int Puntuación, int Calporedad, int Libreria_Multimedia_idLibreria_Multimedia) {

        // Instancias la clase que hemos creado anteriormente.
        clsConexionBD SQL = new clsConexionBD();

        // Llamas al método que tiene la clase y te devuelve una conexión.
        Connection objConn = SQL.conectarBD();

        try {
            if (objConn != null) {
                // Preparamos la insert.
                //Se borra Libreria_Multimedia_idLibreria_Multimedia 24/3 - 13:39
                String query = "insert into Películas (Título, Año, Duración, Puntuación, Calporedad, Libreria_Multimedia_idLibreria_Multimedia) values (?, ?, ?, ?, ?, ?)";

                //Creamos las preparedstaments
                PreparedStatement objSt = objConn.prepareStatement(query);
                objSt.setString(1, Titulo);
                objSt.setInt(2, Año);
                objSt.setString(3, Duración);
                objSt.setInt(4, Puntuación);
                objSt.setInt(5, Calporedad);
                objSt.setInt(6, Libreria_Multimedia_idLibreria_Multimedia);

                //Ejecutamos la query que hemos preparado.
                objSt.execute();

                System.out.println("Se ha insertado el registro correctamente");

                //Cerramos el preparedStatement.
                objSt.close();

                //Cerramos la conexión.
                objConn.close();

            } else {
                System.out.println("No existe conexión");
            }

        } catch (SQLException e) {
            System.out.println("No se ha podido realizar el insert: " + e);
        }
    }

    public void insertarLibreriaEnBD(int idLibreria_Multimedia, String Nombre, String Descripcion) {

        // Instancias la clase que hemos creado anteriormente.
        clsConexionBD SQL = new clsConexionBD();

        // Llamas al método que tiene la clase y te devuelve una conexión.
        Connection objConn = SQL.conectarBD();

        try {
            if (objConn != null) {
                // Preparamos la insert
                //Se borra Libreria_Multimedia_idLibreria_Multimedia 24/3 - 13:39
                String query = "insert into Libreria_Multimedia (idLibreria_Multimedia, Nombre, Descripcion) values (?, ?, ?)";

                //Creamos las preparedstaments
                PreparedStatement objSt = objConn.prepareStatement(query);
                objSt.setInt(1, idLibreria_Multimedia);
                objSt.setString(2, Nombre);
                objSt.setString(3, Descripcion);

                //Ejecutamos la query que hemos preparado.
                objSt.execute();

                System.out.println("Se ha insertado el registro correctamente");

                //Cerramos el preparedStatement.
                objSt.close();

                //Cerramos la conexión.
                objConn.close();

            } else {
                System.out.println("No existe conexión");
            }

        } catch (SQLException e) {
            System.out.println("No se ha podido realizar el insert: " + e);
        }
    }

}

