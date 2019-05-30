
package com.company;

import com.company.LP.clsMenu;
import com.company.LP.clsMenuUsuario;
import com.company.LP.frmPrincipal;

/**
 * Donde empieza el programa, llamada al menu del programa.
 * <p>
 * @author Ruben Domínguez
 * Aritz Garitano
 * @see clsMenuUsuario
 */


public class clsMain {

    /**
     * Este metodo llama a la ventana menu que gestiona el programa.
     */
    public static void main(String[] args) {
        //Iniciar programa con frmPrincipal
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                //Create and set up the window.
                frmPrincipal VentanaPrincipal = new frmPrincipal("LANDO V0.8");
                VentanaPrincipal.createAndShowGUI();

            }
        });


        //Iniciar programa con clsMenuUsuario
        /*clsMenuUsuario miFrame = new clsMenuUsuario();
        miFrame.setVisible(true);*/

    }
}
