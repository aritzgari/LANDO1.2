package com.company.LP;

import com.company.Comun.itfPropertyV2;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTablaLibrerias extends AbstractTableModel {
    private ArrayList<itfPropertyV2> listaLibrerias;
    private String[] columnas = {"idLibreria", "Nombre", "Descripción"};

    public ModeloTablaLibrerias(ArrayList<itfPropertyV2> _listaLibrerias) {
        this.listaLibrerias = _listaLibrerias;

    }

    @Override
    public int getRowCount() {
        return listaLibrerias.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaLibrerias.get(rowIndex).getObjectProperty("idLibreria_Multimedia");

            case 1:
                return listaLibrerias.get(rowIndex).getObjectProperty("Nombre");

            case 2:
                return listaLibrerias.get(rowIndex).getObjectProperty("Descripción");

        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {   //Como no hay manera de cambiar el valor de los itfProperties no hay manera de hacer la tabla ediTable
        itfPropertyV2 row = listaLibrerias.get(rowIndex);

        /*
        listaLibrerias.add(row);
        System.out.println(listaLibrerias.size());
        if(0 == columnIndex) {

        }
        else if(1 == columnIndex) {
            row.setName((String) aValue);
        }
        else if(2 == columnIndex) {
            row.setHourlyRate((Double) aValue);
        }
        else if(3 == columnIndex) {
            row.setPartTime((Boolean) aValue);
        }*/
        super.setValueAt(aValue,rowIndex,columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        System.out.println("row: " + rowIndex + " column: " + columnIndex);
        return true;
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

    @Override
    public void fireTableChanged(TableModelEvent e) {
        super.fireTableChanged(e);
    }

    @Override
    public void fireTableRowsUpdated(int firstRow, int lastRow) {
        super.fireTableRowsUpdated(firstRow, lastRow);
    }
}
