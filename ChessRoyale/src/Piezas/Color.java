/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

/**
 * Colores de las piezas y jugadores
 *
 * @author Eugenio Navarro
 * @author Carlos Canovas
 */
public enum Color {
    BLANCAS {
        @Override
        int getDireccion() {
            return -1;
        }

        @Override
        public Color cambiarJugador() {
            return NEGRAS;
        }
    }, NEGRAS {
        @Override
        int getDireccion() {
            return 1;
        }

        @Override
        public Color cambiarJugador() {
            return BLANCAS;
        }
    };

    /**
     * Según el color del jugador los peones se moverán en una u otra
     * dirección<br>
     * <br>
     * Se usa como multiplicador en el momento de calcular los movimientos
     * válidos de los peones.<br>
     * <br>
     * Usado exclusivamente por el paquete Piezas
     *
     * @return int
     */
    abstract int getDireccion();

    /**
     * Cambia entre los 2 colores posibles<br>
     * <br>
     * Usado por la clase Tablero
     *
     * @return Color
     */
    abstract public Color cambiarJugador();
}
