package coche;

import java.util.Scanner;

public class Menu {

	public static int mainMenu() {
		int opc = 0;
		Scanner leer = new Scanner(System.in);
		boolean correcto = false;
		do {
			leer = new Scanner(System.in);
			System.out.println("------------MEÑU----------");
			System.out.println("1. añadir jugador");
			System.out.println("2. iniciar carrera");
			System.out.println("3. jugar");
			System.out.println("4. salir");
			try {
				correcto = true;
				opc = leer.nextInt();
				if (opc < 1 || opc > 4) {
					correcto = false;
				}
			} catch (Exception e) {
				correcto = false;
			}

		} while (!correcto);

		return opc;
	}
	
	public static int gameMenu() {
		int opc=0;
		Scanner leer = new Scanner(System.in);
		boolean correcto = false;
		do {
			leer = new Scanner(System.in);
			System.out.println("------------MEÑU----------");
			System.out.println("1. acelerar");
			System.out.println("2. frenar");
			System.out.println("3. rearrancar");
			try {
				correcto = true;
				opc = leer.nextInt();
				if (opc < 1 || opc > 3) {
					correcto = false;
				}
			} catch (Exception e) {
				correcto = false;
			}

		} while (!correcto);

		return opc;
		
		
		
		
	}
	
	
	
}
