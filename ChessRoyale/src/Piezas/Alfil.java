/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.Jugador;

/**
 * Clase Alfil
 *
 * @author infor04
 */
public class Alfil extends Pieza {

    private Tipo tipo;

    public Alfil(int x, int y, Jugador jugador) {
        super(x, y, jugador);
        this.tipo = Tipo.ALFIL;
    }

    @Override
    public boolean movimientoValido(int f_destino, int c_destino) {

        int f_diferencia = Math.abs(f_destino - this.x);
        int c_diferencia = Math.abs(c_destino - this.y);

        return (f_diferencia == c_diferencia);
    }

    @Override
    public Tipo getTipo() {
        return this.tipo;
    }

}
