package com.company.LP;

import com.company.LN.itfProperty;

import javax.swing.*;
import java.util.LinkedList;

/**
 * Es la clase que da forma a las listas.
 * <p>
 *
 * @author Ruben Domínguez
 * @author Aritz Garitano
 */

public class ModeloLista extends DefaultListModel<itfProperty> {
    //Confirmamos que este no es el que duplica
    protected LinkedList<itfProperty> lista;


    public ModeloLista(LinkedList<itfProperty> lista) {
        this.lista = lista;
    }

    public itfProperty getElementAt(int index) {
        return lista.get(index);
    }

    public int getSize() {
        return lista.size();
    }
    public void clear(){
        for (int i = 0; i < lista.size(); i++) {
            lista.remove(i);
        }
    }

    @Override
    public void addElement(itfProperty element) {
        lista.add(element);
        this.fireContentsChanged(this, lista.size(), lista.size());
    }
}
