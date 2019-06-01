/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.Color;

/**
 * Clase Rey
 *
 * @author infor04
 */
public class Rey extends Pieza {

    private final Tipo tipo;

    public Rey(Color color) {
        super(color);
        this.tipo = Tipo.REY;
    }

    @Override
    public boolean movimientoValido(int f_origen, int c_origen, int f_destino, int c_destino) {

        int f_diferencia = Math.abs(f_destino - f_origen);
        int c_diferencia = Math.abs(c_destino - c_origen);

        return ((f_diferencia <= 1) && (c_diferencia <= 1));
    }

    @Override
    public Tipo getTipo() {
        return this.tipo;
    }
}
