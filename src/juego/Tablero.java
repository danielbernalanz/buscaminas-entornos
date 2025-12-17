package juego;

import java.util.Arrays;

public class Tablero {
	private Casilla[][] tablero;
	private int numMinas;
	private int numFilas;
	private int numColumnas;

	public Tablero(int numMinas, int numFilas, int numColumnas) {
		/*
		 * El constructor se encargará de inicializar cada atributo según parámetros y
		 * creará el tablero con Casillas “vacías”,
		 */
		this.numMinas = numMinas;
		this.numFilas = numFilas;
		this.numColumnas = numColumnas;
		
		tablero = new Casilla[numFilas][numColumnas];
	}

	/*
	 * Devolve el tablero como cadena
	 */
	public String toString() {
		return "Tablero [tablero=" + Arrays.toString(tablero) + ", numMinas=" + numMinas + ", numFilas=" + numFilas
				+ ", numColumnas=" + numColumnas + "]";
	}

	/*
	 * Este metodo añadirá minas de forma aleatoria y calculará los números de cada
	 * casilla en función de las minas que haya en las casillas de alrededores.
	 */
	public void inicializarTablero() {
		
	}

}
