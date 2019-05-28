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

    public Torre(Jugador jugador) {
        super(jugador);
        this.tipo = Tipo.TORRE;
    }

    @Override
    public boolean movimientoValido(int f_origen, int c_origen, int f_destino, int c_destino) {

        return ((f_origen == f_destino) || (c_origen == c_destino));
    }

    @Override
    public Tipo getTipo() {
        return this.tipo;
    }

}
