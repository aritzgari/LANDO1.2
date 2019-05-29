package com.company.LP;

import com.company.LN.clsGestorLN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmInsertLibros extends JInternalFrame implements ActionListener {
    //Declaraciones
    //Necesitamos un JPanel que es donde se ponen todos los componentes, creo.
    JPanel JPContent;
    //Los TextAreas no se pueden modificar por el usuario, los TextFields, si. Existen tambien los JLabel.
    //Parejas de JLabel y JTextField

    JLabel JLISBN;
    JTextField JTFISBN;

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

    JLabel JLPaginas;
    SpinnerNumberModel ModeloPaginas;
    JSpinner JSPaginas;

    JLabel JLidGenero;
    SpinnerNumberModel ModeloidGenero;
    JSpinner JSidGenero;

    JLabel JLidAutor;
    SpinnerNumberModel ModeloidAutor;
    JSpinner JSidAutor;

    JLabel JLidEditorial;
    SpinnerNumberModel ModeloidEditorial;
    JSpinner JSidEditorial;

    JLabel JLResumen;
    JTextField JTFResumen;

    JLabel JLSerie_SoN;
    JCheckBox JCBSerie_SoN;

    JLabel JLNombre_serie;
    JTextField JTFNombre_serie;

    JLabel JLOrden_serie;
    SpinnerNumberModel ModeloOrden_serie;
    JSpinner JSOrden_serie;


    //Botones
    JButton JBAceptar;
    JButton JBCancelar;
    JButton JBFIXED;


    private final String TextoJTFISBN = "<Inserte el ISBN aqui>";
    private final String TextoJTFTitulo = "<Inserte el Titulo aqui>";
    private final String TextoJTFTitulo_original = "<Inserte el Titulo original aqui>";
    private final String TextoJTFFormato = "<Inserte el Formato aqui. Ej. .mkv, Vinilo, VHS...>";
    private final String TextoJTFResumen = "<Inserte el resumen aqui>";
    private final String TextoJTFNombre_serie = "<Inserte el nombre de la serie aqui>";


    private clsGestorLN objGestorLN;

    //C?digo
    //Constructor (?)
    public frmInsertLibros(clsGestorLN _objGestorLN) {
        //Tamaño y componentes
        JPContent = new JPanel();
        setBounds(0, 0, 1000, 475);

        JLISBN = new JLabel("\nISBN:");
        JTFISBN = new JTextField(TextoJTFISBN);

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

        JLPaginas = new JLabel("\nPáginas:");
        JSPaginas = new JSpinner();
        ModeloPaginas = new SpinnerNumberModel();
        ModeloPaginas.setMinimum(0);
        ModeloPaginas.setStepSize(1);
        ModeloPaginas.setValue(90);
        JSPaginas.setModel(ModeloPaginas);

        JLidGenero = new JLabel("\nidGénero:");
        JSidGenero = new JSpinner();
        ModeloidGenero = new SpinnerNumberModel();
        ModeloidGenero.setMinimum(1);
        ModeloidGenero.setStepSize(1);
        ModeloidGenero.setValue(1);
        JSidGenero.setModel(ModeloidGenero);

        JLidAutor = new JLabel("\nidAutor:");
        JSidAutor = new JSpinner();
        ModeloidAutor = new SpinnerNumberModel();
        ModeloidAutor.setMinimum(1);
        ModeloidAutor.setStepSize(1);
        ModeloidAutor.setValue(1);
        JSidAutor.setModel(ModeloidAutor);

        JLidEditorial = new JLabel("\nidEditorial:");
        JSidEditorial = new JSpinner();
        ModeloidEditorial = new SpinnerNumberModel();
        ModeloidEditorial.setMinimum(1);
        ModeloidEditorial.setStepSize(1);
        ModeloidEditorial.setValue(1);
        JSidEditorial.setModel(ModeloidEditorial);

        JLTipo_DoA = new JLabel("\nFormato digital o Formato físico:");
        JCBTipo_DoA = new JComboBox();
        JCBTipo_DoA.addItem("Digital");
        JCBTipo_DoA.addItem("Fisico");

        JLPrecio = new JLabel("\nPrecio (Euros):");
        JSPrecio = new JSpinner();
        ModeloPrecio = new SpinnerNumberModel();
        ModeloPrecio.setMinimum(0.00);
        ModeloPrecio.setStepSize(0.1);
        ModeloPrecio.setValue(9.99);
        JSPrecio.setModel(ModeloPrecio);

        JLEn_propiedad = new JLabel("\nLo tengo:");
        JCBEn_propiedad = new JCheckBox("Sí");

        JLSerie_SoN = new JLabel("\nParte de una serie:");
        JCBSerie_SoN = new JCheckBox("Sí");

        JLEn_busqueda = new JLabel("\nLo quiero:");
        JCBEn_busqueda = new JCheckBox("Sí");

        JLResumen = new JLabel("\nResumen:");
        JTFResumen = new JTextField(TextoJTFResumen);

        JLFormato = new JLabel("\nFormato:");
        JTFFormato = new JTextField(TextoJTFFormato);

        JLNombre_serie = new JLabel("\nNombre de la serie:");
        JTFNombre_serie = new JTextField(TextoJTFNombre_serie);

        JLOrden_serie = new JLabel("\nOrden dentro de la serie:");
        JSOrden_serie = new JSpinner();
        ModeloOrden_serie = new SpinnerNumberModel();
        ModeloOrden_serie.setMinimum(0.00);
        ModeloOrden_serie.setStepSize(0.1);
        ModeloOrden_serie.setValue(1.00);
        JSOrden_serie.setModel(ModeloOrden_serie);


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
        setTitle("Insertar Libros");
        JPContent.setLayout(new BorderLayout());

        JPContent.add(JLISBN);
        JPContent.add(JTFISBN);

        JPContent.add(JLTitulo);
        JPContent.add(JTFTitulo);

        JPContent.add(JLTitulo_original);
        JPContent.add(JTFTitulo_original);

        JPContent.add(JLAño);
        JPContent.add(JSAño);

        JPContent.add(JLPaginas);
        JPContent.add(JSPaginas);

        JPContent.add(JLidGenero);
        JPContent.add(JSidGenero);

        JPContent.add(JLidAutor);
        JPContent.add(JSidAutor);

        JPContent.add(JLidEditorial);
        JPContent.add(JSidEditorial);

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

        JPContent.add(JLSerie_SoN);
        JPContent.add(JCBSerie_SoN);

        JPContent.add(JLNombre_serie);
        JPContent.add(JTFNombre_serie);

        JPContent.add(JLOrden_serie);
        JPContent.add(JSOrden_serie);

        JPContent.add(JLResumen);
        JPContent.add(JTFResumen);


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
        int altura = 30;
        JLISBN.setBounds(25, 0, 450, altura);
        JTFISBN.setBounds(25, 30, 450, altura);

        JLTitulo.setBounds(500, 0, 450, altura);
        JTFTitulo.setBounds(500, 30, 450, altura);

        JLTitulo_original.setBounds(500, 60, 450, altura);
        JTFTitulo_original.setBounds(500, 90, 450, altura);

        JLAño.setBounds(25, 60, 100, altura);
        JSAño.setBounds(25, 90, 100, altura);

        JLPaginas.setBounds(250, 60, 100, altura);
        JSPaginas.setBounds(250, 90, 100, altura);

        JLTipo_DoA.setBounds(25, 120, 300, altura);
        JCBTipo_DoA.setBounds(25, 150, 300, altura);

        JLPrecio.setBounds(25, 180, 100, altura);
        JSPrecio.setBounds(25, 210, 100, altura);

        JLSerie_SoN.setBounds(25, 240, 150, altura);
        JCBSerie_SoN.setBounds(25, 270, 150, altura);

        JLOrden_serie.setBounds(175, 240, 300, altura);
        JSOrden_serie.setBounds(175, 270, 300, altura);

        JLidGenero.setBounds(500, 240, 100, altura);
        JSidGenero.setBounds(500, 270, 100, altura);

        JLidAutor.setBounds(650, 240, 100, altura);
        JSidAutor.setBounds(650, 270, 100, altura);

        JLidEditorial.setBounds(800, 240, 100, altura);
        JSidEditorial.setBounds(800, 270, 100, altura);

        JLNombre_serie.setBounds(25, 300, 300, altura);
        JTFNombre_serie.setBounds(25, 330, 300, altura);

        JLEn_propiedad.setBounds(200, 180, 75, altura);
        JCBEn_propiedad.setBounds(200, 210, 75, altura);


        JLEn_busqueda.setBounds(300, 180, 75, altura);
        JCBEn_busqueda.setBounds(300, 210, 75, altura);

        JLFormato.setBounds(375, 120, 300, altura);
        JTFFormato.setBounds(375, 150, 300, altura);


        JLResumen.setBounds(375, 180, 550, altura);
        JTFResumen.setBounds(375, 210, 550, altura);


        JBAceptar.setBounds(525, 360, 200, 2 * altura);
        JBCancelar.setBounds(775, 360, 200, 2 * altura);
        JBFIXED.setVisible(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Aceptar":
                if ((!JTFTitulo.getText().equals(TextoJTFTitulo))
                        && (!JTFTitulo_original.getText().equals(TextoJTFTitulo_original))
                        && (!JTFFormato.getText().equals(TextoJTFFormato))
                        && (!JTFNombre_serie.getText().equals(TextoJTFNombre_serie))
                        && (!JTFResumen.getText().equals(TextoJTFResumen))
                        && (!JTFISBN.getText().equals(TextoJTFISBN))

                        && (!JTFTitulo.getText().equals(""))
                        && (!JTFTitulo_original.getText().equals(""))
                        && (!JTFFormato.getText().equals(""))
                        && (!JTFNombre_serie.getText().equals(""))
                        && (!JTFResumen.getText().equals(""))
                        && (!JTFISBN.getText().equals(""))) {

                    if (objGestorLN.crearLibro(objGestorLN.getLibreriaDefinida(),JTFISBN.getText(), JTFTitulo.getText(), JTFTitulo_original.getText(), (int) JSAño.getValue(), (String) JCBTipo_DoA.getSelectedItem(), (Double) JSPrecio.getValue(), JCBEn_propiedad.isSelected(), JCBEn_busqueda.isSelected(), JTFFormato.getText(), (int) JSPaginas.getValue(), JTFResumen.getText(), JCBSerie_SoN.isSelected(),  JTFNombre_serie.getText(),(Double) JSOrden_serie.getValue(), (int) JSidGenero.getValue(), (int) JSidAutor.getValue(), (int) JSidEditorial.getValue()) != 0) {
                        //Ha funcionado el insert.
                        //JLMensaje.setText("Insert realizado.");
                        //JLMensaje.setVisible(true);
                        JOptionPane.showInternalMessageDialog(null, "  Insert realizado.");

                    } else {
                        //No ha funcionado el insert.
                        //JLMensaje.setText("Insert no realizado, revisar parámetros.");
                        //JLMensaje.setVisible(true);
                        JOptionPane.showInternalMessageDialog(null, "Insert no realizado, revisar parámetros.");

                    }
                } else {

                    JOptionPane.showInternalMessageDialog(null, "Campos vacíos o sin editar.");
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
