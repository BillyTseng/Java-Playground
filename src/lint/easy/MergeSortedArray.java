/*Given two sorted integer arrays A and B, merge B into A as one sorted array.*/
package lint.easy;

public class MergeSortedArray {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = m - 1, j = n - 1, idx = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[idx--] = A[i--];
            } else {
                A[idx--] = B[j--];
            }
        }

        while (j >= 0) {
            A[idx--] = B[j--];
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
