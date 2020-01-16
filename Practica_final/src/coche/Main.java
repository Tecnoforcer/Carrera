package coche;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean correcto = false;
		int opc = 0;
		int opcAUX = 0;
		int numJugadores = 1;
		int dorsal = 0;
		String nombre_piloto = "";
		double distancia_carrera = 0;
		Coche c[];

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
				// TODO: handle exception
			}
		} while (!correcto);

		c = new Coche[numJugadores];

		do {
			opc = Menu.mainMenu();
			switch (opc) {
			case 1:

				for (int i = 0; i < c.length; i++) {
					do {
						try {
							correcto = true;
							System.out.println("escribe el dorsal");
							dorsal = leerI.nextInt();

							nombre_piloto = leerS.nextLine();
						} catch (Exception e) {
							correcto = false;
						}
					} while (!correcto);
					c[i] = new Coche(nombre_piloto, dorsal, distancia_carrera);
				}

				break;
			// fin opc 1
			// :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
			case 2:
				for (int i = 0; i < c.length; i++) {
					c[i].setEstado("marcha");
				}
				break;
			case 3:// meter esto en un metodo y que se vaya repitiendo

				if (correcto) {
					
					//dentro metodo
					
					for (int i = 0; i < c.length; i++) {
						opcAUX = Menu.gameMenu();
						switch (opcAUX) {
						case 1:
							c[i].acelerar();
							break;
						case 2:
							c[i].frenar();
							break;
						case 3:
							c[i].reArrancarCoche();
							break;

						default:
							break;
						}
					}
					
					
					
					
					//fin dentro metodo
				} else {
					System.out.println("inicia la carrera");
				}

				break;

			default:
				break;
			}

		} while (opc != 4);

	}

}
