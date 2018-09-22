package leet.g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Q406_QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][];
        Arrays.sort(people, (a1, a2) -> {
            if (a1[0] != a2[0]) {
                return a2[0] < a1[0] ? -1 : 1;
            } else {
                return a1[1] < a2[1] ? -1 : 1;
            }
        });

        ArrayList<int[]> list = new ArrayList<>();

        for (int[] arr : people) {
            list.add(arr[1], arr);
        }

        for (int i = 0; i < people.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        Q406_QueueReconstructionByHeight solution = new Q406_QueueReconstructionByHeight();
        solution.reconstructQueue(input);
    }
}
