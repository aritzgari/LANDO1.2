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
 * Ventana para mostrar la lista de Premios de Peliculas, pero en vez de con JLists como antes, con un JTable.
 * <p>
 *
 * @author Ruben Dom�nguez
 * Aritz Garitano
 * @see frmListaGeneroPeli
 */

public class frmTablaPremiosPelicula extends JInternalFrame implements ActionListener, ListSelectionListener  {

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
    private JLabel JLPremiosPelicula;
    private JLabel JLLista;
    private JLabel JLAcci�n;


    //Botones
    private JButton JBActualizar;
    private JButton JBBorrar;
    private JButton JBCancelar;


    //JTable y sus Propiedades
    private JTable TablaPremiosPelicula;
    private String[] nombrescolumnas;
    private Object[][] datosfila;
    private ArrayList<itfPropertyV2> ContenidoTabla;
    private JScrollPane JSkrull;
    private ListSelectionModel lsmTabla;

    /**
     * Creaci�n de lista de premios peliculas dentro del JPanel.
     *
     * @see ModeloListaV2
     */
    //Constructor
    public frmTablaPremiosPelicula(clsGestorLN _objGestorLN, JDesktopPane _desktop, frmPrincipal _ventanaPrincipal) {
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
        setTitle("Tabla de premios pelicula guardados");

        //News y Valores de inicializaci�n
        //JPanels
        JPContent = new JPanel();
        JPTabla = new JPanel();

        //JLabels
        JLPremiosPelicula = new JLabel("Lista de premios pelicula disponibles:");
        JLLista = new JLabel("");

        //JButtons
        JBActualizar = new JButton("Actualizar");
        JBBorrar = new JButton("Borrar");
        JBCancelar = new JButton("Cancelar");

        //JTable
        ContenidoTabla = objGestorLN.consultarPremiosPeliculaEnBD();
        datosfila = new Object[ContenidoTabla.size()][5];


        int j = 0;
        for (itfPropertyV2 I : ContenidoTabla) {
            datosfila[j][0] = (int) I.getObjectProperty("idPremios");
            datosfila[j][1] = (String) I.getObjectProperty("Nombre");
            datosfila[j][2] = (String) I.getObjectProperty("Categoria");
            datosfila[j][3] = (int) I.getObjectProperty("A�o");
            datosfila[j][4] = (String) I.getObjectProperty("Pel�culas_T�tulo");
            j++;
        }


        nombrescolumnas = new String[]{"idPremios", "Nombre", "Categoria", "A�o", "Pel�culas_T�tulo"};

        TablaPremiosPelicula = new JTable(datosfila, nombrescolumnas);
        JSkrull = new JScrollPane(TablaPremiosPelicula);

        //Colores
        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155, 255, 141);
        Color naranja = new Color(255, 196, 87);

        //A�adimos las cosas a sus continentes
        JPTabla.add(JSkrull);
        JPContent.add(JPTabla);
        JPContent.add(JLPremiosPelicula);
        JPContent.add(JBActualizar);
        JPContent.add(JBBorrar);
        JPContent.add(JBCancelar);

        JPTabla.setBounds(25, 50, 800, 320);
        TablaPremiosPelicula.setBounds(0, 0, 650, 200);
        JLPremiosPelicula.setBounds(50, 20, 200, 30);
        JBActualizar.setBounds(100, 385, 150, 50);
        JBBorrar.setBounds(350, 385, 150, 50);
        JBCancelar.setBounds(600, 385, 150, 50);
        this.setContentPane(JPContent);

        //M�s propiedades
        JPContent.setLayout(null);
        TablaPremiosPelicula.setPreferredScrollableViewportSize(new Dimension(750, 280));
        TablaPremiosPelicula.setFillsViewportHeight(true);
        TablaPremiosPelicula.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmTabla = TablaPremiosPelicula.getSelectionModel();
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
        query = "DELETE FROM lando.premios_pel�cula WHERE(idPremios = '" + TablaPremiosPelicula.getValueAt(TablaPremiosPelicula.getSelectedRow(), 0) + "')";
        objGestorLN.deletePremiosPeliculaEnBD(query);
        frmTablaPremiosPelicula VentanaTablaPremiosPelicula= new frmTablaPremiosPelicula(objGestorLN, desktop, ventanaPrincipal);
        desktop.add(VentanaTablaPremiosPelicula);
        dispose();
    }

    /**
     * Metodo para guardar las acciones pensadas para el boton de Actualizar
     */
    private void caseActualizar() {
        String query;
        query = "UPDATE lando.premios_pel�cula SET Nombre = '" + TablaPremiosPelicula.getValueAt(TablaPremiosPelicula.getSelectedRow(), 1) + "', Categoria = '" + TablaPremiosPelicula.getValueAt(TablaPremiosPelicula.getSelectedRow(), 2) + "', A�o = '" + TablaPremiosPelicula.getValueAt(TablaPremiosPelicula.getSelectedRow(), 3) +  "', Pel�culas_T�tulo = '" + TablaPremiosPelicula.getValueAt(TablaPremiosPelicula.getSelectedRow(), 4) + "' WHERE (idPremios = '" + TablaPremiosPelicula.getValueAt(TablaPremiosPelicula.getSelectedRow(), 0) + "');";
        objGestorLN.updatePremiosPeliculaEnBD(query);
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
