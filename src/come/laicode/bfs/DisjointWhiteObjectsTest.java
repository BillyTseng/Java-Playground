package come.laicode.bfs;

import org.junit.Test;

import static org.junit.Assert.*;

public class DisjointWhiteObjectsTest {

    @Test
    public void test1() {
        DisjointWhiteObjects solution = new DisjointWhiteObjects();
        int res = solution.whiteObjects(new int[][] {{0, 0, 0, 1},
                                                    {1, 0, 1, 1},
                                                    {1, 1, 0, 0},
                                                    {0, 1, 0, 0}});
        assertEquals(3, res);
    }

    @Test
    public void test2() {
        DisjointWhiteObjects solution = new DisjointWhiteObjects();
        int res = solution.whiteObjects(new int[][] {{1,0,1,0},
                                                    {1,0,0,1},
                                                    {0,1,1,0},
                                                    {1,0,0,1},
                                                    {0,1,1,0}});
        assertEquals(7, res);
    }
}