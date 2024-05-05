package ual.hmis.sesion05.ejercicio4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


class Ejercicio4Test {
	
	static Stream<Arguments> mezclaProvider() {
		return Stream.of(
					Arguments.of(Arrays.asList(), 					Arrays.asList(), 					Arrays.asList()),
					Arguments.of(Arrays.asList(), 					Arrays.asList(1, 3, 5, 7, 9), 		Arrays.asList(1, 3, 5, 7, 9)),
					Arguments.of(Arrays.asList(0, 2, 4, 6, 8), 		Arrays.asList(), 					Arrays.asList(0, 2, 4, 6, 8)),
					Arguments.of(Arrays.asList(0, 2, 4, 6, 8), 		Arrays.asList(1, 3, 5, 7, 9), 		Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)),
					Arguments.of(Arrays.asList(0, 2, 4, 0, 2, 4), 	Arrays.asList(0, 3, 5, 1, 3, 5), 	Arrays.asList(0, 1, 2, 3, 4, 5))
					
				);
	}
	
	@ParameterizedTest(name = "{index} => mezclar {0} con {1} y sale {2}")
	@MethodSource("mezclaProvider")
	public void testMezclarConjuntosOrdenados(List<Integer> list1, List<Integer> list2, List<Integer> result){
		MezclaLineal<Integer> mezclaLineal = new MezclaLineal<Integer>();
		assertEquals(mezclaLineal.mezclarConjuntosOrdenados(list1, list2).toString(), result.toString());
	}
}
