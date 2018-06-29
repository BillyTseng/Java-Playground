package come.class03_Queue_Stack.attempt01;

import java.util.Arrays;
import java.util.LinkedList;

public class Q1_1_SortWith3Stacks {
    private void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();

        int s1Size = s1.size();
        while (s3.size() < s1Size) {
            int min = Integer.MAX_VALUE;
            while (!s1.isEmpty()) {
                int s1Elem = s1.pop();
                if (s1Elem <= min) {
                    min = s1Elem;
                }
                s2.push(s1Elem);
            }

            while (!s2.isEmpty()) {
                int s2Elem = s2.pop();
                if (s2Elem > min) {
                    s1.push(s2Elem);
                } else {
                    s3.push(min);
                }
            }
        }

        while (!s3.isEmpty()) {
            s1.push(s3.pop());
        }
    }


    public static void main(String[] args) {
        Q1_1_SortWith3Stacks solution = new Q1_1_SortWith3Stacks();
        LinkedList<Integer> s1 = new LinkedList<>();
        s1.push(4);
        s1.push(4);
        s1.push(3);
        s1.push(5);
        s1.push(-1);

        System.out.println(Arrays.toString(s1.toArray()));
        solution.sort(s1);
        System.out.println(Arrays.toString(s1.toArray()));
    }
}
