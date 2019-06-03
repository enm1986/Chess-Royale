/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
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

    abstract ArrayList<PanelCasilla> girar(ArrayList<PanelCasilla> tableroGUI);

    abstract DireccionTablero girarTablero();
}
