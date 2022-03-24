package tresenrayabackend;

public class TresEnRaya {

    private boolean turno; // true =x  , false = 0
    private  char [][] tablero ;
    private final char JUGADOR1 = 'X';
    private final char JUGADOR2 = 'O';
    private final char VACIO = ' ';

    public TresEnRaya() {
        tablero =  new char[3][3];
        turno = true;
        crearTablero();
    }

    public boolean jugar(int fila, int col) {
        boolean seInserto = false;
        if(esValido(fila,col) && esCasillaDisponible(fila,col)){
            if (turno) {
                tablero[fila][col] = JUGADOR1;
                seInserto = true;
                cambiarTurno();

            } else {
                tablero[fila][col] = JUGADOR2;
                seInserto = true;
                cambiarTurno();
            }
        }
        return seInserto;
    }

    public boolean tie(){
        return estaLlenoTablero() && !hayTresEnRaya();
    }

    public String obtenerGanador(){
        String estado = "VACIO";
        if(hayTresEnRaya()){
            estado = getTipoGanador();
        }

        return estado;
    }

    public boolean hayTresEnRaya() {
        return (verificarFilasYColumnas() || verificarDiagonales());
    }

    public String toString(){
     String cadTablero = "";
     for (int fila = 0 ; fila < tablero.length ; fila++){
         for(int col = 0 ; col < tablero[0].length;col++){
             cadTablero += " | "+ tablero[fila][col]+" "+" | ";
         }
         cadTablero+="\n";
     }
     cadTablero+="\n"+"Ganador es:"+obtenerGanador();
     return cadTablero;
    }


    private void crearTablero(){
        for(int fila = 0 ; fila < tablero.length ; fila++){
            for(int col = 0 ; col < tablero[0].length ; col++){
                tablero[fila][col] = VACIO;
            }
        }
    }

    private boolean estaLlenoTablero(){
        boolean resp = false;
        int cont =0 ;
        for(int fila = 0 ; fila < tablero.length ; fila++){
            for(int col = 0 ; col < tablero[0].length ; col++){
                if (tablero[fila][col] == JUGADOR1 || tablero[fila][col] == JUGADOR2){
                    cont++;
                }
            }
        }
        if(cont==9){
            resp = true;
        }
        return resp;
    }

    private boolean esValido(int i, int j) {
        return i >= 0 && i < tablero.length && j >= 0 && j < tablero[0].length;
    }

    private boolean esCasillaDisponible(int i, int j) {
        boolean resp = false;
        if (tablero[i][j] == VACIO) {
            resp = true;
        }
        return resp;
    }

    private void cambiarTurno() {
        turno = !turno;
    }

    private String getTipoGanador(){
        String ganador = "VACIO";
        if(verificaUnaFilaYUnaColumna((JUGADOR1))|| verificarDiagonales(JUGADOR1)){
            ganador ="JUGADOR1";
        }
        else if(verificaUnaFilaYUnaColumna(JUGADOR2) || verificarDiagonales(JUGADOR2)) {
            ganador = "JUGADOR2";
        }
        return ganador;
    }

    private boolean verificarFilasYColumnas() {
        return verificaUnaFilaYUnaColumna(JUGADOR1)|| verificaUnaFilaYUnaColumna(JUGADOR2) ;
    }

    private boolean verificaUnaFilaYUnaColumna(char jugador) {
        boolean banderaRespuesta = false;

        for(int fila = 0 ; fila < tablero.length ; fila++){
            int contFila = 0;
            int contCol = 0;
            for(int col = 0 ; col < tablero[0].length ; col++){
                if (tablero[fila][col]==jugador){ // fila
                    contFila++;
                }

                if(tablero[col][fila]==jugador){ // col
                    contCol++;
                }
            }
            if(contFila==tablero.length || contCol==tablero[0].length){
                banderaRespuesta = true;
                break;

            }
        }
        return banderaRespuesta;
    }

    private boolean verificarDiagonales(){
        return verificarDiagonales(JUGADOR1) || verificarDiagonales(JUGADOR2);
    }

    private boolean verificarDiagonales(char jugador) {
        boolean bandera = false;
        int contadorDP = 1;
        int contadorDS = 1;
        int tam = tablero.length - 1;
        for(int fila = 0  ; fila < tablero.length -1 ; fila++){
            if (tablero[fila][fila] == jugador && tablero[fila][fila] == tablero[fila + 1][fila + 1]) {
                contadorDP++;
            } else if (tablero[fila][tam - fila] == jugador && tablero[fila][tam - fila] == tablero[fila + 1][(tam - fila) - 1]) {
                contadorDS++;
            }
        }
        if (contadorDP == tablero.length || contadorDS == tablero.length) {
            bandera = true;
        }

        return bandera;
    }

}


