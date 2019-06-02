/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Juego.Tablero;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author navar
 */
public class PanelTablero extends JPanel {
    
    private final static Dimension DIMENSION_TABLERO = new Dimension(480, 480);
    private Tablero tablero;
    //private ArrayList<PanelCasilla> casillasTablero;

    public PanelTablero(Tablero tablero) {
        super(new GridLayout(8, 8));
        this.tablero = tablero;
        //this.casillasTablero = new ArrayList<>();

        this.dibujarTablero(tablero);
        this.setPreferredSize(DIMENSION_TABLERO);
        this.validate();
    }
    
    public void dibujarTablero(Tablero tablero) {
        this.removeAll();
        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {
                PanelCasilla casilla = new PanelCasilla(f, c, this.tablero, this);
                //this.casillasTablero.add(casilla);
                this.add(casilla);
            }
        }
        this.validate();
        this.repaint();
    }
    
}
