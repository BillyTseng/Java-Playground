package come.class26_BST_DP;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2_1_MergeKSortedArray {
    public int[] merge(int[][] arrayOfArrays) {
        PriorityQueue<Entry> minHeap = new PriorityQueue<>(new MyComparator());
        int outputLength = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            int[] array = arrayOfArrays[i];
            outputLength += array.length;
            if (array.length > 0) {
                minHeap.offer(new Entry(i, 0, array[0]));
            }
        }

        int[] res = new int[outputLength];
        int cur = 0;
        while (!minHeap.isEmpty()) {
            Entry temp = minHeap.poll();
            res[cur++] = temp.value;
            if (temp.col + 1 < arrayOfArrays[temp.row].length) {
                temp.col++;
                temp.value = arrayOfArrays[temp.row][temp.col];
                minHeap.offer(temp);
            }
        }
        return res;
    }

    class MyComparator implements Comparator<Entry> {
        @Override
        public int compare (Entry e1, Entry e2) {
            if (e1.value == e2.value) {
                return 0;
            }
            return e1.value < e2.value ? -1 : 1;
        }
    }

    class Entry {
        int row;
        int col;
        int value;
        Entry (int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}
