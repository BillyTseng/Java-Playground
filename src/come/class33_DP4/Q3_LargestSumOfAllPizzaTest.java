package come.class33_DP4;

import org.junit.Test;

import static org.junit.Assert.*;

public class Q3_LargestSumOfAllPizzaTest {

    @Test
    public void test1() {
        Q3_LargestSumOfAllPizza solution = new Q3_LargestSumOfAllPizza();
        int res = solution.largestSum(new int[] {1, 2, 3, 4, 5, 6});
        assertEquals(12, res);
    }

    @Test
    public void test2() {
        Q3_LargestSumOfAllPizza solution = new Q3_LargestSumOfAllPizza();
        int res = solution.largestSum(new int[] {1, 2, 3, 4, 100, 10});
        assertEquals(104, res);
    }
}