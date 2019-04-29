package com.company.LP;

import com.company.LN.clsGestorLN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmInsertLibrerias extends JInternalFrame implements ActionListener {
    //Declaraciones
    //Necesitamos un JPanel que es donde se ponen todos los componentes, creo.
    JPanel JPContent;
    //Los TextAreas no se pueden modificar por el usuario, los TextFields, si. Existen tambien los JLabel.
    JLabel JLNombre;
    JTextField JTFNombre;
    JLabel JLDescripcion;
    JTextField JTFDescripcion;
    JButton JBAceptar;
    JButton JBCancelar;
    JButton JBFIXED;

    private final String TextoJLNombre = "<Inserte el nombre aquí>";
    private final String TextoJLDescripcion = "<Inserte la descripción aquí>";

    private clsGestorLN objGestorLN;
    //Código


    //Constructor (?)
    public frmInsertLibrerias(clsGestorLN _objGestorLN) {
        //Tamaño y componentes
        JPContent = new JPanel();
        setBounds(50, 50, 500, 400);
        JLNombre = new JLabel("\nNombre:");
        JTFNombre = new JTextField(TextoJLNombre);
        JLDescripcion = new JLabel("\nDescripcion:");
        JTFDescripcion = new JTextField(TextoJLDescripcion);
        JBAceptar = new JButton("Aceptar");
        JBCancelar = new JButton("Cancelar");
        JBFIXED = new JButton("Bibidi Babidi Bu");
        objGestorLN = _objGestorLN;


        //Propiedades de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setVisible(true);

        //Agregar los componentes y conformar la ventana
        setTitle("Insertar Librerías Multimedia");
        JPContent.setLayout(new BorderLayout());
        JPContent.add(JLNombre);
        JPContent.add(JTFNombre);
        JPContent.add(JLDescripcion);
        JPContent.add(JTFDescripcion);
        JPContent.add(JBAceptar);
        JPContent.add(JBCancelar);

        JPContent.add(JBFIXED);

        this.setContentPane(JPContent);

        //Darle valores de acción a los botones
        JBAceptar.setActionCommand("Aceptar");
        JBCancelar.setActionCommand("Cancelar");
        JBAceptar.addActionListener(this);
        JBCancelar.addActionListener(this);

        //Ubicar las cosas porque sino sale tudu amontonado:
        JLNombre.setBounds(25, 0, 450, 50);
        JTFNombre.setBounds(25, 50, 450, 50);
        JLDescripcion.setBounds(25, 100, 450, 50);
        JTFDescripcion.setBounds(25, 150, 450, 50);
        JBAceptar.setBounds(25, 250, 200, 50);
        JBCancelar.setBounds(250, 250, 200, 50);
        JBFIXED.setVisible(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Aceptar":
                if ((!JTFNombre.getText().equals(TextoJLNombre)) && (!JTFDescripcion.getText().equals(TextoJLDescripcion)) && (!JTFNombre.getText().equals("")) && (!JTFDescripcion.getText().equals(""))) {
                    objGestorLN.crearLibreria(JTFNombre.getText(), JTFDescripcion.getText());
                } else {
                    //ESTO HAY QUE PONERLO EN LA VENTANA O CON UNA EXCEPCION Y UNA VENTANA DE ERROR.
                    System.out.println("Campos vacíos o sin editar");
                }
                break;
            case "Cancelar":
                System.out.println("Cancelando");
                break;
            default:
                //Igual una excepcion de Runtime?
                System.out.println("Acción no definida.");
                break;
        }

    }
}
