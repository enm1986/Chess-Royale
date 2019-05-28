/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.Jugador;

/**
 * Clase Caballo
 *
 * @author infor04
 */
public class Caballo extends Pieza {

    private Tipo tipo;

    public Caballo(Jugador jugador) {
        super(jugador);
        this.tipo = Tipo.CABALLO;
    }

    @Override
    public boolean movimientoValido(int f_origen, int c_origen, int f_destino, int c_destino) {

        int f_diferencia = Math.abs(f_destino - f_origen);
        int c_diferencia = Math.abs(c_destino - c_origen);

        return ((f_diferencia * f_diferencia) + (c_diferencia * c_diferencia) == 5);
    }

    @Override
    public Tipo getTipo() {
        return this.tipo;
    }

}
