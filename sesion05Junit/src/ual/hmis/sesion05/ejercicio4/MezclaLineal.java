package ual.hmis.sesion05.ejercicio4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MezclaLineal<T extends Comparable<T>> {
    public static <T extends Comparable<T>> List<T> mezclarConjuntosOrdenados(List<T> list1, List<T> list2) {
    	List<T> result;
        HashSet<T> resultHashSet = new HashSet<>();
        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            T elem1 = list1.get(i);
            T elem2 = list2.get(j);

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

        return result = new ArrayList<>(resultHashSet);
    }
}
