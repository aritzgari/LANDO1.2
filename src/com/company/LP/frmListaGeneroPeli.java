package com.company.LP;

import com.company.LN.itfProperty;
import com.company.Comun.itfPropertyV2;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.LinkedList;

/**
 * Ventana para mostrar la lista de librerias multimedia que hay en la base de datos.
 * <p>
 *
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */
public class frmListaGeneroPeli extends JInternalFrame implements ListSelectionListener {
    //Objeto visual
    private JList<itfPropertyV2> jlista;
    //Modelo de la vista
    protected ModeloListaV2 modelo;

    //Lista auxiliar de Objetos
    private LinkedList<itfPropertyV2> Objetos;


    /**
     * Creaci�n de lista de  librerias.
     *
     * @see ModeloLista
     */
    public frmListaGeneroPeli() {
        setTitle("Lista de g�nero de peliculas");

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
            String TextoAMostrar =
                    "clsGeneroPeli{" +
                            " Nombre= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Nombre") + " }";
            System.out.println("Atributos: " + TextoAMostrar);
        }
    }
}
