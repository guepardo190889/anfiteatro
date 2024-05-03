package com.blackdeath.anfiteatro;

import java.util.Map;
import java.util.TreeMap;

import com.blackdeath.anfiteatro.Asiento.DISPONIBILIDAD;

/**
 * Representa un anfiteatro. En un anfiteatro se pueden reservar asientos.
 */
public class Anfiteatro {

	/**
	 * Nombre de este anfiteatro
	 */
	private String nombre;

	/**
	 * {@link Fila}s de asientos de este anfiteatro
	 */
	private Fila[] filas;

	/**
	 * Mapa que permite obtener una {@link Fila} por su letra
	 */
	private Map<String, Fila> mapaFilas;

	/**
	 * Constructor que permite inicializar este anfiteatro con cierta
	 * {@code cantidadFilas} y {@code cantidadAsientosPorFila}
	 * 
	 * @param nombre
	 * @param cantidadFilas
	 * @param cantidadAsientosPorFila
	 */
	public Anfiteatro(String nombre, int cantidadFilas, int cantidadAsientosPorFila) {
		mapaFilas = new TreeMap<>();

		this.nombre = nombre;

		filas = new Fila[cantidadFilas];

		for (int numeroFila = 0; numeroFila < cantidadFilas; numeroFila++) {
			char letraFila = AbecedarioUtil.obtenerLetraPorPosicion(numeroFila + 1);
			Asiento[] asientos = new Asiento[cantidadAsientosPorFila];

			for (int numeroAsiento = 0; numeroAsiento < cantidadAsientosPorFila; numeroAsiento++) {
				asientos[numeroAsiento] = new Asiento(Character.toString(letraFila), numeroAsiento + 1,
						DISPONIBILIDAD.LIBRE);
			}

			Fila fila = new Fila(letraFila, asientos);

			mapaFilas.put(Character.toString(letraFila), fila);

			filas[numeroFila] = fila;
		}
	}

	/**
	 * Devuelve el nombre de este anfiteatro;
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Imprime el mapa de los asientos de este anfiteatro
	 */
	public void imprimirMapa() {
		Pantalla.iprimirFilas(filas);
	}

	/**
	 * Obtiene una fila por su letra
	 * 
	 * @param fila
	 */
	private Fila obtenerFila(String letraFila) {
		return mapaFilas.get(letraFila);
	}

	/**
	 * Reserva un asiento en el anfiteatro si este está libre
	 * 
	 * @return
	 */
	public boolean reservarAsiento(String reservacion) {
		String filaElegida = Character.toString(reservacion.charAt(0));
		Fila fila = obtenerFila(filaElegida);
		Asiento asiento = fila.getAsientoPorIdentificador(reservacion);

		if (asiento.isDisponible()) {
			asiento.reservar();

			return true;
		} else {
			System.out.println("El asiento no está disponible");

			return false;
		}
	}

}
