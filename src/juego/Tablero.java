package juego;

import java.util.concurrent.ThreadLocalRandom;

public class Tablero {

	private Casilla[][] tablero;
	private int numMinas;
	private int numFilas;
	private int numColumnas;

	/*
	 * El constructor se encargará de inicializar cada atributo según parámetros y
	 * creará el tablero con Casillas “vacías”,
	 */
	public Tablero(int numMinas, int numFilas, int numColumnas) {
		this.numMinas = numMinas;
		this.numFilas = numFilas;
		this.numColumnas = numColumnas;
		tablero = new Casilla[numFilas][numColumnas];
		for (int i = 0; i < numFilas; i++) {
			for (int j = 0; j < numColumnas; j++) {
				tablero[i][j] = new Casilla();
				tablero[i][j].setVisible(false);
			}
		}
	}

	/*
	 * Devuelve el tablero como cadena
	 */
	public String toString() {
		String cadena = "   "; // se meten 3 espacios debido al formato
		// impresión de la parte de arriba del tablero
		for (int i = 0; i < numColumnas; i++) {
			cadena += i + " ";
		}
		// impresion de la parte central del tablero
		for (int i = 0; i < numFilas; i++) {
			cadena += i + " |";
			for (int j = 0; j < numColumnas; j++) {
				cadena += tablero[i][j] + " ";
			}
			cadena+="\n";
		}
		// impresion de la parte de abajo del tablero
		cadena += "   ";
		for (int i = 0; i < numColumnas; i++) {
			cadena += i + " ";
		}
		return cadena;
	}

	/*
	 * Este metodo añadirá minas de forma aleatoria y calculará los números de cada
	 * casilla en función de las minas que haya en las casillas de alrededores.
	 */
	public void crearTableroVacio() {// inicialización del tablero del usuario
		tablero = new Casilla[numFilas][numColumnas];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j] = new Casilla(); // hay que crearla para que no de error de null point
				tablero[i][j].setVisible(false);
			}
		}
	}

	public void inicializarTablero() {// inicializacion del tablero del sistema
		// Colocación de las minas aleatorias
		int casillasTot = tablero.length * tablero[0].length;
		for (int i = 0; i < numMinas; i++) {
			int mina = ThreadLocalRandom.current().nextInt(0, casillasTot);
			int filaMina = mina / tablero[0].length;
			int anchuraMina = mina % tablero[0].length;
			
			if (!tablero[filaMina][anchuraMina].isMina()) { // evita repetidos
				tablero[filaMina][anchuraMina].setMina(true);
			} else {
			    i--; // repite porque no ha puesto la mina
			}
		}
		
		calcularNumeros();
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j].setVisible(true); // todas las casillas visibles, para cuando se llame al toString
			}
		}
	}
	
	private void calcularNumeros() {
	    for (int i = 0; i < numFilas; i++) {
	        for (int j = 0; j < numColumnas; j++) {

	            if (!tablero[i][j].isMina()) {
	                int minas = contarMinasAlrededor(i, j);
	                tablero[i][j].setNumero(minas);
	                tablero[i][j].setBlanco(minas == 0);
	            }
	        }
	    }
	}
	
	private int contarMinasAlrededor(int fila, int columna) {
	    int contador = 0;

	    for (int i = fila - 1; i <= fila + 1; i++) {
	        for (int j = columna - 1; j <= columna + 1; j++) {

	            if (i >= 0 && i < numFilas && j >= 0 && j < numColumnas) {

	                if (!(i == fila && j == columna)) { //para evitar contar la propia casilla
	                    if (tablero[i][j].isMina()) {
	                        contador++;
	                    }
	                }
	            }
	        }
	    }
	    return contador;
	}

	public Casilla[][] getTablero() {
		return tablero;
	}

}
