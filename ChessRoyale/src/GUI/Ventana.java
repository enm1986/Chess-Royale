/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Juego.Casilla;
import Juego.Tablero;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author navar
 */
public class Ventana extends JFrame {

    final static String RUTA_IMAGEN = "img/";
    final static Dimension DIMENSION_VENTANA = new Dimension(600, 600);
    final static Dimension DIMENSION_TABLERO = new Dimension(480, 480);
    final static Dimension DIMENSION_CASILLA = new Dimension(60, 60);

    private JFrame ventana;
    private PanelTablero panelTablero;
    private Tablero tablero;
    static Casilla casillaOrigen;
    static Casilla casillaDestino;

    public Ventana() {
        this.ventana = new JFrame("Chess Royale");
        this.ventana.setLayout(new BorderLayout());
        this.ventana.setSize(DIMENSION_VENTANA);
        this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.tablero = new Tablero();
        //this.tablero.mostrarTablero();

        this.panelTablero = new PanelTablero(this.tablero);
        this.ventana.add(this.panelTablero, BorderLayout.CENTER);
        this.ventana.setVisible(true);
    }

}
