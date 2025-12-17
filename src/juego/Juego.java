package juego;

public class Juego {
	Tablero tablero;

	/*
	 * El constructor se encargará de crear el tablero inicial del Juego para poder
	 * empezar a jugar.
	 */
	public Juego(Tablero tablero) {
		this.tablero = tablero;
	}

	public boolean descubrirCasilla() {
		boolean tieneMina = false;
		boolean tieneNumero = false;
		if (tieneMina) {
			// Mostrar minas
			// Terminar juego
		} else if (tieneNumero) {
			// Mostrar número de minas adyacentes
		} else {
			// Descubrir automáticamente el área de casillas blancas adyacentes
		}

		return true;
	}

	public void ponerBandera() {
		
	}

	public void quitarBandera() {

	}

}
