package com.company.LP;

import com.company.LD.clsConsultar;
import com.company.LN.clsGestorLN;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase para gestionar y coordinar el flujo del programa.
 *
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */

public class clsMenu {

    private static clsGestorLN objGestorLN = new clsGestorLN();

    public static void MenuPrincipal() {
        /**
         * Este m�todo permite navegar entre los submenus
         */
        int op = 0;
        do {
            System.out.println("MENU PRINCIPAL\n" +
                    "--------------------\n" +
                    "1.-A�adir registros\n" +
                    "2.-Mostrar registros\n" +
                    "3.-Salir\n" +
                    "--------------------\n" +
                    "Opci�n:");
            op = UtilidadesLP.leerEntero();
            switch (op) {
                case 1:
                    SubMenu1();
                    break;
                case 2:
                    SubMenu2();
                    break;
                case 3:
                    System.out.println("Cerrando aplicaci�n.");
                    break;
            }
        } while (op != 3);

    }


    private static void SubMenu1() {
        /**
         * El Submemu1 se encarga de A�adir items.
         */
        int op = 0;
        do {
            System.out.println("MEN� - A�adir\n" +
                    "--------------------\n" +
                    "1.-A�adir Librer�a\n" +
                    "2.-A�adir Pel�culas\n" +
                    "3.-A�adir Libros\n" +
                    "4.-A�adir M�sica\n" +
                    "5.-Men� Principal\n" +
                    "--------------------\n" +
                    "Opci�n:");
            op = UtilidadesLP.leerEntero();
            switch (op) {
                case 1:
                    System.out.println("Datos para crear la Librer�a:");
                    //System.out.println("Un ID para identificarla (int)");
                    //int idLibreria_Multimedia = UtilidadesLP.leerEntero();
                    System.out.println("Un Nombre para saber que libreria es. (String)\n" +
                            "ej. 'Casa' � 'Oficina'.");
                    String Nombre = UtilidadesLP.leerCadena();
                    System.out.println("A�ade una descripci�n para saber que es lo que va a contener esta librer�a");
                    String Descripcion = UtilidadesLP.leerCadena();
                    objGestorLN.crearLiberia(/*idLibreria_Multimedia,*/ Nombre, Descripcion);

                    break;
                case 2:
                    //LLAMADA DE PRUEBA
                    //clsInsertar.insertarBD();
                    //LLAMADA DE PRUEBA
                    System.out.println("Datos para crear la Pel�cula:");
                    System.out.println("T�tulo:");
                    String Titulo = UtilidadesLP.leerCadena();
                    System.out.println("Titulo_original:");
                    String Titulo_original = UtilidadesLP.leerCadena();
                    System.out.println("Anno_de_publicacion:");
                    String Anno_de_publicacion = UtilidadesLP.leerCadena();
                    System.out.println("Tipo_DoA:");
                    String Tipo_DoA = UtilidadesLP.leerCadena();
                    System.out.println("Formato:");
                    String Formato = UtilidadesLP.leerCadena();
                    System.out.println("En_propiedad:");
                    boolean En_propiedad = Boolean.parseBoolean(UtilidadesLP.leerCadena());
                    System.out.println("En_busqueda:");
                    boolean En_busqueda = Boolean.parseBoolean(UtilidadesLP.leerCadena());
                    System.out.println("Precio:");
                    double Precio = UtilidadesLP.leerReal();
                    System.out.println("Genero:");
                    String Genero = UtilidadesLP.leerCadena();
                    System.out.println("Premios:");
                    String Premios = UtilidadesLP.leerCadena();
                    System.out.println("Director:");
                    String Director = UtilidadesLP.leerCadena();
                    System.out.println("Enlace_a_trailer:");
                    String Enlace_a_trailer = UtilidadesLP.leerCadena();
                    System.out.println("Sinopsis:");
                    String Sinopsis = UtilidadesLP.leerCadena();
                    System.out.println("Cantidad_actores:");
                    int Cantidad_actores = UtilidadesLP.leerEntero();
                    System.out.println("Actor1:");
                    String Actor1 = UtilidadesLP.leerCadena();
                    System.out.println("Actor2:");
                    String Actor2 = UtilidadesLP.leerCadena();
                    System.out.println("Actor3:");
                    String Actor3 = UtilidadesLP.leerCadena();
                    System.out.println("Saga:");
                    String Saga = UtilidadesLP.leerCadena();
                    System.out.println("Orden:");
                    Double Orden = UtilidadesLP.leerReal();
                    System.out.println("Duracion:");
                    int Duracion = UtilidadesLP.leerEntero();
                    System.out.println("Calporedad:");
                    int Calporedad = UtilidadesLP.leerEntero();
                    System.out.println("Calificaci�n:");
                    int Calificacion = UtilidadesLP.leerEntero();
                    System.out.println("ID de la librer�a a la que pertenece:");
                    int Libreria_Multimedia_idLibreria_Multimedia = UtilidadesLP.leerEntero();

                    objGestorLN.crearPelicula(Titulo, Titulo_original, Anno_de_publicacion, Tipo_DoA, Formato, En_propiedad, En_busqueda, Precio, Genero, Premios, Director, Enlace_a_trailer, Sinopsis, Cantidad_actores, Actor1, Actor2, Actor3, Saga, Orden, Duracion, Calporedad, Calificacion, Libreria_Multimedia_idLibreria_Multimedia);

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Men� principal.");
                    break;
            }
        } while (op != 5);

    }

    private static void SubMenu2() /*10/04/2019: A�adida excepcion aqui provisionalmente:throws SQLException*/ {
        /**
         * El Submemu2 se encarga de Mostrar items
         */
        int op = 0;
        clsConsultar objConsultor = new clsConsultar();
        do {
            System.out.println("MEN� - Mostrar\n" +
                    "--------------------\n" +
                    "1.-Mostrar Librer�as\n" +
                    "2.-Mostrar Pel�culas\n" +
                    "3.-Mostrar Libros\n" +
                    "4.-Mostrar M�sica\n" +
                    "5.-Men� Principal\n" +
                    "--------------------\n" +
                    "Opci�n:");
            op = UtilidadesLP.leerEntero();
            switch (op) {
                case 1:
                    //objConsultor.consultarLibreriasEnBD();

                    //Codigo provisional, intento 2:
                    ResultSet resultado = objGestorLN.consultarLibreriasEnBD();
                    //AQUI FALLA: Creo que por no mostrar el ResultSet como debe. Habr� que asignar los valores del resulset a mis Arraylists en la RAM en el gestor y aqui mostrar esos arraylists o algo asi.
                    try {
                        while (resultado.next()) {
                            System.out.println("id: " + resultado.getInt(1) + " Nombre: " + resultado.getString(2) + " Descripci�n: " + resultado.getString(3));
                        }
                    } catch (SQLException e) {
                        System.out.println("Error SQL");
                        System.out.println(e);
                    }

                    break;
                case 2:
                    /*No se leer? m?s que la ubicaci?n de memoria, hay que recorrer el Array. (Averiguar como)
                    System.out.println(objGestorLN.getDatosPeliculas());*/
                    //objConsultor.consultarPeliculasEnBD();
                    break;
                case 3:
                    //objGestorLN.getDatosLibros();
                    break;
                case 4:
                    //objGestorLN.getDatosMusicas();
                    break;
                case 5:
                    System.out.println("Men� principal.");
                    break;
            }
        } while (op != 5);
    }
}