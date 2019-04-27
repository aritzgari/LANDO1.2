package com.company.LP;

import com.company.LN.itfProperty;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.LinkedList;

public class frmListaLibros extends JInternalFrame implements ListSelectionListener {
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
        public frmListaLibros() {
            setTitle("Lista de libros");

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
                String TextoAMostrar = "clsLibro{" +
                        "Libreria_Multimedia_idLibreria_Multimedia=" + ((itfProperty) jlista.getSelectedValue()).getIntegerProperty("Libreria_Multimedia_idLibreria_Multimedia") +
                        ", ISBN='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("ISBN") + '\'' +
                        ", Titulo='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Titulo") + '\'' +
                        ", Titulo_original='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Titulo_original") + '\'' +
                        ", Anno_de_publicacion=" + ((itfProperty) jlista.getSelectedValue()).getIntegerProperty("Anno_de_publicacion") +
                        ", Tipo_DoA='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Tipo_DoA") + '\'' +
                        ", Precio=" + ((itfProperty) jlista.getSelectedValue()).getDoubleProperty("Precio") +
                        ", En_propiedad=" + ((itfProperty) jlista.getSelectedValue()).getBooleanProperty("En_propiedad") +
                        ", En_busqueda=" + ((itfProperty) jlista.getSelectedValue()).getBooleanProperty("En_busqueda") +
                        ", Formato='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Formato") + '\'' +
                        ", Paginas=" + ((itfProperty) jlista.getSelectedValue()).getIntegerProperty("Paginas") +
                        ", Resumen='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Resumen") + '\'' +
                        ", Serie_SoN=" + ((itfProperty) jlista.getSelectedValue()).getBooleanProperty("Serie_SoN") +
                        ", Nombre_serie='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Nombre_serie") +
                        ", Orden_serie='" + ((itfProperty) jlista.getSelectedValue()).getStringProperty("Orden_serie") + '\'' +
                        '}';
                System.out.println("Atributos: " + TextoAMostrar);
            }

        }

    }
