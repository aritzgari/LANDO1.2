package com.company.LP;

import com.company.Excepciones.clsPropiedadNonExistantException;
import com.company.LN.clsGestorLN;
import com.company.Excepciones.clsPropiedadNonExistantException;
import com.company.LN.itfProperty;
import com.company.Comun.itfPropertyV2;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import java.awt.Color;

public class frmPrincipal extends JFrame implements InternalFrameListener, ActionListener {
    //Declaraciones funcionales
    private static clsGestorLN objGestorLN = new clsGestorLN();
    private Color colorAzul = new Color(112, 146, 190);
    private Color colorGris = new Color(195, 195, 195);
    //Componentes para el menu de las librerias
    private JButton JBCambiar;
    private JLabel JLNombreLibreria;
    private JLabel JLNombreLibreria2;
    private JPanel JPInterfazMenuLibreria;

    //Tudu lo que contiene el menu
    private JPanel miPanel;// contenedor de los componentes
    private JMenuBar barraMenu;
    private JMenu menuInsertar, menuConsultar;
    /* items del menu Insertar */
    private JMenuItem menuItemInsLibrerias_Multimedia, menuItemInsPeliculas, menuItemInsLibros, menuItemInsCancion, menuItemInsActor, menuItemInsDirector, menuItemInsGeneroPeli, menuItemInsAutor, menuItemInsGeneroLibro, menuItemInsEditorial, menuItemInsPremiosPelicula, menuItemInsPremiosLibro, menuItemInsGeneroCancion, menuItemInsCantante, menuItemInsAlbum, menuItemInsPremiosCancion;
    /* items del menu Consultar */
    private JMenuItem menuItemConsLibrerias_Multimedia, menuItemConsPeliculas, menuItemConsLibros, menuItemConsActor, menuItemConsDirector, menuItemConsGeneroPeli, menuItemConsAutor, menuItemConsGeneroLibro, menuItemConsEditorial, menuItemConsPremiosPelicula, menuItemConsPremiosLibro, menuItemConsLibro, menuItemConsGeneroCancion, menuItemConsPremiosCancion, menuItemConsCancion, menuItemConsAlbum, menuItemConsCantante;


    //Declaraciones copiadas
    JTextArea display;
    JDesktopPane desktop;
    JInternalFrame displayWindow;
    JInternalFrame listenedToWindow;

    static final String SHOW = "show";
    static final String CLEAR = "clear";
    String newline = "\n";
    static final int desktopWidth = 1365;
    static final int desktopHeight = 700;

    //Constructor
    public frmPrincipal(String title) {
        //Secuencia de arranque del programa
        super(title);
        //Set up the GUI.
        desktop = new JDesktopPane();
        desktop.setPreferredSize(new Dimension(desktopWidth, desktopHeight));
        //this.setExtendedState(MAXIMIZED_BOTH);                                //Para que salga directamente maximizado
        this.setResizable(false);
        setContentPane(desktop);
        //Inicializacion
        inicializador();

        //Personalizaci?n
        desktop.setBackground(colorGris);


        //createDisplayWindow();
        //desktop.add(displayWindow); //DON'T FORGET THIS!!!
        //Dimension displaySize = displayWindow.getSize();
        //displayWindow.setSize(desktopWidth, displaySize.height);
    }

    private void inicializador() {
        //Inserte los g?neros si no se han insertado
        //HAY QUE HACERLO CON UPDATES O SE CREAR?N OTRA VEZ CUANDO SE INICIE EL PROGRAMA
        //CUANDO NO HAY VALORES EL UPDATE NO LOS CREA, SOCORRO

        //Intento 2
        objGestorLN.updateGeneroPeliEnBD("insert into lando.género_película values (1, 'Acción');");
        objGestorLN.updateGeneroPeliEnBD("insert into lando.género_película values (2, 'Animación');");
        objGestorLN.updateGeneroPeliEnBD("insert into lando.género_película values (3, 'Ciencia Ficción');");
        objGestorLN.updateGeneroPeliEnBD("insert into lando.género_película values (4, 'Drama');");
        objGestorLN.updateGeneroPeliEnBD("insert into lando.género_película values (5, 'Fantasía');");
        objGestorLN.updateGeneroPeliEnBD("insert into lando.género_película values (6, 'Negro');");
        objGestorLN.updateGeneroPeliEnBD("insert into lando.género_película values (7, 'Misterio');");
        objGestorLN.updateGeneroPeliEnBD("insert into lando.género_película values (8, 'Musical');");
        objGestorLN.updateGeneroPeliEnBD("insert into lando.género_película values (9, 'Romántico');");
        //Intento 1
        objGestorLN.updateGeneroPeliEnBD("UPDATE lando.género_película SET Nombre = 'Acción' WHERE idGénero = 1;");
        objGestorLN.updateGeneroPeliEnBD("UPDATE lando.género_película SET Nombre = 'Animación' WHERE idGénero = 2;");
        objGestorLN.updateGeneroPeliEnBD("UPDATE lando.género_película SET Nombre = 'Ciencia Ficción' WHERE idGénero = 3;");
        objGestorLN.updateGeneroPeliEnBD("UPDATE lando.género_película SET Nombre = 'Drama' WHERE idGénero = 4;");
        objGestorLN.updateGeneroPeliEnBD("UPDATE lando.género_película SET Nombre = 'Fantasía' WHERE idGénero = 5;");
        objGestorLN.updateGeneroPeliEnBD("UPDATE lando.género_película SET Nombre = 'Negro' WHERE idGénero = 6;");
        objGestorLN.updateGeneroPeliEnBD("UPDATE lando.género_película SET Nombre = 'Misterio' WHERE idGénero = 7;");
        objGestorLN.updateGeneroPeliEnBD("UPDATE lando.género_película SET Nombre = 'Musical' WHERE idGénero = 8;");
        objGestorLN.updateGeneroPeliEnBD("UPDATE lando.género_película SET Nombre = 'Romántico' WHERE idGénero = 9;");
        //Consulta los g?neros para meterlos en la RAM
        //objGestorLN.consultarGeneroPeliEnBD();
        //Inserte otras cosas que necesiten ser insertadas

        //Pantalla para gestionar las librerias desde el principio
        generarMenuLibrerias();
    }


    //Ventana que muestra la informaci?n de eventos.
    protected void createDisplayWindow() {
        JButton b1 = new JButton("Show internal frame");
        b1.setActionCommand(SHOW);
        b1.addActionListener(this);

        JButton b2 = new JButton("Clear event info");
        b2.setActionCommand(CLEAR);
        b2.addActionListener(this);

        display = new JTextArea(3, 30);
        display.setEditable(false);
        JScrollPane textScroller = new JScrollPane(display);
        //Have to supply a preferred size, or else the scroll
        //area will try to stay as large as the text area.
        textScroller.setPreferredSize(new Dimension(200, 75));
        textScroller.setMinimumSize(new Dimension(10, 10));

        displayWindow = new JInternalFrame("Event Watcher",
                true,  //resizable
                false, //not closable
                true, //not maximizable
                true); //iconifiable
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BoxLayout(contentPane,
                BoxLayout.PAGE_AXIS));
        b1.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(b1);
        contentPane.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPane.add(textScroller);
        contentPane.add(Box.createRigidArea(new Dimension(0, 5)));
        b2.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(b2);

        displayWindow.setContentPane(contentPane);
        displayWindow.pack();
        displayWindow.setVisible(true);
    }

    public void internalFrameClosing(InternalFrameEvent e) {
        displayMessage("Internal frame closing", e);
    }

    public void internalFrameClosed(InternalFrameEvent e) {
        displayMessage("Internal frame closed", e);
    }

    public void internalFrameOpened(InternalFrameEvent e) {
        displayMessage("Internal frame opened", e);
    }

    public void internalFrameIconified(InternalFrameEvent e) {
        displayMessage("Internal frame iconified", e);
    }

    public void internalFrameDeiconified(InternalFrameEvent e) {
        displayMessage("Internal frame deiconified", e);
    }

    public void internalFrameActivated(InternalFrameEvent e) {
        displayMessage("Internal frame activated", e);
    }

    public void internalFrameDeactivated(InternalFrameEvent e) {
        displayMessage("Internal frame deactivated", e);
    }

    //Add some text to the text area.
    void displayMessage(String prefix, InternalFrameEvent e) {
        String s = prefix + ": " + e.getSource();
        display.append(s + newline);
        display.setCaretPosition(display.getDocument().getLength());
    }

    //Handle events on the  buttons and menus.
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "ActionInsertLibrerias_Multimedia":
                caseInsertarLibrerias();
                break;
            case "ActionInsertPeliculas":
                caseInsertPeliculas();
                break;
            case "ActionInsertLibros":
                caseInsertarLibros();
                break;
            case "ActionInsertCancion":
                caseInsertarCancion();
                break;
            case "ActionInsertActor":
                caseInsertarActor();
                break;
            case "ActionInsertDirector":
                caseInsertarDirector();
                break;
            case "ActionInsertGeneroPeli":
                caseInsertarGeneroPeli();
                break;
            case "ActionInsertAutor":
                caseInsertarAutor();
                break;
            case "ActionInsertGeneroLibro":
                caseInsertarGeneroLibro();
                break;
            case "ActionInsertEditorial":
                caseInsertarEditorial();
                break;
            case "ActionInsertCantante":
                caseInsertarCantante();
                break;
            case "ActionInsertPremiosPelicula":
                caseInsertarPremiosPelicula();
                break;
            case "ActionInsertPremiosLibro":
                caseInsertarPremiosLibro();
                break;
            case "ActionInsertGeneroCancion":
                caseInsertarGeneroCancion();
                break;
            case "ActionInsertAlbum":
                caseInsertarAlbum();
                break;
            case "ActionInsertPremiosCancion":
                caseInsertarPremiosCancion();
                break;
            case "ActionConsLibrerias_Multimedia":
                caseConsLibrerias();
                break;
            case "ActionConsPeliculas":
                caseConsPeliculas();
                break;
            case "ActionConsLibros":
                caseConsLibros();
                break;
            case "ActionConsActor":
                caseConsActor();
                break;
            case "ActionConsDirector":
                caseConsDirector();
                break;
            case "ActionConsGeneroPeli":
                caseConsGeneroPeli();
                break;
            case "ActionConsAutor":
                caseConsAutor();
                break;
            case "ActionConsGeneroLibro":
                caseConsGeneroLibro();
                break;
            case "ActionConsEditorial":
                caseConsEditorial();
                break;
            case "ActionConsPremiosPelicula":
                caseConsPremiosPelicula();
                break;
            case "ActionConsPremiosLibro":
                caseConsPremiosLibro();
                break;
            case "ActionConsLibro":
                caseConsLibro();
                break;
            case "ActionConsCanciones":
                caseConsCanciones();
                break;
            case "ActionConsPremiosCancion":
                caseConsPremiosCancion();
                break;
            case "ActionConsGeneroCancion":
                caseConsGeneroCancion();
                break;
            case "ActionConsAlbumes":
                caseConsAlbumes();
                break;
            case "ActionConsCantante":
                caseConsCantante();
                break;
            case "Cambiar":
                caseCambiar();
                break;
            default:
                throw new clsPropiedadNonExistantException();

        }


    }


    private void quit() {
        System.exit(0);
    }

    /*protected void createFrame()
    {
        frmInternal frame = new frmInternal();
        frame.setVisible(true); //necessary as of 1.3
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }*/
    private void crearMenuLibrerias() {
        JBCambiar = new JButton("Cambiar");
        JLNombreLibreria = new JLabel("Libreria Seleccionada: ");
        JLNombreLibreria2 = new JLabel(objGestorLN.getNombreLibreriaDefinida());
        JPInterfazMenuLibreria = new JPanel();

        JPInterfazMenuLibreria.setBackground(Color.white);
        JPInterfazMenuLibreria.setLayout(null);
        if (objGestorLN.getNombreLibreriaDefinida() == "<No seleccionada>") {
            JLNombreLibreria2.setForeground(Color.RED);
        } else {
            JLNombreLibreria2.setForeground(Color.gray);
        }
        //JPInterfazMenuLibreria.setBorder();

        JBCambiar.setActionCommand("Cambiar");
        JBCambiar.addActionListener(this);

        desktop.add(JPInterfazMenuLibreria);
        JPInterfazMenuLibreria.add(JBCambiar);
        JPInterfazMenuLibreria.add(JLNombreLibreria);
        JPInterfazMenuLibreria.add(JLNombreLibreria2);

        JPInterfazMenuLibreria.setBounds(875, 0, 490, 30);
        JBCambiar.setBounds(395, 2, 88, 26);
        JLNombreLibreria.setBounds(4, 0, 130, 30);
        JLNombreLibreria2.setBounds(138, 0, 260, 30);
    }

    protected JMenuBar createMenuBar() {
        //JMenuBar menuBar = new JMenuBar();

        /* Inicia instancias de los componentes */
        miPanel = new JPanel();
        miPanel.setLayout(null);
        barraMenu = new JMenuBar();

        menuInsertar = new JMenu();
        menuConsultar = new JMenu();

        menuItemInsLibrerias_Multimedia = new JMenuItem();
        menuItemInsPeliculas = new JMenuItem();
        menuItemInsLibros = new JMenuItem();
        menuItemInsCancion = new JMenuItem();
        menuItemInsActor = new JMenuItem();
        menuItemInsDirector = new JMenuItem();
        menuItemInsGeneroPeli = new JMenuItem();
        menuItemInsAutor = new JMenuItem();
        menuItemInsGeneroLibro = new JMenuItem();
        menuItemInsEditorial = new JMenuItem();
        menuItemInsPremiosPelicula = new JMenuItem();
        menuItemInsPremiosLibro = new JMenuItem();
        menuItemInsGeneroCancion = new JMenuItem();
        menuItemInsCantante = new JMenuItem();
        menuItemInsAlbum = new JMenuItem();
        menuItemInsPremiosCancion = new JMenuItem();

        menuItemConsLibrerias_Multimedia = new JMenuItem();
        menuItemConsPeliculas = new JMenuItem();
        menuItemConsLibros = new JMenuItem();
        menuItemConsActor = new JMenuItem();
        menuItemConsDirector = new JMenuItem();
        menuItemConsGeneroPeli = new JMenuItem();
        menuItemConsAutor = new JMenuItem();
        menuItemConsGeneroLibro = new JMenuItem();
        menuItemConsEditorial = new JMenuItem();
        menuItemConsPremiosPelicula = new JMenuItem();
        menuItemConsPremiosLibro = new JMenuItem();
        menuItemConsLibro = new JMenuItem();
        menuItemConsCancion = new JMenuItem();
        menuItemConsPremiosCancion = new JMenuItem();
        menuItemConsGeneroCancion = new JMenuItem();
        menuItemConsAlbum = new JMenuItem();
        menuItemConsCantante = new JMenuItem();

        //Personalizaci?n
        //miPanel.setBackground(colorAzul);


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

        menuItemInsCancion.setText("Cancion");
        menuItemInsCancion.setActionCommand("ActionInsertCancion");
        menuInsertar.add(menuItemInsCancion);
        menuInsertar.addSeparator();

        menuItemInsActor.setText("Actor");
        menuItemInsActor.setActionCommand("ActionInsertActor");
        menuInsertar.add(menuItemInsActor);
        menuInsertar.addSeparator();

        menuItemInsDirector.setText("Director");
        menuItemInsDirector.setActionCommand("ActionInsertDirector");
        menuInsertar.add(menuItemInsDirector);
        menuInsertar.addSeparator();

        menuItemInsGeneroPeli.setText("Genero Pelicula");
        menuItemInsGeneroPeli.setActionCommand("ActionInsertGeneroPeli");
        menuInsertar.add(menuItemInsGeneroPeli);
        menuInsertar.addSeparator();

        menuItemInsAutor.setText("Autores");
        menuItemInsAutor.setActionCommand("ActionInsertAutor");
        menuInsertar.add(menuItemInsAutor);
        menuInsertar.addSeparator();

        menuItemInsGeneroLibro.setText("Genero Libro");
        menuItemInsGeneroLibro.setActionCommand("ActionInsertGeneroLibro");
        menuInsertar.add(menuItemInsGeneroLibro);
        menuInsertar.addSeparator();

        menuItemInsEditorial.setText("Editorial");
        menuItemInsEditorial.setActionCommand("ActionInsertEditorial");
        menuInsertar.add(menuItemInsEditorial);
        menuInsertar.addSeparator();

        menuItemInsPremiosPelicula.setText("Premios Pelicula");
        menuItemInsPremiosPelicula.setActionCommand("ActionInsertPremiosPelicula");
        menuInsertar.add(menuItemInsPremiosPelicula);
        menuInsertar.addSeparator();

        menuItemInsPremiosLibro.setText("Premios Libro");
        menuItemInsPremiosLibro.setActionCommand("ActionInsertPremiosLibro");
        menuInsertar.add(menuItemInsPremiosLibro);
        menuInsertar.addSeparator();

        menuItemInsGeneroCancion.setText("Genero Cancion");
        menuItemInsGeneroCancion.setActionCommand("ActionInsertGeneroCancion");
        menuInsertar.add(menuItemInsGeneroCancion);
        menuInsertar.addSeparator();

        menuItemInsCantante.setText("Cantante");
        menuItemInsCantante.setActionCommand("ActionInsertCantante");
        menuInsertar.add(menuItemInsCantante);
        menuInsertar.addSeparator();

        menuItemInsAlbum.setText("Album");
        menuItemInsAlbum.setActionCommand("ActionInsertAlbum");
        menuInsertar.add(menuItemInsAlbum);
        menuInsertar.addSeparator();

        menuItemInsPremiosCancion.setText("Premios Cancion");
        menuItemInsPremiosCancion.setActionCommand("ActionInsertPremiosCancion");
        menuInsertar.add(menuItemInsPremiosCancion);

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

        menuItemConsActor.setText("Actor");
        menuItemConsActor.setActionCommand("ActionConsActor");
        menuConsultar.add(menuItemConsActor);
        menuConsultar.addSeparator();

        menuItemConsDirector.setText("Director");
        menuItemConsDirector.setActionCommand("ActionConsDirector");
        menuConsultar.add(menuItemConsDirector);
        menuConsultar.addSeparator();

        menuItemConsGeneroPeli.setText("Genero Pelicula");
        menuItemConsGeneroPeli.setActionCommand("ActionConsGeneroPeli");
        menuConsultar.add(menuItemConsGeneroPeli);
        menuConsultar.addSeparator();

        menuItemConsAutor.setText("Autor");
        menuItemConsAutor.setActionCommand("ActionConsAutor");
        menuConsultar.add(menuItemConsAutor);
        menuConsultar.addSeparator();

        menuItemConsGeneroLibro.setText("Genero Libro");
        menuItemConsGeneroLibro.setActionCommand("ActionConsGeneroLibro");
        menuConsultar.add(menuItemConsGeneroLibro);
        menuConsultar.addSeparator();

        menuItemConsEditorial.setText("Editorial");
        menuItemConsEditorial.setActionCommand("ActionConsEditorial");
        menuConsultar.add(menuItemConsEditorial);
        menuConsultar.addSeparator();

        menuItemConsPremiosPelicula.setText("Premios Pelicula");
        menuItemConsPremiosPelicula.setActionCommand("ActionConsPremiosPelicula");
        menuConsultar.add(menuItemConsPremiosPelicula);
        menuConsultar.addSeparator();

        menuItemConsPremiosLibro.setText("Premios Libro");
        menuItemConsPremiosLibro.setActionCommand("ActionConsPremiosLibro");
        menuConsultar.add(menuItemConsPremiosLibro);
        menuConsultar.addSeparator();

        menuItemConsLibro.setText("Libros");
        menuItemConsLibro.setActionCommand("ActionConsLibro");
        menuConsultar.add(menuItemConsLibro);
        menuConsultar.addSeparator();

        menuItemConsCancion.setText("Canciones");
        menuItemConsCancion.setActionCommand("ActionConsCanciones");
        menuConsultar.add(menuItemConsCancion);
        menuConsultar.addSeparator();

        menuItemConsPremiosCancion.setText("Premios Cancion");
        menuItemConsPremiosCancion.setActionCommand("ActionConsPremiosCancion");
        menuConsultar.add(menuItemConsPremiosCancion);
        menuConsultar.addSeparator();

        menuItemConsGeneroCancion.setText("Generos Cancion");
        menuItemConsGeneroCancion.setActionCommand("ActionConsGeneroCancion");
        menuConsultar.add(menuItemConsGeneroCancion);
        menuConsultar.addSeparator();

        menuItemConsAlbum.setText("Albumes");
        menuItemConsAlbum.setActionCommand("ActionConsAlbumes");
        menuConsultar.add(menuItemConsAlbum);
        menuConsultar.addSeparator();

        menuItemConsCantante.setText("Cantantes");
        menuItemConsCantante.setActionCommand("ActionConsCantante");
        menuConsultar.add(menuItemConsCantante);



        /* Agrega los Menus de la barra de Menu */
        menuInsertar.setText("Insertar");
        barraMenu.add(menuInsertar);

        menuConsultar.setText("Consultar");
        barraMenu.add(menuConsultar);


        setJMenuBar(barraMenu);

        menuItemInsLibrerias_Multimedia.addActionListener(this);
        menuItemInsPeliculas.addActionListener(this);
        menuItemInsLibros.addActionListener(this);
        menuItemInsCancion.addActionListener(this);
        menuItemInsActor.addActionListener(this);
        menuItemInsDirector.addActionListener(this);
        menuItemInsGeneroPeli.addActionListener(this);
        menuItemInsAutor.addActionListener(this);
        menuItemInsGeneroLibro.addActionListener(this);
        menuItemInsEditorial.addActionListener(this);
        menuItemInsPremiosPelicula.addActionListener(this);
        menuItemInsPremiosLibro.addActionListener(this);
        menuItemInsGeneroCancion.addActionListener(this);
        menuItemInsCantante.addActionListener(this);
        menuItemInsAlbum.addActionListener(this);
        menuItemInsPremiosCancion.addActionListener(this);

        menuItemConsLibrerias_Multimedia.addActionListener(this);
        menuItemConsPeliculas.addActionListener(this);
        menuItemConsLibros.addActionListener(this);
        menuItemConsActor.addActionListener(this);
        menuItemConsDirector.addActionListener(this);
        menuItemConsGeneroPeli.addActionListener(this);
        menuItemConsAutor.addActionListener(this);
        menuItemConsGeneroLibro.addActionListener(this);
        menuItemConsEditorial.addActionListener(this);
        menuItemConsPremiosPelicula.addActionListener(this);
        menuItemConsPremiosLibro.addActionListener(this);
        menuItemConsLibro.addActionListener(this);
        menuItemConsCancion.addActionListener(this);
        menuItemConsPremiosCancion.addActionListener(this);
        menuItemConsGeneroCancion.addActionListener(this);
        menuItemConsAlbum.addActionListener(this);
        menuItemConsCantante.addActionListener(this);

        return barraMenu;
    }

    public void createAndShowGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(createMenuBar());
        this.crearMenuLibrerias();
        //Display the window.
        this.pack();
        this.setVisible(true);
    }


    /**
     * Clase insertar librerias desde la ventana.
     *
     * @see clsGestorLN
     */
    private void caseInsertarLibrerias() {
        //Declaraciones
        //Codigo
        frmInsertLibrerias VentanaInsertLibrerias = new frmInsertLibrerias(objGestorLN, desktop, this);
        desktop.add(VentanaInsertLibrerias);
    }

    /**
     * Clase insertar peliculas desde la ventana.
     *
     * @see clsGestorLN
     */
    private void caseInsertPeliculas() {
        //Declaraciones
        frmInsertPeliculas VentanaInsertPeliculas = new frmInsertPeliculas(objGestorLN);
        desktop.add(VentanaInsertPeliculas);
    }

    /**
     * Clase insertar libros desde la ventana.
     *
     * @see clsGestorLN
     */

    private void caseInsertarLibros() {
        frmInsertLibros VentanaInsertLibros = new frmInsertLibros(objGestorLN);
        desktop.add(VentanaInsertLibros);

    }

    /**
     * Clase insertar album desde la ventana.
     *
     * @see clsGestorLN
     */
    private void caseInsertarAlbum() {
        //Declaraciones
        frmInsertAlbum VentanaInsertAlbum = new frmInsertAlbum(objGestorLN);
        desktop.add(VentanaInsertAlbum);
    }

    /**
     * Clase insertar Cancion desde la ventana.
     *
     * @see clsGestorLN
     */
    private void caseInsertarCancion() {
        frmInsertCancion VentanaInsertCancion = new frmInsertCancion(objGestorLN);
        desktop.add(VentanaInsertCancion);
    }

    /**
     * Clase insertar actores desde la ventana.
     *
     * @see clsGestorLN
     */

    private void caseInsertarActor() {
        frmInsertActor VentanaInsertActor = new frmInsertActor(objGestorLN);
        desktop.add(VentanaInsertActor);
    }

    /**
     * Clase insertar autores desde la ventana.
     *
     * @see clsGestorLN
     */

    private void caseInsertarAutor() {
        frmInsertAutor VentanaInsertAutor = new frmInsertAutor(objGestorLN);
        desktop.add(VentanaInsertAutor);
    }

    /**
     * Clase insertar cantante desde la ventana.
     *
     * @see clsGestorLN
     */

    private void caseInsertarCantante() {
        frmInsertCantante VentanaInsertCantante = new frmInsertCantante(objGestorLN);
        desktop.add(VentanaInsertCantante);
    }

    /**
     * Clase insertar directores desde la ventana.
     *
     * @see clsGestorLN
     */

    private void caseInsertarDirector() {
        frmInsertDirector VentanaInsertDirector = new frmInsertDirector(objGestorLN);
        desktop.add(VentanaInsertDirector);
    }

    /**
     * Clase insertar directores desde la ventana.
     *
     * @see clsGestorLN
     */

    private void caseInsertarEditorial() {
        frmInsertEditorial VentanaInsertEditorial = new frmInsertEditorial(objGestorLN);
        desktop.add(VentanaInsertEditorial);
    }

    /**
     * Clase insertar premios de peliculas desde la ventana.
     *
     * @see clsGestorLN
     */

    private void caseInsertarPremiosPelicula() {
        frmInsertPremiosPelicula VentanaInsertPremiosPelicula = new frmInsertPremiosPelicula(objGestorLN);
        desktop.add(VentanaInsertPremiosPelicula);
    }

    /**
     * Clase insertar premios de canciones desde la ventana.
     *
     * @see clsGestorLN
     */

    private void caseInsertarPremiosCancion() {
        frmInsertPremiosCancion VentanaInsertPremiosCancion = new frmInsertPremiosCancion(objGestorLN);
        desktop.add(VentanaInsertPremiosCancion);
    }

    /**
     * Clase insertar premios de libros desde la ventana.
     *
     * @see clsGestorLN
     */

    private void caseInsertarPremiosLibro() {
        frmInsertPremiosLibro VentanaInsertPremiosLibro = new frmInsertPremiosLibro(objGestorLN);
        desktop.add(VentanaInsertPremiosLibro);
    }

    /**
     * Clase insertar generos de pelicula desde la ventana.
     *
     * @see clsGestorLN
     */
    private void caseInsertarGeneroPeli() {

        frmInsertGeneroPeli VentanaInsertGeneroPeli = new frmInsertGeneroPeli(objGestorLN);
        desktop.add(VentanaInsertGeneroPeli);
    }

    /**
     * Clase insertar generos de canciones desde la ventana.
     *
     * @see clsGestorLN
     */
    private void caseInsertarGeneroCancion() {

        frmInsertGeneroCancion VentanaInsertGeneroCancion = new frmInsertGeneroCancion(objGestorLN);
        desktop.add(VentanaInsertGeneroCancion);
    }

    /**
     * Clase insertar generos de libros desde la ventana.
     *
     * @see clsGestorLN
     */
    private void caseInsertarGeneroLibro() {

        frmInsertGeneroLibro VentanaInsertGeneroLibro = new frmInsertGeneroLibro(objGestorLN);
        desktop.add(VentanaInsertGeneroLibro);
    }

    /**
     * Método consultar Libro desde la ventana.
     */

    private void caseConsLibro() {
        //Ahora con JTables:
        frmTablaLibro VentanaTablaLibro = new frmTablaLibro(objGestorLN, desktop, this);
        desktop.add(VentanaTablaLibro);
    }

    /**
     * Método consultar Cancion desde la ventana.
     */

    private void caseConsCanciones() {
        //Ahora con JTables:
        frmTablaCancion VentanaTablaCancion = new frmTablaCancion(objGestorLN, desktop, this);
        desktop.add(VentanaTablaCancion);
    }

    /**
     * Método consultar PremiosCancion desde la ventana.
     */

    private void caseConsPremiosCancion() {
        //Ahora con JTables:
        frmTablaPremiosCancion VentanaTablaPremiosCancion = new frmTablaPremiosCancion(objGestorLN, desktop, this);
        desktop.add(VentanaTablaPremiosCancion);
    }

    /**
     * Método consultar GeneroCancion desde la ventana.
     */

    private void caseConsGeneroCancion() {
        //Ahora con JTables:
        frmTablaGeneroCancion VentanaTablaGeneroCancion = new frmTablaGeneroCancion(objGestorLN, desktop, this);
        desktop.add(VentanaTablaGeneroCancion);
    }

    /**
     * Método consultar Album desde la ventana.
     */

    private void caseConsAlbumes() {
        //Ahora con JTables:
        frmTablaAlbum VentanaTablaAlbum = new frmTablaAlbum(objGestorLN, desktop, this);
        desktop.add(VentanaTablaAlbum);
    }

    /**
     * Método consultar Cantante desde la ventana.
     */

    private void caseConsCantante() {
        //Ahora con JTables:
        frmTablaCantante VentanaTablaCantante = new frmTablaCantante(objGestorLN, desktop, this);
        desktop.add(VentanaTablaCantante);
    }

    /**
     * Método consultar librerias desde la ventana.
     */

    private void caseConsLibrerias() {
        //Ahora con JTables:
        frmTablaLibrerias VentanaTablaLibrerias = new frmTablaLibrerias(objGestorLN, desktop, this);
        desktop.add(VentanaTablaLibrerias);
    }

    /**
     * Método consultar peliculas desde la ventana.
     */
    private void caseConsPeliculas() {
        frmTablaPeliculas VentanaTablaPelicula = new frmTablaPeliculas(objGestorLN, desktop, this);
        desktop.add(VentanaTablaPelicula);
    }

    /**
     * Método consultar Libros desde la ventana.
     */
    private void caseConsLibros() {
        frmTablaLibro VentanaTablaLibro = new frmTablaLibro(objGestorLN, desktop, this);
        desktop.add(VentanaTablaLibro);
    }

    /**
     * Método consultar Actores desde la ventana.
     */
    private void caseConsActor() {
        frmTablaActor VentanaTablaActor = new frmTablaActor(objGestorLN, desktop, this);
        desktop.add(VentanaTablaActor);
    }

    /**
     * Método consultar Autores desde la ventana.
     */
    private void caseConsAutor() {
        frmTablaAutor VentanaTablaAutor = new frmTablaAutor(objGestorLN, desktop, this);
        desktop.add(VentanaTablaAutor);
    }

    /**
     * Método consultar directores desde la ventana.
     */

    private void caseConsDirector() {
        frmTablaDirector VentanaTablaDirector = new frmTablaDirector(objGestorLN, desktop, this);
        desktop.add(VentanaTablaDirector);
    }

    /**
     * Método consultar eitoriales desde la ventana.
     */

    private void caseConsEditorial() {
        frmTablaEditorial VentanaTablaEditorial = new frmTablaEditorial(objGestorLN, desktop, this);
        desktop.add(VentanaTablaEditorial);
    }

    /**
     * Método consultar generos de pelicula desde la ventana.
     */

    private void caseConsGeneroPeli() {
        frmTablaGeneroPelicula VentanaTablaGeneroPeli = new frmTablaGeneroPelicula(objGestorLN, desktop, this);
        desktop.add(VentanaTablaGeneroPeli);
    }

    /**
     * Método consultar generos de pelicula desde la ventana.
     */

    private void caseConsGeneroLibro() {
        frmTablaGeneroLibro VentanaTablaGeneroLibro = new frmTablaGeneroLibro(objGestorLN, desktop, this);
        desktop.add(VentanaTablaGeneroLibro);
    }

    /**
     * Método consultar premios de película desde la ventana.
     */
    private void caseConsPremiosPelicula() {
        frmTablaPremiosPelicula VentanaTablaPremiosPelicula = new frmTablaPremiosPelicula(objGestorLN, desktop, this);
        desktop.add(VentanaTablaPremiosPelicula);
    }

    /**
     * Método consultar premios de película desde la ventana.
     */
    private void caseConsPremiosLibro() {
        frmTablaPremiosLibro VentanaTablaPremiosLibro = new frmTablaPremiosLibro(objGestorLN, desktop, this);
        desktop.add(VentanaTablaPremiosLibro);
    }

    private void caseCambiar() {
        generarMenuLibrerias();
    }

    public void generarMenuLibrerias() {
        frmMenuLibrerias VentanaMenuLibrerias = new frmMenuLibrerias(objGestorLN, desktop, this);
        ArrayList<itfPropertyV2> resultado = objGestorLN.consultarLibreriasEnBD();
        for (itfPropertyV2 L : resultado
        ) {
            VentanaMenuLibrerias.setItem(L);
        }
        desktop.add(VentanaMenuLibrerias);
    }

    public void actualizarNombreLibreriaSeleccionada() {
        JLNombreLibreria2.setText(objGestorLN.getNombreLibreriaDefinida());
        if (objGestorLN.getNombreLibreriaDefinida() == "<No seleccionada>") {
            JLNombreLibreria2.setForeground(Color.RED);
        } else {
            JLNombreLibreria2.setForeground(Color.gray);
        }
    }


}