package come.practice.class20.e03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class generics3 {
    public static <A, B, C> void printAll(A[] arr, List<B> list, Queue<C> queue) {
        for (A a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();

        for (B b : list) {
            System.out.print(b + " ");
        }
        System.out.println();

        while (!queue.isEmpty()) {
            C c = queue.poll();
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3};
        List<Double> list = new ArrayList<>();
        list.add(1.5); list.add(2.5); list.add(3.5);
        Queue<String> queue = new LinkedList<>();
        queue.offer("c"); queue.offer("o"); queue.offer("o"); queue.offer("l");
        printAll(array, list, queue);
    }
}
