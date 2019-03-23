package com.company.LP;

import com.company.LN.clsGestorLN;

/**
 * Clase para gestionar y coordinar el flujo del programa.
 *
 * @author RubenD AritzG
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
                    "------------\n" +
                    "1.-A�adir cosas\n" +
                    "2.-Mostrar cosas\n" +
                    "3.-Salir\n" +
                    "------------\n" +
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
         * El Submemu1 se encarga de A�adir items
         */
        int op = 0;
        do {
            System.out.println("MENU - A�adir\n" +
                    "------------\n" +
                    "1.-A�adir Peliculas\n" +
                    "2.-A�adir Libros\n" +
                    "3.-A�adir Musica\n" +
                    "4.-Menu Principal\n" +
                    "------------\n" +
                    "Opci�n:");
            op = UtilidadesLP.leerEntero();
            switch (op) {
                case 1:
                    System.out.println("Titulo:");
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
                    System.out.println("Calificacion:");
                    int Calificacion = UtilidadesLP.leerEntero();

                    objGestorLN.crearPelicula(Titulo, Titulo_original, Anno_de_publicacion, Tipo_DoA, Formato, En_propiedad, En_busqueda, Precio, Genero, Premios, Director, Enlace_a_trailer, Sinopsis, Cantidad_actores, Actor1, Actor2, Actor3, Saga, Orden, Duracion, Calporedad, Calificacion);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Menu principal.");
                    break;
            }
        } while (op != 4);

    }

    private static void SubMenu2() {
        /**
         * El Submemu2 se encarga de Mostrar items
         */
        int op = 0;
        do {
            System.out.println("MENU - Mostrar\n" +
                    "------------\n" +
                    "1.-Mostrar Peliculas\n" +
                    "2.-Mostrar Libros\n" +
                    "3.-Mostrar Musica\n" +
                    "4.-Menu Principal\n" +
                    "------------\n" +
                    "Opci�n:");
            op = UtilidadesLP.leerEntero();
            switch (op) {
                case 1:
                    //No se leer� m�s que la ubicaci�n de memoria, hay que recorrer el Array. (Averiguar como)
                    System.out.println(objGestorLN.getDatosPeliculas());
                    break;
                case 2:
                    objGestorLN.getDatosLibros();
                    break;
                case 3:
                    objGestorLN.getDatosMusicas();
                    break;
                case 4:
                    System.out.println("Menu principal.");
                    break;
            }
        } while (op != 4);
    }
}