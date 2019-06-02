/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import GUI.Ventana;

/**
 *
 * @author infor04
 */
public class chess {

    public static void main(String[] args) {

        
        Tablero tablero = new Tablero();
        tablero.mostrarTablero();
        tablero.getCasilla(2, 1).setPieza(tablero.getCasilla(1, 1).vaciarCasilla());
        tablero.mostrarTablero();
        

        Ventana ventana = new Ventana();

    }
}
