/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import GUI.Ventana2;

/**
 *
 * @author infor04
 */
public class chess {

    public static void main(String[] args) {
        Tablero t = new Tablero();
        
        Jugador blanco = new Jugador("Eugenio", Color.BLANCAS);
        Jugador negro = new Jugador("Carlos", Color.NEGRAS);
        t.inicializarTablero();
        t.mostrarTablero();
        
        Ventana2 ventana = new Ventana2();

    }
}
