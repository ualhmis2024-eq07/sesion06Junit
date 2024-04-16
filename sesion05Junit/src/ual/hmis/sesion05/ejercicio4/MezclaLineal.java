package ual.hmis.sesion05.ejercicio4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MezclaLineal<T extends Comparable<T>> {
    public static <T extends Comparable<T>> List<T> mezclarConjuntosOrdenados(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();
        result.addAll(list1);

        for (T t : result) {
            for (T t2 : list2) {
                if (t2.compareTo(t) <= 0) {
                    int index = result.indexOf(t);
                    desplazarIzquierda(result, index);
                    result.set(index, t2);
                }
            }
        }

        for (T t : list2) {
            result.add(t);
        }

        return result;
    }

    private static <T> void desplazarIzquierda(List<T> result, int index) {
        for (int i = result.size() - 1; i > index; i--) {
            result.set(i + 1, result.get(i));
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8));

        System.out.println("ArrayList 1:");
        System.out.println(list1.toString());
        System.out.println("ArrayList 2:");
        System.out.println(list2.toString());
        System.out.println("Resultado:");
        System.out.println(mezclarConjuntosOrdenados(list1, list2));
    }
}
