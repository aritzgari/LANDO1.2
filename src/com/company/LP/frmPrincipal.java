package com.company.LP;

import com.company.LN.clsGestorLN;
import com.company.LN.itfProperty;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class frmPrincipal extends JFrame implements InternalFrameListener, ActionListener {
    //Declaraciones funcionales
    private static clsGestorLN objGestorLN = new clsGestorLN();
    /*Tudo lo que contiene el menu*/
    private JPanel miPanel;// contenedor de los componentes
    private JMenuBar barraMenu;
    private JMenu menuInsertar, menuConsultar;
    /* items del menu Insertar */
    private JMenuItem menuItemInsLibrerias_Multimedia, menuItemInsPeliculas, menuItemInsLibros, menuItemInsMusica, menuItemInsActor, menuItemInsDirector;
    /* items del menu Consultar */
    private JMenuItem menuItemConsLibrerias_Multimedia, menuItemConsPeliculas, menuItemConsLibros, menuItemConsMusica, menuItemConsActor, menuItemConsDirector;


    //Declaraciones copiadas
    JTextArea display;
    JDesktopPane desktop;
    JInternalFrame displayWindow;
    JInternalFrame listenedToWindow;

    static final String SHOW = "show";
    static final String CLEAR = "clear";
    String newline = "\n";
    static final int desktopWidth = 500;
    static final int desktopHeight = 300;

    public frmPrincipal(String title) {

        super(title);

        //Set up the GUI.
        desktop = new JDesktopPane();
        desktop.setPreferredSize(new Dimension(desktopWidth, desktopHeight));
        setContentPane(desktop);

        //createDisplayWindow();
        //desktop.add(displayWindow); //DON'T FORGET THIS!!!
        //Dimension displaySize = displayWindow.getSize();
        //displayWindow.setSize(desktopWidth, displaySize.height);
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
            case "ActionInsertMusica":
                caseInsertarMusica();
                break;
            case "ActionInsertActor":
                caseInsertarActor();
                break;
            case "ActionInsertDirector":
                caseInsertarDirector();
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
            case "ActionConsMusica":
                caseConsMusica();
                break;
            case "ActionConsActor":
                caseConsActor();
                break;
            case "ActionConsDirector":
                caseConsDirector();
                break;

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
        menuItemInsMusica = new JMenuItem();
        menuItemInsActor = new JMenuItem();
        menuItemInsDirector = new JMenuItem();

        menuItemConsLibrerias_Multimedia = new JMenuItem();
        menuItemConsPeliculas = new JMenuItem();
        menuItemConsLibros = new JMenuItem();
        menuItemConsMusica = new JMenuItem();
        menuItemConsActor = new JMenuItem();
        menuItemConsDirector = new JMenuItem();



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
        menuInsertar.addSeparator();

        menuItemInsActor.setText("Actor");
        menuItemInsActor.setActionCommand("ActionInsertActor");
        menuInsertar.add(menuItemInsActor);
        menuInsertar.addSeparator();

        menuItemInsDirector.setText("Director");
        menuItemInsDirector.setActionCommand("ActionInsertDirector");
        menuInsertar.add(menuItemInsDirector);
        menuInsertar.addSeparator();

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
        menuConsultar.addSeparator();

        menuItemConsActor.setText("Actor");
        menuItemConsActor.setActionCommand("ActionConsActor");
        menuConsultar.add(menuItemConsActor);
        menuConsultar.addSeparator();

        menuItemConsDirector.setText("Director");
        menuItemConsDirector.setActionCommand("ActionConsDirector");
        menuConsultar.add(menuItemConsDirector);
        menuConsultar.addSeparator();


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
        menuItemInsActor.addActionListener(this);
        menuItemInsDirector.addActionListener(this);

        menuItemConsLibrerias_Multimedia.addActionListener(this);
        menuItemConsPeliculas.addActionListener(this);
        menuItemConsLibros.addActionListener(this);
        menuItemConsMusica.addActionListener(this);
        menuItemConsActor.addActionListener(this);
        menuItemConsDirector.addActionListener(this);


       /* //Set up the lone menu.
        JMenu menu = new JMenu("Document");
        menu.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menu);*/

        /*//Set up the first menu item.
        JMenuItem menuItem = new JMenuItem("New");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("new");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menu.addSeparator();*/

       /* //Set up the second menu item.
        menuItem = new JMenuItem("Quit");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menu.addSeparator();*/


        return barraMenu;
    }

    public void createAndShowGUI() {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(createMenuBar());
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
        String Nombre;
        String Descripcion;
        //Codigo
        System.out.println("Datos para crear la Librería:");
        System.out.println("Un Nombre para saber que libreria es. (String)\n" +
                "ej. 'Casa' ó 'Oficina'.");
        Nombre = UtilidadesLP.leerCadena();
        System.out.println("Añade una descripción para saber que es lo que va a contener esta librería");
        Descripcion = UtilidadesLP.leerCadena();
        objGestorLN.crearLibreria(/*idLibreria_Multimedia,*/ Nombre, Descripcion);
    }

    /**
     * Clase insertar peliculas desde la ventana.
     *
     * @see clsGestorLN
     */
    private void caseInsertPeliculas() {
        //Declaraciones
        int Libreria_Multimedia_idLibreria_Multimedia;
        String Titulo;
        String Titulo_original;
        int Anno_de_publicacion;
        int Duracion;
        int Calificacion;
        int Calporedad;
        String Tipo_DoA;
        double Precio;
        boolean En_propiedad = false;
        boolean En_busqueda = false;
        String Formato;
        String Saga;
        Double Orden;
        String Sinopsis;
        String Enlace_a_trailer;

        //Codigo
        System.out.println("Datos para crear la Pelicula:");
        System.out.println("ID de la libreria a la que pertenece:(int)");
        Libreria_Multimedia_idLibreria_Multimedia = UtilidadesLP.leerEntero();
        System.out.println("Titulo: (String)");
        Titulo = UtilidadesLP.leerCadena();
        System.out.println("Titulo original: (String)");
        Titulo_original = UtilidadesLP.leerCadena();
        System.out.println("Año de publicación: (int)");
        Anno_de_publicacion = UtilidadesLP.leerEntero();
        System.out.println("Duracion: (int)");
        Duracion = UtilidadesLP.leerEntero();
        System.out.println("Calificacion: (int)");
        Calificacion = UtilidadesLP.leerEntero();
        System.out.println("Calificación por edad: (int)");
        Calporedad = UtilidadesLP.leerEntero();
        System.out.println("Tipo de formato: (String Digital ó Analógico)");
        Tipo_DoA = UtilidadesLP.leerCadena();
        System.out.println("Precio: (Double)");
        Precio = UtilidadesLP.leerReal();
        System.out.println("Lo tengo: (boolean 0 o 1)");
        int valor = UtilidadesLP.leerEntero();
        if (valor == 0) {
            En_propiedad = false;
        } else if (valor == 1) {
            En_propiedad = true;
        }
        System.out.println("Lo quiero: (boolean 0 o 1)");
        valor = UtilidadesLP.leerEntero();
        if (valor == 0) {
            En_busqueda = false;
        } else if (valor == 1) {
            En_busqueda = true;
        }
        System.out.println("Formato: (String) - Ej: .mp3 o Vinilo o BluRay");
        Formato = UtilidadesLP.leerCadena();
        System.out.println("Nombre de la saga a la que pertenece (String)");
        Saga = UtilidadesLP.leerCadena();
        System.out.println("En esa saga, que numero es: (Double)");
        Orden = UtilidadesLP.leerReal();
        System.out.println("Sinopsis: (String)");
        Sinopsis = UtilidadesLP.leerCadena();
        System.out.println("Puedes añadir el enlace al trailer: (String)");
        Enlace_a_trailer = UtilidadesLP.leerCadena();

        objGestorLN.crearPelicula(Libreria_Multimedia_idLibreria_Multimedia, Titulo, Titulo_original, Anno_de_publicacion, Duracion, Calificacion, Calporedad, Tipo_DoA, Precio, En_propiedad, En_busqueda, Formato, Saga, Orden, Sinopsis, Enlace_a_trailer);
    }

    /**
     * Clase insertar libros desde la ventana.
     *
     * @see clsGestorLN
     */

    private void caseInsertarLibros() {
        //Declaraciones
        int Libreria_Multimedia_idLibreria_Multimedia;
        String ISBN;
        String Titulo;
        String Titulo_original;
        int Anno_de_publicacion;
        String Tipo_DoA;
        double Precio;
        boolean En_propiedad = false;
        boolean En_busqueda = false;
        String Formato;
        int Paginas;
        String Resumen;
        boolean SerieSoN = false;
        String Nombre_serie;
        double Orden_serie;

        //Prueba:
        int idGenero = 1;
        int idAutor = 0;

        //Codigo
        System.out.println("Datos para crear el libro:");
        System.out.println("ID de la libreria a la que pertenece:(int)");
        Libreria_Multimedia_idLibreria_Multimedia = UtilidadesLP.leerEntero();
        System.out.println("ISBN: (String)");
        ISBN = UtilidadesLP.leerCadena();
        System.out.println("Titulo: (String)");
        Titulo = UtilidadesLP.leerCadena();
        System.out.println("Titulo original: (String)");
        Titulo_original = UtilidadesLP.leerCadena();
        System.out.println("Año de publicación: (int)");
        Anno_de_publicacion = UtilidadesLP.leerEntero();
        System.out.println("Tipo de formato: (String Digital ó Analógico)");
        Tipo_DoA = UtilidadesLP.leerCadena();
        System.out.println("Precio: (Double)");
        Precio = UtilidadesLP.leerReal();
        System.out.println("Lo tengo: (boolean 0 o 1)");
        int valor = UtilidadesLP.leerEntero();
        if (valor == 0) {
            En_propiedad = false;
        } else if (valor == 1) {
            En_propiedad = true;
        }
        System.out.println("Lo quiero: (boolean 0 o 1)");
        valor = UtilidadesLP.leerEntero();
        if (valor == 0) {
            En_busqueda = false;
        } else if (valor == 1) {
            En_busqueda = true;
        }
        System.out.println("Formato: (String) - Ej: .mp3 o Vinilo o BluRay");
        Formato = UtilidadesLP.leerCadena();
        System.out.println("Paginas que tiene: (int)");
        Paginas = UtilidadesLP.leerEntero();
        System.out.println("Un resumen: (String)");
        Resumen = UtilidadesLP.leerCadena();
        System.out.println("Pertenece a una serie de libros: (boolean 0 o 1)");
        valor = UtilidadesLP.leerEntero();
        if (valor == 0) {
            SerieSoN = false;
        } else if (valor == 1) {
            SerieSoN = true;
        }
        System.out.println("Como se llama la serie: (String)");
        Nombre_serie = UtilidadesLP.leerCadena();
        System.out.println("Orden cronológico de la serie a la que pertenece: (Double)");
        Orden_serie = UtilidadesLP.leerReal();
        //Prueba
        //System.out.println("idGenero(INT)");

        //System.out.println("Yoquesetio(INT)");


        objGestorLN.crearLibro(Libreria_Multimedia_idLibreria_Multimedia, ISBN, Titulo, Titulo_original, Anno_de_publicacion, Tipo_DoA, Precio, En_propiedad, En_busqueda, Formato, Paginas, Resumen, SerieSoN, Nombre_serie, Orden_serie, idGenero, idAutor);
    }


    private void caseInsertarMusica() {
    }

    /**
     * Clase insertar actores desde la ventana.
     *
     * @see clsGestorLN
     */

    private void caseInsertarActor() {
        //Declaraciones
        String Nombre;
        String Apellido;
        //Codigo
        System.out.println("Datos para crear el actor:");
        System.out.println("Nombre del actor:");
        Nombre = UtilidadesLP.leerCadena();
        System.out.println("Apellido del actor:");
        Apellido = UtilidadesLP.leerCadena();
        objGestorLN.crearActor(Nombre, Apellido);
    }

    private void caseInsertarDirector() {
        //Declaraciones
        String Nombre;
        String Apellido;
        //Codigo
        System.out.println("Datos para crear el director:");
        System.out.println("Nombre del director:");
        Nombre = UtilidadesLP.leerCadena();
        System.out.println("Apellido del director:");
        Apellido = UtilidadesLP.leerCadena();
        objGestorLN.crearDirector(Nombre, Apellido);
    }

    /**
     * Método consultar librerias desde la ventana.
     */

    private void caseConsLibrerias() {
        frmListaLibrerias VentanaConsLibrerias = new frmListaLibrerias();
        ArrayList<itfProperty> resultado = objGestorLN.consultarLibreriasEnBD();
        for (itfProperty L : resultado
        ) {
            VentanaConsLibrerias.setItem(L);
        }
        desktop.add(VentanaConsLibrerias);
    }

    /**
     * Método consultar peliculas desde la ventana.
     */
    private void caseConsPeliculas() {
        frmListaPeliculas VentanaConsPeliculas = new frmListaPeliculas();
        ArrayList<itfProperty> resultado = objGestorLN.consultarPeliculaEnBD();
        for (itfProperty L : resultado
        ) {
            VentanaConsPeliculas.setItem(L);
        }
        desktop.add(VentanaConsPeliculas);
    }

    /**
     * Método consultar Libros desde la ventana.
     */
    private void caseConsLibros() {
        frmListaLibros VentanaConsLibros = new frmListaLibros();
        ArrayList<itfProperty> resultado = objGestorLN.consultarLibrosEnBD();
        for (itfProperty L : resultado
        ) {
            VentanaConsLibros.setItem(L);
        }
        desktop.add(VentanaConsLibros);
    }

    /**
     * Método consultar Actores desde la ventana.
     */
    private void caseConsActor() {
        frmListaActor VentanaConsActor = new frmListaActor();
        ArrayList<itfProperty> resultado = objGestorLN.consultarActoresEnBD();
        for (itfProperty L : resultado
        ) {
            VentanaConsActor.setItem(L);
        }
        desktop.add(VentanaConsActor);
    }

    private void caseConsDirector() {
        frmListaDirector VentanaConsDirector = new frmListaDirector();
        ArrayList<itfProperty> resultado = objGestorLN.consultarDirectorEnBD();
        for (itfProperty L : resultado
        ) {
            VentanaConsDirector.setItem(L);
        }
        desktop.add(VentanaConsDirector);
    }

    private void caseConsMusica() {
    }


}