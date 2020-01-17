package coche;

import java.io.ObjectInputStream.GetField;
import java.util.Random;
import java.util.Scanner;

public class Main {

	private static boolean jugar(Coche c[], int jugadores) {
		boolean juegoTerminado = false;
		boolean terminado = false;// sobra?
		int opcAUX = 0;
		int botaction = 0;
		int hanterminado = 0;
		Random r;
		do {

			for (int i = 0; i < c.length; i++) {
				if (!c[i].isTerminado() && !c[i].isBot()) {

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

					if (c[i].getKm_recorridos() >= c[i].getDistancia_carrera()) {
						c[i].setTerminado(true);
						System.out.println("has terminado");
					}
				} else if (!c[i].isTerminado() && c[i].isBot()) {
					r = new Random();
					botaction = r.nextInt(2);
					System.out.println(botaction);

					if (c[i].getEstado().equalsIgnoreCase("accidentado")) {
						botaction = 3;
					}
					switch (botaction) {
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

					if (c[i].getKm_recorridos() >= c[i].getDistancia_carrera()) {
						c[i].setTerminado(true);
						System.out.println("has terminado");
					}
				}
			}

			for (int i = 0; i < c.length; i++) {
				hanterminado = 0;
				if (c[i].isTerminado() == true || (c[i].getEstado().equalsIgnoreCase("accidentado") && jugadores > 1)) {
					hanterminado++;
				}
				if (hanterminado == jugadores) {
					juegoTerminado = true;
				}
			}
		} while (!juegoTerminado);

		return juegoTerminado;
	}

	private static int dorsalBot() {
		int dorsal = 0;
		Random r = new Random();

		dorsal = r.nextInt(4);

		return dorsal;
	}

	public static void main(String[] args) {
		boolean correcto = false;
		boolean bot = false;
		int numJugadoresBot = 1;
		int numJugadoresHumanos = 1;// not implemented
		int dorsal = 0;
		int opc = 0;
		String nombre_piloto = "";
		double distancia_carrera = 0;
		int cont = 0;
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
		do {
			leerI = new Scanner(System.in);
			try {
				System.out.println("cuantos jugadores humanos hay?");
				numJugadoresHumanos = leerI.nextInt();
				System.out.println("cuantos bot hay?");
				numJugadoresBot = leerI.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
			}

		} while (!correcto);
		c = new Coche[(numJugadoresHumanos + numJugadoresBot)];

		do {
			opc = Menu.mainMenu();
			leerD = new Scanner(System.in);
			leerI = new Scanner(System.in);
			leerS = new Scanner(System.in);
			switch (opc) {
			case 1:

				for (int i = 0; i < c.length; i++) {
					do {
						try {
							correcto = true;

							if (numJugadoresHumanos != 0 && cont <= numJugadoresHumanos) {
								System.out.println("escribe el dorsal");
								dorsal = leerI.nextInt();
								for (int j = 0; j < numJugadoresHumanos; j++) {
									do {
										correcto=true;
										if (c[j] != null && (c[j].getDorsal() == dorsal)) {
										System.out.println("el dorsal ya esta escogido");
										correcto = false;
										cont--;
										j--;
									}
									} while (!correcto);
									
									
								}

								System.out.println("escribe el nombre");
								nombre_piloto = leerS.nextLine();
								bot = false;
								cont++;
							} else if (cont <= (numJugadoresBot + numJugadoresHumanos)) {

								for (int j = (numJugadoresHumanos - 1); j < numJugadoresBot; j++) {

									do {
										correcto=true;
										dorsal = dorsalBot();

										nombre_piloto = "bot " + (i + 1 - (numJugadoresHumanos));
										for (int p = 0; p < c.length; p++) {
											if (c[p] != null && (c[p].getDorsal() == dorsal)) {

												correcto = false;
												cont--;
												j--;
											}
										}

									} while (!correcto);
								}
							}
						} catch (Exception e) {
							correcto = false;
						}
					} while (!correcto);
					c[i] = new Coche(nombre_piloto, dorsal, distancia_carrera, bot);
				}

				break;
			// fin opc 1
			// :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
			case 2:

				for (int i = 0; i < c.length; i++) {
					if (c[i] == null) {
						System.out.println("la carrera no se configuro correctamente");
						for (int j = 0; j < c.length; j++) {
							c[j] = null;
							correcto = false;
						}
						break;
					} else {
						c[i].setEstado("marcha");
						correcto = true;
					}
				}
				break;
			case 3:

				if (correcto && (numJugadoresHumanos > 0)) {

					jugar(c, (numJugadoresHumanos + numJugadoresBot));

				} else if (numJugadoresHumanos > 0) {
					System.out.println("inicia la carrera");
				} else {
					System.out.println("NO TIENES PERMISO, es una carrera exclusiva de bots");
				}

				break;

			default:
				break;
			}

		} while (opc != 4);

	}

}
