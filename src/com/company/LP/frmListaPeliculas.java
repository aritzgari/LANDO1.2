package com.company.LP;

import com.company.Comun.itfPropertyV2;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.LinkedList;

/**
 * Ventana para mostrar la lista de peliculas de la base de datos.
 * <p>
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 * @see ModeloListaV2
 * @deprecated
 */

public class frmListaPeliculas extends JInternalFrame implements ListSelectionListener {
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
    public frmListaPeliculas() {
        setTitle("Lista de Peliculas");

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
            String TextoAMostrar = "clsPelicula{" +
                    "Libreria_Multimedia_idLibreria_Multimedia=" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Libreria_Multimedia_idLibreria_Multimedia") +
                    ", Titulo='" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Titulo") + '\'' +
                    ", Titulo_original='" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Titulo_original") + '\'' +
                    ", Anno_de_publicacion=" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Anno_de_publicacion") +
                    ", Duracion=" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Duracion") +
                    ", Calificacion=" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Calificacion") +
                    ", Calporedad=" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Calporedad") +
                    ", Tipo_DoA='" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Tipo_DoA") + '\'' +
                    ", Precio=" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Precio") +
                    ", En_propiedad=" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("En_propiedad") +
                    ", En_busqueda=" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("En_busqueda") +
                    ", Formato='" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Formato") + '\'' +
                    ", Saga='" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Saga") + '\'' +
                    ", Orden=" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Orden") +
                    ", Sinopsis='" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Sinopsis") + '\'' +
                    ", Enlace_a_trailer='" + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Enlace_a_trailer") + '\'' +
                    '}';
            System.out.println("Atributos: " + TextoAMostrar);
        }

    }

}
