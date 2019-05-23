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
    private String fila;
    private String columna;
    private String casilla;
    private boolean disponible;
    private Pieza pieza;
    
    //Contructores

    public Casilla() {
    }

    public Casilla(String fila, String columna) {
        this.fila = fila;
        this.columna = columna;
        this.casilla = fila+columna;
        this.disponible = true;
        this.pieza = null;
    }
    
    //G&S

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getCasilla() {
        return casilla;
    }

    public void setCasilla(String casilla) {
        this.casilla = casilla;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
    
    
    
}
