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
 * Ventana para mostrar la lista de premios de Canciones, pero en vez de con JLists como antes, con un JTable.
 * <p>
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 * @see frmListaPremiosLibro
 */

public class frmTablaPremiosCancion extends JInternalFrame implements ActionListener, ListSelectionListener {

    private clsGestorLN objGestorLN;
    //La pantalla principal
    private frmPrincipal ventanaPrincipal;
    private JDesktopPane desktop;
    //JPanels
    private JPanel JPContent;
    private JPanel JPTabla;

    //JLabels
    private JLabel JLPremiosLibro;
    private JLabel JLLista;
    private JLabel JLAcción;


    //Botones
    private JButton JBActualizar;
    private JButton JBBorrar;
    private JButton JBCancelar;


    //JTable y sus Propiedades
    private JTable TablaPremiosCancion;
    private String[] nombrescolumnas;
    private Object[][] datosfila;
    private ArrayList<itfPropertyV2> ContenidoTabla;
    private JScrollPane JSkrull;
    private ListSelectionModel lsmTabla;

    /**
     * Creación de lista de premios libros dentro del JPanel.
     *
     * @see ModeloListaV2
     */
    //Constructor
    public frmTablaPremiosCancion(clsGestorLN _objGestorLN, JDesktopPane _desktop, frmPrincipal _ventanaPrincipal) {
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
        setTitle("Tabla de premios libro guardados");

        //News y Valores de inicialización
        //JPanels
        JPContent = new JPanel();
        JPTabla = new JPanel();

        //JLabels
        JLPremiosLibro = new JLabel("Lista de premios de canciones disponibles:");
        JLLista = new JLabel("");

        //JButtons
        JBActualizar = new JButton("Actualizar");
        JBBorrar = new JButton("Borrar");
        JBCancelar = new JButton("Cancelar");

        //JTable
        ContenidoTabla = objGestorLN.consultarPremiosCancionesBD();
        datosfila = new Object[ContenidoTabla.size()][9];


        int j = 0;
        for (itfPropertyV2 I : ContenidoTabla) {
            datosfila[j][0] =  I.getObjectProperty("idPremios");
            datosfila[j][1] =  I.getObjectProperty("Nombre");
            datosfila[j][2] =  I.getObjectProperty("Categoria");
            datosfila[j][3] =  I.getObjectProperty("Año");
            datosfila[j][4] =  I.getObjectProperty("Canciones_idCanciones");
            datosfila[j][5] =  I.getObjectProperty("Canciones_Género_Canción_idGénero_Canción");
            datosfila[j][6] =  I.getObjectProperty("Canciones_Album_idAlbum");
            datosfila[j][7] =  I.getObjectProperty("Canciones_Album_Cantante_idCantante");
            datosfila[j][8] =  I.getObjectProperty("Canciones_Libreria_Multimedia_idLibreria_Multimedia");
            j++;
        }


        nombrescolumnas = new String[]{"idPremios", "Nombre", "Categoria", "Año", "idCancion", "idGénero", "idAlbum", "idAlbum_Cantante", "idLibreria"};

        TablaPremiosCancion = new JTable(datosfila, nombrescolumnas);
        JSkrull = new JScrollPane(TablaPremiosCancion);

        //Colores
        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155, 255, 141);
        Color naranja = new Color(255, 196, 87);

        //Añadimos las cosas a sus continentes
        JPTabla.add(JSkrull);
        JPContent.add(JPTabla);
        JPContent.add(JLPremiosLibro);
        JPContent.add(JBActualizar);
        JPContent.add(JBBorrar);
        JPContent.add(JBCancelar);

        JPTabla.setBounds(25, 50, 800, 320);
        TablaPremiosCancion.setBounds(0, 0, 650, 200);
        JLPremiosLibro.setBounds(50, 20, 200, 30);
        JBActualizar.setBounds(100, 385, 150, 50);
        JBBorrar.setBounds(350, 385, 150, 50);
        JBCancelar.setBounds(600, 385, 150, 50);
        this.setContentPane(JPContent);

        //Más propiedades
        JPContent.setLayout(null);
        TablaPremiosCancion.setPreferredScrollableViewportSize(new Dimension(750, 280));
        TablaPremiosCancion.setFillsViewportHeight(true);
        TablaPremiosCancion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmTabla = TablaPremiosCancion.getSelectionModel();
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
        query = "DELETE FROM lando.premios_cancion WHERE(idPremios = '" + TablaPremiosCancion.getValueAt(TablaPremiosCancion.getSelectedRow(), 0) + "')";
        objGestorLN.deletePremiosCancionEnBD(query);
        frmTablaPremiosCancion VentanaTablaPremiosCancion= new frmTablaPremiosCancion(objGestorLN, desktop, ventanaPrincipal);
        desktop.add(VentanaTablaPremiosCancion);
        dispose();
    }

    /**
     * Metodo para guardar las acciones pensadas para el boton de Actualizar
     */
    private void caseActualizar() {
        String query;
        query = "UPDATE lando.premios_cancion SET Nombre = '" + TablaPremiosCancion.getValueAt(TablaPremiosCancion.getSelectedRow(), 1) +
                "', Categoria = '" + TablaPremiosCancion.getValueAt(TablaPremiosCancion.getSelectedRow(), 2) +
                "', Año = '" + TablaPremiosCancion.getValueAt(TablaPremiosCancion.getSelectedRow(), 3) +
                "', Canciones_idCanciones = '" + TablaPremiosCancion.getValueAt(TablaPremiosCancion.getSelectedRow(), 4) +
                "', Canciones_Género_Canción_idGénero_Canción = '" + TablaPremiosCancion.getValueAt(TablaPremiosCancion.getSelectedRow(), 5) +
                "', Canciones_Album_idAlbum = '" + TablaPremiosCancion.getValueAt(TablaPremiosCancion.getSelectedRow(), 6) +
                "', Canciones_Album_Cantante_idCantante = '" + TablaPremiosCancion.getValueAt(TablaPremiosCancion.getSelectedRow(), 7) +
                "', Canciones_Libreria_Multimedia_idLibreria_Multimedia = '" + TablaPremiosCancion.getValueAt(TablaPremiosCancion.getSelectedRow(), 8) +
                "' WHERE (idPremios = '" + TablaPremiosCancion.getValueAt(TablaPremiosCancion.getSelectedRow(), 0) + "');";
        objGestorLN.updatePremiosCancionEnBD(query);
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
