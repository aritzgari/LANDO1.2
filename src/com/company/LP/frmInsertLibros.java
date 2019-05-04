package com.company.LP;

import com.company.LN.clsGestorLN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class frmInsertLibros {
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

    JLabel JLA�o;
    SpinnerNumberModel ModeloA�o;
    JSpinner JSA�o;

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


    private final String TextoJTFISBN = "<Inserte el ISBN aqu�>";
    private final String TextoJTFTitulo = "<Inserte el T�tulo aqu�>";
    private final String TextoJTFTitulo_original = "<Inserte el T�tulo original aqu�>";
    private final String TextoJTFFormato = "<Inserte el Formato aqu�. Ej. .mkv, Vinilo, VHS...>";
    private final String TextoJTFNombre_serie = "<Inserte el nombre de la serie aqu�>";
    private final String TextoJTFResumen = "<Inserte la resumen aqu�>";

    private clsGestorLN objGestorLN;

    //C�digo
    //Constructor (?)
    public frmInsertLibros(clsGestorLN _objGestorLN) {
        //Tama�o y componentes
        JPContent = new JPanel();
        setBounds(0, 0, 1000, 475);
        //setLayout(null);
        //setPreferredSize(new Dimension(400, 400));

        JLISBN = new JLabel("\nISBN:");
        JTFISBN = new JTextField(TextoJTFISBN);

        JLTitulo = new JLabel("\nT�tulo:");
        JTFTitulo = new JTextField(TextoJTFTitulo);

        JLTitulo_original = new JLabel("\nT�tulo Original:");
        JTFTitulo_original = new JTextField(TextoJTFTitulo_original);

        JLA�o = new JLabel("\nA�o:");
        JSA�o = new JSpinner();
        ModeloA�o = new SpinnerNumberModel();
        ModeloA�o.setMinimum(1885);
        ModeloA�o.setMaximum(2085);
        ModeloA�o.setStepSize(1);
        ModeloA�o.setValue(2019);
        JSA�o.setModel(ModeloA�o);

        JLPaginas = new JLabel("\nDuraci�n (min):");
        JSPaginas = new JSpinner();
        ModeloPaginas = new SpinnerNumberModel();
        ModeloPaginas.setMinimum(0);
        ModeloPaginas.setStepSize(1);
        ModeloPaginas.setValue(90);
        JSPaginas.setModel(ModeloPaginas);

        JLTipo_DoA = new JLabel("\nFormato digital o Formato f�sico:");
        JCBTipo_DoA = new JComboBox();
        JCBTipo_DoA.addItem("Digital");
        JCBTipo_DoA.addItem("F�sico");

        JLPrecio = new JLabel("\nPrecio (Euros):");
        JSPrecio = new JSpinner();
        ModeloPrecio = new SpinnerNumberModel();
        ModeloPrecio.setMinimum(0.00);
        ModeloPrecio.setStepSize(0.1);
        ModeloPrecio.setValue(9.99);
        JSPrecio.setModel(ModeloPrecio);

        JLEn_propiedad = new JLabel("\nLo tengo:");
        JCBEn_propiedad = new JCheckBox("S�");

        JLSerie_SoN = new JLabel("\nParte de una serie:");
        JCBSerie_SoN = new JCheckBox("S�");

        JLEn_busqueda = new JLabel("\nLo quiero:");
        JCBEn_busqueda = new JCheckBox("S�");


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

        JLResumen = new JLabel("\nResumen:");
        JTFResumen = new JTextField(TextoJTFResumen);


        JBAceptar = new JButton("Aceptar");
        JBCancelar = new JButton("Cancelar");
        JBFIXED = new JButton("Bibidi Babidi Bu");
        objGestorLN = _objGestorLN;


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

        JPContent.add(JLA�o);
        JPContent.add(JSA�o);

        JPContent.add(JLPaginas);
        JPContent.add(JSPaginas);

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

        //Darle valores de acci�n a los botones
        JBAceptar.setActionCommand("Aceptar");
        JBCancelar.setActionCommand("Cancelar");
        JBAceptar.addActionListener(this);
        JBCancelar.addActionListener(this);

        //Ubicar las cosas porque sino sale tudu amontonado:
        int altura = 30;
        JLISBN.setBounds(25, 0, 450, altura);
        JTFISBN.setBounds(25, 30, 450, altura);

        JLTitulo.setBounds(500, 0, 450, altura);
        JTFTitulo.setBounds(500, 30, 450, altura);
        JLTitulo_original.setBounds(25, 60, 450, altura);
        JTFTitulo_original.setBounds(25, 90, 450, altura);
        JLA�o.setBounds(25, 60, 100, altura);
        JSA�o.setBounds(25, 90, 100, altura);

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
                        && (!JTFNombre_serie.getText().equals(TextoJTFNombre_serie))
                        && (!JTFResumen.getText().equals(TextoJTFResumen))
                        && (!JTFISBN.getText().equals(TextoJTFISBN)))

                        && (!JTFTitulo.getText().equals(""))
                        && (!JTFTitulo_original.getText().equals(""))
                        && (!JTFFormato.getText().equals(""))
                        && (!JTFNombre_serie.getText().equals(""))
                        && (!JTFResumen.getText().equals(""))
                        && (!JTFISBN.getText().equals(""))) {
                    objGestorLN.crearLibro(/*De momento a la libreria 1 tudo*/1, JTFISBN.getText(), JTFTitulo.getText(), JTFTitulo_original.getText(), (int) JSA�o.getValue(), (int) JSDuracion.getValue(), (int) JSCalificacion.getValue(), (int) JSCalporedad.getValue(), (String) JCBTipo_DoA.getSelectedItem(), (Double) JSPrecio.getValue(), JCBEn_propiedad.isSelected(), JCBEn_busqueda.isSelected(), JTFFormato.getText(), JTFNombre_serie.getText(), (Double) JSOrden_serie.getValue(), JTFResumen.getText());
                    } else {
                    //ESTO HAY QUE PONERLO EN LA VENTANA O CON UNA EXCEPCION Y UNA VENTANA DE ERROR.
                    System.out.println("Campos vac�os o sin editar");
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
                System.out.println("Acci�n no definida.");
                break;
        }

    }
}