package juego;

public class Juego {

	private Tablero tableroReal;
	private Tablero tableroUsuario;
	private boolean juego;
	private int numBanderas; // el usuario debera poner tantas banderas como minas y en las posiciones de las
								// minas
	private int casillasPorVisitar; // las casillas que al jugador le quedan por revelar

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
		if (fila > tableroReal.getTablero().length || columna > tableroReal.getTablero()[fila].length || fila < 0
				|| columna < 0) {
			if (!tableroUsuario.getTablero()[fila][columna].isVisible()) {
				if (!tableroUsuario.getTablero()[fila][columna].isBandera()) {
					if (tableroUsuario.getTablero()[fila][columna].isMina()) {
						juego = false;
						tableroReal.toString();// Muestra el tablero con las bombas (el tablero del sistema)
						return false;// Ha perdido ya que exploto una mina
					}
					tableroUsuario.getTablero()[fila][columna].setVisible(true); // se le muestra la casilla al usuario
																					// mostrando numero
					casillasPorVisitar--;
					if (tableroUsuario.getTablero()[fila][columna].isBlanco()) { // si es vacia se muestran las que lo
																					// rodean
						descubrirCasilla(fila - 1, columna - 1);
						descubrirCasilla(fila - 1, columna);
						descubrirCasilla(fila - 1, columna + 1);
						descubrirCasilla(fila, columna - 1);
						descubrirCasilla(fila, columna + 1);
						descubrirCasilla(fila + 1, columna - 1);
						descubrirCasilla(fila + 1, columna + 1);
					}
					if (casillasPorVisitar == 0 && numBanderas == 0) { // si ya ha descubierto todas las casillas y ha
																		// puesto todas las banderas ne las bombas
						juego = false; // el juego se acaba
					}
				} // hay bandera, por lo que no se puede revelar
			}
			return false; // la casilla ya es visible o datos erroneos
		}
		return false; // la casilla esta fuera del tablero
	}

	public void ponerBandera(int fila, int columna) {
		if (!tableroUsuario.getTablero()[fila][columna].isVisible()) {// solo bandera si la casilla no es visible
			tableroUsuario.getTablero()[fila][columna].setBandera(true);
			if (tableroUsuario.getTablero()[fila][columna].isMina()) {
				numBanderas--;
				if (numBanderas == 0 && casillasPorVisitar == 0) { // si ya puso tantas banderas como bombas y no quedan
																	// casillas por visitar gano
					juego = false;
				}
			}
		}
	}

	public boolean getJuego() {
		return juego;
	}

	public void quitarBandera(int fila, int columna) {
		tableroUsuario.getTablero()[fila][columna].setBandera(false);
		numBanderas++; // no hace falta comrpobar la victoria ya que se gana poniendo una bandera o
						// revelando una casilla, en ningún otro caso se gana
	}

}
