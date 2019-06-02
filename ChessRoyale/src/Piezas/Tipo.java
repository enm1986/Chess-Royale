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
public enum Tipo {
    PEON {
        @Override
        public boolean esRey() {
            return false;
        }
    }, ALFIL {
        @Override
        public boolean esRey() {
            return false;
        }
    }, TORRE {
        @Override
        public boolean esRey() {
            return false;
        }
    }, CABALLO {
        @Override
        public boolean esRey() {
            return false;
        }
    }, DAMA {
        @Override
        public boolean esRey() {
            return false;
        }
    }, REY {
        @Override
        public boolean esRey() {
            return true;
        }
    };

    abstract public boolean esRey();
}
