package com.company.LP;

import com.company.Comun.itfPropertyV2;

import javax.swing.*;
import java.util.LinkedList;

/**
 * Es la clase que da forma a las listas.
 * <p>
 *
 * @author Ruben Domínguez
 * @author Aritz Garitano
 */

public class ModeloListaV2 extends DefaultListModel<itfPropertyV2> {
    protected LinkedList<itfPropertyV2> lista;


    public ModeloListaV2(LinkedList<itfPropertyV2> lista) {
        this.lista = lista;
    }

    public itfPropertyV2 getElementAt(int index) {
        return lista.get(index);
    }

    public int getSize() {
        return lista.size();
    }

    @Override
    public void addElement(itfPropertyV2 element) {
        lista.add(element);
        this.fireContentsChanged(this, lista.size(), lista.size());
    }
}
