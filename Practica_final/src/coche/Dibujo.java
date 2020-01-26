package coche;

public class Dibujo {
	private static int calcularPorcentaje(Coche vCoches[],int pos) {
		double porcentaje=0;
		int progreso=0;
		
		
		porcentaje=  ((vCoches[pos].getKm_recorridos()/vCoches[pos].getDistancia_carrera())*100);
		
		if (porcentaje ==100||porcentaje>100) {
			return 100;
		}else if (porcentaje ==90||porcentaje >90) {
			return 90;
		}else if (porcentaje ==80||porcentaje >80) {
			return 80;
		}else if (porcentaje ==70||porcentaje >70) {
			return 70;
		}else if (porcentaje ==60||porcentaje >60) {
			return 60;
		}else if (porcentaje ==50||porcentaje >50) {
			return 50;
		}else if (porcentaje ==40||porcentaje >40) {
			return 40;
		}else if (porcentaje ==30||porcentaje >30) {
			return 30;
		}else if (porcentaje ==20||porcentaje >20) {
			return 20;
		}else if (porcentaje ==10||porcentaje >10) {
			return 10;
		}else if (porcentaje ==0||porcentaje >0) {
			return 0;
		}
		
		return progreso;
	}
	public static void pintarCoche(Coche vCoches[], int pos) {
		int progreso=0;
		progreso=calcularPorcentaje(vCoches, pos);
		switch (progreso) {
		case 0:
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("いいいいい################################################################################いいいいい");
			break;
		case 10:
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("いいいいい################################################################################いいいいい");
			break;
		case 20:
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]__                                                                              [  FINAL ]");
			System.out.println("[ INICIO ].-'--'-._                                                                       [  FINAL ]");
			System.out.println("[ INICIO ]'-o---o--'                                                                      [  FINAL ]");
			System.out.println("いいいいい################################################################################いいいいい");
			break;
		case 30:
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]          __                                                                    [  FINAL ]");
			System.out.println("[ INICIO ]          .-'--'-._                                                             [  FINAL ]");
			System.out.println("[ INICIO ]          '-o---o--'                                                            [  FINAL ]");
			System.out.println("いいいいい################################################################################いいいいい");	
			break;
		case 40:
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                    __                                                          [  FINAL ]");
			System.out.println("[ INICIO ]                    .-'--'-._                                                   [  FINAL ]");
			System.out.println("[ INICIO ]                    '-o---o--'                                                  [  FINAL ]");
			System.out.println("いいいいい################################################################################いいいいい");	
			break;
		case 50:
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                              __                                                [  FINAL ]");
			System.out.println("[ INICIO ]                              .-'--'-._                                         [  FINAL ]");
			System.out.println("[ INICIO ]                              '-o---o--'                                        [  FINAL ]");
			System.out.println("いいいいい################################################################################いいいいい");	
			break;
		case 60:
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                        __                                      [  FINAL ]");
			System.out.println("[ INICIO ]                                        .-'--'-._                               [  FINAL ]");
			System.out.println("[ INICIO ]                                        '-o---o--'                              [  FINAL ]");
			System.out.println("いいいいい################################################################################いいいいい");	
			break;
		case 70:
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                                  __                            [  FINAL ]");
			System.out.println("[ INICIO ]                                                  .-'--'-._                     [  FINAL ]");
			System.out.println("[ INICIO ]                                                  '-o---o--'                    [  FINAL ]");
			System.out.println("いいいいい################################################################################いいいいい");	
			break;
		case 80:
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                                            __                  [  FINAL ]");
			System.out.println("[ INICIO ]                                                            .-'--'-._           [  FINAL ]");
			System.out.println("[ INICIO ]                                                            '-o---o--'          [  FINAL ]");
			System.out.println("いいいいい################################################################################いいいいい");	
			break;
		case 90:
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                                                      __        [  FINAL ]");
			System.out.println("[ INICIO ]                                                                      .-'--'-._ [  FINAL ]");
			System.out.println("[ INICIO ]                                                                      '-o---o--'[  FINAL ]");
			System.out.println("いいいいい################################################################################いいいいい");	
			break;
		case 100:
			System.out.println("[ INICIO ]                                TERMINADO                                       [  FINAL ]");
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("[ INICIO ]                                                                                [  FINAL ]");
			System.out.println("いいいいい################################################################################いいいいい");	
			break;

		default:
			break;
		}
		
		
		
		
		
	}
}
