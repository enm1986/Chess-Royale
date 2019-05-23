/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

/**
 *
 * @author infor04
 */
public final class Tablero {

    private Casilla[][] tablero;

    //constructor
    public Tablero() {
        this.tablero = new Casilla[8][8];
        generarTablero();
    }

    
    public void generarTablero() {
        for (int f = 0; f < tablero.length; f++) {
            for (int c = 0; c < tablero.length; c++) {
                this.tablero[f][c] = new Casilla(f, c);
            }
        }
    }
    
    public Casilla getCasilla(int fila, int columna){
        return this.tablero[fila][columna];
    }
    

}
