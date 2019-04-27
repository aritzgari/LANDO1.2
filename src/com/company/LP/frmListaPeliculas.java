package com.company.LP;

import com.company.LN.itfProperty;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.LinkedList;

/**
 * Ventana para mostrar la lista de ºpeliculas de la base de datos.
 * <p>
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 * @see ModeloLista
 */

public class frmListaPeliculas extends JInternalFrame implements ListSelectionListener {
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
    public frmListaPeliculas() {
        setTitle("Lista de Peliculas");

        setBounds(100, 100, 400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Objetos = new LinkedList<itfProperty>();

        modelo = new ModeloLista(Objetos);
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


    public void setItem(itfProperty Objeto) {
        modelo.addElement(Objeto);


        //jlista.setModel(modelo);


    }

    @Override
    public void valueChanged(ListSelectionEvent arg0) {

        //Se controla si se est?n realizando cambios todav?a en la lista.
        //Si no se controla esto, los eventos se lanzan varias veces.
        if (arg0.getValueIsAdjusting() == false) {
            //String TextoAMostrar = ((itfProperty) jlista.getSelectedValue()).getStringProperty("Descripcion");
            String TextoAMostrar = "clsPelicula{" +
                    "Libreria_Multimedia_idLibreria_Multimedia=" + ((itfProperty) jlista.getSelectedValue()).getIntegerProperty("Libreria_Multimedia_idLibreria_Multimedia") +
                    ", Titulo='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Titulo") + '\'' +
                    ", Titulo_original='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Titulo_original") + '\'' +
                    ", Anno_de_publicacion=" + ((itfProperty) jlista.getSelectedValue()).getIntegerProperty("Anno_de_publicacion") +
                    ", Duracion=" + ((itfProperty) jlista.getSelectedValue()).getIntegerProperty("Duracion") +
                    ", Calificacion=" + ((itfProperty) jlista.getSelectedValue()).getIntegerProperty("Calificacion") +
                    ", Calporedad=" + ((itfProperty) jlista.getSelectedValue()).getIntegerProperty("Calporedad") +
                    ", Tipo_DoA='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Tipo_DoA") + '\'' +
                    ", Precio=" + ((itfProperty) jlista.getSelectedValue()).getDoubleProperty("Precio") +
                    ", En_propiedad=" + ((itfProperty) jlista.getSelectedValue()).getBooleanProperty("En_propiedad") +
                    ", En_busqueda=" + ((itfProperty) jlista.getSelectedValue()).getBooleanProperty("En_busqueda") +
                    ", Formato='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Formato") + '\'' +
                    ", Saga='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Saga") + '\'' +
                    ", Orden=" + ((itfProperty) jlista.getSelectedValue()).getDoubleProperty("Orden") +
                    ", Sinopsis='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Sinopsis") + '\'' +
                    ", Enlace_a_trailer='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Enlace_a_trailer") + '\'' +
                    '}';
            System.out.println("Atributos: " + TextoAMostrar);
        }

    }

}
