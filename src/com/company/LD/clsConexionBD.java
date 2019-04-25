package com.company.LD;

//import java.sql.* ---->importamos todas las clases del paquete java.sql

import java.sql.*;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 * <p>
 * Esta clase es la que establece conexion con la BD, se le dan los parámetros de conexión y con ellos forma una expresión de conexión;
 * que luego será leída por el driver de mySQL. O al menos ese es el plan, pero tiene pinta de ser un plan muy alejado del resultado real.
 */

public abstract class clsConexionBD {

    //Nombre de la base de datos
    public String database = "lando";

    //host
    public String hostname = "localhost";

    //puerto
    public String port = "3306";

    //Ruta de la base de datos (jdbc:mysql://localhost:3306/alumnoBD?useTimezone=true&serverTimezone=GMT&useSSL=false)
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useTimezone=true&serverTimezone=GMT&allowPublicKeyRetrieval=true&useSSL=false";

    //Nombre de usuario
    public String user = "root";

    //Password
    public String password = "23011604";

    private Connection objCon;
    private PreparedStatement objSt;
    private ResultSet objRs;

    public void setObjCon(Connection objCon) {
        this.objCon = objCon;
    }

    public void setObjSt(PreparedStatement objSt) {
        this.objSt = objSt;
    }

    public void setObjRs(ResultSet objRs) {
        this.objRs = objRs;
    }

    public Connection getObjCon() {
        return objCon;
    }

    public PreparedStatement getObjSt() {
        return objSt;
    }

    public ResultSet getObjRs() {
        return objRs;
    }

    public void conectarBD() {

        objCon = null;

        try {

            objCon = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println("Ha fallado la conexión" + e);
        }

    }

    public ResultSet sendSelect(String query) {
        this.conectarBD();
        try {
            objSt = objCon.prepareStatement(query);
            objRs = objSt.executeQuery();

        } catch (SQLException e) {
            //haced algo.
        }
        //10/04/2019->LA DEJO SIN DESCONECTAR PARA UNA PRUEBA, PORQUE NO PUEDO LEER EL RESULSET DESDE clsMenu SI LO CIERRO
        //this.desconectarBD(objCon);
        return objRs;

    }

    public abstract int sendInsert(String query);

    public abstract int sendUpdate(String query);

    public void sendDelete/*byID*/(String query, int id) {

        try {
            objSt = objCon.prepareStatement(query);
            objSt.setInt(1, id);
            objSt.executeUpdate();
        } catch (SQLException e) {

        }

    }


    public void desconectarBD(Connection conexion) {

        try {

            objCon.close();
            objSt.close();
            objRs.close();

        } catch (SQLException e) {
            System.out.println("Ha fallado la desconexión");
        }

    }

}
