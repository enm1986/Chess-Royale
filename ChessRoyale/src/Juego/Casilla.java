/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Piezas.Pieza;

/**
 * Clase Casilla.
 *
 * Define la casilla de un tablero de ajedrez
 *
 * @author Eugenio Navarro
 * @author Carlos Canovas
 */
public class Casilla {

    //Atributos
    private final int fila;
    private final int columna;
    private Pieza pieza;

    //Contructor
    /**
     * Al crearse una casilla se indican sus coordenadas y se deja vacía (sin
     * pieza)
     *
     * @param fila coordena X de la casilla
     * @param columna coordenada Y de casilla
     */
    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.pieza = null;
    }

    //G&S
    /**
     * Coordenada X de la casilla
     *
     * @return int
     */
    public int getFila() {
        return fila;
    }

    /**
     * Coordenada Y de la casilla
     *
     * @return int
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Pieza que contiene la casilla.
     * <br>
     * Si no tiene pieza devuelve <i>null</i>.
     *
     * @return Pieza
     */
    public Pieza getPieza() {
        return pieza;
    }

    /**
     * Asigna una pieza a la casilla
     *
     * @param pieza Pieza que contendrá la casilla
     */
    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    //Métodos
    /**
     * Comprueba si la casilla está ocupada por una pieza
     *
     * @return boolean
     */
    public boolean isOcupada() {
        return this.pieza != null;
    }

    /**
     * Vacía una casilla y devuelve la pieza que contenía la casilla
     * 
     * @return Pieza
     */
    public Pieza sacarPieza() {
        Pieza pieza = this.pieza;
        this.pieza = null;
        return pieza;
    }

    /**
     * Muestra información de la casilla por pantalla.
     * <br><br>
     * Usado para hacer pruebas
     */
    public void mostrarCasilla() {
        System.out.println("coordenadas: " + this.getFila() + "," + this.getColumna());
        if (this.isOcupada()) {
            System.out.println("Pieza: " + this.getPieza().getTipo() + " " + this.getPieza().getColor());
        } else {
            System.out.println("Pieza: NO");
        }
    }
}
