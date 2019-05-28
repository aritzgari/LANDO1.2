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


public class frmInsertPremiosPelicula extends JInternalFrame implements ActionListener {


    JPanel JPContent;
    JLabel JLNombre;
    JTextField JTFNombre;
    JLabel JLCategoria;
    JTextField JTFCategoria;
    JLabel JLAño;
    SpinnerNumberModel ModeloAño;
    JSpinner JSAño;
    JLabel JLTituloPelicula;
    JTextField JTFTitulopelicula;

    JButton JBAceptar;
    JButton JBCancelar;
    JButton JBFIXED;


    private final String TextoJLNombre = "<Inserte el nombre aquí>";
    private final String TextoJLCategoria = "<Inserte la categoria aquí>";
    private final String TextoJLTitulopelicula = "<Inserte el titulo de pelicula aquí>";

    private clsGestorLN objGestorLN;
    //Código
    //Constructor
    public frmInsertPremiosPelicula(clsGestorLN _objGestorLN) {
        //Tamaño y componentes
        JPContent = new JPanel();
        setBounds(50, 50, 500, 450);
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

        JLTituloPelicula = new JLabel("\nTitulo pelicula:");
        JTFTitulopelicula = new JTextField(TextoJLTitulopelicula);

        JBAceptar = new JButton("Aceptar");
        JBCancelar = new JButton("Cancelar");
        JBFIXED = new JButton("Bibidi Babidi Bu");
        objGestorLN = _objGestorLN;

        //Colores
        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155,255, 141);

        //Propiedades de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setVisible(true);

        //Agregar los componentes y conformar la ventana
        setTitle("Insertar Premios Pelicula");
        JPContent.setLayout(new BorderLayout());
        JPContent.add(JLNombre);
        JPContent.add(JTFNombre);
        JPContent.add(JLCategoria);
        JPContent.add(JTFCategoria);
        JPContent.add(JLAño);
        JPContent.add(JSAño);
        JPContent.add(JLTituloPelicula);
        JPContent.add(JTFTitulopelicula);
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
        JLAño.setBounds(300, 100, 100, 50);
        JSAño.setBounds(300, 150, 100, 50);
        JLTituloPelicula.setBounds(25, 200, 450, 50);
        JTFTitulopelicula.setBounds(25, 250, 450, 50);
        JBAceptar.setBounds(25, 350, 200, 50);
        JBCancelar.setBounds(250, 350, 200, 50);
        JBFIXED.setVisible(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Aceptar":
                if ((!JTFNombre.getText().equals(TextoJLNombre)) && (!JTFCategoria.getText().equals(TextoJLCategoria)) && (!JTFNombre.getText().equals("")) && (!JTFCategoria.getText().equals(""))) {
                    if(objGestorLN.crearPremiosPelicula(JTFNombre.getText(), JTFCategoria.getText(), (int) JSAño.getValue(), JLTituloPelicula.getText()) != 0){
                        //Ha funcionado el insert.
                        JOptionPane.showInternalMessageDialog(null,"  Insert realizado.");

                    }
                    else{
                        //No ha funcionado el insert.
                        JOptionPane.showInternalMessageDialog(null,"Insert no realizado, revisar parámetros.");

                    }
                } else {
                    //ESTO HAY QUE PONERLO EN LA VENTANA O CON UNA EXCEPCION Y UNA VENTANA DE ERROR.
                    JOptionPane.showInternalMessageDialog(null,"Campos vacíos o sin editar.");
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

    }
}
