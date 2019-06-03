/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Tipos de dirección del tablero.
 * <br><br>
 * Solo 2 tipos de dirección: normal y girado 180º.
 *
 * @author Eugenio Navarro
 * @author Carlos Canovas
 */
public enum DireccionTablero {
    NORMAL {
        @Override
        ArrayList<PanelCasilla> girar(ArrayList<PanelCasilla> tableroGUI) {
            return tableroGUI;
        }

        @Override
        DireccionTablero girarTablero() {
            return GIRADO;
        }
    },
    GIRADO {
        @Override
        ArrayList<PanelCasilla> girar(ArrayList<PanelCasilla> tableroGUI) {
            ArrayList<PanelCasilla> tableroGirado = new ArrayList<>(tableroGUI);
            Collections.reverse(tableroGirado);
            return tableroGirado;
        }

        @Override
        DireccionTablero girarTablero() {
            return NORMAL;
        }
    };

    /**
     * Devuelve una lista de PanelCasilla (casillas gráficas) ordenadas según la
     * dirección del tablero
     *
     * @param tableroGUI PanelTablero
     * @return ArrayList&lt;PanelCasilla&gt;
     */
    abstract ArrayList<PanelCasilla> girar(ArrayList<PanelCasilla> tableroGUI);

    /**
     * Devuelve la dirección contraria a la actual
     * 
     * @return DireccionTablero
     */
    abstract DireccionTablero girarTablero();
}
