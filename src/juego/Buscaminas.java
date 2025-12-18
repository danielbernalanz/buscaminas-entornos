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
                    System.out.println("Fils de casilla a descubrir (empieza en 0)");
                    int fila = sc.nextInt();
                    System.out.println("Columna de casilla a descubrir (empieza en 0)");
                    int columna = sc.nextInt();
                    buscaminas.descubrirCasilla(fila, columna);
                    break;
                case 2:

                    break;
                case 3:

                    break;
            }
        }
    }
}