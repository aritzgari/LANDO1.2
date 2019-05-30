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
 * Ventana para mostrar la lista de Preliculas, pero en vez de con JLists como antes, con un JTable.
 * <p>
 *
 * @author Ruben Dom�nguez
 * Aritz Garitano
 * @see frmListaPeliculas
 */
public class frmTablaPeliculas extends JInternalFrame implements ActionListener, ListSelectionListener {

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
    private JLabel JLPeliculas;
    private JLabel JLLista;
    private JLabel JLAcci�n;


    //Botones
    private JButton JBActualizar;
    private JButton JBBorrar;
    private JButton JBCancelar;


    //JTable y sus Propiedades
    private JTable TablaPeliculas;
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
    public frmTablaPeliculas(clsGestorLN _objGestorLN, JDesktopPane _desktop, frmPrincipal _ventanaPrincipal) {
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
        setTitle("Tabla de peliculas guardadas");

        //News y Valores de inicializaci�n
        //JPanels
        JPContent = new JPanel();
        JPTabla = new JPanel();

        //JLabels
        JLPeliculas = new JLabel("Lista de peliculas disponibles:");
        JLLista = new JLabel("");

        //JButtons
        JBActualizar = new JButton("Actualizar");
        JBBorrar = new JButton("Borrar");
        JBCancelar = new JButton("Cancelar");

        //JTable
        ContenidoTabla = objGestorLN.consultarPeliculaEnBD();
        datosfila = new Object[ContenidoTabla.size()][16];


        int j = 0;
        for (itfPropertyV2 I : ContenidoTabla) {
            datosfila[j][0] = (String) I.getObjectProperty("T�tulo");
            datosfila[j][1] = (String) I.getObjectProperty("T�tulo_Original");
            datosfila[j][2] = (int) I.getObjectProperty("A�o");
            datosfila[j][3] = (int) I.getObjectProperty("Duraci�n");
            datosfila[j][4] = (int) I.getObjectProperty("Puntuaci�n");
            datosfila[j][5] = (int) I.getObjectProperty("Calporedad");
            datosfila[j][6] = (String) I.getObjectProperty("Tipo_DoA");
            datosfila[j][7] = (double) I.getObjectProperty("Precio");
            datosfila[j][8] = (boolean) I.getObjectProperty("En_propiedad");
            datosfila[j][9] = (boolean) I.getObjectProperty("En_busqueda");
            datosfila[j][10] = (String) I.getObjectProperty("Formato");
            datosfila[j][11] = (String) I.getObjectProperty("Saga");
            datosfila[j][12] = (Double) I.getObjectProperty("Ord�n_en_Saga");
            datosfila[j][13] = (String) I.getObjectProperty("Sinopsis");
            datosfila[j][14] = (String) I.getObjectProperty("Enlace_al_Trailer");
            datosfila[j][15] = (int) I.getObjectProperty("Libreria_Multimedia_idLibreria_Multimedia");
            j++;
        }


        nombrescolumnas = new String[]{"T�tulo", "T�tulo_Original", "A�o", "Duraci�n", "Puntuaci�n", "Calporedad", "Tipo_DoA", "Precio", "En_propiedad", "En_busqueda", "Formato", "Saga", "Orden_en_Saga", "Sinopsis", "Enlace_al_Trailer", "Libreria_Multimedia_idLibreria_Multimedia"};

        TablaPeliculas = new JTable(datosfila, nombrescolumnas);
        JSkrull = new JScrollPane(TablaPeliculas);

        //Colores
        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155, 255, 141);
        Color naranja = new Color(255, 196, 87);

        //A�adimos las cosas a sus continentes
        JPTabla.add(JSkrull);
        JPContent.add(JPTabla);
        JPContent.add(JLPeliculas);
        JPContent.add(JBActualizar);
        JPContent.add(JBBorrar);
        JPContent.add(JBCancelar);

        JPTabla.setBounds(25, 50, 800, 320);
        TablaPeliculas.setBounds(0, 0, 650, 200);
        JLPeliculas.setBounds(50, 20, 200, 30);
        JBActualizar.setBounds(100, 385, 150, 50);
        JBBorrar.setBounds(350, 385, 150, 50);
        JBCancelar.setBounds(600, 385, 150, 50);
        this.setContentPane(JPContent);

        //M�s propiedades
        JPContent.setLayout(null);
        TablaPeliculas.setPreferredScrollableViewportSize(new Dimension(750, 280));
        TablaPeliculas.setFillsViewportHeight(true);
        TablaPeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmTabla = TablaPeliculas.getSelectionModel();
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
        query = "DELETE FROM lando.pel�culas WHERE(T�tulo = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 0) + "') and (Libreria_Multimedia_idLibreria_Multimedia = '"  + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 15) + "');";
        objGestorLN.deletePeliculaEnBD(query);
        frmTablaPeliculas VentanaTablaPelicula= new frmTablaPeliculas(objGestorLN, desktop, ventanaPrincipal);
        desktop.add(VentanaTablaPelicula);
        dispose();
    }

    /**
     * Metodo para guardar las acciones pensadas para el boton de Actualizar
     */
    private void caseActualizar() {
        String query;
        query = "UPDATE lando.pel�culas SET T�tulo = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 0) + "', T�tulo_Original = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 1) + "', A�o = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 2) +  "', Duraci�n = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 3) + "', Puntuaci�n = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 4) + "', Calporedad = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 5) + "', Tipo_DoA = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 6) + "', Precio = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 7) +  "', En_propiedad = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 8) + "', En_busqueda = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 9) + "', Formato = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 10) + "', Saga = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 11) + "', Orden_en_Saga = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 12) + "', Sinopsis = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 13) + "', Enlace_al_Trailer = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 14) + "', Sinopsis = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 13) + "', Libreria_Multimedia_idLibreria_Multimedia = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 15) +  "' WHERE (T�tulo = '" + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 0) + "') and (Libreria_Multimedia_idLibreria_Multimedia = '"  + TablaPeliculas.getValueAt(TablaPeliculas.getSelectedRow(), 15) + "');";
        objGestorLN.updatePeliculaEnBD(query);
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

