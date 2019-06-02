/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

/**
 *
 * @author infor04
 */
public enum Color {
    BLANCAS {
        @Override
        public int getDireccion() {
            return -1;
        }

        @Override
        public Color cambiarJugador() {
            return NEGRAS;
        }
    }, NEGRAS {
        @Override
        public int getDireccion() {
            return 1;
        }

        @Override
        public Color cambiarJugador() {
            return BLANCAS;
        }
    };

    abstract public int getDireccion();

    abstract public Color cambiarJugador();
}
