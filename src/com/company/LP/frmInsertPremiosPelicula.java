package com.company.LP;

import com.company.LN.clsGestorLN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

/**
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */


public class frmInsertPremiosPelicula extends JInternalFrame implements ActionListener {


    JPanel JPContent;
    JLabel JLNombre;
    JTextField JTFNombre;
    JLabel JLCategoria;
    JTextField JTFCategoria;
    JLabel JLA�o;
    SpinnerNumberModel ModeloA�o;
    JSpinner JSA�o;
    JLabel JLTituloPelicula;
    JTextField JTFTitulopelicula;

    JButton JBAceptar;
    JButton JBCancelar;
    JButton JBFIXED;


    private final String TextoJLNombre = "<Inserte el nombre aqu�>";
    private final String TextoJLCategoria = "<Inserte la categoria aqu�>";
    private final String TextoJLTitulopelicula = "<Inserte el titulo de pelicula aqu�>";

    private clsGestorLN objGestorLN;
    //C�digo
    //Constructor
    public frmInsertPremiosPelicula(clsGestorLN _objGestorLN) {
        //Tama�o y componentes
        JPContent = new JPanel();
        setBounds(50, 50, 500, 450);
        JLNombre = new JLabel("\nNombre:");
        JTFNombre = new JTextField(TextoJLNombre);
        JLCategoria = new JLabel("\nCategoria:");
        JTFCategoria = new JTextField(TextoJLCategoria);
        JLA�o = new JLabel("\nA�o:");
        JSA�o = new JSpinner();
        ModeloA�o = new SpinnerNumberModel();
        ModeloA�o.setMinimum(1885);
        ModeloA�o.setMaximum(2085);
        ModeloA�o.setStepSize(1);
        ModeloA�o.setValue(2019);
        JSA�o.setModel(ModeloA�o);

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
        JPContent.add(JLA�o);
        JPContent.add(JSA�o);
        JPContent.add(JLTituloPelicula);
        JPContent.add(JTFTitulopelicula);
        JPContent.add(JBAceptar);
        JPContent.add(JBCancelar);

        JPContent.add(JBFIXED);

        this.setContentPane(JPContent);

        //Darle valores de acci�n a los botones
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
        JLA�o.setBounds(300, 100, 100, 50);
        JSA�o.setBounds(300, 150, 100, 50);
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
                    if(objGestorLN.crearPremiosPelicula(JTFNombre.getText(), JTFCategoria.getText(), (int) JSA�o.getValue(), JLTituloPelicula.getText()) != 0){
                        //Ha funcionado el insert.
                        JOptionPane.showInternalMessageDialog(null,"  Insert realizado.");

                    }
                    else{
                        //No ha funcionado el insert.
                        JOptionPane.showInternalMessageDialog(null,"Insert no realizado, revisar par�metros.");

                    }
                } else {
                    //ESTO HAY QUE PONERLO EN LA VENTANA O CON UNA EXCEPCION Y UNA VENTANA DE ERROR.
                    JOptionPane.showInternalMessageDialog(null,"Campos vac�os o sin editar.");
                }
                break;
            case "Cancelar":
                dispose();
                /*JTFNombre.setText("");
                JTFDescripcion.setText("");*/
                break;
            default:
                //Igual una excepcion de Runtime?
                System.out.println("Acci�n no definida.");
                break;
        }

    }
}
