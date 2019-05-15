package com.company.LP;
import com.company.Comun.itfPropertyV2;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class frmTablaMultimedia {
    public static void frmTablaMultimedia() {
        JInternalFrame marco = new marcotabla();
        marco.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        marco.setVisible(true);
    }
    static class marcotabla extends JInternalFrame{
        public marcotabla(){
            setTitle("Los planetas");
            setBounds(300,300,400,200);
            JTable tablademierdas = new JTable(/**datosfila, nombrescolumnas**/);
            add (new JScrollPane(tablademierdas), BorderLayout.CENTER);
            JButton botonimprimir = new JButton("Imprimir tabla");
            botonimprimir.addActionListener (new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        tablademierdas.print();

                    }catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    JPanel laminaboton = new JPanel();
                    add (laminaboton, BorderLayout.SOUTH);

                }
            });}

        private String [] nombrescolumnas = {"ID Multimedia", "Nombre", "Descripción"};
    }

    private Object datosfila[][] ={
            {/**id, nombre, descripcion**/}
            //.................
    };

}