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
 * @author Eugenio Navarro
 * @author Carlos Canovas
 */
public class Caballo extends Pieza {

    /**
     * Offset de coordenadas (fila, columna) que indican las POSICIONES donde
     * puede moverse el Caballo. <br>
     * <br>
     * Posiciones: {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}
     */
    private final static int[][] COORDENADAS_OFFSET
            = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};

    public Caballo(Color color) {
        super(Tipo.CABALLO, color);
    }

    @Override
    public ArrayList<Casilla> movimientosValidos(Tablero tablero, Casilla origen) {
        ArrayList<Casilla> lista = new ArrayList<>();
        int[] coordenadaDestino = {0, 0};
        for (int[] coordenadaOffset : COORDENADAS_OFFSET) {
            // por cada offset se comprueban los movimientos válidos
            coordenadaDestino[0] = origen.getFila() + coordenadaOffset[0]; //añadimos el offset a la posición de la pieza
            coordenadaDestino[1] = origen.getColumna() + coordenadaOffset[1];
            if (coordenadaValida(coordenadaDestino)) { // si la coordenada destino es válida
                Casilla destino = tablero.getCasilla(coordenadaDestino[0], coordenadaDestino[1]);
                if (!destino.isOcupada()) { // si la casilla desino está vacía
                    lista.add(destino); // movimiento válido
                } else { // si está ocupada
                    if (this.getColor() != destino.getPieza().getColor()) { // si está ocupada por el oponente
                        lista.add(destino); // movimiento válido (Ataque)
                    }
                }
            }
        }
        return lista;
    }

}
