package com.company.LP;
import com.company.LN.clsGestorLN;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class frmInsertGeneroLibro extends JInternalFrame implements ActionListener {
    //Declaraciones
    //Necesitamos un JPanel que es donde se ponen todos los componentes, creo.
    JPanel JPContent;
    //Los TextAreas no se pueden modificar por el usuario, los TextFields, si. Existen tambien los JLabel.
    JLabel JLNombre;
    JLabel JLMensaje;
    JTextField JTFNombre;
    JButton JBAceptar;
    JButton JBCancelar;
    JButton JBFIXED;

    private final String TextoJLNombre = "<Inserte el nombre aquí>";

    private clsGestorLN objGestorLN;
    //Código


    public frmInsertGeneroLibro(clsGestorLN _objGestorLN) {
        //Tamaño y componentes
        JPContent = new JPanel();
        setBounds(50, 50, 500, 400);
        JLNombre = new JLabel("\nNombre:");
        JTFNombre = new JTextField(TextoJLNombre);
        JBAceptar = new JButton("Aceptar");
        JBCancelar = new JButton("Cancelar");
        JLMensaje = new JLabel("\n");
        JBFIXED = new JButton("Bibidi Babidi Bu");
        objGestorLN = _objGestorLN;


        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155,255, 141);



        //Propiedades de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setVisible(true);

        //Agregar los componentes y conformar la ventana
        setTitle("Insertar género de libros");
        JPContent.setLayout(new BorderLayout());
        JPContent.add(JLNombre);
        JPContent.add(JTFNombre);
        JPContent.add(JBAceptar);
        JPContent.add(JBCancelar);
        JPContent.add(JLMensaje);


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
        JLNombre.setBounds(25, 50, 450, 50);
        JTFNombre.setBounds(25, 100, 450, 100);
        JLMensaje.setBounds(25,10,450,50);
        JBAceptar.setBounds(25, 250, 200, 50);
        JBCancelar.setBounds(250, 250, 200, 50);
        JBFIXED.setVisible(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Aceptar":
                if ((!JTFNombre.getText().equals(TextoJLNombre)) && (!JTFNombre.getText().equals(""))) {
                    if(objGestorLN.crearGeneroLibro(JTFNombre.getText()) != 0){
                        //Ha funcionado el insert.
                        JLMensaje.setText("Insert realizado.");
                        JLMensaje.setVisible(true);

                    }
                    else{
                        //No ha funcionado el insert.
                        JLMensaje.setText("Insert no realizado, revisar parámetros.");
                        JLMensaje.setVisible(true);

                    }
                } else {
                    //ESTO HAY QUE PONERLO EN LA VENTANA O CON UNA EXCEPCION Y UNA VENTANA DE ERROR.
                    JLMensaje.setText("Campos vacíos o sin editar.");
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
                System.out.println("Acción no definida.");
                break;
        }

    }
}
