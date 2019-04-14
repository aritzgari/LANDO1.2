package com.company.LP;

import com.company.LN.itfProperty;

import javax.swing.*;
import java.util.LinkedList;


public class ModeloLista extends DefaultListModel<itfProperty>
{
	  protected LinkedList<itfProperty> lista;
	
	  public ModeloLista(LinkedList<itfProperty> lista)
	  {
	    this.lista = lista;
	  }
	
	  public itfProperty getElementAt(int index)
	  {
	    return lista.get(index);
	  }
	
	  public int getSize()
	  {
	    return lista.size();
	  }

	  @Override
	  public void addElement(itfProperty element)
	  {
		  lista.add(element);
		  this.fireContentsChanged(this, lista.size(), lista.size());
	  }
}
