package com.company.LP;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;
import com.company.LN.clsGestorLN;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Ventana para mostrar la lista de Libros, pero en vez de con JLists como antes, con un JTable.
 * <p>
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 * @see frmListaAutor
 */

public class frmTablaLibro extends JInternalFrame implements ActionListener, ListSelectionListener {
    private clsGestorLN objGestorLN;
    //La pantalla principal
    private frmPrincipal ventanaPrincipal;
    private JDesktopPane desktop;
    //JPanels
    private JPanel JPContent;
    private JPanel JPTabla;

    //JLabels
    private JLabel JLAutor;
    private JLabel JLLista;
    private JLabel JLAcción;


    //Botones
    private JButton JBActualizar;
    private JButton JBBorrar;
    private JButton JBCancelar;

    //String para tomar los datos
    private String Apellido;

    //JTable y sus Propiedades
    private JTable TablaLibro;
    private String[] nombrescolumnas;
    private Object[][] datosfila;
    private ArrayList<itfPropertyV2> ContenidoTabla;
    private JScrollPane JSkrull;
    private ListSelectionModel lsmTabla;

    /**
     * Creación de lista de Libros dentro del JPanel.
     *
     * @see ModeloLista
     */
    //Constructor
    public frmTablaLibro(clsGestorLN _objGestorLN, JDesktopPane _desktop, frmPrincipal _ventanaPrincipal) {
        //Definir el gestor dentro de este ámbito para poder acceder a él
        objGestorLN = _objGestorLN;
        ventanaPrincipal = _ventanaPrincipal;
        desktop = _desktop;
        //Propiedades de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setVisible(true);
        setBounds(0, 40, 850, 500);
        setTitle("Tabla de Libros guardados");

        //News y Valores de inicialización
        //JPanels
        JPContent = new JPanel();
        JPTabla = new JPanel();

        //JLabels
        JLAutor = new JLabel("Lista de libros disponibles:");
        JLLista = new JLabel("");

        //JButtons
        JBActualizar = new JButton("Actualizar");
        JBBorrar = new JButton("Borrar");
        JBCancelar = new JButton("Cancelar");

        //JTable
        ContenidoTabla = objGestorLN.consultarLibrosEnBD();
        datosfila = new Object[ContenidoTabla.size()][18];


        int j = 0;
        for (itfPropertyV2 I : ContenidoTabla) {
            datosfila[j][0] = I.getObjectProperty("ISBN");
            datosfila[j][1] = I.getObjectProperty("Título");
            datosfila[j][2] = I.getObjectProperty("Título_original");
            datosfila[j][3] = I.getObjectProperty("Año");
            datosfila[j][4] = I.getObjectProperty("Tipo_DoA");
            datosfila[j][5] = I.getObjectProperty("Precio");
            datosfila[j][6] = I.getObjectProperty("En_propiedad");
            datosfila[j][7] = I.getObjectProperty("En_busqueda");
            datosfila[j][8] = I.getObjectProperty("Formato");
            datosfila[j][9] = I.getObjectProperty("Paginas");
            datosfila[j][10] = I.getObjectProperty("Resumen");
            datosfila[j][11] = I.getObjectProperty("Serie_SoN");
            datosfila[j][12] = I.getObjectProperty("Nombre_serie");
            datosfila[j][13] = I.getObjectProperty("Orden_serie");
            datosfila[j][14] = I.getObjectProperty("Género_Libro_idGénero_Libro");
            datosfila[j][15] = I.getObjectProperty("Autor_idAutor");
            datosfila[j][16] = I.getObjectProperty("Libreria_Multimedia_idLibreria_Multimedia");
            datosfila[j][17] = I.getObjectProperty("Editorial_idEditorial");
            j++;
        }


        nombrescolumnas = new String[]{"ISBN", "Título", "Título_Original", "Año", "Digital/Analógico", "Precio", "Lo tengo", "Lo quiero", "Formato", "Páginas", "Resumen", "Pertenece a Serie", "Nombre de Serie", "Orden en Serie", "idGénero", "idAutor", "idLibreriaMultimedia", "idEditorial"};

        TablaLibro = new JTable(datosfila, nombrescolumnas);
        JSkrull = new JScrollPane(TablaLibro);

        //Colores
        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155, 255, 141);
        Color naranja = new Color(255, 196, 87);

        //Añadimos las cosas a sus continentes
        JPTabla.add(JSkrull);
        JPContent.add(JPTabla);
        JPContent.add(JLAutor);
        JPContent.add(JBActualizar);
        JPContent.add(JBBorrar);
        JPContent.add(JBCancelar);

        JPTabla.setBounds(25, 50, 800, 320);
        TablaLibro.setBounds(0, 0, 650, 200);
        JLAutor.setBounds(50, 20, 200, 30);
        JBActualizar.setBounds(100, 385, 150, 50);
        JBBorrar.setBounds(350, 385, 150, 50);
        JBCancelar.setBounds(600, 385, 150, 50);
        this.setContentPane(JPContent);

        //Más propiedades
        JPContent.setLayout(null);
        TablaLibro.setPreferredScrollableViewportSize(new Dimension(750, 280));
        TablaLibro.setFillsViewportHeight(true);
        TablaLibro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmTabla = TablaLibro.getSelectionModel();
        lsmTabla.addListSelectionListener(this);

        //Acciones en los botones
        JBActualizar.addActionListener(this);
        JBBorrar.addActionListener(this);
        JBCancelar.addActionListener(this);
        JBActualizar.setActionCommand("Actualizar");
        JBBorrar.setActionCommand("Borrar");
        JBCancelar.setActionCommand("Cancelar");
        JBActualizar.setBackground(verde);
        JBBorrar.setBackground(naranja);
        JBCancelar.setBackground(rojo);


    }

    /**
     * Metodo para guardar las acciones pensadas para el boton de Borrar
     */
    private void caseBorrar() {
        String query;
        query = "DELETE FROM lando.Libros WHERE(ISBN = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 0) + "')";
        objGestorLN.deleteLibroEnBD(query);
        frmTablaLibro VentanaTablaLibro = new frmTablaLibro(objGestorLN, desktop, ventanaPrincipal);
        desktop.add(VentanaTablaLibro);
        dispose();
    }

    /**
     * Metodo para guardar las acciones pensadas para el boton de Actualizar
     */
    private void caseActualizar() {
        String query;
        query = "UPDATE lando.Libros SET " +
                "Título = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 1) +
                "', Título_Original = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 2) +
                "', Año = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 3) +
                "', Tipo_DoA = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 4) +
                "', Precio = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 5) +
                "', En_propiedad = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 6) +
                "', En_busqueda = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 7) +
                "', Formato = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 8) +
                "', Paginas = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 9) +
                "', Resumen = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 10) +
                "', Serie_SoN = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 11) +
                "', Nombre_serie = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 12) +
                "', Orden_serie = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 13) +
                "', Género_Libro_idGénero_Libro = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 14) +
                "', Autor_idAutor = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 15) +
                "', Libreria_Multimedia_idLibreria_Multimedia = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 16) +
                "', Editorial_idEditorial = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 17) +
                "' WHERE (ISBN = '" + TablaLibro.getValueAt(TablaLibro.getSelectedRow(), 0) + "');";
        objGestorLN.updateLibroEnBD(query);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Actualizar":
                caseActualizar();
                break;

            case "Borrar":
                caseBorrar();
                break;

            case "Cancelar":
                dispose();
                break;

            default:
                throw new clsPropiedadNonExistantException();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            //Se llama cada vez que pinchas en la tabla
        }
    }
}