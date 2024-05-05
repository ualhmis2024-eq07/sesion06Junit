package ual.hmis.sesion05.ejercicio5;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
class ContadorPalabraTest {
	
    @ParameterizedTest(name = "Caso {index}: Ruta del archivo: {0}")
    @ValueSource(strings = {"archivo.txt"})
    void testObtenerPalabrasEnOrdenAlfabetico(String archivo) {
        String rutaArchivo = "src/ual/hmis/sesion05/ejercicio5/" + archivo;
        List<String> palabras = ContadorPalabra.obtenerPalabrasEnOrdenAlfabetico(rutaArchivo);
        
            }

    @ParameterizedTest(name = "Caso {index}: Ruta del archivo: {0}")
    @ValueSource(strings = {"archivo.txt"})
    void testObtenerPalabrasOrdenFrecuencia(String archivo) {
        String rutaArchivo = "src/ual/hmis/sesion05/ejercicio5/" + archivo;
        List<String> palabras = ContadorPalabra.obtenerPalabrasOrdenFrecuencia(rutaArchivo);
     // Verificamos que las palabras estén ordenadas por frecuencia
        for (int i = 0; i < palabras.size() - 1; i++) {
            int frecuenciaActual = Collections.frequency(palabras, palabras.get(i));
            int frecuenciaSiguiente = Collections.frequency(palabras, palabras.get(i + 1));
            assertTrue(frecuenciaActual >= frecuenciaSiguiente);
        }
    }
    @Test
    void testMain() {
        // Guardar la salida estándar en un ByteArrayOutputStream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // Llamar al método main
        ContadorPalabra.main(null);
        
        // Verificar que no se lanzaron excepciones
        // Esto también indica que el método se ejecutó sin problemas
        assertNull(outContent.toString());
    

    }
    @Test
    void testIOException() {
        // Definir un archivo inexistente
        String rutaArchivoInexistente = "archivo_inexistente.txt";
        
        // Verificar que se lance IOException al intentar leer el archivo inexistente
        assertThrows(IOException.class, () -> {
            ContadorPalabra.obtenerPalabrasEnOrdenAlfabetico(rutaArchivoInexistente);
        });
    }
       
    }
