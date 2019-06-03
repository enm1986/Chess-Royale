/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.*;
import java.util.ArrayList;

/**
 * Clase abstracta que define las piezas de ajedrez
 * 
 * @author Eugenio Navarro
 * @author Carlos Canovas
 */
public abstract class Pieza {

    
    private Tipo tipo;
    private Color color;

    /**
     * 
     * @param tipo Tipo de la pieza (PEON, CABALLO, ALFIL, TORRE, DAMA, REY)
     * @param color Color de la pieza (BLANCAS , NEGRAS)
     */
    public Pieza(Tipo tipo, Color color) {
        this.tipo = tipo;
        this.color = color;
    }

    /**
     * 
     * @return Color de la pieza (BLANCAS , NEGRAS)
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * 
     * @return Tipo de la pieza (PEON, CABALLO, ALFIL, TORRE, DAMA, REY)
     */
    public Tipo getTipo() {
        return this.tipo;
    }

    /**
     * Calcula los movimientos válidos de la pieza según la distribución del tablero y la casilla donde se encuentra la pieza.
     * 
     * @param tablero Tablero de juego
     * @param casilla Casilla donde se encuentra la pieza
     * @return ArrayList&lt;Casilla&gt;
     */
    abstract public ArrayList<Casilla> movimientosValidos(Tablero tablero, Casilla casilla);

    /**
     * Crea un String según el Color y Tipo de la pieza
     * @return String
     */
    public String getNombre() {
        return this.getTipo().toString().substring(0, 1) + this.getColor().toString().substring(0, 1);
    }

    /**
     * Método estático que sólo usarán las subclases de Pieza.<br>
     * Comprueba si la coordenada pasada se encuentra dentro de las coordenadas válidas (interior del tablero).
     * 
     * @param coordenada coordenada a comprobar
     * @return boolean
     */
    protected static boolean coordenadaValida(int[] coordenada) {
        return (coordenada[0] >= 0 && coordenada[0] <= 7 && coordenada[1] >= 0 && coordenada[1] <= 7);
    }
    
    
}
