package come.eClass2_LinkedList_BinarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class Q2_2_findMaxSmallerThanTargetTest {

    @Test
    public void test1() {
        Q2_2_findMaxSmallerThanTarget solution = new Q2_2_findMaxSmallerThanTarget();
        int[] testArray = new int[] {1, 2, 3, 4, 6};
        int res = solution.findMaxSmallerThanTarget(testArray, 5);
        int res1 = solution.findMaxSmallerThanTargetI(testArray, 5);
        assertEquals(3, res);
        assertEquals(3, res1);
    }

    @Test
    public void test2() {
        Q2_2_findMaxSmallerThanTarget solution = new Q2_2_findMaxSmallerThanTarget();
        int[] testArray = new int[] {1, 2, 3, 4, 6};
        int res = solution.findMaxSmallerThanTarget(testArray, 1);
        int res1 = solution.findMaxSmallerThanTargetI(testArray, 1);
        assertEquals(-1, res);
        assertEquals(-1, res1);
    }

    @Test
    public void test3() {
        Q2_2_findMaxSmallerThanTarget solution = new Q2_2_findMaxSmallerThanTarget();
        int[] testArray = new int[] {1, 2, 9, 35, 77};
        int res = solution.findMaxSmallerThanTarget(testArray, 100);
        int res1 = solution.findMaxSmallerThanTargetI(testArray, 100);
        assertEquals(4, res);
        assertEquals(4, res1);
    }
}