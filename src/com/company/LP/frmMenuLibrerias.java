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
import java.util.LinkedList;

/**
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */
public class frmMenuLibrerias extends JInternalFrame implements ActionListener, ListSelectionListener {
    //Declaraciones
    //El gestor
    private clsGestorLN objGestorLN;
    //La pantalla principal
    private frmPrincipal ventanaPrincipal;
    private JDesktopPane desktop;
    //JPanels
    private JPanel JPContent;
    private JPanel JPLista;

    //Lista
    private JList<itfPropertyV2> JLista;
    //Modelo de la vista
    protected ModeloListaV2 modelo;
    //Lista auxiliar de Objetos
    private LinkedList<itfPropertyV2> Objetos;
    private JScrollPane scroll;

    //JLabels
    private JLabel JLSeleccion;
    private JLabel JLLista;
    private JLabel JLAcci�n;



    //Botones
    private JButton JBAceptar;
    private JButton JBCancelar;
    private JButton JBCrear;
    private JButton JBFIXED;

    //String para tomar los datos
    private String Descripcion;

    /**
     * Creaci�n de lista de librerias dentro del JPanel.
     *
     * @see ModeloLista
     */
    //Constructor
    public frmMenuLibrerias(clsGestorLN _objGestorLN, JDesktopPane _desktop, frmPrincipal _ventanaPrincipal) {
        //Definir el gestor dentro de este ?mbito para poder acceder a ?l
        objGestorLN = _objGestorLN;
        ventanaPrincipal = _ventanaPrincipal;
        desktop = _desktop;
        //Propiedades de la ventana
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setVisible(true);
        setBounds(0, 0, 650, 500);
        setTitle("Menu de Librer�as");


        //News y Valores de inicializaci�n
        //JPanels
        JPContent = new JPanel();
        JPLista = new JPanel();

        //JLabels
        JLSeleccion = new JLabel("Escoja la librer�a en la que quiere a�adir objetos, o cree una nueva:");
        JLLista = new JLabel("Lista de librer�as disponibles:");

        //News de los componentes de la lista
        Objetos = new LinkedList<itfPropertyV2>();
        modelo = new ModeloListaV2(Objetos);
        JLista = new JList<itfPropertyV2>(modelo);
        JLista.addListSelectionListener(this);
        JLista.setVisibleRowCount(15);                          //Numero de registros que muestra la JLista
        scroll = new JScrollPane();

        //News de Botones
        JBAceptar = new JButton("Aceptar");
        JBCancelar = new JButton("Cerrar");
        JBCrear = new JButton("Crear Librer�a");
        JBFIXED = new JButton("Bibidi Babidi Bu");


        //A�adimos las cosas a sus continentes
        JPLista.add(scroll);                                    //El scroll va dentro del panel que existe solo para a la lista
        JPLista.add(JLista);                                    //La lista va en el panel que existe solo para la lista
        JPContent.add(JLSeleccion);
        JPContent.add(JLLista);
        JPContent.add(JPLista);                                 //El panel de la lista a?adido en el JPanel de contenido, el principal
        JPContent.add(JBAceptar);                               //El boton de aceptar a?adido en el JPanel de contenido, el principal
        JPContent.add(JBCancelar);                              //El boton de cancelar a?adido en el JPanel de contenido, el principal
        JPContent.add(JBCrear);                                 //El boton de crear a?adido en el JPanel de contenido, el principal
        JPContent.add(JBFIXED);                                 //El boton que arregla el problema de display con el ?ltimo componente a?adido, a?adido en el JPanel de contenido, el principal

        this.setContentPane(JPContent);

        //Colores
        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155, 255, 141);
        Color azul = new Color(116, 255, 235);

        //Darle valores de acci�n a los botones
        JBAceptar.setActionCommand("Aceptar");
        JBCancelar.setActionCommand("Cancelar");
        JBCrear.setActionCommand("Crear");
        JBAceptar.addActionListener(this);
        JBCancelar.addActionListener(this);
        JBCrear.addActionListener(this);
        JBAceptar.setBackground(verde);
        JBCancelar.setBackground(rojo);
        JBCrear.setBackground(azul);

        //Dar valores a cosas
        JPContent.setLayout(null);
        JLista.setFixedCellWidth(350);
        JBCancelar.setVisible(objGestorLN.getLibreriaDefinida()>0);


        //Cambios en tipos de letra
        Font tipoLetra = JLSeleccion.getFont();
        tipoLetra.deriveFont(Font.BOLD);
        tipoLetra.deriveFont(40.0f);
        JLSeleccion.setFont(tipoLetra);   //Intento de ponerlo en negrita

        //Ubicar las cosas porque sino sale tudu amontonado:
        //scroll.setBounds(0,0,500,500);
        //JPLista.setLocation(0,100);
        scroll.setViewportView(JLista);
        JPLista.setBounds(10, 75, 400, 500);
        JLSeleccion.setBounds(25, 10, 500, 30);
        JLLista.setBounds(25, 45, 300, 30);
        JBAceptar.setBounds(450, 80, 150, 60);
        JBCrear.setBounds(450, 185, 150, 60);
        JBCancelar.setBounds(450, 290, 150, 60);
        JBAceptar.setVisible(true);
        //JBCancelar.setVisible(true);
        JBFIXED.setVisible(false);

    }

    public void setItem(itfPropertyV2 Objeto) {
        modelo.addElement(Objeto);
    }

    /**
     * Metodo para guardar las acciones pensadas para el boton de Aceptar
     */
    private void caseAceptar() {
        // JLSeleccion.setText("ID lista seleccionado: " + JLista.getSelectedValue().getObjectProperty("idLibreria_Multimedia")); //Aqu? da NPE si no hay nada seleccionado
        objGestorLN.setLibreriaDefinida((Integer) JLista.getSelectedValue().getObjectProperty("idLibreria_Multimedia"));

        //INTENTO MUY LOCO DE MOSTRARLO EN LA P.PRINCIPAL
        //Actualizar el valor en el gestor y en la pantalla principal
        objGestorLN.setNombreLibreriaDefinida((String) JLista.getSelectedValue().getObjectProperty("Nombre"));
        //INTENTO MUY LOCO DE MOSTRARLO EN LA P.PRINCIPAL

        JBCancelar.setVisible(objGestorLN.getLibreriaDefinida()>0);   //Si se descomenta se actualizar? nada mas cargar un valor, sino, cuando se vuelva a llamar a esta ventana



    }
    /**
     * Metodo para guardar las acciones pensadas para el boton de Crear Libreria
     */
    private void caseCrear() {
        frmInsertLibrerias VentanaInsertLibrerias = new frmInsertLibrerias(objGestorLN,desktop, ventanaPrincipal);
        desktop.add(VentanaInsertLibrerias);
        dispose();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Aceptar":
                caseAceptar();
                break;

            case "Crear":
                caseCrear();
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
    public void valueChanged(ListSelectionEvent arg0) {
        if (arg0.getValueIsAdjusting() == false) {
            String TextoAMostrar =
                    "clsLibreriaMultimedia{" +
                            " Descripci?n= " + ((itfPropertyV2) JLista.getSelectedValue()).getObjectProperty("Descripci?n") + " }";
            System.out.println("Atributos: " + TextoAMostrar);

        }
    }
}
