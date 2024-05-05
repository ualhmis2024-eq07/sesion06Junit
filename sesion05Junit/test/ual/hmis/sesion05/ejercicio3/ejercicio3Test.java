package ual.hmis.sesion05.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ejercicio3Test {

    @ParameterizedTest(name = "Caso {index}: Password: {0}, Resultado esperado: {1}")
    @CsvSource({
            "123, password demasiado corto",
            "abcdefg, ********",
            "abcdefghijkl, ************",
            "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmno, password demasiado largo",
            ", password demasiado corto", // Caso de cadena vacía
            "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmn, *********************" // Caso para longitud > 40
    })
    void testDevuelvePassword(String password, String expected) {
        ejercicio3 ej = new ejercicio3();
        assertEquals(expected, ej.devuelvePassword(password));
    }
}
