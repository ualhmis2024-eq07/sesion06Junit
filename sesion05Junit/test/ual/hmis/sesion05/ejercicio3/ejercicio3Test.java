package ual.hmis.sesion05.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Ejercicio3Test {

    @ParameterizedTest
    @CsvSource({
        "123, ************",
        "password, password demasiado corto",
        "secure, ********",
        "password1234567890123456789012345678901234567890, password demasiado largo"
    })
    void testDevuelvePassword(String password, String expected) {
        // Arrange
        ejercicio3 ejercicio3 = new ejercicio3();

        // Act
        String result = ejercicio3.devuelvePassword(password);

        // Assert
        assertEquals(expected, result);
    }
}
