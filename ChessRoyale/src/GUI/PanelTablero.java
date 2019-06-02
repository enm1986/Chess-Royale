/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.Ventana.DIMENSION_TABLERO;
import static GUI.Ventana.direccionTablero;
import static GUI.Ventana.mostrarMovimientos;
import Juego.Casilla;
import Juego.Tablero;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author navar
 */
public class PanelTablero extends JPanel {

    private final Tablero tablero;
    private ArrayList<PanelCasilla> casillasGUI;

    public PanelTablero(Tablero tablero) {
        super(new GridLayout(8, 8));
        this.tablero = tablero;
        this.casillasGUI = new ArrayList<>();

        this.crearTableroGUI();
        this.setPreferredSize(DIMENSION_TABLERO);
        this.validate();
    }

    public ArrayList<PanelCasilla> getCasillasGUI() {
        return casillasGUI;
    }

    public void crearTableroGUI() {
        removeAll();
        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {
                PanelCasilla casilla = new PanelCasilla(f, c, this.tablero, this);
                this.casillasGUI.add(casilla);
                this.add(casilla);
            }
        }
        this.validate();
        this.repaint();
    }

    public void dibujarTableroGUI() {
        removeAll();
        for (PanelCasilla casillaGUI : direccionTablero.girar(this.casillasGUI)) {
            casillaGUI.dibujarCasilla(this.tablero);
            this.add(casillaGUI);
        }
        this.validate();
        this.repaint();
    }
}
