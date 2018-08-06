package come.eClass8_DP;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q2_1_HouseRobberITest {

    @Test
    public void test1() {
        Q2_1_HouseRobberI solution = new Q2_1_HouseRobberI();
        assertEquals(9, solution.rob(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    public void test2() {
        Q2_1_HouseRobberI solution = new Q2_1_HouseRobberI();
        assertEquals(4, solution.rob(new int[] {1,2,3,1}));
    }

    @Test
    public void test3() {
        Q2_1_HouseRobberI solution = new Q2_1_HouseRobberI();
        assertEquals(12, solution.rob(new int[] {2,7,9,3,1}));
    }
}