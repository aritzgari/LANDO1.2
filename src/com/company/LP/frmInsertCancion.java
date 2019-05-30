package com.company.LP;
import com.company.LN.clsGestorLN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Ruben Domínguez
 * Aritz Garitano
 */
public class frmInsertCancion extends JInternalFrame implements ActionListener{



    //Declaraciones
    //Necesitamos un JPanel que es donde se ponen todos los componentes, creo.
    JPanel JPContent;
    //Los TextAreas no se pueden modificar por el usuario, los TextFields, si. Existen tambien los JLabel.
    //Parejas de JLabel y JTextField
    JLabel JLTitulo;
    JTextField JTFTitulo;

    JLabel JLTitulo_original;
    JTextField JTFTitulo_original;

    JLabel JLAño;
    SpinnerNumberModel ModeloAño;
    JSpinner JSAño;

    JLabel JLTipo_DoA;
    JComboBox JCBTipo_DoA;

    JLabel JLPrecio;
    SpinnerNumberModel ModeloPrecio;
    JSpinner JSPrecio;

    JLabel JLEn_propiedad;
    JCheckBox JCBEn_propiedad;

    JLabel JLEn_busqueda;
    JCheckBox JCBEn_busqueda;

    JLabel JLFormato;
    JTextField JTFFormato;

    JLabel JLEnlace_a_YT;
    JTextField JTFEnlace_a_YT;

    JLabel JLidGenero;
    SpinnerNumberModel ModeloidGenero;
    JSpinner JSidGenero;

    JLabel JLidAlbum;
    SpinnerNumberModel ModeloidAlbum;
    JSpinner JSidAlbum;

    JLabel JLidCantante;
    SpinnerNumberModel ModeloidCantante;
    JSpinner JSidCantante;


    //JLabel JLMensaje;

    //Botones
    JButton JBAceptar;
    JButton JBCancelar;
    JButton JBFIXED;


    private final String TextoJTFTitulo = "<Inserte el Título aquí>";
    private final String TextoJTFTitulo_original = "<Inserte el Título original aquí>";
    private final String TextoJTFFormato = "<Inserte el Formato aquí. Ej. .mkv, Vinilo, VHS...>";
    private final String TextoJTFEnlace_a_trailer = "<Inserte el trailer aquí>";

    private clsGestorLN objGestorLN;

    //C?digo
    //Constructor
    public frmInsertCancion(clsGestorLN _objGestorLN) {
        //Tama?o y componentes
        JPContent = new JPanel();
        setBounds(0, 0, 1000, 475);
        //setLayout(null);
        //setPreferredSize(new Dimension(400, 400));

        JLTitulo = new JLabel("\nTítulo:");
        JTFTitulo = new JTextField(TextoJTFTitulo);

        JLTitulo_original = new JLabel("\nTítulo Original:");
        JTFTitulo_original = new JTextField(TextoJTFTitulo_original);

        JLAño = new JLabel("\nAño:");
        JSAño = new JSpinner();
        ModeloAño = new SpinnerNumberModel();
        ModeloAño.setMinimum(1885);
        ModeloAño.setMaximum(2085);
        ModeloAño.setStepSize(1);
        ModeloAño.setValue(2019);
        JSAño.setModel(ModeloAño);


        JLTipo_DoA = new JLabel("\nFormato digital o Formato físico:");
        JCBTipo_DoA = new JComboBox();
        JCBTipo_DoA.addItem("Digital");
        JCBTipo_DoA.addItem("Físico");

        JLPrecio = new JLabel("\nPrecio (Euros):");
        JSPrecio = new JSpinner();
        ModeloPrecio = new SpinnerNumberModel();
        ModeloPrecio.setMinimum(0.00);
        ModeloPrecio.setStepSize(0.1);
        ModeloPrecio.setValue(9.99);
        JSPrecio.setModel(ModeloPrecio);

        JLEn_propiedad = new JLabel("\nLo tengo:");
        JCBEn_propiedad = new JCheckBox("Sí");

        JLEn_busqueda = new JLabel("\nLo quiero:");
        JCBEn_busqueda = new JCheckBox("Sí");


        JLFormato = new JLabel("\nFormato:");
        JTFFormato = new JTextField(TextoJTFFormato);

        JLEnlace_a_YT= new JLabel("\nEnlace a trailer:");
        JTFEnlace_a_YT = new JTextField(TextoJTFEnlace_a_trailer);

        JLidGenero = new JLabel("\nidGenero:");
        JSidGenero = new JSpinner();
        ModeloidGenero = new SpinnerNumberModel();
        ModeloidGenero.setMinimum(1);
        ModeloidGenero.setStepSize(1);
        ModeloidGenero.setValue(1);
        JSidGenero.setModel(ModeloidGenero);

        JLidAlbum = new JLabel("\nidAlbum :");
        JSidAlbum = new JSpinner();
        ModeloidAlbum  = new SpinnerNumberModel();
        ModeloidAlbum .setMinimum(1);
        ModeloidAlbum .setStepSize(1);
        ModeloidAlbum .setValue(1);
        JSidAlbum .setModel(ModeloidAlbum );

        JLidCantante = new JLabel("\nidCantante :");
        JSidCantante = new JSpinner();
        ModeloidCantante  = new SpinnerNumberModel();
        ModeloidCantante .setMinimum(1);
        ModeloidCantante .setStepSize(1);
        ModeloidCantante .setValue(1);
        JSidCantante .setModel(ModeloidCantante);

        JBAceptar = new JButton("Aceptar");
        JBCancelar = new JButton("Cancelar");
        JBFIXED = new JButton("Bibidi Babidi Bu");
        objGestorLN = _objGestorLN;


        //Colores
        Color rojo = new Color(255, 140, 135);
        Color verde = new Color(155,255, 141);

        //Propiedades de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setVisible(true);

        //Agregar los componentes y conformar la ventana
        setTitle("Insertar Cancion");
        JPContent.setLayout(new BorderLayout());
        JPContent.add(JLTitulo);
        JPContent.add(JTFTitulo);

        JPContent.add(JLTitulo_original);
        JPContent.add(JTFTitulo_original);

        JPContent.add(JLAño);
        JPContent.add(JSAño);

        JPContent.add(JLTipo_DoA);
        JPContent.add(JCBTipo_DoA);

        JPContent.add(JLPrecio);
        JPContent.add(JSPrecio);

        JPContent.add(JLEn_propiedad);
        JPContent.add(JCBEn_propiedad);

        JPContent.add(JLEn_busqueda);
        JPContent.add(JCBEn_busqueda);

        JPContent.add(JLFormato);
        JPContent.add(JTFFormato);

        JPContent.add(JLEnlace_a_YT);
        JPContent.add(JTFEnlace_a_YT);

        JPContent.add(JLidGenero);
        JPContent.add(JSidGenero);

        JPContent.add(JLidAlbum);
        JPContent.add(JSidAlbum);

        JPContent.add(JLidCantante);
        JPContent.add(JSidCantante);

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

        //Darle valores a los textos que los requieran
        //JLMensaje.setHorizontalAlignment(SwingConstants.CENTER);

        //Ubicar las cosas porque sino sale tudu amontonado:
        int altura = 30;
        JLTitulo.setBounds(25, 0, 450, altura);
        JTFTitulo.setBounds(25, 30, 450, altura);
        JLTitulo_original.setBounds(500, 0, 450, altura);
        JTFTitulo_original.setBounds(500, 30, 450, altura);

        JLAño.setBounds(25, 60, 150, altura);
        JSAño.setBounds(25, 90, 150, altura);

        JLidAlbum.setBounds(200, 60, 150, altura);
        JSidAlbum.setBounds(200, 90, 150, altura);

        JLidGenero.setBounds(400, 60, 150, altura);
        JSidGenero.setBounds(400, 90, 150, altura);

        JLidCantante.setBounds(600, 60, 150, altura);
        JSidCantante.setBounds(600, 90, 150, altura);

        JLTipo_DoA.setBounds(25, 120, 300, altura);
        JCBTipo_DoA.setBounds(25, 150, 300, altura);

        JLPrecio.setBounds(25, 180, 100, altura);
        JSPrecio.setBounds(25, 210, 100, altura);

        JLEn_propiedad.setBounds(200, 180, 75, altura);
        JCBEn_propiedad.setBounds(200, 210, 75, altura);

        JLEn_busqueda.setBounds(300, 180, 75, altura);
        JCBEn_busqueda.setBounds(300, 210, 75, altura);

        JLFormato.setBounds(375, 120, 300, altura);
        JTFFormato.setBounds(375, 150, 300, altura);

        JLEnlace_a_YT.setBounds(25, 250, 450, altura);
        JTFEnlace_a_YT.setBounds(25, 280, 450, altura);

        JBAceptar.setBounds(525, 360, 200, 2*altura);
        JBCancelar.setBounds(775, 360, 200, 2*altura);
        JBFIXED.setVisible(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Aceptar":
                if ((!JTFTitulo.getText().equals(TextoJTFTitulo))
                        && (!JTFTitulo_original.getText().equals(TextoJTFTitulo_original))
                        && (!JTFFormato.getText().equals(TextoJTFFormato))
                        && (!JTFEnlace_a_YT.getText().equals(TextoJTFEnlace_a_trailer))

                        && (!JTFTitulo.getText().equals(""))
                        && (!JTFTitulo_original.getText().equals(""))
                        && (!JTFFormato.getText().equals(""))
                        && (!JTFEnlace_a_YT.getText().equals(""))) {

                    if(objGestorLN.crearCancion(objGestorLN.getLibreriaDefinida(), JTFTitulo.getText(), JTFTitulo_original.getText(), (int) JSAño.getValue(), (int) JSidCantante.getValue(), (int) JSidGenero.getValue(), (int) JSidAlbum.getValue(), (String) JCBTipo_DoA.getSelectedItem(), (Double) JSPrecio.getValue(), JCBEn_propiedad.isSelected(), JCBEn_busqueda.isSelected(), JTFFormato.getText(), JTFEnlace_a_YT.getText())!= 0){
                        //Ha funcionado el insert.
                        //JLMensaje.setText("Insert realizado.");
                        //JLMensaje.setVisible(true);
                        JOptionPane.showInternalMessageDialog(null,"  Insert realizado.");

                    }
                    else{
                        //No ha funcionado el insert.
                        //JLMensaje.setText("Insert no realizado, revisar par?metros.");
                        //JLMensaje.setVisible(true);
                        JOptionPane.showInternalMessageDialog(null,"Insert no realizado, revisar parámetros.");

                    }
                } else {
                    //Se comenta porque ahora va con ventana
                    //JLMensaje.setText("Campos vac?os o sin editar");
                    //JLMensaje.setVisible(true);
                    JOptionPane.showInternalMessageDialog(null,"Campos vacíos o sin editar.");
                }
                break;
            case "Cancelar":
                dispose();
                /*JTFTitulo.setText("");
                JTFTitulo_original.setText("");
                JTFFormato.setText("");
                JTFSaga.setText("");
                JTFSinopsis.setText("");
                JTFEnlace_a_trailer.setText("");*/
                break;
            default:
                //Igual una excepcion de Runtime?
                System.out.println("Acción no definida.");
                break;
        }

    }
}
