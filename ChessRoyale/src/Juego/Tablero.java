/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Piezas.Color;
import Piezas.*;
import java.util.ArrayList;

/**
 *
 * @author infor04
 */
public class Tablero {

    private Casilla[][] tablero;
    private Color jugadorActivo;
    private boolean fin;

    //constructor
    public Tablero() {
        this.tablero = new Casilla[8][8];
        this.generarTablero();
        this.inicializarTablero();
        this.fin = false;
        this.jugadorActivo = Color.BLANCAS;
    }

    public Casilla getCasilla(int fila, int columna) {
        return this.tablero[fila][columna];
    }

    public Color getJugadorActivo() {
        return jugadorActivo;
    }

    public boolean isFin() {
        return fin;
    }

    private void setFin() {
        this.fin = true;
    }

    private void cambiarJugadorActivo() {
        this.jugadorActivo = this.jugadorActivo.cambiarJugador();
    }
    
    public void reiniciarTablero(){
        this.fin = false;
        this.jugadorActivo = Color.BLANCAS;
        this.generarTablero();
        this.inicializarTablero();
    }

    private void generarTablero() {
        for (int f = 0; f < tablero.length; f++) {
            for (int c = 0; c < tablero.length; c++) {
                this.tablero[f][c] = new Casilla(f, c);
            }
        }
    }

    private void inicializarTablero() {
        for (int f = 0; f < tablero.length; f++) {
            for (int c = 0; c < tablero.length; c++) {
                switch (f) {
                    case 0: // primera fila
                        switch (c) { // piezas blancas
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
                    case 1: // segunda fila - peones blancos
                        this.getCasilla(f, c).setPieza(new Peon(Color.NEGRAS));
                        break;

                    case 6: // Penúltima fila - peones negros
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

    public void ejecutarJugada(Casilla casillaOrigen, Casilla casillaDestino) {
        ArrayList<Casilla> lista = casillaOrigen.getPieza().movimientosValidos(this, casillaOrigen);
        boolean movimientoValido = false;
        int i = 0;
        while (!movimientoValido && i < lista.size()) {
            if (lista.get(i) == casillaDestino) {
                movimientoValido = true;
                Pieza piezaCapturada = null;
                if (casillaDestino.isOcupada()) {
                    piezaCapturada = casillaDestino.sacarPieza();
                }
                casillaDestino.setPieza(casillaOrigen.sacarPieza()); 
                if (piezaCapturada instanceof Rey) {
                    this.setFin();
                } else {
                    if(casillaDestino.getPieza().getTipo().esRey()){
                        ((Rey)casillaDestino.getPieza()).setContadorMovimientos();
                        if (((Rey)casillaDestino.getPieza()).getContadorMovimientos()>10){
                            this.setFin();
                        }
                    }
                    this.cambiarJugadorActivo();
                }
            } else {
                i++;
            }
        }
    }

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
