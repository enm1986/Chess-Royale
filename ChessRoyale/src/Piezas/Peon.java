/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.Color;

/**
 * Clase Peón
 *
 * @author infor04
 */
public class Peon extends Pieza {

    private final Tipo tipo;
    private boolean movido_1;

    public Peon(Color color) {
        super(color);
        this.movido_1 = false;
        this.tipo = Tipo.PEON;
    }

    public boolean isMovido_1() {
        return movido_1;
    }

    public void setMovido_1(boolean movido_1) {
        this.movido_1 = movido_1;
    }

    @Override
    public boolean movimientoValido(int f_origen, int c_origen, int f_destino, int c_destino) {

        int f_diferencia = Math.abs(f_destino - f_origen);
        int diagonal = Math.abs(c_destino - c_origen);

        boolean valido = false;

        if (f_destino != f_origen) {
            if ((f_destino > f_origen && this.color == Color.NEGRAS)
                    || (f_destino < f_origen && this.color == Color.BLANCAS)) {
                if ((f_diferencia == 1) && ((diagonal == 0) || (diagonal == 1))) { // movimientos válidos del peón
                    valido = true;
                } else if (!isMovido_1()) {
                    if ((f_diferencia == 2) && (diagonal == 0)) { //movimiento válido del peón en primer movimiento
                        valido = true;
                    }
                }
            }
        }
        return valido;
    }

    @Override
    public Tipo getTipo() {
        return this.tipo;
    }

}
