/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Piezas.Pieza;

/**
 *
 * @author infor04
 */
public class Casilla {

    //Atributos
    private int fila;
    private int columna;
    private Pieza pieza;

    //Contructores
    public Casilla() {
    }

    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.pieza = null;
    }

    //G&S
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    //Métodos
    public boolean isOcupada() {
        return this.pieza != null;
    }

    public Pieza vaciarCasilla() {
        Pieza pieza = this.pieza;
        this.pieza = null;
        return pieza;
    }

}
