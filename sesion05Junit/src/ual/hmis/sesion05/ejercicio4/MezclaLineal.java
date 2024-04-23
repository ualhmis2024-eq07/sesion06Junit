package ual.hmis.sesion05.ejercicio4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MezclaLineal<Number extends Comparable<Number>> {
    public List<Number> mezclarConjuntosOrdenados(List<Number> list1, List<Number> list2) {
    	
        HashSet<Number> resultHashSet = new HashSet<>();
        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            Number elem1 = list1.get(i);
            Number elem2 = list2.get(j);

            if (elem1.compareTo(elem2) < 0) {
            	resultHashSet.add(elem1);
                i++;
            } else if (elem1.compareTo(elem2) > 0){
            	resultHashSet.add(elem2);
                j++;
            } else {
            	resultHashSet.add(elem1);
            	i++;
            	j++;
            }
        }
        
        while (i < list1.size()) {
        	resultHashSet.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
        	resultHashSet.add(list2.get(j));
            j++;
        }
        
        List<Number> result = new ArrayList<>(resultHashSet);
        return result;
    }
}
