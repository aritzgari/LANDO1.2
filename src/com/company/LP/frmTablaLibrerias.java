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
 * Ventana para mostrar la lista de Librerías, pero en vez de con JLists como antes, con un JTable.
 * <p>
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 * @see frmListaLibrerias
 */
public class frmTablaLibrerias extends JInternalFrame implements ActionListener, ListSelectionListener {
    //Declaraciones
    //El gestor
    private clsGestorLN objGestorLN;
    //La pantalla principal
    private frmPrincipal ventanaPrincipal;
    private JDesktopPane desktop;
    //JPanels
    private JPanel JPContent;
    private JPanel JPTabla;

    //ScrollPane por si acaso
    private JScrollPane scroll;

    //JLabels
    private JLabel JLLiberiasEnBD;
    private JLabel JLLista;
    private JLabel JLAcción;


    //Botones
    private JButton JBActualizar;
    private JButton JBBorrar;
    private JButton JBCancelar;

    //String para tomar los datos
    private String Descripcion;

    //JTable y sus Propiedades
    private JTable TablaLibrerias;
    private String[] nombrescolumnas;
    private Object[][] datosfila;
    private ArrayList<itfPropertyV2> ContenidoTabla;
    private JScrollPane JSkrull;
    private ListSelectionModel lsmTabla;

    /**
     * Creación de lista de librerias dentro del JPanel.
     *
     * @see ModeloLista
     */
    //Constructor
    public frmTablaLibrerias(clsGestorLN _objGestorLN, JDesktopPane _desktop, frmPrincipal _ventanaPrincipal) {
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
        setTitle("Tabla de Librerías guardadas");

        //News y Valores de inicialización
        //JPanels
        JPContent = new JPanel();
        JPTabla = new JPanel();

        //JLabels
        JLLiberiasEnBD = new JLabel("Lista de librerías disponibles:");
        JLLista = new JLabel("");

        //JButtons
        JBActualizar = new JButton("Actualizar");
        JBBorrar = new JButton("Borrar");
        JBCancelar = new JButton("Cancelar");

        //JTable
        ContenidoTabla = objGestorLN.consultarLibreriasEnBD();
        datosfila = new Object[ContenidoTabla.size()][3];


        int j = 0;
        for (itfPropertyV2 I : ContenidoTabla) {
            datosfila[j][0] = (int) I.getObjectProperty("idLibreria_Multimedia");
            datosfila[j][1] = (String) I.getObjectProperty("Nombre");
            datosfila[j][2] = (String) I.getObjectProperty("Descripción");
            j++;
        }


        nombrescolumnas = new String[]{"idLibreria", "Nombre", "Descripción"};

        TablaLibrerias = new JTable(datosfila, nombrescolumnas);
        JSkrull = new JScrollPane(TablaLibrerias);

        //Colores
        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155, 255, 141);
        Color naranja = new Color(255, 196, 87);

        //Añadimos las cosas a sus continentes
        JPTabla.add(JSkrull);
        JPContent.add(JPTabla);
        JPContent.add(JLLiberiasEnBD);
        JPContent.add(JBActualizar);
        JPContent.add(JBBorrar);
        JPContent.add(JBCancelar);

        JPTabla.setBounds(25, 50, 800, 320);
        TablaLibrerias.setBounds(0, 0, 650, 200);
        JLLiberiasEnBD.setBounds(50, 20, 200, 30);
        JBActualizar.setBounds(100, 385, 150, 50);
        JBBorrar.setBounds(350, 385, 150, 50);
        JBCancelar.setBounds(600, 385, 150, 50);
        this.setContentPane(JPContent);

        //Más propiedades
        JPContent.setLayout(null);
        TablaLibrerias.setPreferredScrollableViewportSize(new Dimension(750, 280));
        TablaLibrerias.setFillsViewportHeight(true);
        TablaLibrerias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmTabla = TablaLibrerias.getSelectionModel();
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
        query = "DELETE FROM lando.libreria_multimedia WHERE(idLibreria_Multimedia = '" + TablaLibrerias.getValueAt(TablaLibrerias.getSelectedRow(), 0) + "')";
        objGestorLN.deleteLibrerias_multimediaEnBD(query);
        //Solo por si la libreria seleccionada es sobre la que estamos trabajando
        if (objGestorLN.getLibreriaDefinida() == (int) TablaLibrerias.getValueAt(TablaLibrerias.getSelectedRow(), 0)) {
            objGestorLN.setNombreLibreriaDefinida("<No seleccionada>");
            objGestorLN.setLibreriaDefinida(-1);
            ventanaPrincipal.actualizarNombreLibreriaSeleccionada();
        }
        //Volvemos a crear la pantalla para generar la tabla actualizada
        frmTablaLibrerias VentanaTablaLibrerias = new frmTablaLibrerias(objGestorLN, desktop, ventanaPrincipal);
        desktop.add(VentanaTablaLibrerias);
        dispose();
    }

    /**
     * Metodo para guardar las acciones pensadas para el boton de Actualizar
     */
    private void caseActualizar() {
        String query;
        query = "UPDATE lando.Libreria_Multimedia SET Nombre = '" + TablaLibrerias.getValueAt(TablaLibrerias.getSelectedRow(), 1) + "', Descripcion = '" + TablaLibrerias.getValueAt(TablaLibrerias.getSelectedRow(), 2) + "' WHERE (idLibreria_Multimedia = '" + TablaLibrerias.getValueAt(TablaLibrerias.getSelectedRow(), 0) + "');";
        objGestorLN.updateLibrerias_multimediaEnBD(query);
        //SOLO PARA LIBRERIAS:
        if (objGestorLN.getLibreriaDefinida() == (int) TablaLibrerias.getValueAt(TablaLibrerias.getSelectedRow(), 0)) {
            //objGestorLN.setLibreriaDefinida((int) TablaLibrerias.getValueAt(TablaLibrerias.getSelectedRow(), 0));
            objGestorLN.setNombreLibreriaDefinida("" + TablaLibrerias.getValueAt(TablaLibrerias.getSelectedRow(), 1));
            ventanaPrincipal.actualizarNombreLibreriaSeleccionada();
        }
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

        ventanaPrincipal.actualizarNombreLibreriaSeleccionada();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            //Se llama cada vez que pinchas en la tabla
        }
    }
}
