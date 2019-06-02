/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.*;
import java.util.ArrayList;

/**
 * Clase Caballo
 *
 * @author infor04
 */
public class Caballo extends Pieza {

    private final static int[][] COORDENADAS_OFFSET
            = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};

    public Caballo(Color color) {
        super(Tipo.CABALLO, color);
    }

    @Override
    public ArrayList<Casilla> movimientosValidos(Tablero tablero, Casilla origen) {
        //ArrayList<Movimiento> lista = new ArrayList<>();
        ArrayList<Casilla> lista = new ArrayList<>();
        int[] coordenadaDestino = {0, 0};

        for (int[] coordenadaOffset : COORDENADAS_OFFSET) {
            coordenadaDestino[0] = origen.getFila() + coordenadaOffset[0];
            coordenadaDestino[1] = origen.getColumna() + coordenadaOffset[1];
            if (coordenadaValida(coordenadaDestino)) {
                Casilla destino = tablero.getCasilla(coordenadaDestino[0], coordenadaDestino[1]);
                if (!destino.isOcupada()) {
                    //lista.add(new MovimientoSimple(tablero, origen, destino));
                    lista.add(destino);
                } else {
                    if (this.getColor() != destino.getPieza().getColor()) {
                        //lista.add(new MovimientoAtaque(tablero, origen, destino));
                        lista.add(destino);
                    }
                }
            }
        }
        return lista;
    }

}
