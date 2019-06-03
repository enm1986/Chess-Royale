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
 * Clase Torre
 *
 * @author infor04
 */
public class Torre extends Pieza {

    private final static int[][] COORDENADAS_OFFSET
            = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public Torre(Color color) {
        super(Tipo.TORRE, color);
    }

    @Override
    public ArrayList<Casilla> movimientosValidos(Tablero tablero, Casilla origen) {
        ArrayList<Casilla> lista = new ArrayList<>();
        int[] coordenadaDestino = {0, 0};
        for (int[] coordenadaOffset : COORDENADAS_OFFSET) {
            coordenadaDestino[0] = origen.getFila() + coordenadaOffset[0];
            coordenadaDestino[1] = origen.getColumna() + coordenadaOffset[1];
            boolean piezaBloquea = false;
            while (coordenadaValida(coordenadaDestino) && !piezaBloquea) {
                Casilla destino = tablero.getCasilla(coordenadaDestino[0], coordenadaDestino[1]);
                if (!destino.isOcupada()) {
                    lista.add(destino);
                } else {
                    if (this.getColor() != destino.getPieza().getColor()) {
                        lista.add(destino);
                    }
                    piezaBloquea = true;
                }
                if (!piezaBloquea) {
                    coordenadaDestino[0] = coordenadaDestino[0] + coordenadaOffset[0];
                    coordenadaDestino[1] = coordenadaDestino[1] + coordenadaOffset[1];
                }
            }
        }
        return lista;
    }
}
