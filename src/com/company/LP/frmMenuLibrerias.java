package com.company.LP;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 */
public class frmMenuLibrerias extends JInternalFrame implements ActionListener, ListSelectionListener {
    //Declaraciones
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

    //Botones
    private JButton JBAceptar;
    private JButton JBCancelar;
    private JButton JBCrear;
    private JButton JBFIXED;

    //String para tomar los datos
    private String Descripcion;

    /**
     * Creación de lista de librerias dentro del JPanel.
     *
     * @see ModeloLista
     */
    public frmMenuLibrerias() {
        //Propiedades de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setVisible(true);
        setBounds(0, 0, 650, 500);
        setTitle("Menu de Librerías");


        //News y Valores de inicialización
        //JPanels
        JPContent = new JPanel();
        JPLista = new JPanel();

        //JLabels
        JLSeleccion = new JLabel("Escoja la librería en la que quiere añadir objetos:");

        //News de los componentes de la lista
        Objetos = new LinkedList<itfPropertyV2>();
        modelo = new ModeloListaV2(Objetos);
        JLista = new JList<itfPropertyV2>(modelo);
        JLista.addListSelectionListener(this);
        JLista.setVisibleRowCount(15);                          //Numero de registros que muestra la JLista
        scroll = new JScrollPane();

        //News de Botones
        JBAceptar = new JButton("Aceptar");
        JBCancelar = new JButton("Cancelar");
        JBCrear = new JButton("Crear Librería");
        JBFIXED = new JButton("Bibidi Babidi Bu");


        //Añadimos las cosas a sus continentes
        JPLista.add(scroll);                                    //El scroll va dentro del panel que existe solo para a la lista
        JPLista.add(JLista);                                    //La lista va en el panel que existe solo para la lista
        JPContent.add(JLSeleccion);
        JPContent.add(JPLista);                                 //El panel de la lista añadido en el JPanel de contenido, el principal
        JPContent.add(JBAceptar);                               //El boton de aceptar añadido en el JPanel de contenido, el principal
        JPContent.add(JBCancelar);                              //El boton de cancelar añadido en el JPanel de contenido, el principal
        JPContent.add(JBCrear);                                 //El boton de crear añadido en el JPanel de contenido, el principal
        JPContent.add(JBFIXED);                                 //El boton que arregla el problema de display con el último componente añadido, añadido en el JPanel de contenido, el principal

        this.setContentPane(JPContent);

        //Colores
        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155, 255, 141);
        Color azul = new Color(116, 255, 235);

        //Darle valores de acción a los botones
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

        Font tipoLetra = JLSeleccion.getFont();
        tipoLetra.deriveFont(Font.BOLD);
        tipoLetra.deriveFont(40.0f);
        JLSeleccion.setFont(tipoLetra);   //Intento de ponerlo en negrita

        //Ubicar las cosas porque sino sale tudu amontonado:
        //scroll.setBounds(0,0,500,500);
        //JPLista.setLocation(0,100);
        scroll.setViewportView(JLista);
        JPLista.setBounds(20,75,400,500);
        JLSeleccion.setBounds(25, 15, 300, 50);
        JBAceptar.setBounds(450, 80, 150, 60);
        JBCrear.setBounds(450, 180, 150, 60);
        JBCancelar.setBounds(450, 290, 150, 60);
        JBAceptar.setVisible(true);
        JBCancelar.setVisible(true);
        JBFIXED.setVisible(false);

    }

    public void setItem(itfPropertyV2 Objeto) {
        modelo.addElement(Objeto);
    }

    /**
     * Metodo para guardar las acciones pensadas para el boton de Aceptar
     */
    private void caseAceptar() {
        JLSeleccion.setText("" + JLista.getSelectedValue().getObjectProperty("Descripción")); //Aquí da NPE si no hay nada seleciionado
        //JLista.getSelectedValue().getObjectProperty("Descripción");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Aceptar":
                caseAceptar();
                break;

            default:
                throw new clsPropiedadNonExistantException();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent arg0) {
        if (arg0.getValueIsAdjusting() == false) {
            String TextoAMostrar =
                    "clsLibreriaMultimedia{" +
                            " Descripción= " + ((itfPropertyV2) JLista.getSelectedValue()).getObjectProperty("Descripción") + " }";
            System.out.println("Atributos: " + TextoAMostrar);

        }

    }
}
