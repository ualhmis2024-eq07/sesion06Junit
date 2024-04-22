package ual.hmis.sesion05.ejercicio4;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static ual.hmis.sesion05.ejercicio4.MezclaLineal.mezclarConjuntosOrdenados;

@RunWith(Parameterized.class)
class Ejercicio3Test {
	private List<Integer> list1, list2, result;
	
	public Ejercicio3Test (Integer[] list1, Integer[] list2, Integer[] result) { 
		this.list1 = Arrays.asList(list1);
		this.list2 = Arrays.asList(list2);
		this.result = Arrays.asList(result);
	}
	
	@Parameters
	public static Collection<Integer[][]> addedNumbers() {
	    return Arrays.asList(new Integer[][][] {
	        { new Integer[] {}, new Integer[] {}, new Integer[] {}},
	        {new Integer[] {}, 					new Integer[] {1, 3, 5, 7, 9}, 		new Integer[] {1, 3, 5, 7, 9}},
	        {new Integer[] {0, 2, 4, 6, 8}, 	new Integer[] {}, 					new Integer[] {0, 2, 4, 6, 8}},
	        {new Integer[] {0, 2, 4, 6, 8}, 	new Integer[] {1, 3, 5, 7, 9},		new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}},
	        {new Integer[] {0, 2, 4, 0, 2, 4}, 	new Integer[] {1, 3, 5, 1, 3, 5}, 	new Integer[] {0, 1, 2, 3, 4, 5}}
	    });
	}
	

	
	
	@Test
	public void testMezclarConjuntosOrdenados(){
		assertEquals(mezclarConjuntosOrdenados(list1, list2).toString(), result.toString());
	}
}
