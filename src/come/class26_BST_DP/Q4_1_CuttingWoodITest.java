package come.class26_BST_DP;

import org.junit.Test;

import static org.junit.Assert.*;

public class Q4_1_CuttingWoodITest {

    @Test
    public void Test1() {
        Q4_1_CuttingWoodI solution = new Q4_1_CuttingWoodI();
        int res = solution.minCost(new int[] {2, 4, 7}, 10);
        assertEquals(20, res);
    }

    @Test
    public void Test2() {
        Q4_1_CuttingWoodI solution = new Q4_1_CuttingWoodI();
        int res = solution.minCost(new int[] {1, 3, 7, 9, 13}, 16);
        assertEquals(41, res);
    }
}