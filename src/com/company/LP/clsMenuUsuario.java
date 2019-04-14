package com.company.LP;

import com.company.LN.clsGestorLN;
import com.company.LN.itfProperty;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class clsMenuUsuario extends JFrame implements ActionListener {
    //Declaraciones funcionales
    private static clsGestorLN objGestorLN = new clsGestorLN();
    /*Tudo lo que contiene el menu*/
    private JPanel miPanel;// contenedor de los componentes
    private JMenuBar barraMenu;
    private JMenu menuInsertar, menuConsultar;
    /* items del menu Insertar */
    private JMenuItem menuItemInsLibrerias_Multimedia, menuItemInsPeliculas, menuItemInsLibros, menuItemInsMusica;
    /* items del menu Consultar */
    private JMenuItem menuItemConsLibrerias_Multimedia, menuItemConsPeliculas, menuItemConsLibros, menuItemConsMusica;
    /*labels de los menus para mostrar en pantalla*/


    /*Cadenas para asignar los resultados de eventos*/
    String cadenaInsertar = "";
    String cadenaConsultar = "";
    String cadenaOpcionesCheck = "";
    String cadenaOpcionesRadio = "";
    String cadenaCheck1 = "";
    String cadenaCheck2 = "";
    String cadenaRadio1 = "";
    String cadenaRadio2 = "";
    String informacionAplicacion = "";
    String informacionCoDejaVu = "";


    public clsMenuUsuario()// constructor
    {
        // Aqui podríamos traernos la info de la BBDD

        // Iniciamos los componentes gráficos
        iniciarComponentes();
        // Asigna un titulo a la barra de titulo
        setTitle("LANDO V0.5");
        // tamaño de la ventana
        setSize(400, 200);
        // pone la ventana en el Centro de la pantalla
        setLocationRelativeTo(null);
        /* permite que la ventana cambie de tamaño */
        setResizable(true);
    }

    private void iniciarComponentes() {
        /* Hace que pare el programa al salir*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Inicia instancias de los componentes */
        miPanel = new JPanel();
        miPanel.setLayout(null);
        barraMenu = new JMenuBar();

        menuInsertar = new JMenu();
        menuConsultar = new JMenu();

        menuItemInsLibrerias_Multimedia = new JMenuItem();
        menuItemInsPeliculas = new JMenuItem();
        menuItemInsLibros = new JMenuItem();
        menuItemInsMusica = new JMenuItem();

        menuItemConsLibrerias_Multimedia = new JMenuItem();
        menuItemConsPeliculas = new JMenuItem();
        menuItemConsLibros = new JMenuItem();
        menuItemConsMusica = new JMenuItem();



        /* Crea los items del menu Insertar */
        menuItemInsLibrerias_Multimedia.setText("Librerias Multimedia");
        menuItemInsLibrerias_Multimedia.setActionCommand("ActionInsertLibrerias_Multimedia");
        menuInsertar.add(menuItemInsLibrerias_Multimedia);
        menuInsertar.addSeparator();

        menuItemInsPeliculas.setText("Peliculas");
        menuItemInsPeliculas.setActionCommand("ActionInsertPeliculas");
        menuInsertar.add(menuItemInsPeliculas);
        menuInsertar.addSeparator();

        menuItemInsLibros.setText("Libros");
        menuItemInsLibros.setActionCommand("ActionInsertLibros");
        menuInsertar.add(menuItemInsLibros);
        menuInsertar.addSeparator();

        menuItemInsMusica.setText("Musica");
        menuItemInsMusica.setActionCommand("ActionInsertMusica");
        menuInsertar.add(menuItemInsMusica);

        /* Crea los items del menu Consultar */
        menuItemConsLibrerias_Multimedia.setText("Librerias Multimedia");
        menuItemConsLibrerias_Multimedia.setActionCommand("ActionConsLibrerias_Multimedia");
        menuConsultar.add(menuItemConsLibrerias_Multimedia);
        menuConsultar.addSeparator();

        menuItemConsPeliculas.setText("Peliculas");
        menuItemConsPeliculas.setActionCommand("ActionConsPeliculas");
        menuConsultar.add(menuItemConsPeliculas);
        menuConsultar.addSeparator();

        menuItemConsLibros.setText("Libros");
        menuItemConsLibros.setActionCommand("ActionConsLibros");
        menuConsultar.add(menuItemConsLibros);
        menuConsultar.addSeparator();

        menuItemConsMusica.setText("Musica");
        menuItemConsMusica.setActionCommand("ActionConsMusica");
        menuConsultar.add(menuItemConsMusica);



        /* Agrega los Menus de la barra de Menu */
        menuInsertar.setText("Insertar");
        barraMenu.add(menuInsertar);

        menuConsultar.setText("Consultar");
        barraMenu.add(menuConsultar);


        setJMenuBar(barraMenu);

        menuItemInsLibrerias_Multimedia.addActionListener(this);
        menuItemInsPeliculas.addActionListener(this);
        menuItemInsLibros.addActionListener(this);
        menuItemInsMusica.addActionListener(this);
        menuItemConsLibrerias_Multimedia.addActionListener(this);
        menuItemConsPeliculas.addActionListener(this);
        menuItemConsLibros.addActionListener(this);
        menuItemConsMusica.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Has seleccionado: " + e.getActionCommand());
        switch (e.getActionCommand()){
            case "ActionInsertLibrerias_Multimedia":
                System.out.println("Datos para crear la Librería:");
                System.out.println("Un Nombre para saber que libreria es. (String)\n" +
                        "ej. 'Casa' ó 'Oficina'.");
                String Nombre = UtilidadesLP.leerCadena();
                System.out.println("Añade una descripción para saber que es lo que va a contener esta librería");
                String Descripcion = UtilidadesLP.leerCadena();
                objGestorLN.crearLibreria(/*idLibreria_Multimedia,*/ Nombre, Descripcion);
                break;
            case "ActionInsertPeliculas":
                break;
            case "ActionInsertLibros":
                break;
            case "ActionInsertMusica":
                break;
            case "ActionConsLibrerias_Multimedia":
                frmLista window = new frmLista();
                ArrayList<itfProperty> resultado = objGestorLN.consultarLibreriasEnBD();
                for (itfProperty L : resultado
                ) {
                    window.setItem(L);
                }
                break;
            case "ActionConsPeliculas":
                break;
            case "ActionConsLibros":
                break;
            case "ActionConsMusica":
                break;

        }


    }
}


