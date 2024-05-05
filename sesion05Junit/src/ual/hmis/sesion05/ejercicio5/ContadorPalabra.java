package ual.hmis.sesion05.ejercicio5;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class ValueComparator implements Comparator<String> {
	TreeMap<String, Integer> map;

    public ValueComparator(TreeMap<String, Integer> map) {
        this.map = map;
    }
    @Override
    public int compare(String a, String b) {
        return map.get(b).compareTo(map.get(a));
    }
}
public class ContadorPalabra {
	

	public static List<String> obtenerPalabrasEnOrdenAlfabetico(String ruta) {
		List<String> result = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] palabras = linea.split("[\\s\\n,\\.]+");
				for (String palabra : palabras) {
					palabra = palabra.toLowerCase();
					if (palabra.isEmpty())	continue;
					result.add(palabra);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.sort(result);
		return result;
	}
	
	public static List<String> obtenerPalabrasOrdenFrecuencia(String ruta) {
		List<String> result = null;
		List<String> aux = obtenerPalabrasEnOrdenAlfabetico(ruta);
		TreeMap<String, Integer> palabraFrecuencia = new TreeMap<>();
		
		for (String palabra : aux) {
			Integer frecuencia = palabraFrecuencia.get(palabra);
			palabraFrecuencia.put(palabra, frecuencia != null ? frecuencia + 1 : 1);
		}
		result = new ArrayList<>(palabraFrecuencia.keySet());
		result.sort(new ValueComparator(palabraFrecuencia));
		
		return result;
	}
	
	public static void main(String[] args) {
		String ruta = System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "ual" + File.separator + "hmis" + File.separator + "sesion05" + File.separator + "ejercicio5" + File.separator + "archivo.txt";
		System.out.println(obtenerPalabrasOrdenFrecuencia(ruta).toString());
	}
}


