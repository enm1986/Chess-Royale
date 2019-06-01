/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Juego.Tablero;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author navar
 */
public class Ventana2 extends JFrame {

    private JFrame ventana;
    private PanelTablero panelTablero;
    private final static Dimension DIMENSION_VENTANA = new Dimension(600, 600);
    private Tablero tablero;

    public Ventana2() {
        this.ventana = new JFrame("Chess Royale");
        this.ventana.setLayout(new BorderLayout());
        this.ventana.setSize(DIMENSION_VENTANA);
        
        this.tablero = new Tablero();
        this.tablero.mostrarTablero();

        
        
        this.panelTablero = new PanelTablero(this.tablero);
        this.ventana.add(this.panelTablero, BorderLayout.CENTER);
        this.ventana.setVisible(true);
    }

}
