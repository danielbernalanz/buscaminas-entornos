package juego;

public class Juego {

	private Tablero tableroReal;
	private Tablero tableroUsuario;
	private boolean juego;
	private boolean victoria;
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
		victoria = false;
		juego = true; // cuando sea false el juego para
		casillasPorVisitar = (tableroReal.getTablero().length * tableroReal.getTablero()[0].length) - numMinas;
	}

	public boolean descubrirCasilla(int fila, int columna) {
		if (fila < 0 || fila >= tableroReal.getTablero().length || columna < 0
				|| columna >= tableroReal.getTablero()[0].length) {
			return false; // la casilla esta fuera del tablero
		}
		if (!tableroUsuario.getTablero()[fila][columna].isVisible()) {
			if (!tableroUsuario.getTablero()[fila][columna].isBandera()) {
				if (tableroReal.getTablero()[fila][columna].isMina()) {
					juego = false;
					tableroReal.toString();// Muestra el tablero con las bombas (el tablero del sistema)
					return false;// Ha perdido ya que exploto una mina
				}
				tableroUsuario.getTablero()[fila][columna].setVisible(true); // se le muestra la casilla al usuario
																				// mostrando numero
				Casilla real = tableroReal.getTablero()[fila][columna];
				Casilla usuario = tableroUsuario.getTablero()[fila][columna];

				usuario.setNumero(real.getNumero());
				usuario.setBlanco(real.isBlanco());
				casillasPorVisitar--;
				if (tableroUsuario.getTablero()[fila][columna].isBlanco()) { // si es vacia se muestran las que lo
																				// rodean
					descubrirCasilla(fila - 1, columna - 1);
					descubrirCasilla(fila - 1, columna);
					descubrirCasilla(fila - 1, columna + 1);
					descubrirCasilla(fila, columna - 1);
					descubrirCasilla(fila, columna + 1);
					descubrirCasilla(fila + 1, columna - 1);
					descubrirCasilla(fila + 1, columna);
					descubrirCasilla(fila + 1, columna + 1);
				}
				if (casillasPorVisitar == 0 && numBanderas == 0) { // si ya ha descubierto todas las casillas y ha
																	// puesto todas las banderas ne las bombas
					victoria = true; // para distinguir cuando se acaba la partida por mina o porque hemos ganado
					juego = false; // el juego se acaba
				}
			} // hay bandera, por lo que no se puede revelar
		}
		return false; // la casilla ya es visible o datos erroneos
	}

	public void ponerBandera(int fila, int columna) {
	    if (fila < 0 || fila >= tableroUsuario.getTablero().length ||
	        columna < 0 || columna >= tableroUsuario.getTablero()[0].length) {
	        return;
	    }

	    Casilla c = tableroUsuario.getTablero()[fila][columna];

	    if (!c.isVisible() && !c.isBandera() && numBanderas > 0) {
	        c.setBandera(true); // solo bandera si la casilla no es visible
	        if (tableroReal.getTablero()[fila][columna].isMina()) {
	            numBanderas--;
	        }
	    }
	}

	public boolean getJuego() {
		return juego;
	}

	public boolean getVictoria() {
		return victoria;
	}

	public Tablero getTableroUsuario() {
		return tableroUsuario;
	}
	
	public Tablero getTableroReal() {
		return tableroReal;
	}

	public void quitarBandera(int fila, int columna) {
		Casilla c = tableroUsuario.getTablero()[fila][columna];
	    if (c.isBandera()) {
	        c.setBandera(false);
	        numBanderas++; // no se comprueba la victoria porque se gana poniendo bandera o desvelando la ultima casilla
	    }
	}

}
