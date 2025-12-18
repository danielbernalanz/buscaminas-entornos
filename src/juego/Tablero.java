package juego;

import java.util.Arrays;
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
    }

    /*
    * Devuelve el tablero como cadena
     */
    public String toString() {
        return "Tablero [tablero=" + Arrays.toString(tablero) + ", numMinas=" + numMinas + ", numFilas=" + numFilas
                + ", numColumnas=" + numColumnas + "]";
    }

    /*
	 * Este metodo añadirá minas de forma aleatoria y calculará los números de cada
	 * casilla en función de las minas que haya en las casillas de alrededores.
     */
    public void crearTableroVacio() {//inicialización del tablero del usuario
        tablero = new Casilla[numFilas][numColumnas];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j].setVisible(false);
            }
        }
    }

    public void inicializarTablero() {//inicializacion del tablero del sistema
        //Colocación de las minas aleatorias
        int casillasTot = tablero.length * tablero[0].length;
        for (int i = 0; i < numMinas; i++) {
            int mina = ThreadLocalRandom.current().nextInt(0, casillasTot);
            int filaMina = mina / tablero[0].length;
            int anchuraMina = mina % tablero[0].length;
            if (!tablero[filaMina][anchuraMina].isMina()) { // evita repetidos
                tablero[filaMina][anchuraMina].setMina(true);
            }
        }
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j].setVisible(true); // todas las casillas visibles, para cuando se llame al toSting
            }
        }
    }

    public Casilla[][] getTablero() {
        return tablero;
    }

}
