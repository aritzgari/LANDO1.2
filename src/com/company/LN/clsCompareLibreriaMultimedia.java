package com.company.LN;

import java.util.Comparator;

/**
 * Clase de comparacion de la libreria multimedia.
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 * @see clsLibreriaMultimedia
 */

public class clsCompareLibreriaMultimedia implements Comparator<clsLibreriaMultimedia> {
    public int compare(clsLibreriaMultimedia A1, clsLibreriaMultimedia A2) {// las variables creadas de objLibreriaMultimedia
        if (A1.getNombre().compareTo(A2.getNombre()) == 0) { // en caso de ser nombres iguales coger la descripcion
            return A1.getDescripcion().compareTo(A2.getDescripcion());
        } else {
            return A1.getNombre().compareTo(A2.getNombre());
        }
    }
}
