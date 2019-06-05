/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import static Juego.ChessRoyale.REY_MAX_MOV;
import Piezas.*;
import java.util.ArrayList;

/**
 * Clase Tablero.
 * <br><br>
 * El tablero de ajedrez.<br>
 * Definido por una array bidimensional de casillas.<br>
 * También contiene información sobre el turno del jugador activo y el estado de
 * la partida (actualmente sólo contempla si es Fin de partida o no)
 *
 * @author Eugenio Navarro
 * @author Carlos Canovas
 */
public class Tablero {

    private Casilla[][] tablero;
    private Color jugadorActivo;
    private boolean fin; // indica el fin de partida

    //constructor
    /**
     * Define el tablero como una Array bidimensional 8x8 de casillas.
     * <br>
     * Al crear el tablero se generan las casillas y se inicializa colocando las
     * piezas y el jugador activo (en el ajedrez siempre empieza el jugador
     * blanco).
     *
     * @see Juego.Casilla
     */
    public Tablero() {
        this.tablero = new Casilla[8][8];
        this.generarTablero();
        this.inicializarTablero();
        this.fin = false;
        this.jugadorActivo = Color.BLANCAS;
    }

    /**
     * Devuelve la casilla del tablero según las coordenadas pasadas.
     *
     * @param fila coordenada X del tablero
     * @param columna coordenada Y del tablero
     * @return Casilla
     */
    public Casilla getCasilla(int fila, int columna) {
        return this.tablero[fila][columna];
    }

    /**
     * Devuelve el Color del jugador activo
     *
     * @return Color
     */
    public Color getJugadorActivo() {
        return jugadorActivo;
    }

    /**
     * Comprueba si se ha terminado la partida.
     *
     * @return boolean
     */
    public boolean isFin() {
        return fin;
    }

    /**
     * Marca el Fin de la partida.
     * <br>
     * Usado cuando se cumple alguna condición de victoria o derrota
     */
    private void setFin() {
        this.fin = true;
    }

    /**
     * Cambia el jugador activo del tablero
     */
    private void cambiarJugadorActivo() {
        this.jugadorActivo = this.jugadorActivo.cambiarJugador();
    }

    /**
     * Reinicia la partida para volver a empezar
     */
    public void reiniciarTablero() {
        this.fin = false;
        this.jugadorActivo = Color.BLANCAS;
        this.generarTablero();
        this.inicializarTablero();
    }

    /**
     * Genera una tablero de 8x8 casillas
     */
    private void generarTablero() {
        for (int f = 0; f < tablero.length; f++) {
            for (int c = 0; c < tablero.length; c++) {
                this.tablero[f][c] = new Casilla(f, c);
            }
        }
    }

    /**
     * Coloca las piezas en las casillas del tablero con la distribución de
     * empezar partida.
     */
    private void inicializarTablero() {
        for (int f = 0; f < tablero.length; f++) {
            for (int c = 0; c < tablero.length; c++) {
                switch (f) {
                    case 0: // primera fila
                        switch (c) { // piezas negras
                            case 0:
                            case 7:
                                this.getCasilla(f, c).setPieza(new Torre(Color.NEGRAS));
                                break;
                            case 1:
                            case 6:
                                this.getCasilla(f, c).setPieza(new Caballo(Color.NEGRAS));
                                break;
                            case 2:
                            case 5:
                                this.getCasilla(f, c).setPieza(new Alfil(Color.NEGRAS));
                                break;
                            case 3:
                                this.getCasilla(f, c).setPieza(new Dama(Color.NEGRAS));
                                break;
                            case 4:
                                this.getCasilla(f, c).setPieza(new Rey(Color.NEGRAS));
                                break;
                        }
                        break;
                    case 1: // segunda fila - peones negros
                        this.getCasilla(f, c).setPieza(new Peon(Color.NEGRAS));
                        break;

                    case 6: // Penúltima fila - peones blancos
                        this.getCasilla(f, c).setPieza(new Peon(Color.BLANCAS));
                        break;

                    case 7: // última fila
                        switch (c) { // piezas negras
                            case 0:
                            case 7:
                                this.getCasilla(f, c).setPieza(new Torre(Color.BLANCAS));
                                break;
                            case 1:
                            case 6:
                                this.getCasilla(f, c).setPieza(new Caballo(Color.BLANCAS));
                                break;
                            case 2:
                            case 5:
                                this.getCasilla(f, c).setPieza(new Alfil(Color.BLANCAS));
                                break;
                            case 3:
                                this.getCasilla(f, c).setPieza(new Dama(Color.BLANCAS));
                                break;
                            case 4:
                                this.getCasilla(f, c).setPieza(new Rey(Color.BLANCAS));
                                break;
                        }
                        break;
                }
            }
        }
    }

    /**
     * Ejecuta el movimiento de una pieza según las casillas de origen y destino
     *
     * @param casillaOrigen Casilla de origen del movimiento
     * @param casillaDestino Casilla de destino del movimiento.
     */
    public void ejecutarJugada(Casilla casillaOrigen, Casilla casillaDestino) {
        // generamos la lista de movimientos válidos de la pieza
        ArrayList<Casilla> lista = new ArrayList<>(casillaOrigen.getPieza().movimientosValidos(this, casillaOrigen));
        boolean movimientoValido = false;
        int i = 0;
        while (!movimientoValido && i < lista.size()) {
            //recorreremos la lista de movimientos válidos hasta que encontremos en ella la casilla destino
            if (lista.get(i) == casillaDestino) {
                movimientoValido = true; // la casilla destino está dentro de los movimientos válidos
                Pieza piezaCapturada = null;
                if (casillaDestino.isOcupada()) { // si la casilla destino está ocupada la vaciamos
                    piezaCapturada = casillaDestino.sacarPieza(); // guardamos la pieza capturada
                }
                casillaDestino.setPieza(casillaOrigen.sacarPieza()); // movemos la pieza de origen a destino
                if (piezaCapturada instanceof Rey) {
                    this.setFin(); // si la pieza capturada es el Rey se termina la partida
                } else {
                    if (casillaDestino.getPieza().getTipo().esRey()) {
                        ((Rey) casillaDestino.getPieza()).setContadorMovimientos();
                        if (((Rey) casillaDestino.getPieza()).getContadorMovimientos() > REY_MAX_MOV) {
                            this.setFin(); // si se ha movido el Rey más de los movimientos máximos permitidos se termina la partida
                        }
                    } else if (casillaDestino.getPieza().getTipo().esPeon()) {
                        // si se ha movido un peón se actualiza a que ya se ha movido
                        ((Peon) casillaDestino.getPieza()).primerMovimientoHecho();
                    }
                    this.cambiarJugadorActivo(); // al final del turno cambiamos el jugador activo
                }
            } else {
                i++;
            }
        }
    }

    /**
     * Muestra el tablero por pantalla.
     * <br><br>
     * Usado para hacer pruebas
     * 
     * @deprecated Se usa una interficie gráfica para ver el tablero
     * @see GUI.Ventana
     */
    public void mostrarTablero() {
        System.out.println("  ___ ___ ___ ___ ___ ___ ___ ___ ");
        for (int f = 0; f < tablero.length; f++) {
            for (int c = 0; c < tablero.length; c++) {
                if (this.getCasilla(f, c).getPieza() != null) {
                    if (this.getCasilla(f, c).getPieza().getColor() == Color.BLANCAS) {
                        System.out.print(" | " + this.getCasilla(f, c).getPieza().getTipo().toString().substring(0, 1).toLowerCase());
                    } else {
                        System.out.print(" | " + this.getCasilla(f, c).getPieza().getTipo().toString().substring(0, 1));
                    }
                } else {
                    System.out.print(" |  ");
                }
            }
            System.out.println(" |");
            System.out.println(" |___|___|___|___|___|___|___|___|");
        }
        System.out.println("");
    }

}
