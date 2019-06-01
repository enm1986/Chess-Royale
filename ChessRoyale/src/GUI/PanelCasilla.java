/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author navar
 */
public class PanelCasilla extends JPanel {

    private final static Dimension DIMENSION_CASILLA = new Dimension(10, 10);
    private final int fila;
    private final int columna;

    public PanelCasilla(int fila, int columna, PanelTablero tablero) {
        super(new GridBagLayout());
        this.fila = fila;
        this.columna = columna;
        this.setPreferredSize(DIMENSION_CASILLA);
        this.darColor();
        this.validate();
    }

    private void darColor() {
        if ((this.fila % 2 == 0 && this.columna % 2 == 0) || (this.fila % 2 != 0 && this.columna % 2 != 0)) {
            this.setBackground(Color.BLACK);
        } else {
            this.setBackground(Color.WHITE);
        }
    }
}
