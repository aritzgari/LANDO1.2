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
 * Ventana para mostrar la lista de Actores, pero en vez de con JLists como antes, con un JTable.
 * <p>
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 * @see frmListaActor
 */
public class frmTablaActor extends JInternalFrame implements ActionListener, ListSelectionListener {
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
    private JLabel JLActor;
    private JLabel JLLista;
    private JLabel JLAcción;


    //Botones
    private JButton JBActualizar;
    private JButton JBBorrar;
    private JButton JBCancelar;

    //String para tomar los datos
    private String Apellido;

    //JTable y sus Propiedades
    private JTable TablaActor;
    private String[] nombrescolumnas;
    private Object[][] datosfila;
    private ArrayList<itfPropertyV2> ContenidoTabla;
    private JScrollPane JSkrull;
    private ListSelectionModel lsmTabla;

    /**
     * Creación de lista de actores dentro del JPanel.
     *
     * @see ModeloLista
     */
    //Constructor
    public frmTablaActor(clsGestorLN _objGestorLN, JDesktopPane _desktop, frmPrincipal _ventanaPrincipal) {
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
        setTitle("Tabla de actores guardados");

        //News y Valores de inicialización
        //JPanels
        JPContent = new JPanel();
        JPTabla = new JPanel();

        //JLabels
        JLActor = new JLabel("Lista de Actores disponibles:");
        JLLista = new JLabel("");

        //JButtons
        JBActualizar = new JButton("Actualizar");
        JBBorrar = new JButton("Borrar");
        JBCancelar = new JButton("Cancelar");

        //JTable
        ContenidoTabla = objGestorLN.consultarActoresEnBD();
        datosfila = new Object[ContenidoTabla.size()][3];


        int j = 0;
        for (itfPropertyV2 I : ContenidoTabla) {
            datosfila[j][0] = (int) I.getObjectProperty("idActores");
            datosfila[j][1] = (String) I.getObjectProperty("Nombre");
            datosfila[j][2] = (String) I.getObjectProperty("Apellido");
            j++;
        }


        nombrescolumnas = new String[]{"idActores", "Nombre", "Apellido"};

        TablaActor = new JTable(datosfila, nombrescolumnas);
        JSkrull = new JScrollPane(TablaActor);

        //Colores
        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155, 255, 141);
        Color naranja = new Color(255, 196, 87);

        //Añadimos las cosas a sus continentes
        JPTabla.add(JSkrull);
        JPContent.add(JPTabla);
        JPContent.add(JLActor);
        JPContent.add(JBActualizar);
        JPContent.add(JBBorrar);
        JPContent.add(JBCancelar);

        JPTabla.setBounds(25, 50, 800, 320);
        TablaActor.setBounds(0, 0, 650, 200);
        JLActor.setBounds(50, 20, 200, 30);
        JBActualizar.setBounds(100, 385, 150, 50);
        JBBorrar.setBounds(350, 385, 150, 50);
        JBCancelar.setBounds(600, 385, 150, 50);
        this.setContentPane(JPContent);

        //Más propiedades
        JPContent.setLayout(null);
        TablaActor.setPreferredScrollableViewportSize(new Dimension(750, 280));
        TablaActor.setFillsViewportHeight(true);
        TablaActor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmTabla = TablaActor.getSelectionModel();
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
        query = "DELETE FROM lando.actores WHERE(idActores = '" + TablaActor.getValueAt(TablaActor.getSelectedRow(), 0) + "')";
        objGestorLN.deleteActorEnBD(query);
        frmTablaActor VentanaTablaActor= new frmTablaActor(objGestorLN, desktop, ventanaPrincipal);
        desktop.add(VentanaTablaActor);
        dispose();
    }

    /**
     * Metodo para guardar las acciones pensadas para el boton de Actualizar
     */
    private void caseActualizar() {
        String query;
        query = "UPDATE lando.actores SET Nombre = '" + TablaActor.getValueAt(TablaActor.getSelectedRow(), 1) + "', Apellido = '" + TablaActor.getValueAt(TablaActor.getSelectedRow(), 2) + "' WHERE (idActores = '" + TablaActor.getValueAt(TablaActor.getSelectedRow(), 0) + "');";
        objGestorLN.updateActorEnBD(query);
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
