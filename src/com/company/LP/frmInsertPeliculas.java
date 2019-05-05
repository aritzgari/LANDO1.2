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
public class frmInsertPeliculas extends JInternalFrame implements ActionListener {
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

    JLabel JLDuracion;
    SpinnerNumberModel ModeloDuracion;
    JSpinner JSDuracion;

    JLabel JLCalificacion;
    SpinnerNumberModel ModeloCalificacion;
    JSpinner JSCalificacion;

    JLabel JLCalporedad;
    SpinnerNumberModel ModeloCalporedad;
    JSpinner JSCalporedad;

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

    JLabel JLSaga;
    JTextField JTFSaga;

    JLabel JLOrden;
    SpinnerNumberModel ModeloOrden;
    JSpinner JSOrden;

    JLabel JLSinopsis;
    JTextField JTFSinopsis;

    JLabel JLEnlace_a_trailer;
    JTextField JTFEnlace_a_trailer;

    JLabel JLMensaje;

    //Botones
    JButton JBAceptar;
    JButton JBCancelar;
    JButton JBFIXED;


    private final String TextoJTFTitulo = "<Inserte el Título aquí>";
    private final String TextoJTFTitulo_original = "<Inserte el Título original aquí>";
    private final String TextoJTFFormato = "<Inserte el Formato aquí. Ej. .mkv, Vinilo, VHS...>";
    private final String TextoJTFSaga = "<Inserte el nombre de la Saga aquí>";
    private final String TextoJTFSinopsis = "<Inserte la sinópsis aquí>";
    private final String TextoJTFEnlace_a_trailer = "<Inserte el enlace al tráiler aquí>";

    private clsGestorLN objGestorLN;

    //Código
    //Constructor
    public frmInsertPeliculas(clsGestorLN _objGestorLN) {
        //Tamaño y componentes
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

        JLDuracion = new JLabel("\nDuración (min):");
        JSDuracion = new JSpinner();
        ModeloDuracion = new SpinnerNumberModel();
        ModeloDuracion.setMinimum(0);
        ModeloDuracion.setStepSize(1);
        ModeloDuracion.setValue(90);
        JSDuracion.setModel(ModeloDuracion);

        JLCalificacion = new JLabel("\nPuntuación (sobre 100):");
        JSCalificacion = new JSpinner();
        ModeloCalificacion = new SpinnerNumberModel();
        ModeloCalificacion.setMinimum(0);
        ModeloCalificacion.setMaximum(100);
        ModeloCalificacion.setStepSize(1);
        ModeloCalificacion.setValue(50);
        JSCalificacion.setModel(ModeloCalificacion);

        JLCalporedad = new JLabel("\nCalificación por edad (No apta para menores de):");
        JSCalporedad = new JSpinner();
        ModeloCalporedad = new SpinnerNumberModel();
        ModeloCalporedad.setMinimum(0);
        ModeloCalporedad.setMaximum(18);
        ModeloCalporedad.setStepSize(1);
        ModeloCalporedad.setValue(0);
        JSCalporedad.setModel(ModeloCalporedad);

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

        JLSaga = new JLabel("\nNombre de la Saga:");
        JTFSaga = new JTextField(TextoJTFSaga);

        JLOrden = new JLabel("\nOrden dentro de la saga:");
        JSOrden = new JSpinner();
        ModeloOrden = new SpinnerNumberModel();
        ModeloOrden.setMinimum(0.00);
        ModeloOrden.setStepSize(0.1);
        ModeloOrden.setValue(1.00);
        JSOrden.setModel(ModeloOrden);

        JLSinopsis = new JLabel("\nSinópsis:");
        JTFSinopsis = new JTextField(TextoJTFSinopsis);

        JLEnlace_a_trailer = new JLabel("\nEnlace al tráiler:");
        JTFEnlace_a_trailer = new JTextField(TextoJTFEnlace_a_trailer);

        JLMensaje = new JLabel();
        JLMensaje.setVisible(false);

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
        setTitle("Insertar Películas");
        JPContent.setLayout(new BorderLayout());
        JPContent.add(JLTitulo);
        JPContent.add(JTFTitulo);

        JPContent.add(JLTitulo_original);
        JPContent.add(JTFTitulo_original);

        JPContent.add(JLAño);
        JPContent.add(JSAño);

        JPContent.add(JLDuracion);
        JPContent.add(JSDuracion);

        JPContent.add(JLCalificacion);
        JPContent.add(JSCalificacion);

        JPContent.add(JLCalporedad);
        JPContent.add(JSCalporedad);

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

        JPContent.add(JLSaga);
        JPContent.add(JTFSaga);

        JPContent.add(JLOrden);
        JPContent.add(JSOrden);

        JPContent.add(JLSinopsis);
        JPContent.add(JTFSinopsis);

        JPContent.add(JLEnlace_a_trailer);
        JPContent.add(JTFEnlace_a_trailer);

        JPContent.add(JLMensaje);

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
        JLMensaje.setHorizontalAlignment(SwingConstants.CENTER);

        //Ubicar las cosas porque sino sale tudu amontonado:
        int altura = 30;
        JLTitulo.setBounds(25, 0, 450, altura);
        JTFTitulo.setBounds(25, 30, 450, altura);
        JLTitulo_original.setBounds(500, 0, 450, altura);
        JTFTitulo_original.setBounds(500, 30, 450, altura);
        JLAño.setBounds(25, 60, 100, altura);
        JSAño.setBounds(25, 90, 100, altura);
        JLDuracion.setBounds(175, 60, 100, altura);
        JSDuracion.setBounds(175, 90, 100, altura);
        JLCalificacion.setBounds(325, 60, 150, altura);
        JSCalificacion.setBounds(325, 90, 150, altura);
        JLCalporedad.setBounds(525, 60, 300, altura);
        JSCalporedad.setBounds(525, 90, 300, altura);
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
        JLSaga.setBounds(25, 240, 325, altura);
        JTFSaga.setBounds(25, 270, 325, altura);
        JLOrden.setBounds(400, 240, 200, altura);
        JSOrden.setBounds(400, 270, 200, altura);
        JLMensaje.setBounds(600, 270, 400, altura);
        JLSinopsis.setBounds(25, 300, 450, altura);
        JTFSinopsis.setBounds(25, 330, 450, altura);
        JLEnlace_a_trailer.setBounds(25, 360, 450, altura);
        JTFEnlace_a_trailer.setBounds(25, 390, 450, altura);

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
                        && (!JTFSaga.getText().equals(TextoJTFSaga))
                        && (!JTFSinopsis.getText().equals(TextoJTFSinopsis))
                        && (!JTFEnlace_a_trailer.getText().equals(TextoJTFEnlace_a_trailer))

                        && (!JTFTitulo.getText().equals(""))
                        && (!JTFTitulo_original.getText().equals(""))
                        && (!JTFFormato.getText().equals(""))
                        && (!JTFSaga.getText().equals(""))
                        && (!JTFSinopsis.getText().equals(""))
                        && (!JTFEnlace_a_trailer.getText().equals(""))) {
                    if(objGestorLN.crearPelicula(/*De momento a la libreria 1 tudo*/1, JTFTitulo.getText(), JTFTitulo_original.getText(), (int) JSAño.getValue(), (int) JSDuracion.getValue(), (int) JSCalificacion.getValue(), (int) JSCalporedad.getValue(), (String) JCBTipo_DoA.getSelectedItem(), (Double) JSPrecio.getValue(), JCBEn_propiedad.isSelected(), JCBEn_busqueda.isSelected(), JTFFormato.getText(), JTFSaga.getText(), (Double) JSOrden.getValue(), JTFSinopsis.getText(), JTFEnlace_a_trailer.getText())!= 0){
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
                    JLMensaje.setText("Campos vacíos o sin editar");
                    JLMensaje.setVisible(true);
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
