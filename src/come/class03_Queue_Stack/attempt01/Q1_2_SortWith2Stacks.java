package come.class03_Queue_Stack.attempt01;

import java.util.Arrays;
import java.util.LinkedList;
// from top to bottom the integers are sorted in ascending order. eg.top 1, 2, 3, 4 bottom.
public class Q1_2_SortWith2Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();

        int s1Size = s1.size();
        int prevMax = Integer.MIN_VALUE;
        while (s1Size-- > 0) {
            int max = Integer.MIN_VALUE;
            int cntMax = 1;
            while (!s1.isEmpty()) {
                if (prevMax != s1.peek()) {
                    int s1Elem = s1.pop();
                    s2.push(s1Elem);
                    if (s1Elem >= max) {
                        if (s1Elem == max) {
                            // Repeated max elements
                            cntMax++;
                            // subtract numbers of while-loop
                            s1Size--;
                        } else {
                            cntMax = 1;
                        }
                        max = s1Elem;
                    }
                } else {
                    break;
                }
            }
            prevMax = max;
            while (!s2.isEmpty()) {
                while (cntMax-- > 0) {
                    s1.push(max);
                }
                int s2Elem = s2.pop();
                if (s1.isEmpty() || s2Elem != max) {
                    s1.push(s2Elem);
                }
            }
        }
    }

    public static void main(String[] args) {
        Q1_2_SortWith2Stacks solution = new Q1_2_SortWith2Stacks();
        LinkedList<Integer> s1 = new LinkedList<>();
        s1.push(4);
        s1.push(4);
        s1.push(3);
        s1.push(5);
        s1.push(-1);

        System.out.println(Arrays.toString(s1.toArray()));
        solution.sort(s1);
        System.out.println(Arrays.toString(s1.toArray()));

        // 4, 2, 1, 1, 3, 2
        s1 = new LinkedList<>();
        s1.push(4);
        s1.push(2);
        s1.push(1);
        s1.push(1);
        s1.push(3);
        s1.push(2);
        System.out.println(Arrays.toString(s1.toArray()));
        solution.sort(s1);
        System.out.println(Arrays.toString(s1.toArray()));

        // 1, 9, 6, 3, 4, 1, 7, 2, 4
        s1 = new LinkedList<>();
        s1.push(1);
        s1.push(9);
        s1.push(6);
        s1.push(3);
        s1.push(4);
        s1.push(1);
        s1.push(7);
        s1.push(2);
        s1.push(4);
        System.out.println(Arrays.toString(s1.toArray()));
        solution.sort(s1);
        System.out.println(Arrays.toString(s1.toArray()));
    }
}
