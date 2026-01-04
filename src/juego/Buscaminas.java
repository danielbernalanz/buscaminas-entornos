package juego;

import java.util.Scanner;

public class Buscaminas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean funcionamiento = true;
		System.out.println("Con cuantas filas desea jugar?");
		int filasInicio = sc.nextInt();
		System.out.println("Con cuantas columnas desea jugar?");
		int columnasInicio = sc.nextInt();
		System.out.println("Con cuantas minas desea jugar?");
		int minas = sc.nextInt();
		Juego buscaminas = new Juego(minas, filasInicio, columnasInicio);
		while (funcionamiento) {
			System.out.println("0.Salir");
			System.out.println("1.Descubrir");
			System.out.println("2.Poner Bandera");
			System.out.println("3.Quitar Bandera");
			int opcion = sc.nextInt();
			switch (opcion) {
			case 0:
				funcionamiento = false;
				break;
			case 1:
				System.out.println("Fila de casilla a descubrir (empieza en 0)");
				int filaDescubrir = sc.nextInt();
				System.out.println("Columna de casilla a descubrir (empieza en 0)");
				int columnaDescubrir = sc.nextInt();
				buscaminas.descubrirCasilla(filaDescubrir, columnaDescubrir);
				break;
			case 2:
				System.out.println("Fila de casilla a poner bandera (empieza en 0)");
				int filaBandera = sc.nextInt();
				System.out.println("Columna de casilla a poner bandera (empieza en 0)");
				int columnaBandera = sc.nextInt();
				buscaminas.ponerBandera(filaBandera, columnaBandera);
				break;
			case 3:
				System.out.println("Fila de casilla a quitar bandera (empieza en 0)");
				int filaQuitar = sc.nextInt();
				System.out.println("Columna de casilla a quitar bandera (empieza en 0)");
				int columnaQuitar = sc.nextInt();
				buscaminas.quitarBandera(filaQuitar, columnaQuitar);
				break;
			}
			System.out.println("Tablero actual:");
			System.out.println(buscaminas.getTableroUsuario());
			if (!buscaminas.getJuego()) {
				if (buscaminas.getVictoria()) {
					System.out.println("Enhorabuena, has ganado");
				} else {
					System.out.println("Has perdido");
					System.out.println(buscaminas.getTableroReal());
				}
				funcionamiento = false;
			}
		}
		sc.close();
	}
}