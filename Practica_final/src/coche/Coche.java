package coche;

import java.util.Random;

public class Coche {
	private String nombre_piloto;
	private int dorsal;
	private double distancia_carrera;
	private String estado;
	private int potencia;
	private double velocidad;
	private double km_recorridos;
	private boolean bot;
	private boolean terminado;

	public Coche(String nombre_piloto, int dorsal, double distancia_carrera, boolean bot) {
		this.nombre_piloto = nombre_piloto;
		this.dorsal = dorsal;
		this.distancia_carrera = distancia_carrera;// antes de crear objeto coche se pide
		estado = "parado";
		potencia = 50;
		this.velocidad = 0;
		this.km_recorridos = 0;
		this.bot = bot;
		terminado = false;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	public boolean isBot() {
		return bot;
	}

	public String getNombre_piloto() {
		return nombre_piloto;
	}

	public int getDorsal() {
		return dorsal;
	}

	public double getDistancia_carrera() {
		return distancia_carrera;
	}

	public String getEstado() {
		return estado;
	}

	public int getPotencia() {
		return potencia;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public double getKm_recorridos() {
		return km_recorridos;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void arrancarCoche() {
		if (estado.equalsIgnoreCase("parado")) {
			estado = "marcha";
		} else {
			System.out.println("no se puede realizar la operacion");
		}
	}

	public void reArrancarCoche() {// falta comprobas si otro ha terminado
		if (estado.equalsIgnoreCase("accidentado")) {
			System.out.println("Km recorridos" + km_recorridos);
			estado = "marcha";
		} else {
			System.out.println("no estas accidentado");
		}
	}

	private double calcularAceleracion() {
		double ac = 0;
		Random r = new Random();
		ac = r.nextDouble() * potencia;
		return ac;
	}

	public void acelerar() {
		
		if (!estado.equalsIgnoreCase("accidentado")) {
			velocidad += calcularAceleracion();
			System.out.println("velocidad: " + velocidad);
			System.out.println("Km recorridos" + km_recorridos);
			km_recorridos += velocidad;
			if (velocidad >= 200) {
				estado = "accidentado";
				velocidad = 0;
				System.out.println("te has accidentado");
			}
		} else {
			System.out.println("has tenido un accidente, tienes que rearrancar");
		}
	}

	public void frenar() {
		double frenazo;
		System.out.println("Km recorridos" + km_recorridos);
		if (!estado.equalsIgnoreCase("accidentado") && velocidad > 0) {
			frenazo = calcularAceleracion();
			km_recorridos += frenazo;
			velocidad -= frenazo;
			if (velocidad < 0) {
				velocidad = 0;
			}
		} else {
			System.out.println("deberias replantearte tus opciones en la vida");
		}
	}

	@Override
	public String toString() {
		return "Coche [nombre_piloto=" + nombre_piloto + ", dorsal=" + dorsal + ", distancia_carrera="
				+ distancia_carrera + ", estado=" + estado + ", potencia=" + potencia + ", velocidad=" + velocidad
				+ ", km_recorridos=" + km_recorridos + "]";
	}

}
