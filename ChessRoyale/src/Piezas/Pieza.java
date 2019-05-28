/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.Jugador;

/**
 *
 * @author infor04
 */
public abstract class Pieza {

    protected Jugador jugador;

    public Pieza(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    abstract public boolean movimientoValido(int f_origen, int c_origen, int f_destino, int c_destino);

    abstract public Tipo getTipo();

}
