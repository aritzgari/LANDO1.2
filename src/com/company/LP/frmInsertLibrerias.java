package com.company.LP;


import com.company.Comun.itfPropertyV2;
import com.company.LN.clsGestorLN;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 */

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
    private JDesktopPane desktop;
    private frmPrincipal ventanaPrincipal;

    //C?digo
    //Constructor
    public frmInsertLibrerias(clsGestorLN _objGestorLN, JDesktopPane _desktop, frmPrincipal _ventanaPrincipal) {
        //Tama?o y componentes
        JPContent = new JPanel();
        setBounds(50, 50, 500, 430);
        JLNombre = new JLabel("\nNombre:");
        JTFNombre = new JTextField(TextoJLNombre);
        JLDescripcion = new JLabel("\nDescripcion:");
        JTFDescripcion = new JTextField(TextoJLDescripcion);
        JBAceptar = new JButton("Aceptar");
        JBCancelar = new JButton("Cancelar");
        JBFIXED = new JButton("Bibidi Babidi Bu");
        objGestorLN = _objGestorLN;
        desktop = _desktop;
        ventanaPrincipal = _ventanaPrincipal;

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

        //Darle valores de acci?n a los botones
        JBAceptar.setActionCommand("Aceptar");
        JBCancelar.setActionCommand("Cancelar");
        JBAceptar.addActionListener(this);
        JBCancelar.addActionListener(this);
        JBAceptar.setBackground(verde);
        JBCancelar.setBackground(rojo);

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
                    if (objGestorLN.crearLibreria(JTFNombre.getText(), JTFDescripcion.getText()) != 0) {
                        //Ha funcionado el insert.
                        JOptionPane.showInternalMessageDialog(null, "  Insert realizado.");

                    } else {
                        //No ha funcionado el insert.
                        JOptionPane.showInternalMessageDialog(null, "Insert no realizado, revisar parámetros.");

                    }
                } else {
                    //ESTO HAY QUE PONERLO EN LA VENTANA O CON UNA EXCEPCION Y UNA VENTANA DE ERROR.
                    JOptionPane.showInternalMessageDialog(null, "Campos vacíos o sin editar.");
                }
                if (objGestorLN.getLibreriaDefinida() < 0) {
                    frmMenuLibrerias VentanaMenuLibrerias = new frmMenuLibrerias(objGestorLN, desktop, ventanaPrincipal);
                    ArrayList<itfPropertyV2> resultado = objGestorLN.consultarLibreriasEnBD();
                    for (itfPropertyV2 L : resultado
                    ) {
                        VentanaMenuLibrerias.setItem(L);
                    }
                    desktop.add(VentanaMenuLibrerias);
                    dispose();
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
