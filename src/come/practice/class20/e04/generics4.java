package come.practice.class20.e04;

public class generics4 {
    public static <E extends Comparable<E>> E getMin(E[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        E min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = arr[i].compareTo(min) < 0 ? arr[i] : min;
        }
        return min;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        Integer m1 = getMin(intArray);
        System.out.println(m1);
        Double m2 = getMin(doubleArray);
        System.out.println(m2);
        Character m3 = getMin(charArray);
        System.out.println(m3);
    }
}
