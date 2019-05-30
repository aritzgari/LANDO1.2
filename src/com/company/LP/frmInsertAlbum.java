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


public class frmInsertAlbum extends JInternalFrame implements ActionListener  {

    JPanel JPContent;
    JLabel JLNombre;
    JTextField JTFNombre;

    JLabel JLidCantante;
    SpinnerNumberModel ModeloidCantante;
    JSpinner JSidCantante;

    JButton JBAceptar;
    JButton JBCancelar;
    JButton JBFIXED;


    private final String TextoJLNombre = "<Inserte el nombre aquí>";

    private clsGestorLN objGestorLN;
    //Código
    //Constructor
    public frmInsertAlbum(clsGestorLN _objGestorLN) {
        //Tamaño y componentes
        JPContent = new JPanel();
        setBounds(50, 50, 500, 430);
        JLNombre = new JLabel("\nNombre:");
        JTFNombre = new JTextField(TextoJLNombre);
        JLidCantante = new JLabel("\nidCantante:");
        JSidCantante = new JSpinner();
        ModeloidCantante = new SpinnerNumberModel();
        ModeloidCantante.setStepSize(1);
        ModeloidCantante.setValue(1);
        JSidCantante.setModel(ModeloidCantante);

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
        setTitle("Insertar Album");
        JPContent.setLayout(new BorderLayout());
        JPContent.add(JLNombre);
        JPContent.add(JTFNombre);
        JPContent.add(JLidCantante);
        JPContent.add(JSidCantante);
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

        JLidCantante.setBounds(170, 100, 100, 50);
        JSidCantante.setBounds(170, 150, 100, 50);

        JBAceptar.setBounds(25, 250, 200, 50);
        JBCancelar.setBounds(250, 250, 200, 50);
        JBFIXED.setVisible(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Aceptar":
                if ((!JTFNombre.getText().equals(TextoJLNombre)) && (!JTFNombre.getText().equals(""))){
                    if(objGestorLN.crearAlbum(JTFNombre.getText(),(int) JSidCantante.getValue()) != 0){
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

