package come.class28_DFS_2Sum;

import org.junit.Test;

import static org.junit.Assert.*;

public class Q2_1b_TwoSubsetsWithMinDifferenceTest {

    @Test
    public void test1() {
        Q2_1b_TwoSubsetsWithMinDifference solution = new Q2_1b_TwoSubsetsWithMinDifference();
        int res = solution.minDifference(new int[] {1, 4, 2, 3});
        assertEquals(0, res);
    }

    @Test
    public void test2() {
        Q2_1b_TwoSubsetsWithMinDifference solution = new Q2_1b_TwoSubsetsWithMinDifference();
        int res = solution.minDifference(new int[] {1, 3, 2});
        assertEquals(0, res);
    }

    @Test
    public void test3() {
        Q2_1b_TwoSubsetsWithMinDifference solution = new Q2_1b_TwoSubsetsWithMinDifference();
        int res = solution.minDifference(new int[] {5,-2,-10,3});
        assertEquals(6, res);
    }
}