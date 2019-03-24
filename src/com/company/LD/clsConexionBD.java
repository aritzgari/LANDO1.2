package com.company.LD;
/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * <p>
 * Esta clase es la que establece conexion con la BD, se le dan los parámetros de conexión y con ellos forma una expresión de conexión;
 * que luego será leída por el driver de mySQL. O al menos ese es el plan, pero tiene pinta de ser un plan muy alejado del resultado real.
 */
//import java.sql.* ---->importamos todas las clases del paquete java.sql

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*Esta es la clase de conexiones con la BD esta sacada/copiada del programa de alvaro necesitaremos cambiarla.*/


public class clsConexionBD {

    //Nombre de la base de datos
    public String database = "lando";

    //host
    public String hostname = "localhost";

    //puerto
    public String port = "3306";

    //Ruta de la base de datos (jdbc:mysql://localhost:3306/alumnoBD?useTimezone=true&serverTimezone=GMT&useSSL=false)
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useTimezone=true&serverTimezone=GMT&useSSL=false";

    //Nombre de usuario
    public String user = "root";

    //Password
    public String password = "1243";

    public Connection conectarBD() {

        Connection objConn = null;

        try {

            objConn = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println("Ha fallado la conexión" + e);
        }

        return objConn;

    }

    public void desconectarBD(Connection conexion) {

        try {

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Ha fallado la desconexión");
        }

    }

}
