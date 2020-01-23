package coche;

import java.util.Random;
import java.util.Scanner;

public class Carrera {
	private String nombreCarrera;
	private double distancia;
	private Coche[] vCoches;
	private int numJugadoresHumanos;
	private int numJugadoresBot;

	public Carrera(String nombreCarrera, double distancia, int numJugadoresHumanos, int numJugadoresBot) {
		this.nombreCarrera = nombreCarrera;
		this.distancia = distancia;
		this.numJugadoresBot = numJugadoresBot;
		this.numJugadoresHumanos = numJugadoresHumanos;
		vCoches = new Coche[(this.numJugadoresBot + this.numJugadoresHumanos)];
	}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::añadir_jugadores:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private static int dorsalBot() {
		int dorsal = 0;
		Random r = new Random();

		dorsal = r.nextInt();

		return dorsal;
	}

	public void añadirJugadores() {
		Scanner leerS = new Scanner(System.in);
		Scanner leerI = new Scanner(System.in);
		Scanner leerD = new Scanner(System.in);

		boolean correcto = false;
		int cont = 1;
		int dorsal = 0;
		String nombre_piloto = "";
		boolean bot = false;

		for (int i = 0; i < vCoches.length; i++) {
			do {
				leerS = new Scanner(System.in);
				leerS = new Scanner(System.in);
				try {
					correcto = true;

					if (cont <= numJugadoresHumanos && numJugadoresHumanos != 0) {
						leerI = new Scanner(System.in);
						leerS = new Scanner(System.in);
						correcto = true;
						System.out.println("escribe el dorsal     (numero entero)");
						dorsal = leerI.nextInt();
						correcto = true;
						for (int j = 0; j < numJugadoresHumanos; j++) {
							if (vCoches[j] != null && (vCoches[j].getDorsal() == dorsal)) {
								System.out.println("el dorsal ya esta escogido");
								correcto = false;
								cont--;
								break;
							}
						}
						if (correcto) {
							System.out.println("escribe el nombre");
							nombre_piloto = leerS.nextLine();
							bot = false;
						}

						cont++;
					} else if (cont > (numJugadoresHumanos)) {

						for (int j = (numJugadoresHumanos); j < (numJugadoresBot+numJugadoresHumanos); j++) {

							do {
								correcto = true;
								dorsal = dorsalBot();
								nombre_piloto = "bot " + (i + 1 - (numJugadoresHumanos));
								for (int p = 0; p < vCoches.length; p++) {
									if (vCoches[p] != null && (vCoches[p].getDorsal() == dorsal)) {
										correcto = false;
										j--;
									}
								}

							} while (!correcto);
						}
						bot = true;
					}
				} catch (Exception e) {
					correcto = false;
				}
			} while (!correcto);

			vCoches[i] = new Coche(nombre_piloto, dorsal, this.distancia, bot);
		}
	}
	// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::FIN_añadir_jugadores:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::iniciar_carrera:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	public boolean IniciarCarera() {
		boolean correcto = true;

		for (int i = 0; i < vCoches.length; i++) {
			if (vCoches[i] == null) {
				System.out.println("la carrera no se configuro correctamente");
				for (int j = 0; j < vCoches.length; j++) {
					vCoches[j] = null;
					correcto = false;
				}
				break;
			} else {
				vCoches[i].setEstado("marcha");
				correcto = true;
			}
		}

		return correcto;
	}

	// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::FIN_iniciar_carrera::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::jugar:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// inicio buscar buesto
	private int buscarPuesto(String puesto[]) {//ni idea
		int pos = 0;
		for (int i = 0; i < puesto.length; i++) {
			if (puesto[i] == null) {
				pos = i;
				break;
			}
		}

		return pos;
	}

	// inicio metodo jugar
	private boolean jugar(int jugadores, String puesto[]) {
		boolean juegoTerminado = false;
		boolean terminado = false;// sobra?
		int opcAUX = 0;
		int botaction = 0;
		int hanterminado = 0;
		int pos;
		Random r;
		do {

			for (int i = 0; i < vCoches.length; i++) {

				if (!vCoches[i].isTerminado() && !vCoches[i].isBot()) {
					System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
					System.out.println(
							"jugador: " + vCoches[i].getNombre_piloto() + " Dorsal: " + vCoches[i].getDorsal());
					opcAUX = Menu.gameMenu();
					switch (opcAUX) {
					case 1:
						vCoches[i].acelerar();
						break;
					case 2:
						vCoches[i].frenar();
						break;
					case 3:
						vCoches[i].reArrancarCoche();
						break;

					default:
						break;
					}

					if (vCoches[i].getKm_recorridos() >= vCoches[i].getDistancia_carrera()) {
						vCoches[i].setTerminado(true);
						
						if (!vCoches[i].isTenerPuesto()) {
							pos = buscarPuesto(puesto);

						puesto[pos] = vCoches[i].getNombre_piloto() + " con dorsal " + vCoches[i].getDorsal();
						}
						vCoches[i].setTenerPuesto(true);
						
						
						System.out.println(vCoches[i].getNombre_piloto() + " ha terminado");
					}
					System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
				} else if (!vCoches[i].isTerminado() && vCoches[i].isBot()) {
					r = new Random();
					botaction = r.nextInt(3);
					if (vCoches[i].getEstado().equalsIgnoreCase("accidentado")) {
						botaction = 3;
					}
					switch (botaction) {
					case 1:
						vCoches[i].acelerar();
						break;
					case 2:
						vCoches[i].frenar();
						break;
					case 3:
						vCoches[i].reArrancarCoche();
						break;

					default:
						break;
					}

					if (vCoches[i].getKm_recorridos() >= vCoches[i].getDistancia_carrera()) {
						vCoches[i].setTerminado(true);
						if (!vCoches[i].isTenerPuesto()) {
							pos = buscarPuesto(puesto);
							puesto[pos] = vCoches[i].getNombre_piloto() + " con dorsal " + vCoches[i].getDorsal();
						}
						
						vCoches[i].setTenerPuesto(true);

							System.out.println(vCoches[i].getNombre_piloto() + " ha terminado");//////////////////////////////////////////////////////////////////////////////
					}
				}
				
			}
			hanterminado = 0;
			for (int i = 0; i < vCoches.length; i++) {

				if ((vCoches[i].isTerminado() == true
						|| (vCoches[i].getEstado().equalsIgnoreCase("accidentado")) && jugadores > 1)) {
					hanterminado++;
				}
				if (hanterminado == jugadores) {
					juegoTerminado = true;
				}
			}
		} while (!juegoTerminado);

		return juegoTerminado;
	}

	// fin metodo jugar
	// inicio gestion metodo jugar
	public boolean juego(boolean correcto, String puesto[]) {
		boolean terminado = false;

		if (correcto && (numJugadoresHumanos > 0)) {

			terminado = jugar((numJugadoresHumanos + numJugadoresBot), puesto);
			if (terminado) {
				System.out.println("juego terminado");

			}

		} else if (numJugadoresHumanos > 0) {
			System.out.println("inicia la carrera");
		} else {
			System.out.println("NO TIENES PERMISO, es una carrera exclusiva de bots");
		}
		return terminado;
	}
}
