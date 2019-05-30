package com.company.LP;

import com.company.Comun.itfPropertyV2;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.LinkedList;

/**
 * Ventana para mostrar la lista de Premios de Libros de la base de datos.
 * <p>
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 * @see ModeloListaV2
 */

public class frmListaPremiosLibro  extends JInternalFrame implements ListSelectionListener {

    //Objeto visual
    private JList<itfPropertyV2> jlista;
    //Modelo de la vista
    protected ModeloListaV2 modelo;

    //Lista auxiliar de Objetos
    private LinkedList<itfPropertyV2> Objetos;


    /**
     * Creación de lista de  librerias.
     *
     * @see ModeloListaV2
     */
    public frmListaPremiosLibro() {
        setTitle("Lista de Premios Libro");

        setBounds(100, 100, 400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Objetos = new LinkedList<itfPropertyV2>();

        modelo = new ModeloListaV2(Objetos);
        jlista = new JList<itfPropertyV2>(modelo);
        //jlista.setCellRenderer(new ListRenderer());
        jlista.addListSelectionListener(this);
        JScrollPane scroll = new JScrollPane(jlista);

        this.getContentPane().add(scroll, BorderLayout.CENTER);

        setVisible(true);
        this.setResizable(true);
        this.setClosable(true);
        this.setIconifiable(true);
    }


    public void setItem(itfPropertyV2 Objeto) {
        modelo.addElement(Objeto);


        //jlista.setModel(modelo);


    }

    @Override
    public void valueChanged(ListSelectionEvent arg0) {

        //Se controla si se est?n realizando cambios todav?a en la lista.
        //Si no se controla esto, los eventos se lanzan varias veces.
        if (arg0.getValueIsAdjusting() == false) {
            //String TextoAMostrar = ((itfProperty) jlista.getSelectedValue()).getStringProperty("Descripcion");
            String TextoAMostrar = "clsPremios_Libro{" +
                    "ID Premios Libro= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("idPremios") +
                    ", Nombre= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Nombre") +
                    ", Categoria= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Categoria") +
                    ", Año= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Año") +
                    ", ISBN libro= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Libro_ISBN") +
                    '}';
            System.out.println("Atributos: " + TextoAMostrar);
        }

    }

}
