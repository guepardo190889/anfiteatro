package com.blackdeath.anfiteatro;

import java.util.Scanner;

import com.blackdeath.anfiteatro.Captura.TipoCaptura;

/**
 * Clase que sirve para controlar lo que el usuario ve por pantalla
 */
public class ControlPantalla {

	private Scanner scanner = new Scanner(System.in);

	boolean isReservacionAsientosTerminada = false;

	/**
	 * Constructor que permite recibir un {@link Anfiteatro}
	 * 
	 * @param anfiteatro
	 */
	public ControlPantalla(Anfiteatro anfiteatro) {
		imprimirBienvenida(anfiteatro);

		while (!isReservacionAsientosTerminada) {
			Captura datoCapturado = capturarDato();

			if (TipoCaptura.RESERVACION == datoCapturado.getTipoCaptura()) {
				reservarAsiento(anfiteatro, datoCapturado);
			} else if (TipoCaptura.FINALIZACION == datoCapturado.getTipoCaptura()) {
				finalizarReservacion(anfiteatro);
			}
		}
	}

	/**
	 * Limpia la consola
	 * <p>
	 * La secuencia \033[H\033[2J mueve el cursor a la esquina superior izquierda y
	 * borra toda la pantalla
	 */
	private void limpiarConsola() {
		System.out.flush();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

	/**
	 * Imprime la bienvenida de este programa
	 * 
	 * @param anfiteatro
	 */
	private void imprimirBienvenida(Anfiteatro anfiteatro) {
		limpiarConsola();
		System.out.println("Bienvenido al Anfiteatro " + anfiteatro.getNombre());
		System.out.println();

		anfiteatro.imprimirMapa();
	}

	/**
	 * Solicita la captura de una reservación
	 * 
	 * @param anfiteatro
	 * @param captura
	 */
	private void reservarAsiento(Anfiteatro anfiteatro, Captura captura) {
		boolean asientoReservado = anfiteatro.reservarAsiento(captura.getCaptura());

		if (asientoReservado) {
			imprimirBienvenida(anfiteatro);
		}
	}

	/**
	 * Finaliza la reservación
	 * 
	 * @param anfiteatro
	 */
	private void finalizarReservacion(Anfiteatro anfiteatro) {
		imprimirFinalizacion(anfiteatro);
		isReservacionAsientosTerminada = true;
	}

	/**
	 * Imprime la finalización de este programa
	 * 
	 * @param anfiteatro
	 */
	private void imprimirFinalizacion(Anfiteatro anfiteatro) {
		System.out.println();
		anfiteatro.imprimirMapa();
		System.out.println("Adiós");
	}

	/**
	 * Captura un dato por el usuario
	 * 
	 * @return
	 */
	private Captura capturarDato() {
		System.out.println();
		System.out.println("¿Qué asiento desea reservar?");

		String captura = scanner.nextLine();

		if (captura.length() == 2 || captura.length() == 3) {
			try {
				PatronUtil.validarReservacion(captura);

				return new Captura(captura, TipoCaptura.RESERVACION);
			} catch (IllegalArgumentException iae) {
				System.out.println("Formato de reservación inválido");
				return capturarDato();
			}
		} else if (captura.length() == 1) {
			if ("S".equals(captura)) {
				return new Captura(captura, TipoCaptura.FINALIZACION);
			} else {
				System.out.println("Formato de salida inválido");

				return capturarDato();
			}
		} else {
			System.out.println("Dato inválido");

			return capturarDato();
		}
	}

}
