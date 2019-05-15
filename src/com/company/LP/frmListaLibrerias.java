package com.company.LP;

import com.company.Comun.itfPropertyV2;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.LinkedList;

/**
 * Ventana para mostrar la lista de librerias multimedia que hay en la base de datos.
 * <p>
 * @author Ruben Domínguez
 * Aritz Garitano
 */
public class frmListaLibrerias extends JInternalFrame implements ListSelectionListener
{
	//Objeto visual
	private JList<itfPropertyV2> jlista;
	//Modelo de la vista
	protected ModeloListaV2 modelo;

	//Lista auxiliar de Objetos
	private LinkedList<itfPropertyV2> Objetos;


	/**
	 * Creación de lista de  librerias.
	 *
	 * @see ModeloLista
	 */
	public frmListaLibrerias()
	{
		setTitle("Lista de Librerías");
		
		setBounds(100, 100, 400, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		Objetos = new LinkedList<itfPropertyV2>();
		Objetos.clear();
		
		modelo = new ModeloListaV2 (Objetos);
		modelo.clear();

		//Confirmamos que este no es el que duplica
		jlista = new JList<itfPropertyV2>(modelo);
		jlista.removeAll();
		//jlista.setCellRenderer(new ListRenderer());
		jlista.addListSelectionListener(this);
		JScrollPane scroll = new JScrollPane(jlista);
		
		this.getContentPane().add(scroll, BorderLayout.CENTER);
		
		setVisible(true);
		this.setResizable(true);
		this.setClosable(true);
		this.setIconifiable(true);
	}
	

	
	public void setItem(itfPropertyV2 Objeto)
	{
		modelo.addElement(Objeto);
		
	
		//jlista.setModel(modelo);
		
	
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0)
	{
		if (arg0.getValueIsAdjusting() == false) {
			String TextoAMostrar =
					"clsLibreriaMultimedia{" +
							" Descripción= " + ((itfPropertyV2) jlista.getSelectedValue()).getObjectProperty("Descripción") + " }";
			System.out.println("Atributos: " + TextoAMostrar);
		
	}

}}
