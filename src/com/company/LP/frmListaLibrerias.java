package com.company.LP;

import com.company.LN.itfProperty;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.LinkedList;

/**
 * Ventana para mostrar la lista de librerias multimedia que hay en la base de datos.
 * <p>
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */
public class frmListaLibrerias extends JInternalFrame implements ListSelectionListener
{
	//Objeto visual
	private JList<itfProperty> jlista;
	//Modelo de la vista
	protected ModeloLista modelo;
	
	//Lista auxiliar de Objetos
	private LinkedList<itfProperty> Objetos;


	/**
	 * Creaci�n de lista de  librerias.
	 *
	 * @see ModeloLista
	 */
	public frmListaLibrerias()
	{
		setTitle("Lista de Librer�as");
		
		setBounds(100, 100, 400, 500);
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		Objetos = new LinkedList<itfProperty>();
		
		modelo = new ModeloLista (Objetos);
		jlista = new JList<itfProperty>(modelo);
		//jlista.setCellRenderer(new ListRenderer());
		jlista.addListSelectionListener(this);
		JScrollPane scroll = new JScrollPane(jlista);
		
		this.getContentPane().add(scroll, BorderLayout.CENTER);
		
		setVisible(true);
		this.setResizable(true);
		this.setClosable(true);
		this.setIconifiable(true);
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
			System.out.println("Descripci�n: " + DescripcionAMostrar);
		}
		
	}

}
