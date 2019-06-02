/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.Ventana.DIMENSION_CASILLA;
import static GUI.Ventana.RUTA_IMAGEN;
import static GUI.Ventana.casillaOrigen;
import static GUI.Ventana.casillaDestino;
import static GUI.Ventana.direccionTablero;
import static GUI.Ventana.girarTableroAuto;
import static GUI.Ventana.mostrarMovimientos;
import Juego.Casilla;
import Juego.Tablero;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javafx.scene.layout.Border;
import javax.imageio.ImageIO;

/**
 *
 * @author navar
 */
public class PanelCasilla extends JPanel {

    private final static Color claro = new Color(255, 204, 153);
    private final static Color oscuro = new Color(102, 51, 0);
    private final static Color borde = new Color(51, 204, 0);

    private final int fila;
    private final int columna;

    public PanelCasilla(int fila, int columna, Tablero tablero, PanelTablero tableroGUI) {
        super(new GridBagLayout());
        this.fila = fila;
        this.columna = columna;
        this.setPreferredSize(DIMENSION_CASILLA);
        this.dibujarCasilla(tablero);
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                switch (e.getButton()) {
                    case 1: //Botón izquierdo del ratón
                        if (casillaOrigen == null) { //primer click
                            if (tablero.getCasilla(fila, columna).isOcupada()
                                    && tablero.getCasilla(fila, columna).getPieza().getColor() == tablero.getJugadorActivo()) {
                                casillaOrigen = tablero.getCasilla(fila, columna);
                            }
                        } else { //segundo click
                            casillaDestino = tablero.getCasilla(fila, columna);
                            if (casillaDestino != casillaOrigen) {
                                Piezas.Color turno = tablero.getJugadorActivo();
                                tablero.ejecutarJugada(casillaOrigen, casillaDestino);
                                if (tablero.isFin()) {
                                    JOptionPane.showMessageDialog(null, "Han ganado las " + tablero.getJugadorActivo());
                                    tablero.reiniciarTablero();
                                }
                                if (girarTableroAuto && tablero.getJugadorActivo() != turno) { // si a cambiado de turno gira el tablero
                                    direccionTablero = direccionTablero.girarTablero();
                                }
                            }
                            casillaOrigen = null; // resetea las selecciones
                            casillaDestino = null;
                        }

                        tableroGUI.dibujarTableroGUI();
                        break;
                    case 3: //Botón derecho del ratón - cancela selección
                        casillaOrigen = null;
                        casillaDestino = null;
                        tableroGUI.dibujarTableroGUI();
                        break;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        this.validate();
    }

    public void dibujarCasilla(Tablero tablero) {
        removeAll();
        this.colorearCasilla();
        this.dibujarPieza(tablero);
        this.dibujarPunto(tablero);
        this.validate();
        this.repaint();
    }

    private void colorearCasilla() {
        removeAll();
        if ((this.fila % 2 == 0 && this.columna % 2 == 0) || (this.fila % 2 != 0 && this.columna % 2 != 0)) {
            this.setBackground(claro);
        } else {
            this.setBackground(oscuro);
        }
        this.setBorder(null);
    }

    private void dibujarPieza(Tablero tablero) {
        this.removeAll();
        if (tablero.getCasilla(this.fila, this.columna).isOcupada()) {
            try {
                BufferedImage icono
                        = ImageIO.read(new File(RUTA_IMAGEN + tablero.getCasilla(this.fila, this.columna).getPieza().getNombre() + ".gif"));
                this.add(new JLabel(new ImageIcon(icono)));
            } catch (IOException ex) {
                System.out.println("Imagen no encontrada: " + RUTA_IMAGEN + tablero.getCasilla(this.fila, this.columna).getPieza().getNombre() + ".gif");
            }
        }
    }

    public void dibujarPunto(Tablero tablero) {
        if (mostrarMovimientos && casillaOrigen != null && casillaOrigen.isOcupada()) {
            for (Casilla punto : casillaOrigen.getPieza().movimientosValidos(tablero, casillaOrigen)) {
                if (this.fila == punto.getFila() && this.columna == punto.getColumna()) {
                    this.setBorder(BorderFactory.createDashedBorder(borde, 4, 3, 2, true));
                    /*
                    try {
                        BufferedImage icono = ImageIO.read(new File("img/punto.png"));
                        this.add(new JLabel(new ImageIcon(icono)));                        
                    } catch (IOException ex) {
                        System.out.println("Imagen no encontrada: img/punto.png");
                    }*/
                }
            }
        }
    }
}
