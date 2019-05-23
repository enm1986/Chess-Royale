/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.Jugador;

/**
 * Clase Rey
 *
 * @author infor04
 */
public class Rey extends Pieza {

    private Tipo tipo;

    public Rey(int x, int y, Jugador jugador) {
        super(x, y, jugador);
        this.tipo = Tipo.REY;
    }

    @Override
    public boolean movimientoValido(int f_destino, int c_destino) {

        int f_diferencia = Math.abs(f_destino - this.x);
        int c_diferencia = Math.abs(c_destino - this.y);

        return ((f_diferencia <= 1) && (c_diferencia <= 1));
    }

    @Override
    public Tipo getTipo() {
        return this.tipo;
    }
}
