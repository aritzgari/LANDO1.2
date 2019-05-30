package com.company.LP;

import com.company.LN.clsGestorLN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;


/**
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class frmInsertPremiosCancion extends JInternalFrame implements ActionListener {

    JPanel JPContent;
    JLabel JLNombre;
    JTextField JTFNombre;

    JLabel JLCategoria;
    JTextField JTFCategoria;

    JLabel JLAño;
    SpinnerNumberModel ModeloAño;
    JSpinner JSAño;

    JLabel JLidCantante;
    SpinnerNumberModel ModeloidCantante;
    JSpinner JSidCantante;

    JLabel JLidGenero;
    SpinnerNumberModel ModeloidGenero;
    JSpinner JSidGenero;

    JLabel JLidAlbum;
    SpinnerNumberModel ModeloidAlbum;
    JSpinner JSidAlbum;

    JLabel JLidAlbucante;
    SpinnerNumberModel ModeloidAlbucante;
    JSpinner JSidAlbucante;

    JLabel JLidLibrerias;
    SpinnerNumberModel ModeloidLibrerias;
    JSpinner JSidLibrerias;

    JButton JBAceptar;
    JButton JBCancelar;
    JButton JBFIXED;


    private final String TextoJLNombre = "<Inserte el nombre aquí>";
    private final String TextoJLCategoria = "<Inserte la categoria aquí>";
    private final String TextoJLLibros_ISBN = "<Inserte el titulo de pelicula aquí>";

    private clsGestorLN objGestorLN;

    //Código
    //Constructor
    public frmInsertPremiosCancion(clsGestorLN _objGestorLN) {
        //Tamaño y componentes
        JPContent = new JPanel();
        setBounds(50, 50, 500, 600);
        JLNombre = new JLabel("\nNombre:");
        JTFNombre = new JTextField(TextoJLNombre);
        JLCategoria = new JLabel("\nCategoria:");
        JTFCategoria = new JTextField(TextoJLCategoria);

        JLAño = new JLabel("\nAño:");
        JSAño = new JSpinner();
        ModeloAño = new SpinnerNumberModel();
        ModeloAño.setMinimum(1885);
        ModeloAño.setMaximum(2085);
        ModeloAño.setStepSize(1);
        ModeloAño.setValue(2019);
        JSAño.setModel(ModeloAño);

        JLidCantante = new JLabel("\nidCantante:");
        JSidCantante = new JSpinner();
        ModeloidCantante = new SpinnerNumberModel();
        ModeloidCantante.setStepSize(1);
        ModeloidCantante.setValue(1);
        JSidCantante.setModel(ModeloidCantante);

        JLidGenero = new JLabel("\nidGenero:");
        JSidGenero = new JSpinner();
        ModeloidGenero = new SpinnerNumberModel();
        ModeloidGenero.setStepSize(1);
        ModeloidGenero.setValue(1);
        JSidGenero.setModel(ModeloidGenero);

        JLidAlbum = new JLabel("\nidAlbum:");
        JSidAlbum = new JSpinner();
        ModeloidAlbum = new SpinnerNumberModel();
        ModeloidAlbum.setStepSize(1);
        ModeloidAlbum.setValue(1);
        JSidAlbum.setModel(ModeloidAlbum);

        JLidAlbucante = new JLabel("\nidAlbucante:");
        JSidAlbucante = new JSpinner();
        ModeloidAlbucante = new SpinnerNumberModel();
        ModeloidAlbucante.setStepSize(1);
        ModeloidAlbucante.setValue(1);
        JSidAlbucante.setModel(ModeloidAlbucante);

        JLidLibrerias = new JLabel("\nidLibrerias:");
        JSidLibrerias = new JSpinner();
        ModeloidLibrerias = new SpinnerNumberModel();
        ModeloidLibrerias.setStepSize(1);
        ModeloidLibrerias.setValue(1);
        JSidLibrerias.setModel(ModeloidLibrerias);


        JBAceptar = new JButton("Aceptar");
        JBCancelar = new JButton("Cancelar");
        JBFIXED = new JButton("Bibidi Babidi Bu");
        objGestorLN = _objGestorLN;

        //Colores
        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155, 255, 141);

        //Propiedades de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setVisible(true);

        //Agregar los componentes y conformar la ventana
        setTitle("Insertar Premios Cancion");
        JPContent.setLayout(new BorderLayout());
        JPContent.add(JLNombre);
        JPContent.add(JTFNombre);
        JPContent.add(JLCategoria);
        JPContent.add(JTFCategoria);
        JPContent.add(JLAño);
        JPContent.add(JSAño);
        JPContent.add(JLidCantante);
        JPContent.add(JSidCantante);
        JPContent.add(JLidGenero);
        JPContent.add(JSidGenero);
        JPContent.add(JLidAlbum);
        JPContent.add(JSidAlbum);
        JPContent.add(JLidAlbucante);
        JPContent.add(JSidAlbucante);
        JPContent.add(JLidLibrerias);
        JPContent.add(JSidLibrerias);

        JPContent.add(JBAceptar);
        JPContent.add(JBCancelar);

        JPContent.add(JBFIXED);

        this.setContentPane(JPContent);

        //Darle valores de acción a los botones
        JBAceptar.setActionCommand("Aceptar");
        JBCancelar.setActionCommand("Cancelar");
        JBAceptar.addActionListener(this);
        JBCancelar.addActionListener(this);
        JBAceptar.setBackground(verde);
        JBCancelar.setBackground(rojo);

        //Ubicar las cosas porque sino sale tudu amontonado:
        JLNombre.setBounds(25, 0, 450, 50);
        JTFNombre.setBounds(25, 50, 450, 50);
        JLCategoria.setBounds(25, 100, 250, 50);
        JTFCategoria.setBounds(25, 150, 250, 50);

        JLAño.setBounds(25, 200, 100, 50);
        JSAño.setBounds(25, 250, 100, 50);

        JLidCantante.setBounds(300, 200, 100, 50);
        JSidCantante.setBounds(300, 250, 100, 50);

        JLidGenero.setBounds(175, 200, 100, 50);
        JSidGenero.setBounds(175, 250, 100, 50);

        JLidAlbum.setBounds(350, 300, 100, 50);
        JSidAlbum.setBounds(350, 350, 100, 50);

        JLidAlbucante.setBounds(175, 300, 100, 50);
        JSidAlbucante.setBounds(175, 350, 100, 50);

        JLidLibrerias.setBounds(25, 300, 100, 50);
        JSidLibrerias.setBounds(25, 350, 100, 50);


        JBAceptar.setBounds(100, 450, 100, 50);
        JBCancelar.setBounds(300, 450, 100, 50);

        JBFIXED.setVisible(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Aceptar":
                if ((!JTFNombre.getText().equals(TextoJLNombre)) && (!JTFCategoria.getText().equals(TextoJLCategoria)  && (!JTFNombre.getText().equals(""))  && (!JTFCategoria.getText().equals("")))){
                    if (objGestorLN.crearPremiosCancion(JTFNombre.getText(), JTFCategoria.getText(), (int) JSAño.getValue(), (int) JSidCantante.getValue(), (int) JSidGenero.getValue(), (int) JSidAlbum.getValue(), (int) JSidAlbucante.getValue(), (int) JSidLibrerias.getValue()) != 0) {
                        //Ha funcionado el insert.
                        JOptionPane.showInternalMessageDialog(null, "  Insert realizado.");

                    } else {
                        //No ha funcionado el insert.
                        JOptionPane.showInternalMessageDialog(null, "Insert no realizado, revisar parámetros.");

                    }
                } else {
                    JOptionPane.showInternalMessageDialog(null, "Campos vacíos o sin editar.");
                }
                break;
            case "Cancelar":
                dispose();
                /*JTFNombre.setText("");
                JTFDescripcion.setText("");*/
                break;
            default:
                //Igual una excepcion de Runtime?
                System.out.println("Acción no definida.");
                break;
        }

    }}
