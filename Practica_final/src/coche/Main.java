package coche;

import java.io.ObjectInputStream.GetField;
import java.util.Random;
import java.util.Scanner;

public class Main {

	//no funciona con 0 humanos o con muchos jugadores bot (mas de 3 por jugador humano)
	//sique saliendo el error de pedir mas jugadores humanos de los que hay en ciertas ocasiones
	public static void main(String[] args) {
		boolean correcto = false;

		boolean terminado = false;
		int numJugadoresBot = 0;
		int numJugadoresHumanos = 0;
		String puesto[];
		int opc = 0;

		double distancia_carrera = 0;

		

		Scanner leerS = new Scanner(System.in);
		Scanner leerI = new Scanner(System.in);
		Scanner leerD = new Scanner(System.in);

		do {
			try {
//						numJugadores=leer el numero(entero)
				System.out.println("cuantos Km tiene el circuito");
				distancia_carrera = leerD.nextDouble();
				correcto = true;
			} catch (Exception e) {
				correcto = false;
			}
		} while (!correcto);
		do {
			leerI = new Scanner(System.in);
			try {
				correcto = true;
				System.out.println("cuantos jugadores humanos hay?");
				numJugadoresHumanos = leerI.nextInt();
				
			} catch (Exception e) {
				correcto = false;
			}

		} while (!correcto);
		
		do {
			leerI = new Scanner(System.in);
			try {
				correcto = true;
				System.out.println("cuantos bot hay?");
				numJugadoresBot = leerI.nextInt();
			} catch (Exception e) {
				correcto = false;
			}

		} while (!correcto);
		
		
		
		
		Carrera carrera = new Carrera("nombreCarrera", distancia_carrera, numJugadoresHumanos, numJugadoresBot);
		
		
		puesto = new String[(numJugadoresHumanos + numJugadoresBot)];

		do {
			opc = Menu.mainMenu();
			leerD = new Scanner(System.in);
			leerI = new Scanner(System.in);
			leerS = new Scanner(System.in);
			switch (opc) {
			case 1:

				carrera.añadirJugadores();

				break;
			case 2:

				correcto = carrera.IniciarCarera();
				break;
			case 3:

				terminado=carrera.juego(correcto, puesto);
				
				for (int i = 0; i < puesto.length; i++) {
					System.out.println( "En el puesto numero "+(i+1)+" " + puesto[i]);
				}
				
				if (terminado)
					opc = 4;
				break;

			default:
				break;
			}

		} while (opc != 4);

	}

}
