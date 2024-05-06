package ual.hmis.sesion05.ejercicio5;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class ContadorPalabraTest {

	@ParameterizedTest(name = "Caso {index}: Ruta del archivo: {0}")
	@ValueSource(strings = { "archivo.txt" })
	void testObtenerPalabrasEnOrdenAlfabetico(String archivo) {
		String rutaArchivo = "src/ual/hmis/sesion05/ejercicio5/" + archivo;
		ContadorPalabra contadorPalabra = new ContadorPalabra();
		contadorPalabra.obtenerPalabrasEnOrdenAlfabetico(rutaArchivo);
	}

	@ParameterizedTest(name = "Caso {index}: Ruta del archivo: {0}")
	@ValueSource(strings = { "archivo.txt" })
	void testObtenerPalabrasOrdenFrecuencia(String archivo) {
		String rutaArchivo = "src/ual/hmis/sesion05/ejercicio5/" + archivo;
		ContadorPalabra contadorPalabra = new ContadorPalabra();
		List<String> palabras = contadorPalabra.obtenerPalabrasOrdenFrecuencia(rutaArchivo);
		// Verificamos que las palabras estén ordenadas por frecuencia
		for (int i = 0; i < palabras.size() - 1; i++) {
			int frecuenciaActual = Collections.frequency(palabras, palabras.get(i));
			int frecuenciaSiguiente = Collections.frequency(palabras, palabras.get(i + 1));
			assertTrue(frecuenciaActual >= frecuenciaSiguiente);
		}
	}

	@Test
	void testIOException() {
		String rutaInvalida = "ruta_invalida.txt";
		ContadorPalabra contadorPalabra = new ContadorPalabra();

		contadorPalabra.obtenerPalabrasEnOrdenAlfabetico(rutaInvalida);
	}

}
