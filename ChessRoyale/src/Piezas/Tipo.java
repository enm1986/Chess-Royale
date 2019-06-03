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

        @Override
        public boolean esPeon() {
            return true;
        }
    }, ALFIL {
        @Override
        public boolean esRey() {
            return false;
        }

        @Override
        public boolean esPeon() {
            return false;
        }
    }, TORRE {
        @Override
        public boolean esRey() {
            return false;
        }

        @Override
        public boolean esPeon() {
            return false;
        }
    }, CABALLO {
        @Override
        public boolean esRey() {
            return false;
        }

        @Override
        public boolean esPeon() {
            return false;
        }
    }, DAMA {
        @Override
        public boolean esRey() {
            return false;
        }

        @Override
        public boolean esPeon() {
            return false;
        }
    }, REY {
        @Override
        public boolean esRey() {
            return true;
        }

        @Override
        public boolean esPeon() {
            return false;
        }
    };

    abstract public boolean esRey();

    abstract public boolean esPeon();
}
