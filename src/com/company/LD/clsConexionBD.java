package com.company.LD;

//import java.sql.* ---->importamos todas las clases del paquete java.sql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*Esta es la clase de conexiones con la BD esta sacada/copiada del programa de alvaro necesitaremos cambiarla.*/


public class clsConexionBD {

    //Nombre de la base de datos
    public String database="alumnoBD";

    //host
    public String hostname="localhost";

    //puerto
    public String port="3306";

    //Ruta de la base de datos (jdbc:mysql://localhost:3306/alumnoBD?useTimezone=true&serverTimezone=GMT&useSSL=false)
    public String url="jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useTimezone=true&serverTimezone=GMT&useSSL=false";

    //Nombre de usuario
    public String user="root";

    //Password
    public String password="";

    public Connection conectarBD() {

        Connection objConn = null;

        try {

            objConn = DriverManager.getConnection (url, user, password);

        } catch (SQLException e) {
            System.out.println("Ha fallado la conexión" + e);
        }

        return objConn;

    }

	/*public void desconectarBD(Connection conexion) {

        try {

        	conexion.close();

        } catch (SQLException e) {
            System.out.println("Ha fallado la desconexión");
        }

	}*/

}
