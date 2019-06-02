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
    }, NEGRAS {
        @Override
        public int getDireccion() {
            return 1;
        }
    };

    abstract public int getDireccion();
}
