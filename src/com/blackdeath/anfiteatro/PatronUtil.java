package com.blackdeath.anfiteatro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase de utilería para patrones
 */
public class PatronUtil {
	public static final String PATRON_RESERVACION = "^[A-Za-z][0-9]{1,2}$";

	/**
	 * Valida el valor de una reservación
	 * 
	 * @param reservacion
	 */
	public static void validarReservacion(String reservacion) {
		if (!validarPatron(PATRON_RESERVACION, reservacion)) {
			throw new IllegalArgumentException(
					"La reservación no es válida. Debe ser la letra de la fila seguido del número del asiento. Ejemplo: A5, G10");
		}
	}

	/**
	 * Valida que {@code cadena} cumpla con {@code patron}
	 * 
	 * @param patron
	 * @param cadena
	 * @return
	 */
	public static boolean validarPatron(String patron, String cadena) {
		// Compilar la expresión regular en un patrón
		Pattern pattern = Pattern.compile(patron);

		// Crear un matcher para la cadena dada
		Matcher matcher = pattern.matcher(cadena);

		// Devolver true si la cadena cumple con la expresión regular, false en caso
		// contrario
		return matcher.matches();
	}
}
