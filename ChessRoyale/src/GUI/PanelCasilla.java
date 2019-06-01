/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Juego.Tablero;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author navar
 */
class PanelCasilla extends JPanel {

    private final static String RUTA_IMAGEN = "img/";
    private final static Dimension DIMENSION_CASILLA = new Dimension(10, 10);
    private final static Color claro = new Color(255, 204, 153);
    private final static Color oscuro = new Color(102, 51, 0);

    private final int fila;
    private final int columna;

    public PanelCasilla(int fila, int columna, Tablero tablero) {
        super(new GridBagLayout());
        this.fila = fila;
        this.columna = columna;
        this.setPreferredSize(DIMENSION_CASILLA);
        this.darColor();
        this.dibujarPieza(tablero);
        this.validate();
    }

    private void darColor() {
        if ((this.fila % 2 == 0 && this.columna % 2 == 0) || (this.fila % 2 != 0 && this.columna % 2 != 0)) {
            this.setBackground(claro);
        } else {
            this.setBackground(oscuro);
        }
    }

    private void dibujarPieza(Tablero tablero) {
        this.removeAll();
        if (tablero.getCasilla(this.fila, this.columna).isOcupada()) {
            try {
                BufferedImage icono
                        = ImageIO.read(new File(RUTA_IMAGEN + tablero.getCasilla(this.fila, this.columna).getPieza().getNombre() + ".gif"));
                this.add(new JLabel(new ImageIcon(icono)));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
