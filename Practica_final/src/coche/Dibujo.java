package coche;

public class Dibujo {
	private static int calcularPorcentaje(Coche vCoches[],int pos) {
		int porcentaje=0;
		
		
		porcentaje= (int) ((vCoches[pos].getKm_recorridos()/vCoches[pos].getDistancia_carrera())*100);
		
		
		
		return porcentaje;
	}
	public static void pintarCoche(Coche vCoches[], int pos) {
		int porcentaje=0;
		porcentaje=calcularPorcentaje(vCoches, pos);
		switch (porcentaje) {
		case 0:
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("いいいいい################################################################################いいいいい");
			break;
		case 10:
			
			break;
		case 20:
			
			break;
		case 30:
			
			break;
		case 40:
			
			break;
		case 50:
			
			break;
		case 60:
			
			break;
		case 70:
			
			break;
		case 80:
			
			break;
		case 90:
			
			break;
		case 100:
			
			break;

		default:
			break;
		}
		
		
		
		
		
	}
}
