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

    protected int x, y;
    protected Jugador jugador;

    public Pieza(int x, int y, Jugador jugador) {
        this.x = x;
        this.y = y;
        this.jugador = jugador;
    }

    abstract public boolean movimientoValido(int f_destino, int c_destino);

    abstract public Tipo getTipo();
}
