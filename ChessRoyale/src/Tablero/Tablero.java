/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;

/**
 *
 * @author infor04
 */
public class Tablero {

    private String[] filas = {"8", "7", "6", "5", "4", "3", "2", "1"};
    private String[] columnas = {"a", "b", "c", "d", "e", "f", "g", "h"};

    private Casilla[][] tablero;

    //constructor
    public Tablero() {
        this.tablero = new Casilla[8][8];
        generarTablero();
        inicializarTablero();
    }

    public void generarTablero() {
        for (int f = 0; f < tablero.length; f++) {
            for (int c = 0; c < tablero[0].length; c++) {
                tablero[f][c] = new Casilla(filas[f], columnas[c]);

            }
        }
    }
    
    public void inicializarTablero() {
        
    }
    

}
