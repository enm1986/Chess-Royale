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
public class chess {

    public static void main(String[] args) {
        Tablero t = new Tablero();
        Jugador blanco = new Jugador("Eugenio", Color.BLANCAS);
        Jugador negro = new Jugador("Carlos", Color.NEGRAS);
        t.inicializarTablero(blanco, negro);
        t.mostrarTablero();
        
        if(t.getCasilla(1,0).getPieza().movimientoValido(1,0, 0,0)){
            System.out.println("Movimiento válido");
        }else{
            System.out.println("Movimiento NO válido");
        }
    }
}
