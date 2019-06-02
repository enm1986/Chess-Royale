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
    private boolean primer_movimiento;

    public Peon(Color color) {
        super(Tipo.PEON, color);
        this.primer_movimiento = true;
    }

    public boolean isPrimer_movimiento() {
        return primer_movimiento;
    }

    public void setPrimer_movimiento() {
        this.primer_movimiento = false;
    }

    @Override
    public ArrayList<Casilla> movimientosValidos(Tablero tablero, Casilla origen) {
        //ArrayList<Movimiento> lista = new ArrayList<>();
        ArrayList<Casilla> lista = new ArrayList<>();
        int[] coordenadaDestino = {0, 0};
        for (int[] coordenadaOffset : COORDENADAS_OFFSET) {
            coordenadaDestino[0] = origen.getFila() + coordenadaOffset[0] * this.getColor().getDireccion();
            coordenadaDestino[1] = origen.getColumna() + coordenadaOffset[1];
            if (coordenadaValida(coordenadaDestino)) {
                Casilla destino = tablero.getCasilla(coordenadaDestino[0], coordenadaDestino[1]);
                if (coordenadaOffset[1] == 0 && !destino.isOcupada()) {//Movimiento
                    if (coordenadaOffset[0] == 2 && this.isPrimer_movimiento()) {//movimiento de 2 casillas
                        Casilla anterior = tablero.getCasilla(origen.getFila() + this.getColor().getDireccion(), origen.getColumna());
                        if (!anterior.isOcupada()) {
                            //lista.add(new MovimientoSimple(tablero, origen, destino));
                            lista.add(destino);
                        }
                    } else {//movimiento de 1 casilla
                        //lista.add(new MovimientoSimple(tablero, origen, destino));
                        lista.add(destino);
                    }
                } else if (coordenadaOffset[1] != 0 && destino.isOcupada() && this.getColor() != destino.getPieza().getColor()) {//Ataque
                    //lista.add(new MovimientoAtaque(tablero, origen, destino));
                    lista.add(destino);
                }
            }
        }
        return lista;
    }
}
