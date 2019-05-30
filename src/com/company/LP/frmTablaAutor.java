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
 * Ventana para mostrar la lista de Autores, pero en vez de con JLists como antes, con un JTable.
 * <p>
 *
 * @author Ruben Dom�nguez
 * Aritz Garitano
 * @see frmListaAutor
 */

public class frmTablaAutor extends JInternalFrame implements ActionListener, ListSelectionListener  {
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
    private JLabel JLAutor;
    private JLabel JLLista;
    private JLabel JLAcci�n;


    //Botones
    private JButton JBActualizar;
    private JButton JBBorrar;
    private JButton JBCancelar;

    //String para tomar los datos
    private String Apellido;

    //JTable y sus Propiedades
    private JTable TablaAutor;
    private String[] nombrescolumnas;
    private Object[][] datosfila;
    private ArrayList<itfPropertyV2> ContenidoTabla;
    private JScrollPane JSkrull;
    private ListSelectionModel lsmTabla;

    /**
     * Creaci�n de lista de autores dentro del JPanel.
     *
     * @see ModeloLista
     */
    //Constructor
    public frmTablaAutor(clsGestorLN _objGestorLN, JDesktopPane _desktop, frmPrincipal _ventanaPrincipal) {
        //Definir el gestor dentro de este �mbito para poder acceder a �l
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
        setTitle("Tabla de autores guardados");

        //News y Valores de inicializaci�n
        //JPanels
        JPContent = new JPanel();
        JPTabla = new JPanel();

        //JLabels
        JLAutor = new JLabel("Lista de autores disponibles:");
        JLLista = new JLabel("");

        //JButtons
        JBActualizar = new JButton("Actualizar");
        JBBorrar = new JButton("Borrar");
        JBCancelar = new JButton("Cancelar");

        //JTable
        ContenidoTabla = objGestorLN.consultarAutoresEnBD();
        datosfila = new Object[ContenidoTabla.size()][3];


        int j = 0;
        for (itfPropertyV2 I : ContenidoTabla) {
            datosfila[j][0] = (int) I.getObjectProperty("idAutor");
            datosfila[j][1] = (String) I.getObjectProperty("Nombre");
            datosfila[j][2] = (String) I.getObjectProperty("Apellido");
            j++;
        }


        nombrescolumnas = new String[]{"idAutor", "Nombre", "Apellido"};

        TablaAutor = new JTable(datosfila, nombrescolumnas);
        JSkrull = new JScrollPane(TablaAutor);

        //Colores
        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155, 255, 141);
        Color naranja = new Color(255, 196, 87);

        //A�adimos las cosas a sus continentes
        JPTabla.add(JSkrull);
        JPContent.add(JPTabla);
        JPContent.add(JLAutor);
        JPContent.add(JBActualizar);
        JPContent.add(JBBorrar);
        JPContent.add(JBCancelar);

        JPTabla.setBounds(25, 50, 800, 320);
        TablaAutor.setBounds(0, 0, 650, 200);
        JLAutor.setBounds(50, 20, 200, 30);
        JBActualizar.setBounds(100, 385, 150, 50);
        JBBorrar.setBounds(350, 385, 150, 50);
        JBCancelar.setBounds(600, 385, 150, 50);
        this.setContentPane(JPContent);

        //M�s propiedades
        JPContent.setLayout(null);
        TablaAutor.setPreferredScrollableViewportSize(new Dimension(750, 280));
        TablaAutor.setFillsViewportHeight(true);
        TablaAutor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmTabla = TablaAutor.getSelectionModel();
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
        query = "DELETE FROM lando.autor WHERE(idAutor = '" + TablaAutor.getValueAt(TablaAutor.getSelectedRow(), 0) + "')";
        objGestorLN.deleteAutorEnBD(query);
        frmTablaAutor VentanaTablaAutor= new frmTablaAutor(objGestorLN, desktop, ventanaPrincipal);
        desktop.add(VentanaTablaAutor);
        dispose();
    }

    /**
     * Metodo para guardar las acciones pensadas para el boton de Actualizar
     */
    private void caseActualizar() {
        String query;
        query = "UPDATE lando.autor SET Nombre = '" + TablaAutor.getValueAt(TablaAutor.getSelectedRow(), 1) + "', Apellido = '" + TablaAutor.getValueAt(TablaAutor.getSelectedRow(), 2) + "' WHERE (idAutor = '" + TablaAutor.getValueAt(TablaAutor.getSelectedRow(), 0) + "');";
        objGestorLN.updateAutorEnBD(query);
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