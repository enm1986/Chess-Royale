/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

// imports de este paquete
import static GUI.Ventana.casillaOrigen;
import static GUI.Ventana.casillaDestino;
import static GUI.Ventana.direccionTablero;
import static GUI.Ventana.girarTableroAuto;
import static GUI.Ventana.mostrarMovimientos;

// imports de paquete Juego
import Juego.Casilla;
import Juego.Tablero;
import static Juego.ChessRoyale.DIMENSION_CASILLA;
import static Juego.ChessRoyale.RUTA_IMAGEN;

// imports librerías
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase que representa las casillas en forma gráfica
 * <br><br>
 * Las casillas gráficas están a la espera de que se clique sobre ellas con el
 * ratón (<i>MouseListener</i>).
 * <br><br>
 * Una vez clicado sobre una casilla se comporta de la siguiente manera:
 * <ul>
 * <li>Click izquierdo: selecciona una casilla.
 * <ul>
 * <li>Primer click: selecciona la casilla de origen del movimiento.</li>
 * <li>Segundo click: selecciona la casilla de destino del movimiento.</li>
 * </ul>
 * </li>
 * <li>Click derecho: cancela la selección del primer click izquierdo.</li>
 * </ul>
 *
 * @see java.awt.event.MouseListener
 * @see java.awt.event.MouseEvent
 *
 * @author Eugenio Navarro
 * @author Carlos Canovas
 */
public class PanelCasilla extends JPanel {

    // variables estáticas que representan los colores de las casillas y marcas que se pongan en ellas
    private final static Color claro = new Color(255, 204, 153);
    private final static Color oscuro = new Color(102, 51, 0);
    private final static Color borde = new Color(51, 204, 0);

    // Atributos (coordenadas de las casillas)
    private final int fila;
    private final int columna;

    /**
     * Crea una casilla gráfica
     *
     * @param fila coordenada X de la casilla
     * @param columna coordenada Y de la casilla
     * @param tablero Tablero actual
     * @param tableroGUI Tablero gráfico
     */
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
                    case 1: //Botón izquierdo del ratón - selección de casilla
                        if (casillaOrigen == null) { //primer click
                            if (tablero.getCasilla(fila, columna).isOcupada()
                                    && tablero.getCasilla(fila, columna).getPieza().getColor() == tablero.getJugadorActivo()) {
                                // si la casilla seleccionada tiene una pieza y pertenece al jugador activo
                                // selecciona casilla de origen
                                casillaOrigen = tablero.getCasilla(fila, columna);
                            }
                        } else { //segundo click
                            // selecciona la casilla destino
                            casillaDestino = tablero.getCasilla(fila, columna);
                            if (casillaDestino != casillaOrigen
                                    && casillaOrigen.getPieza().getColor() == tablero.getJugadorActivo()) {
                                // si las casillas origen y destino son diferentes y la pieza seleccionada es del jugador activo
                                Piezas.Color turno = tablero.getJugadorActivo(); // guardamos el Color del jugador activo
                                tablero.ejecutarJugada(casillaOrigen, casillaDestino); // ejecuta la jugada si esta es válida
                                if (tablero.isFin()) {
                                    // si se cumple coondición de victoria y derrota se muestra un mensaje y se reinicia el tablero
                                    JOptionPane.showMessageDialog(null, "Han ganado las " + tablero.getJugadorActivo());
                                    tablero.reiniciarTablero();
                                }
                                if (girarTableroAuto && tablero.getJugadorActivo() != turno) {
                                    // si está habilitado el giro automático y ha cambiado de turno gira el tablero
                                    direccionTablero = direccionTablero.girarTablero();
                                }
                            }
                            casillaOrigen = null; // resetea las selecciones
                            casillaDestino = null;
                        }
                        tableroGUI.dibujarTableroGUI(); // dibuja el tablero con las modificaciones hechas
                        break;
                    case 3: //Botón derecho del ratón - cancelar selección
                        casillaOrigen = null;
                        casillaDestino = null;
                        tableroGUI.dibujarTableroGUI(); // dibuja el tablero con las modificaciones hechas
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

    /**
     * Dibuja una casilla gráfica
     * <br><br>
     * Compuesto de varios métodos
     *
     * @param tablero Tablero actual
     */
    public void dibujarCasilla(Tablero tablero) {
        removeAll();
        this.colorearCasilla();
        this.dibujarPieza(tablero);
        this.dibujarMarca(tablero);
        this.validate();
        this.repaint();
    }

    /**
     * Colorea la casilla con los colores del tablero (claro/oscuro)
     */
    private void colorearCasilla() {
        removeAll();
        if ((this.fila % 2 == 0 && this.columna % 2 == 0) || (this.fila % 2 != 0 && this.columna % 2 != 0)) {
            this.setBackground(claro);
        } else {
            this.setBackground(oscuro);
        }
        this.setBorder(null);
    }

    /**
     * Dibuja la imagen de la pieza en la casilla si la casilla está ocupada
     *
     * @param tablero Tablero actual
     */
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

    /**
     * Dibuja un borde en una casilla dependiendo de una lista de movimientos
     * válidos.
     *
     * @param tablero Tablero actual
     */
    public void dibujarMarca(Tablero tablero) {
        if (mostrarMovimientos && casillaOrigen != null && casillaOrigen.isOcupada()) {
            // si está habilitada la opción de mostrar movimientos, está seleccionada una casilla origen y además está ocupada
            for (Casilla punto : casillaOrigen.getPieza().movimientosValidos(tablero, casillaOrigen)) {
                // recorre una lista de casillas (movimientos válidos)
                if (this.fila == punto.getFila() && this.columna == punto.getColumna()) {
                    // si esta casilla se encuentra en la lista se colorea el borde
                    this.setBorder(BorderFactory.createDashedBorder(borde, 4, 3, 2, true));
                }
            }
        }
    }
}
