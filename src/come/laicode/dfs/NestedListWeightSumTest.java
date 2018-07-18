package come.laicode.dfs;

import org.junit.Test;

import static org.junit.Assert.*;

public class NestedListWeightSumTest {
    @Test
    public void test1() {
        NestedListWeightSum solution = new NestedListWeightSum();
        int res = solution.depthSum("[[[8,7],4]]");
        assertEquals(53, res);
    }

    @Test
    public void test2() {
        NestedListWeightSum solution = new NestedListWeightSum();
        int res = solution.depthSum("[[[10],4]]");
        assertEquals(38, res);
    }

    @Test
    public void test3() {
        NestedListWeightSum solution = new NestedListWeightSum();
        int res = solution.depthSum("[[1,3],5,7,[9,[1, 2],6,4]]");
        assertEquals(67, res);
    }

    @Test
    public void test4() {
        NestedListWeightSum solution = new NestedListWeightSum();
        int res = solution.depthSum("[-1]");
        assertEquals(-1, res);
    }
}