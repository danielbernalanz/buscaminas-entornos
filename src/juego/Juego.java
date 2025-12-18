package juego;

public class Juego {

    Tablero tableroReal;
    Tablero tableroUsuario;
    boolean juego;
    private int numBanderas; // el usuario debera poner tantas banderas como minas y en las posiciones de las minas
    private int casillasPorVisitar; //

    /*
	 * El constructor se encargará de crear el tablero inicial del Juego para poder
	 * empezar a jugar.
     */
    public Juego(int numMinas, int numFilas, int numColumnas) {
        tableroReal = new Tablero(numMinas, numFilas, numColumnas);
        tableroUsuario = new Tablero(numMinas, numFilas, numColumnas);
        tableroUsuario.crearTableroVacio();
        tableroReal.inicializarTablero();
        numBanderas = numMinas;
        juego = true; // cuando sea false el juego para
        casillasPorVisitar = (tableroReal.getTablero().length * tableroReal.getTablero()[0].length) - numMinas;
    }

    public boolean descubrirCasilla(int fila, int columna) {
        if (!tableroUsuario.getTablero()[fila][columna].isVisible()) {
            if (!tableroUsuario.getTablero()[fila][columna].isBandera()) {
                if (tableroUsuario.getTablero()[fila][columna].isMina()) {
                    juego = false;
                    tableroReal.toString();//Muestra el tablero con las bombas (el tablero del sistema)
                    return false;//Ha perdido ya que exploto una mina
                }
                tableroUsuario.getTablero()[fila][columna].setVisible(true); //se le muestra la casilla al usuario
                casillasPorVisitar--;
                
                
                if (casillasPorVisitar == 0 && numBanderas == 0) { // si ya ha descubierto todas las casillas y ha puesto todas las banderas ne las bombas
                    juego = false; // el juego se acaba
                }
            }// hay bandera, por lo que no se puede revelar
        }
        return false; //la casilla ya es visible o datos erroneos
    }

    public void ponerBandera(int fila, int columna) {
        tableroUsuario.getTablero()[fila][columna].setBandera(true);
        if (tableroUsuario.getTablero()[fila][columna].isMina()) {
            numBanderas--;
            if (numBanderas == 0 && casillasPorVisitar == 0) { // si ya puso tantas banderas como bombas y no quedan casillas por visitar gano
                juego = false;
            }
        }
    }

    public void quitarBandera(int fila, int columna) {
        tableroUsuario.getTablero()[fila][columna].setBandera(false);
        numBanderas++; // no hace falta comrpobar la victoria ya que se gana poniendo una bandera o revelando una casilla, en ningún otro caso se gana
    }

}
