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

public class frmInsertActor extends JInternalFrame implements ActionListener {
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
    JLabel JLMensaje;
    JButton JBFIXED;

    private final String TextoJLNombre = "<Inserte el nombre aqu�>";
    private final String TextoJLApellido = "<Inserte el apellido aqu�>";

    private clsGestorLN objGestorLN;
    //C�digo
    //Constructor
    public frmInsertActor(clsGestorLN _objGestorLN) {
        //Tama�o y componentes
        JPContent = new JPanel();
        setBounds(50, 50, 500, 430);
        JLNombre = new JLabel("\nNombre:");
        JTFNombre = new JTextField(TextoJLNombre);
        JLApellido = new JLabel("\nApellido:");
        JTFApellido = new JTextField(TextoJLApellido);
        JBAceptar = new JButton("Aceptar");
        JBCancelar = new JButton("Cancelar");
        JLMensaje = new JLabel("\n");
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
        setTitle("Insertar Actor");
        JPContent.setLayout(new BorderLayout());
        JPContent.add(JLNombre);
        JPContent.add(JTFNombre);
        JPContent.add(JLApellido);
        JPContent.add(JTFApellido);
        JPContent.add(JBAceptar);
        JPContent.add(JBCancelar);
        JPContent.add(JLMensaje);

        JPContent.add(JBFIXED);

        this.setContentPane(JPContent);

        //Darle valores de acci�n a los botones
        JBAceptar.setActionCommand("Aceptar");
        JBCancelar.setActionCommand("Cancelar");
        JBAceptar.addActionListener(this);
        JBCancelar.addActionListener(this);
        JBAceptar.setBackground(verde);
        JBCancelar.setBackground(rojo);
        //JBAceptar.setForeground(Color.white);
        //JBCancelar.setForeground(Color.white);

        //Darle valores a los textos que los requieran
        JLMensaje.setHorizontalAlignment(SwingConstants.CENTER);

        //Ubicar las cosas porque sino sale tudu amontonado:
        JLNombre.setBounds(25, 0, 450, 50);
        JTFNombre.setBounds(25, 50, 450, 50);
        JLApellido.setBounds(25, 100, 450, 50);
        JTFApellido.setBounds(25, 150, 450, 50);
        JBAceptar.setBounds(25, 250, 200, 50);
        JBCancelar.setBounds(250, 250, 200, 50);
        JLMensaje.setBounds(25,320,450,50);
        JLMensaje.setVisible(false);
        JBFIXED.setVisible(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Aceptar":
                if ((!JTFNombre.getText().equals(TextoJLNombre)) && (!JTFApellido.getText().equals(TextoJLApellido)) && (!JTFNombre.getText().equals("")) && (!JTFApellido.getText().equals(""))) {
                    if(objGestorLN.crearActor(JTFNombre.getText(), JTFApellido.getText()) != 0){
                        //Ha funcionado el insert.
                        JLMensaje.setText("Insert realizado.");
                        JLMensaje.setVisible(true);

                    }
                    else{
                        //No ha funcionado el insert.
                        JLMensaje.setText("Insert no realizado, revisar par�metros.");
                        JLMensaje.setVisible(true);

                    }
                } else {
                    //ESTO HAY QUE PONERLO EN LA VENTANA O CON UNA EXCEPCION Y UNA VENTANA DE ERROR.
                    JLMensaje.setText("Campos vac�os o sin editar.");
                    JLMensaje.setVisible(true);
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
