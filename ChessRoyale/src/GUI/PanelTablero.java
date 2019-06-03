/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

// imports de este paquete
import static GUI.Ventana.direccionTablero;

// imports de paquete Juego
import static Juego.ChessRoyale.DIMENSION_TABLERO;
import Juego.Tablero;

// imports de librerías
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Clase que representa el tablero de forma gráfica
 *
 * @author Eugenio Navarro
 * @author Carlos Canovas
 */
public final class PanelTablero extends JPanel {

    private final Tablero tablero;
    private final ArrayList<PanelCasilla> casillasGUI;

    /**
     * Crea el tablero gráfico
     *
     * @param tablero Tablero actual
     */
    public PanelTablero(Tablero tablero) {
        super(new GridLayout(8, 8));
        this.tablero = tablero;
        this.casillasGUI = new ArrayList<>();

        this.crearTableroGUI();
        this.setPreferredSize(DIMENSION_TABLERO);
        this.validate();
    }

    /**
     * Devuelve la lista de casillas gráficas (<i>PanelCasilla</i>) que forman
     * este tablero gráfico (<i>PanelTablero</i>)
     *
     * @return ArrayList&lt;PanelCasilla&gt;
     */
    public ArrayList<PanelCasilla> getCasillasGUI() {
        return casillasGUI;
    }

    /**
     * Añade casillas gráficas al tablero gráfico
     */
    public void crearTableroGUI() {
        removeAll();
        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {
                PanelCasilla casillaGUI = new PanelCasilla(f, c, this.tablero, this);
                this.casillasGUI.add(casillaGUI);
                this.add(casillaGUI);
            }
        }
        this.validate();
        this.repaint();
    }

    /**
     * Dibuja el tablero gráfico
     */
    public void dibujarTableroGUI() {
        removeAll();
        for (PanelCasilla casillaGUI : direccionTablero.girar(this.casillasGUI)) {
            //recorre la lista de casillas gráficas ordenadas según la dirección del tablero
            casillaGUI.dibujarCasilla(this.tablero); // dibuja una casilla
            this.add(casillaGUI);
        }
        this.validate();
        this.repaint();
    }
}
