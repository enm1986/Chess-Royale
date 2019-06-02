/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.Casilla;
import Juego.Movimiento;
import Juego.MovimientoAtaque;
import Juego.MovimientoSimple;
import Juego.Tablero;
import java.util.ArrayList;

/**
 * Clase Caballo
 *
 * @author infor04
 */
public class Caballo extends Pieza {

    private final static int[][] COORDENADAS_OFFSET
            = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};

    private final Tipo tipo;

    public Caballo(Color color) {
        super(color);
        this.tipo = Tipo.CABALLO;
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
            coordenadaDestino[0] = origen.getFila() + coordenadaOffset[0];
            coordenadaDestino[1] = origen.getColumna() + coordenadaOffset[1];
            if (coordenadaValida(coordenadaDestino)) {
                Casilla destino = tablero.getCasilla(coordenadaDestino[0], coordenadaDestino[1]);
                if (!destino.isOcupada()) {
                    lista.add(new MovimientoSimple(tablero, origen, destino));
                } else {
                    if (this.getColor() != destino.getPieza().getColor()) {
                        lista.add(new MovimientoAtaque(tablero, origen, destino));
                    }
                }
            }
        }
        return lista;
    }

}
