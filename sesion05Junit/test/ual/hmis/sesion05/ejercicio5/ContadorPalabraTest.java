package ual.hmis.sesion05.ejercicio5;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ContadorPalabraTest {

    @DisplayName("Prueba para obtenerPalabrasEnOrdenAlfabetico")
    @ParameterizedTest(name = "Caso {index}: Ruta del archivo: {0}")
    @ValueSource(strings = {"archivo.txt"})
    void testObtenerPalabrasEnOrdenAlfabetico(String archivo) {
        String rutaArchivo = "src/ual/hmis/sesion05/ejercicio5/" + archivo;
        List<String> palabras = ContadorPalabra.obtenerPalabrasEnOrdenAlfabetico(rutaArchivo);

        // Definimos las palabras esperadas en orden alfabético
        List<String> palabrasEsperadas = Arrays.asList("a", "a", "b", "c", "d", "e", "f", "g", "h");

        // Comparamos las palabras obtenidas con las esperadas
        assertEquals(palabrasEsperadas, palabras);
    }

    @DisplayName("Prueba para obtenerPalabrasOrdenFrecuencia")
    @ParameterizedTest(name = "Caso {index}: Ruta del archivo: {0}")
    @ValueSource(strings = {"archivo.txt"})
    void testObtenerPalabrasOrdenFrecuencia(String archivo) {
        String rutaArchivo = "src/ual/hmis/sesion05/ejercicio5/" + archivo;
        List<String> palabras = ContadorPalabra.obtenerPalabrasOrdenFrecuencia(rutaArchivo);

        // Definimos las palabras esperadas en orden de frecuencia
        List<String> palabrasEsperadas = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");

        // Comparamos las palabras obtenidas con las esperadas
        assertEquals(palabrasEsperadas, palabras);

        // Verificamos que las palabras estén ordenadas por frecuencia
        for (int i = 0; i < palabras.size() - 1; i++) {
            int frecuenciaActual = Collections.frequency(palabras, palabras.get(i));
            int frecuenciaSiguiente = Collections.frequency(palabras, palabras.get(i + 1));
            assertTrue(frecuenciaActual >= frecuenciaSiguiente);
        }
    }

    @DisplayName("Prueba para manejo de archivo inexistente")
    @ParameterizedTest(name = "Caso {index}: Ruta del archivo: {0}")
    @ValueSource(strings = {"archivo_inexistente.txt"})
    void testArchivoInexistente(String archivo) {
        String rutaArchivo = "src/ual/hmis/sesion05/ejercicio5/" + archivo;
        assertThrows(IOException.class, () -> {
            ContadorPalabra.obtenerPalabrasEnOrdenAlfabetico(rutaArchivo);
            ContadorPalabra.obtenerPalabrasOrdenFrecuencia(rutaArchivo);
        });
    }

    // Agrega más casos de prueba para cubrir otros escenarios como archivos vacíos, archivos con una sola palabra, etc.
}
