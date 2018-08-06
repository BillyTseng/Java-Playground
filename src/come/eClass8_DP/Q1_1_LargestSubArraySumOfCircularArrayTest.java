package come.eClass8_DP;

import org.junit.Test;

import static org.junit.Assert.*;

public class Q1_1_LargestSubArraySumOfCircularArrayTest {

    @Test
    public void test1() {
        Q1_1_LargestSubArraySumOfCircularArray solution = new Q1_1_LargestSubArraySumOfCircularArray();
        int[] input = {8, -8, 9, -9, 10, -11, 12};
        assertEquals(22, solution.largestSum(input));
    }

    @Test
    public void test2() {
        Q1_1_LargestSubArraySumOfCircularArray solution = new Q1_1_LargestSubArraySumOfCircularArray();
        int[] input = {10, -3, -4, 7, 6, 5, -4, -1} ;
        assertEquals(23, solution.largestSum(input));
    }

    @Test
    public void test3() {
        Q1_1_LargestSubArraySumOfCircularArray solution = new Q1_1_LargestSubArraySumOfCircularArray();
        int[] input = {-1, 40, -14, 7, 6, 5, -4, -1};
        assertEquals(52, solution.largestSum(input));
    }

    @Test
    public void test4() {
        Q1_1_LargestSubArraySumOfCircularArray solution = new Q1_1_LargestSubArraySumOfCircularArray();
        int[] input = {1, 2, -3, 4, 5};
        assertEquals(12, solution.largestSum(input));
    }
}