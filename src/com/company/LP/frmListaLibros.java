package com.company.LP;

import com.company.Comun.itfPropertyV2;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.LinkedList;

public class frmListaLibros extends JInternalFrame implements ListSelectionListener {
        //Objeto visual
        private JList<itfPropertyV2> jlista;
        //Modelo de la vista
        protected ModeloListaV2 modelo;

        //Lista auxiliar de Objetos
        private LinkedList<itfPropertyV2> Objetos;


        /**
         * Creación de lista de  librerias.
         *
         * @see ModeloLista
         */
        public frmListaLibros() {
            setTitle("Lista de libros");

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
                String TextoAMostrar = "clsLibro{" +
                        "Libreria_Multimedia_idLibreria_Multimedia= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Libreria_Multimedia_idLibreria_Multimedia") +
                        ", ISBN= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("ISBN") +
                        ", Titulo= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Título") +
                        ", Titulo_original= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Título_original") +
                        ", Anno_de_publicacion= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Año") +
                        ", Tipo_DoA= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Tipo_DoA") +
                        ", Precio= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Precio") +
                        ", En_propiedad= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("En_propiedad") +
                        ", En_busqueda= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("En_busqueda") +
                        ", Formato= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Formato") +
                        ", Paginas= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Paginas") +
                        ", Resumen= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Resumen") +
                        ", Serie_SoN= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Serie_SoN") +
                        ", Nombre_serie= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Nombre_serie") +
                        ", Orden_serie= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Orden_serie") +
                        ", idGénero= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Género_Libro_idGénero_Libro") +
                        ", idAutor= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Autor_idAutor") +
                        ", idEditorial= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Editorial_idEditorial") +
                        '}';
                System.out.println("Atributos: " + TextoAMostrar);
            }

        }

    }
