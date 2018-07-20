package come.laicode.dfs;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfIslandsTest {

    @Test
    public void test1() {
        NumberOfIslands solution = new NumberOfIslands();
        int res = solution.numIslands(new char[][] {{'1', '1', '1', '1', '0'},
                                                    {'1', '1', '0', '1', '0'},
                                                    {'1', '1', '0', '0', '0'},
                                                    {'0', '0', '0', '0', '0'}});
        assertEquals(1, res);
    }

    @Test
    public void test2() {
        NumberOfIslands solution = new NumberOfIslands();
        int res = solution.numIslands(new char[][] {{'1', '1', '0', '0', '0'},
                                                    {'1', '1', '0', '0', '0'},
                                                    {'0', '0', '1', '0', '0'},
                                                    {'0', '0', '0', '1', '1'}});
        assertEquals(3, res);
    }
}