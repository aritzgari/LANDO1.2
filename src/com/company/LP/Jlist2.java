package com.company.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jlist2 extends JFrame {

    private JPanel contentPane;
    private JTextField textField;


    private DefaultListModel <String> modelo= new DefaultListModel<String>();
    /**
     * Crear modelo y tipo de dato a insertar
     */


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Jlist2 frame = new Jlist2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Jlist2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(238, 48, 161, 202);
        contentPane.add(scrollPane);

        JList<String> list = new JList<String>();
        scrollPane.setViewportView(list);

        list.setModel(modelo);
        /**
         * vincular modelo con la lista
         */

        JButton btnNewButton = new JButton("Añadir");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {	//Añade a la lista
                String texto = textField.getText();
                modelo.addElement(texto);
            }
        });
        btnNewButton.setBounds(53, 90, 89, 23);
        contentPane.add(btnNewButton);

        textField = new JTextField();
        textField.setBounds(56, 47, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton_1 = new JButton("Borrar");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Quita de la lista

                int posicion = list.getSelectedIndex();
                modelo.remove(posicion);
            }
        });
        btnNewButton_1.setBounds(53, 124, 89, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Salir");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_2.setBounds(53, 227, 89, 23);
        contentPane.add(btnNewButton_2);

    }
}