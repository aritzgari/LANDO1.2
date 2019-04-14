package com.company.LP;

import com.company.LN.itfProperty;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.LinkedList;


public class frmListaLibrerias extends JFrame implements ListSelectionListener
{
	//Objeto visual
	private JList<itfProperty> jlista;
	//Modelo de la vista
	protected ModeloLista modelo;
	
	//Lista auxiliar de Objetos
	private LinkedList<itfProperty> Objetos;
	
	
	/**
	 * Create the application.
	 */
	public frmListaLibrerias()
	{
		setTitle("Lista de Librerías");
		
		setBounds(100, 100, 400, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// pone la ventana en el Centro de la pantalla
		setLocationRelativeTo(null);
		
		Objetos = new LinkedList<itfProperty>();
		
		modelo = new ModeloLista (Objetos);
		jlista = new JList<itfProperty>(modelo);
		//jlista.setCellRenderer(new ListRenderer());
		jlista.addListSelectionListener(this);
		JScrollPane scroll = new JScrollPane(jlista);
		
		this.getContentPane().add(scroll, BorderLayout.CENTER);
		
		setVisible(true);
	}
	

	
	public void setItem(itfProperty Objeto)
	{
		modelo.addElement(Objeto);
		
	
		//jlista.setModel(modelo);
		
	
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0)
	{
	
		//Se controla si se est?n realizando cambios todav?a en la lista.
		//Si no se controla esto, los eventos se lanzan varias veces.
		if (arg0.getValueIsAdjusting()==false)
		{
			String DescripcionAMostrar = ((itfProperty) jlista.getSelectedValue()).getStringProperty("Descripcion");
			System.out.println("Descripción: " + DescripcionAMostrar);
		}
		
	}

}
