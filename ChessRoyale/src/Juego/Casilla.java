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
    private final int fila;
    private final int columna;
    private Pieza pieza;

    //Contructor
    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.pieza = null;
    }

    //G&S
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
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

    public String getDefinicion() {
        return this.getPieza().getTipo().toString().substring(0, 1) + this.getPieza().getColor().toString().substring(0, 1);
    }

    public Pieza vaciarCasilla() {
        Pieza pieza = this.pieza;
        this.pieza = null;
        return pieza;
    }
    
    public void mostrarCasilla(){
        System.out.println("coordenadas: "+this.getFila()+","+this.getColumna());
        if(this.isOcupada()){
            System.out.println("Pieza: "+this.getPieza().getTipo()+" "+this.getPieza().getColor());
        } else {
            System.out.println("Pieza: NO");
        }
        
    }

}
