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

public class frmInsertDirector extends JInternalFrame implements ActionListener {
    //Declaraciones
    //Necesitamos un JPanel que es donde se ponen todos los componentes, creo.
    JPanel JPContent;
    //Los TextAreas no se pueden modificar por el usuario, los TextFields, si. Existen tambien los JLabel.
    JLabel JLNombre;
    JTextField JTFNombre;
    JLabel JLApellido;
    JTextField JTFApellido;
    JButton JBAceptar;
    JButton JBCancelar;
    JButton JBFIXED;

    private final String TextoJLNombre = "<Inserte el nombre aquí>";
    private final String TextoJLApellido = "<Inserte el apellido aquí>";

    private clsGestorLN objGestorLN;
    //Código
    //Constructor
    public frmInsertDirector(clsGestorLN _objGestorLN) {
        //Tamaño y componentes
        JPContent = new JPanel();
        setBounds(50, 50, 500, 430);
        JLNombre = new JLabel("\nNombre:");
        JTFNombre = new JTextField(TextoJLNombre);
        JLApellido = new JLabel("\nApellido:");
        JTFApellido = new JTextField(TextoJLApellido);
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
        setTitle("Insertar Director");
        JPContent.setLayout(new BorderLayout());
        JPContent.add(JLNombre);
        JPContent.add(JTFNombre);
        JPContent.add(JLApellido);
        JPContent.add(JTFApellido);
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
        JLApellido.setBounds(25, 100, 450, 50);
        JTFApellido.setBounds(25, 150, 450, 50);
        JBAceptar.setBounds(25, 250, 200, 50);
        JBCancelar.setBounds(250, 250, 200, 50);
        JBFIXED.setVisible(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Aceptar":
                if ((!JTFNombre.getText().equals(TextoJLNombre)) && (!JTFApellido.getText().equals(TextoJLApellido)) && (!JTFNombre.getText().equals("")) && (!JTFApellido.getText().equals(""))) {
                    if(objGestorLN.crearDirector(JTFNombre.getText(), JTFApellido.getText()) != 0){
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
