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
public class Ventana2 extends JFrame {

    private JFrame ventana;
    private PanelTablero panelTablero;
    private final static Dimension DIMENSION_MAX = new Dimension(600, 600);

    public Ventana2() {
        this.ventana = new JFrame("Chess Royale");
        this.ventana.setLayout(new BorderLayout());
        this.ventana.setSize(DIMENSION_MAX);
        this.ventana.setVisible(true);
        
        this.panelTablero = new PanelTablero();
        this.ventana.add(this.panelTablero, BorderLayout.CENTER);
    }

}
