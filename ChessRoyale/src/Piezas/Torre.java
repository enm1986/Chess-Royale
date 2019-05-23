/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.Jugador;

/**
 * Clase Torre
 *
 * @author infor04
 */
public class Torre extends Pieza {

    private Tipo tipo;

    public Torre(int x, int y, Jugador jugador) {
        super(x, y, jugador);
        this.tipo = Tipo.TORRE;
    }

    @Override
    public boolean movimientoValido(int f_destino, int c_destino) {

        return ((this.x == f_destino) || (this.y == c_destino));
    }

    @Override
    public Tipo getTipo() {
        return this.tipo;
    }

}
