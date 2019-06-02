/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.*;
import static Piezas.Pieza.coordenadaValida;
import java.util.ArrayList;

/**
 * Clase Peón
 *
 * @author infor04
 */
public class Peon extends Pieza {

    private final static int[][] COORDENADAS_OFFSET = {{1, 0}, {2, 0}, {1, -1}, {1, 1}};
    private final Tipo tipo;
    private boolean primer_movimiento;

    public Peon(Color color) {
        super(color);
        this.primer_movimiento = true;
        this.tipo = Tipo.PEON;
    }

    public boolean isPrimer_movimiento() {
        return primer_movimiento;
    }

    public void setPrimer_movimiento() {
        this.primer_movimiento = false;
    }

    @Override
    public Tipo getTipo() {
        return this.tipo;
    }

    @Override
    public ArrayList<Movimiento> movimientosValidos(Tablero tablero, Casilla origen) {
        ArrayList<Movimiento> lista = new ArrayList<>();
        int[] coordenadaDestino = {0, 0};
        for (int[] coordenadaOffset : COORDENADAS_OFFSET) {
            coordenadaDestino[0] = origen.getFila() + coordenadaOffset[0] * this.getColor().getDireccion();
            coordenadaDestino[1] = origen.getColumna() + coordenadaOffset[1];
            if (coordenadaValida(coordenadaDestino)) {
                Casilla destino = tablero.getCasilla(coordenadaDestino[0], coordenadaDestino[1]);
                if (coordenadaOffset[1] == 0 && !destino.isOcupada()) {//Movimiento
                    if (coordenadaOffset[0] == 2 && this.isPrimer_movimiento()) {//movimiento de 2 casillas
                        lista.add(new MovimientoSimple(tablero, origen, destino));
                    } else {//movimiento de 1 casilla
                        lista.add(new MovimientoSimple(tablero, origen, destino));
                    }
                } else {//Ataque
                    if (this.getColor() != destino.getPieza().getColor()) {
                        lista.add(new MovimientoAtaque(tablero, origen, destino));
                    }
                }
            }
        }
        return lista;
    }
}
