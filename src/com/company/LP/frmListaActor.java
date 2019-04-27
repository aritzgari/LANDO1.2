package com.company.LP;

import com.company.LN.itfProperty;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.LinkedList;

/**
 * Ventana para mostrar la lista de librerias multimedia que hay en la base de datos.
 * <p>
 * @author Ruben Domínguez
 * Aritz Garitano
 */
public class frmListaActor extends JInternalFrame implements ListSelectionListener
{
    //Objeto visual
    private JList<itfProperty> jlista;
    //Modelo de la vista
    protected ModeloLista modelo;

    //Lista auxiliar de Objetos
    private LinkedList<itfProperty> Objetos;


    /**
     * Creación de lista de  librerias.
     *
     * @see ModeloLista
     */
    public frmListaActor()
    {
        setTitle("Lista de Actores");

        setBounds(100, 100, 400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Objetos = new LinkedList<itfProperty>();

        modelo = new ModeloLista (Objetos);
        jlista = new JList<itfProperty>(modelo);
        //jlista.setCellRenderer(new ListRenderer());
        jlista.addListSelectionListener(this);
        JScrollPane scroll = new JScrollPane(jlista);

        this.getContentPane().add(scroll, BorderLayout.CENTER);

        setVisible(true);
        this.setResizable(true);
        this.setClosable(true);
        this.setIconifiable(true);
    }



    public void setItem(itfProperty Objeto)
    {
        modelo.addElement(Objeto);


        //jlista.setModel(modelo);


    }

    @Override
    public void valueChanged(ListSelectionEvent arg0)
    {

        //Se controla si se est?n realizando cambios todav?a en la lista.
        //Si no se controla esto, los eventos se lanzan varias veces.
        if (arg0.getValueIsAdjusting()==false)
        {
            String TextoAMostrar =
                    "clsActor{" +
                            "idActores =" + ((itfProperty) jlista.getSelectedValue()).getIntegerProperty("idActores") +
                            ", Nombre='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Nombre") + '\'' +
                            ", Apellido='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Apellido") + '\'' +
                            '}';
            System.out.println("Atributos: " + TextoAMostrar);
        }}}
