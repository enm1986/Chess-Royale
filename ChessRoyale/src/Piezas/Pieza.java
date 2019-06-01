/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.Color;

/**
 *
 * @author infor04
 */
public abstract class Pieza {

    private Color color;

    public Pieza(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    abstract public Tipo getTipo();

    abstract public boolean movimientoValido(int f_origen, int c_origen, int f_destino, int c_destino);

    public String getNombre() {
        return this.getTipo().toString().substring(0, 1) + this.getColor().toString().substring(0, 1);
    }

}
