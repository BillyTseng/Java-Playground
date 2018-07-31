package come.eClass5_BST_Sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class Q6_FindMedianTest {

    @Test
    public void test1() {
        Q6_FindMedian solution = new Q6_FindMedian();
        int res = solution.findMedian(new int[] {4, 3, 2, 5, 1});
        assertEquals(3, res);
    }

    @Test
    public void test2() {
        Q6_FindMedian solution = new Q6_FindMedian();
        int res = solution.findMedian(new int[] {4, 3, 2, 5, 1, 6});
        assertEquals(4, res);
    }
}