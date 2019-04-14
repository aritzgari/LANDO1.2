
package com.company;

import com.company.LP.clsMenu;
import com.company.LP.clsMenuUsuario;

/**
 * Donde empieza el programa, llamada al menu del programa.
 * <p>
 * @author Ruben Domínguez
 * Aritz Garitano
 * @see clsMenuUsuario
 */


public class Main {

    /**
     * Este metodo llama a la ventana menu que gestiona el programa.
     */
    public static void main(String[] args) {
        clsMenuUsuario miFrame = new clsMenuUsuario();
        miFrame.setVisible(true);
        //clsMenu.MenuPrincipal();
    }
}
