package come.class37_final;

import org.junit.Test;

import static org.junit.Assert.*;

public class Q4_IsStringsChainedAsCircleTest {

    @Test
    public void test1() {
        Q4_IsStringsChainedAsCircle solution = new Q4_IsStringsChainedAsCircle();
        boolean res = solution.isChain(new String[] {"aaa", "bbb", "baa", "aab"});
        assertTrue(res);
    }
}