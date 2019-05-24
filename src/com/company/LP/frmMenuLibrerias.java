package com.company.LP;

import com.company.Comun.itfPropertyV2;

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

    //Botones
    private JButton JBAceptar;
    private JButton JBCancelar;
    private JButton JBFIXED;

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
        setBounds(0, 0, 450, 500);
        setTitle("Menu de Librerías");


        //News y Valores de inicialización
        JPContent = new JPanel();
        JPLista = new JPanel();
        //News de los componentes de la lista
        Objetos = new LinkedList<itfPropertyV2>();
        modelo = new ModeloListaV2(Objetos);
        JLista = new JList<itfPropertyV2>(modelo);
        JLista.addListSelectionListener(this);
        scroll = new JScrollPane(JLista);
        JPContent.add(scroll, BorderLayout.CENTER);
        scroll.setViewportView(JLista);

        //News de Botones
        JBAceptar = new JButton("Aceptar");
        JBCancelar = new JButton("Cancelar");
        JBFIXED = new JButton("Bibidi Babidi Bu");


        //Añadimos las cosas a sus continentes
        JPLista.add(JLista);
        JPContent.add(JPLista);
        JPContent.add(JBAceptar);
        JPContent.add(JBCancelar);
        JPContent.add(JBFIXED);

        this.setContentPane(JPContent);

        //Colores
        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155, 255, 141);

        //Darle valores de acción a los botones
        JBAceptar.setActionCommand("Aceptar");
        JBCancelar.setActionCommand("Cancelar");
        JBAceptar.addActionListener(this);
        JBCancelar.addActionListener(this);
        JBAceptar.setBackground(verde);
        JBCancelar.setBackground(rojo);

        //Ubicar las cosas porque sino sale tudu amontonado:
        JPLista.setBounds(0, 0, 200, 100);
        JPLista.setPreferredSize(new Dimension(400, 400));
        //JLista.setBounds(0, 0, 200, 100);
        JBAceptar.setBounds(25, 175, 100, 60);
        JBCancelar.setBounds(150, 175, 100, 60);
        JBFIXED.setVisible(false);

    }

    public void setItem(itfPropertyV2 Objeto) {
        modelo.addElement(Objeto);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
