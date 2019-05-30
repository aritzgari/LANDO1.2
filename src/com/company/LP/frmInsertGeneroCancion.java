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


public class frmInsertGeneroCancion extends JInternalFrame implements ActionListener {

    //Declaraciones
    //Necesitamos un JPanel que es donde se ponen todos los componentes, creo.
    JPanel JPContent;
    //Los TextAreas no se pueden modificar por el usuario, los TextFields, si. Existen tambien los JLabel.
    //Parejas de JLabel y JTextField
    JLabel JLNombre;
    JTextField JTFNombre;

    JButton JBAceptar;
    JButton JBCancelar;
    JButton JBFIXED;


    private final String TextoJTFNombre = "<Inserte el nombre aquí>";


    private clsGestorLN objGestorLN;

    //Código
    //Constructor
    public frmInsertGeneroCancion(clsGestorLN _objGestorLN) {
        //Tamaño y componentes
        JPContent = new JPanel();
        setBounds(0, 0, 500, 300);

        JLNombre = new JLabel("\nNombre:");
        JTFNombre = new JTextField(TextoJTFNombre);

        JBAceptar = new JButton("Aceptar");
        JBCancelar = new JButton("Cancelar");
        JBFIXED = new JButton("Bibidi Babidi Bu");
        objGestorLN = _objGestorLN;

        //Colores
        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155, 255, 141);

        //Propiedades de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setVisible(true);

        //Agregar los componentes y conformar la ventana
        setTitle("Insertar Genero Cancion");
        JPContent.setLayout(new BorderLayout());
        JPContent.add(JLNombre);
        JPContent.add(JTFNombre);

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

        //Darle valores a los textos que los requieran
        //JLMensaje.setHorizontalAlignment(SwingConstants.CENTER);

        //Ubicar las cosas porque sino sale tudu amontonado:
        JLNombre.setBounds(25, 0, 450, 50);
        JTFNombre.setBounds(25, 50, 450, 50);
        JBAceptar.setBounds(25, 150, 200, 50);
        JBCancelar.setBounds(250, 150, 200, 50);
        JBFIXED.setVisible(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Aceptar":
                if ((!JTFNombre.getText().equals(TextoJTFNombre))
                        && (!JTFNombre.getText().equals(""))
                ) {

                    if (objGestorLN.crearGeneroCancion(JTFNombre.getText()) != 0) {
                        JOptionPane.showInternalMessageDialog(null, " Insert realizado.");

                    } else {

                        JOptionPane.showInternalMessageDialog(null, "Insert no realizado, revisar parámetros.");

                    }
                } else {

                    JOptionPane.showInternalMessageDialog(null, "Campos vacíos o sin editar.");
                }
                break;
            case "Cancelar":
                dispose();
                break;
            default:
                System.out.println("Acción no definida.");
                break;
        } }}
